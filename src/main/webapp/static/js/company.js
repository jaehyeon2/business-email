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
