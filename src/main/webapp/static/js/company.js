function addCompany() {
    const companyName = document.getElementById('companyName').value.trim();

    if (!companyName) {
        alertAsync('회사명을 입력해주세요.');
        return;
    }

    const param = JSON.stringify({ companyName: companyName });
    const url = "/be/company/addCompany";

    const request = new XMLHttpRequest();

    request.onload = function() {
        if (request.status === 200) {
            const response = JSON.parse(request.response);

            if ((response.responseResult === true)) {
                alertAsync('회사 정보 등록에 성공했습니다.')
                    .then(function() {
                        location.reload();
                    });
            } else {
                alertAsync('회사 등록에 실패했습니다.');
            }
        } else {
            alertAsync('서버 오류가 발생했습니다.');
        }
    };

    request.onerror = function() {
        alertAsync('요청 중 오류가 발생했습니다.');
    };

    request.open("POST", url, true);
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(param);
}

function getCompanyInfo(){
	const companyName = document.getElementById('companyName').value.trim();
	const companyInfoTextarea = document.getElementById('companyInfo');
	
	if (!companyName) {
        alertAsync('회사명이 존재하지 않습니다.');
        return;
    }

    const param = JSON.stringify({ companyName: companyName });
    const url = "/api/info";

    const request = new XMLHttpRequest();

    request.onload = function() {
        if (request.status === 200) {
            const response = JSON.parse(request.response);
			console.log(response);
            if ((response.gptResponse.result === true)) {
               companyInfoTextarea.value = response.gptResponse.content;
            } else {
                alertAsync('정보 수집에 실패했습니다.');
            }
        } else {
            alertAsync('서버 오류가 발생했습니다.');
        }
    };

    request.onerror = function() {
        alertAsync('요청 중 오류가 발생했습니다.');
    };

    request.open("POST", url, true);
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(param);
}

function getCompanyEmailContent(){
	const companyNo = document.getElementById('companyNo').value.trim();
	const companyInfo = document.getElementById('companyInfo').value.trim();
	const companyMeet = document.getElementById('companyMeet').value.trim();
	const companyEmailContentTextarea = document.getElementById('companyEmailContent');
	
	if (!companyNo) {
        alertAsync('회사 정보가 존재하지 않습니다.');
        return;
    }
    
    if (!companyInfo){
		alertAsync('사전 정보가 존재하지 않습니다.');
        return;
	}
	
	if (!companyMeet){
		alertAsync('미팅 정보가 존재하지 않습니다.');
        return;
	}

    const param = JSON.stringify({ 
		companyNo: companyNo,
		companyInfo: companyInfo,
		companyMeet: companyMeet
    });
    const url = "/api/email";

    const request = new XMLHttpRequest();

    request.onload = function() {
        if (request.status === 200) {
            const response = JSON.parse(request.response);
			console.log(response);
            if ((response.gptResponse.result === true)) {
               companyEmailContentTextarea.value = response.gptResponse.content;
            } else {
                alertAsync('이메일 내용 생성에 실패했습니다.');
            }
        } else {
            alertAsync('서버 오류가 발생했습니다.');
        }
    };

    request.onerror = function() {
        alertAsync('요청 중 오류가 발생했습니다.');
    };

    request.open("POST", url, true);
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(param);
}

function udtCompanyInfo() {
    const companyNo = document.getElementById('companyNo').value.trim();
	const companyInfo = document.getElementById('companyInfo').value.trim();
	
    if (!companyNo) {
        alertAsync('회사 정보가 존재하지 않습니다.');
        return;
    }

    const param = JSON.stringify({
		 companyNo : companyNo,
		 companyInfo : companyInfo
	});
	
    const url = "/be/company/updateCompany";

    const request = new XMLHttpRequest();

    request.onload = function() {
        if (request.status === 200) {
            const response = JSON.parse(request.response);

            if ((response.responseResult === true)) {
                alertAsync('사전 정보 등록에 성공했습니다.')
                    .then(function() {
                        location.reload();
                    });
            } else {
                alertAsync('사전 정보 등록에 실패했습니다.');
            }
        } else {
            alertAsync('서버 오류가 발생했습니다.');
        }
    };

    request.onerror = function() {
        alertAsync('요청 중 오류가 발생했습니다.');
    };

    request.open("POST", url, true);
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(param);
}

function udtCompanyMeet() {
    const companyNo = document.getElementById('companyNo').value.trim();
	const companyMeet = document.getElementById('companyMeet').value.trim();
	
    if (!companyNo) {
        alertAsync('회사 정보가 존재하지 않습니다.');
        return;
    }

    const param = JSON.stringify({
		 companyNo : companyNo,
		 companyMeet : companyMeet
	});
	
    const url = "/be/company/updateCompany";

    const request = new XMLHttpRequest();

    request.onload = function() {
        if (request.status === 200) {
            const response = JSON.parse(request.response);

            if ((response.responseResult === true)) {
                alertAsync('미팅 정보 등록에 성공했습니다.')
                    .then(function() {
                        location.reload();
                    });
            } else {
                alertAsync('미팅 정보 등록에 실패했습니다.');
            }
        } else {
            alertAsync('서버 오류가 발생했습니다.');
        }
    };

    request.onerror = function() {
        alertAsync('요청 중 오류가 발생했습니다.');
    };

    request.open("POST", url, true);
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(param);
}

function udtCompanyEmailContent() {
    const companyNo = document.getElementById('companyNo').value.trim();
	const companyEmailContent = document.getElementById('companyEmailContent').value.trim();
	
    if (!companyNo) {
        alertAsync('회사 정보가 존재하지 않습니다.');
        return;
    }

    const param = JSON.stringify({
		 companyNo : companyNo,
		 companyEmailContent : companyEmailContent
	});
	
    const url = "/be/company/updateCompany";

    const request = new XMLHttpRequest();

    request.onload = function() {
        if (request.status === 200) {
            const response = JSON.parse(request.response);

            if ((response.responseResult === true)) {
                alertAsync('이메일 내용 정보 등록에 성공했습니다.')
                    .then(function() {
                        location.reload();
                    });
            } else {
                alertAsync('이메일 내용 정보 등록에 실패했습니다.');
            }
        } else {
            alertAsync('서버 오류가 발생했습니다.');
        }
    };

    request.onerror = function() {
        alertAsync('요청 중 오류가 발생했습니다.');
    };

    request.open("POST", url, true);
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(param);
}

