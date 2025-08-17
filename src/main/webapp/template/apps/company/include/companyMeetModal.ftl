<#import "/spring.ftl" as spring/>
<div id="companyMeetModal" class="modal" style="display:none;">
	<div class="modal-content">
		<div class="modal-header">
			<h2>미팅 정보</h2>
			<span class="close" onclick="closeModal('companyMeetModal')">&times;</span>
		</div>
		<div class="modal-body">
			<form id="companyMeetForm">
				<div class="form-group">
					<label for="companyMeet">미팅 정보</label>
					<textarea id="companyMeet" name="companyMeet">${model.company.companyMeet?if_exists}</textarea>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="closeModal('companyMeetModal')">취소</button>
					<button type="button" onclick="udtCompanyMeet()">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
