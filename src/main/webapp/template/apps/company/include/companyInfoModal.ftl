<#import "/spring.ftl" as spring/>
<div id="companyInfoModal" class="modal" style="display:none;">
	<div class="modal-content">
		<div class="modal-header">
			<h2>사전 정보</h2>
			<span class="close" onclick="closeModal('companyInfoModal')">&times;</span>
		</div>
		<div class="modal-body">
			<form id="companyInfoForm">
				<div class="form-group">
					<label for="companyInfo">사전 정보</label>
					<textarea id="companyInfo" name="companyInfo">${model.company.companyInfo?if_exists}</textarea>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="getCompanyInfo()">사전 정보 확인</button>
					<button type="button" onclick="closeModal('companyInfoModal')">취소</button>
					<button type="button" onclick="udtCompanyInfo()">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
