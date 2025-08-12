package com.jaehyeon2.be.service;

import com.jaehyeon2.be.beans.param.MeetParam;

public interface GptApiService {
	public String getGPTResponse(MeetParam meetParam) throws Exception;
}
