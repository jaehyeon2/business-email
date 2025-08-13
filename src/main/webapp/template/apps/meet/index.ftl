<#import "layout/layout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>

<div>

	<form action="/meet/submit" method="post">
		<input type="text" id="keymanName" placeholder="고객사 담당자명"/>
		<input type="email" id="keymanEmail" placeholder="고객사 담장자 이메일"/>
		<input type="text" id="meetManagerName" placeholder="담당자명"/>
		<input type="text" id="meetManagerEmail" placeholder="담당자 이메일"/>
		<textarea id="meetContetnt" placeholder="미팅내용"/>
		<button type="button" onclick="submitMeet()" value="생성">
	</form>

</div>

</@layout.myLayout>
