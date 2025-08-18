<#import "/spring.ftl" as spring/>
<div id="companySummaryModal" class="modal" style="display:none;">
	<div class="modal-content">
		<div class="modal-header">
			<h2>요약 내용</h2>
			<span class="close" onclick="closeModal('companySummaryModal')">&times;</span>
		</div>
		<div class="modal-body">
			<form id="companySummaryForm">
				<div class="form-group">
					<label for="companySummary">요약 내용</label>
					<textarea id="companySummary" name="companySummary">${model.company.companySummary?if_exists}</textarea>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="getCompanySummary()">요약 내용 작성</button>
					<button type="button" onclick="closeModal('companySummaryModal')">취소</button>
					<button type="button" onclick="udtCompanySummary()">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
