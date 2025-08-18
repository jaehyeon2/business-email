package com.jaehyeon2.be.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaehyeon2.be.beans.enums.APIType;
import com.jaehyeon2.be.beans.model.GptResponseModel;
import com.jaehyeon2.be.beans.param.CompanyParam;
import com.jaehyeon2.be.service.GptApiService;

@Service
public class GptApiServiceImpl implements GptApiService{
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private String OPENAI_API_KEY;
	
	@Autowired
	private String OPENAI_API_ENDPOINT_URL;
	
	@Autowired
	private String OPENAI_API_GPT_MODEL;
	
	@Autowired
	private String API_PROMPT_INFO_SETTING;
	
	@Autowired
	private String API_PROMPT_INFO_CONTENT;
	
	@Autowired
	private String API_PROMPT_SUMMARY_SETTING;
	
	@Autowired
	private String API_PROMPT_SUMMARY_CONTENT;
	
	@Autowired
	private String API_PROMPT_SUMMARY_INFO;
	
	@Autowired
	private String API_PROMPT_EMAIL_SETTING;

//	/v1/responses
//	private String createRequestBody(String prompt) {
//    	
//        JSONObject json = new JSONObject();
//        json.put("model", OPENAI_API_GPT_MODEL);
//        json.put("input", prompt);
//
//        return json.toString();
//    }
//
//	/v1/responses
//	private String parseResponse(String responseBody) {
//	    JSONObject json = new JSONObject(responseBody);
//	    JSONArray output = json.getJSONArray("output");
//
//	    for (int i = 0; i < output.length(); i++) {
//	        JSONObject message = output.getJSONObject(i);
//	        if (!message.has("content")) continue;
//
//	        JSONArray contentArray = message.getJSONArray("content");
//	        for (int j = 0; j < contentArray.length(); j++) {
//	            JSONObject contentObj = contentArray.getJSONObject(j);
//	            if ("output_text".equals(contentObj.optString("type"))) {
//	                return contentObj.optString("text", "");
//	            }
//	        }
//	    }
//
//	    return ""; // text가 없으면 빈 문자열 반환
//	}
	
//	/v1/chat/completions
	private String createRequestBody(String prompt) {
	    JSONObject json = new JSONObject();
	    json.put("model", OPENAI_API_GPT_MODEL);

	    JSONArray messages = new JSONArray();
	    
	    // user 메시지
	    JSONObject message = new JSONObject();
	    message.put("role", "user");
	    message.put("content", prompt);
	    messages.put(message);

	    json.put("messages", messages);

	    // parameters
//	    json.put("temperature", 0.7);
//	    json.put("top_p", 1.0);
//	    json.put("frequency_penalty", 0.0);
//	    json.put("presence_penalty", 0.0);

	    return json.toString();
	}
	
//	/v1/chat/completions
	private String parseResponse(String responseBody) {
		JSONObject json = new JSONObject(responseBody);
        JSONArray choices = json.getJSONArray("choices");
        JSONObject message = choices.getJSONObject(0).getJSONObject("message");
        return message.getString("content");
	}


	
    @Override
    public GptResponseModel getGPTResponse(CompanyParam companyParam) {
        GptResponseModel result = new GptResponseModel();

        try {
            String fullPrompt = this.makePrompt(companyParam);

            String requestBody = createRequestBody(fullPrompt);

            // OpenAI API 연결 설정
            URL url = new URL(OPENAI_API_ENDPOINT_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + OPENAI_API_KEY);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
                logger.info("GptApiServiceImpl::getGPTResponse::Sending Request");
            }

            int responseCode = connection.getResponseCode();
            logger.info("GptApiServiceImpl::getGPTResponse::OpenAI API Response Code: {}", responseCode);

            if (responseCode != HttpURLConnection.HTTP_OK) {
                result.setResult(false);
                result.setContent("OpenAI API 오류: " + responseCode);
                logger.error("GptApiServiceImpl::getGPTResponse::API Request Fail: {}", responseCode);
                return result;
            }

            // 응답 받아오기
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }

            // GPT 응답 파싱
            String gptAnswer = parseResponse(response.toString());

            // 성공 처리
            result.setResult(true);
            result.setContent(gptAnswer);
            return result;

        } catch (Exception e) {
            // 실패 처리
            result.setResult(false);
            result.setContent("Exception error: " + e.getMessage());
            logger.error("GptApiServiceImpl::getGPTResponse::Exception error", e);
            return result;
        }
    }
	
	private String makePrompt(CompanyParam companyParam){
		
		String fullPrompt = null;
		
		if (companyParam.getAPIType().equals(APIType.INFO)) {
			
			fullPrompt = new StringBuilder()
					.append(API_PROMPT_INFO_SETTING)
					.append(API_PROMPT_INFO_CONTENT)
					.append(companyParam.getCompanyName())
					.toString();
			
		}else if (companyParam.getAPIType().equals(APIType.SUMMARY)) {
			fullPrompt = new StringBuilder()
					.append(API_PROMPT_SUMMARY_SETTING)
					.append(API_PROMPT_SUMMARY_CONTENT)
					.append(companyParam.getCompanyMeet())
					.append(API_PROMPT_SUMMARY_INFO)
					.append(companyParam.getCompanyInfo())
					.toString();
			
		}else if (companyParam.getAPIType().equals(APIType.EMAIL)) {
			fullPrompt = new StringBuilder()
					.append(companyParam.getCompanySummary())
					.append(API_PROMPT_EMAIL_SETTING)
					.append(companyParam.getCompanyStatus())
					.toString();
		}
		
		return fullPrompt;
	}
	
    
}