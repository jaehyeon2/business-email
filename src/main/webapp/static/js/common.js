// 특정 모달 열기
function openModal(id) {
    const modal = document.getElementById(id);
    if (modal) {
        modal.style.display = "block";
    }
}

// 특정 모달 닫기
function closeModal(id) {
    const modal = document.getElementById(id);
    if (modal) {
        modal.style.display = "none";
    }
}

// 모달 영역 바깥 클릭 시 닫기
window.onclick = function(event) {
    const modals = document.getElementsByClassName("modal");
    for (let i = 0; i < modals.length; i++) {
        if (event.target === modals[i]) {
            modals[i].style.display = "none";
        }
    }
};

function alertAsync(message) {
	
	return new Promise(function(resolve) {
		alert(message);
		resolve();
	});
}

function confirmAsync(message) {
	
	return new Promise(function(resolve) {
		const result = confirm(message);
			resolve(result);
	});
}