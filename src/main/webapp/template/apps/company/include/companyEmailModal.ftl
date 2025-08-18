<#import "/spring.ftl" as spring/>
<div id="companyEmailModal" class="modal" style="display:none;">
	<div class="modal-content">
		<div class="modal-header">
			<h2>이메일 내용</h2>
			<span class="close" onclick="closeModal('companyEmailModal')">&times;</span>
		</div>
		<div class="modal-body">
			<form id="companyEmailForm">
				<div class="form-group">
					<label for="companySummary">담당자 세부 내용</label>
					<textarea class="textarea-10vh" id="companyStatus" name="companyStatus">${model.company.companyStatus?if_exists}</textarea>
					<label for="companyEmail">이메일 내용</label>
					<textarea id="companyEmail" name="companyEmail">${model.company.companyEmail?if_exists}</textarea>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="getCompanyEmail()">요약 내용 작성</button>
					<button type="button" onclick="closeModal('companyEmailModal')">취소</button>
					<button type="button" onclick="udtCompanyEmail()">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
