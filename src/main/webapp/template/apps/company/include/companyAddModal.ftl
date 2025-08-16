<#import "/spring.ftl" as spring/>
<div id="companyAddModal" class="modal" style="display:none;">
	<div class="modal-content">
		<div class="modal-header">
			<h2>회사 등록</h2>
			<span class="close" onclick="closeModal('companyAddModal')">&times;</span>
		</div>
		<div class="modal-body">
			<form id="companyAddForm">
				<div class="form-group">
					<label for="companyName">회사명</label>
					<input type="text" id="companyName" name="companyName" required>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="closeModal('companyAddModal')">취소</button>
					<button type="button" onclick="addCompany()">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
