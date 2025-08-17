<#import "/layout/layout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>

<div>
	<div>
		<div>
			<button type="button" onclick="openModal('companyAddModal')">등록하기</button>
		</div>
	<#if model??>
		
		<#if model.companyList?has_content>
		<div>
			<ul>
				<li>#</li>
				<li>회사명</li>
				<li>등록시간</li>
				<li>수정시간</li>
			</ul>
		</div>
		<#list model.companyList as company>
		<div onClick="location.href='/be/company/detail?companyNo=${company.companyNo?if_exists}'">
			<ul>
				<li>${company.companyNo?if_exists}</li>
				<li>${company.companyName?if_exists}</li>
				<li><#if company.insertTime?exists>${company.insertTime?string('yyyy.MM.dd | HH:mm:ss')}</#if></li>
				<li><#if company.updateTime?exists>${company.updateTime?string('yyyy.MM.dd | HH:mm:ss')}</#if></li>
			</ul>
		</div>
		</#list>
		<#else>
			<p>
				<span>해당 정보가 존재하지 않습니다.</span>
			<p>
		</#if>
	<#else>
		<p>
			<span>등록된 계정이 없습니다.</span>
		</p>
	</#if>
	</div>
</div>

<#include "/apps/company/include/companyAddModal.ftl"/>

<script src="/static/js/company.js"></script>

</@layout.myLayout>
