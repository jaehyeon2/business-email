function meetSubmit(){
	
	const meetName = document.getElementById("meetName");
	const meetEmail = document.getElementById("meetName");
	const meetManagerName = document.getElementById("meetName");
	const meetManagerEmail = document.getElementById("meetName");
	const meetContent = document.getElementById("meetName");
	
	var regName = /^[a-zA-Z0-9가-힣]*$/;
	var regEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	
	if(!meetEmail.value || meetEmail.value==""){
		alertAsync("담당자 이메일을 입력해주세요.").then(function(){
			meetName.focus();
		});
		return;
	}
	if(!regEmail.test(meetEmail.value)){
		alertAsync('이메일 주소가 유효하지 않습니다').then(function(){
			meetEmail.focus();
		});
		return false;
	}
	if(!regName.test(meetName.value) || meetName.value.length > 4){
		alertAsync("이름은 한글 영문 숫자를 합하여 최대 4자리까지 입력 가능합니다.").then(function(){
			meetName.focus();
		});
		return;
	}
	if(!meetManagerEmail.value || meetManagerEmail.value==""){
		alertAsync("이메일을 입력해주세요.").then(function(){
			meetManagerEmail.focus();
		});
		return false;
	}
	if(!regEmail.test(meetManagerEmail.value)){
		alertAsync('이메일 주소가 유효하지 않습니다').then(function(){
			meetManagerEmail.focus();
		});
		return false;
	}
	if(!meetManagerName.value || meetManagerName.value==""){
		alertAsync("이름을 입력해주세요.").then(function(){
			meetManagerName.focus();
		});
		return false;
	}
	if(!meetContent.value || meetContent.value==""){
		alertAsync("내용을 입력해주세요.").then(function(){
			meetContent.focus();
		});
		return false;
	}
}

function alertAsync(message) {
	return new Promise(function(resolve) {
		alert(message);
		resolve();
	});
}