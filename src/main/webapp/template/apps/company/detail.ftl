<#import "/layout/layout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>

<div>

	<input type="hidden" id="companyNo" value="${model.company.companyNo?if_exists}"/>
	<input type="hidden" id="companyName" value="${model.company.companyName?if_exists}"/>
    <div style="margin-top: 20px;">
        <button type="button" onclick="openModal('companyInfoModal')">사전 정보 확인</button>
        <button type="button" onclick="openModal('companyMeetModal')">미팅 정보 확인</button>
        <button type="button" onclick="openModal('companyEmailContentModal')">이메일 정보 확인</button>
        <button type="button" onclick="location.href='/be/company'">목록으로</button>
    </div>

    <ul>
        <li>번호</li>
        <li>이름</li>
        <li>등록시간</li>
		<li>수정시간</li>
    </ul>

    <ul>
        <li>${model.company.companyNo?if_exists}</li>
        <li>${model.company.companyName?if_exists}</li>
        <li><#if model.company.insertTime?exists>${model.company.insertTime?string('yyyy.MM.dd | HH:mm:ss')}</#if></li>
		<li><#if model.company.updateTime?exists>${model.company.updateTime?string('yyyy.MM.dd | HH:mm:ss')}</#if></li>
    </ul>
    
    <div>
    	<span>사전 정보</span><br>
    	<#if model.company.companyInfo??>
    	<textarea>${model.company.companyInfo?if_exists}</textarea>
    	<#else>
    	<span>등록되어 있는 사전 정보가 없습니다.</span>
    	</#if>
    </div>
    
    <div>
    	<span>미팅 정보</span><br>
    	<#if model.company.companyMeet??>
    	<textarea>${model.company.companyMeet?if_exists}</textarea>
    	<#else>
    	<span>등록되어 있는 미팅 정보가 없습니다.</span>
    	</#if>
    </div>
    
    <div>
    	<span>이메일 내용 정보</span><br>
    	<#if model.company.companyEmailContent??>
    	<textarea>${model.company.companyEmailContent?if_exists}</textarea>
    	<#else>
    	<span>등록되어 있는 이메일 내용 정보가 없습니다.</span>
    	</#if>
    </div>

</div>

<#include "/apps/company/include/companyInfoModal.ftl"/>
<#include "/apps/company/include/companyMeetModal.ftl"/>
<#include "/apps/company/include/companyEmailContentModal.ftl"/>

<script src="/static/js/company.js"></script>
</@layout.myLayout>
