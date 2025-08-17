<#import "/spring.ftl" as spring/>
<div id="companyEmailContentModal" class="modal" style="display:none;">
	<div class="modal-content">
		<div class="modal-header">
			<h2>이메일 내용</h2>
			<span class="close" onclick="closeModal('companyEmailContentModal')">&times;</span>
		</div>
		<div class="modal-body">
			<form id="companyEmailContentForm">
				<div class="form-group">
					<label for="companyEmailContent">이메일 내용</label>
					<textarea id="companyEmailContent" name="companyEmailContent">${model.company.companyEmailContent?if_exists}</textarea>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="getCompanyEmailContent()">이메일 내용 작성</button>
					<button type="button" onclick="closeModal('companyEmailContentModal')">취소</button>
					<button type="button" onclick="udtCompanyEmailContent()">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
