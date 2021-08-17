/**
 * 
 */

// id중복확인 화면 출력
function idcheck() {
	if ($('#id').val() == "") { //값을 입력했는지 확인
		alert("아이디를 입력해 주세요!");
		$('#id').focus();
		return;
	}
	
	// 아이디 중복 체크를 위한 윈도우 오픈 요청
	var url="id_check_form?id=" + $('#id').val();
	
	window.open(url, "_blank_1", 
			"toolbar=no, menubar=no, scrollbars=no, resizable=yes, width=350, height=200");
}

// 사용가능한 아이디를 사용
function idok() {
	$("#theform").attr("action", "id_check_confirmed").submit();
}

/*
 * 회원가입 시, 필수 입력 사항 체크
 * action url: join
 * 
 */
function go_save() {
	if ($("#id").val() == "") {
		alert("아이디를 입력해 주세요!");
		$("#id").focus();
	} else if ($("#id").val() != $("#reid").val()) {
		alert("아이디 중복체크를 해주세요!");
		$("#id").focus();
	} else if ($("#pwd").val() == "") {
		alert("비밀번호를 입력해 주세요!");
		$("#pwd").focus();
	} else if ($("#pwd").val() != $("#pwdCheck").val()) {
		alert("비밀번호가 일치하지 않습니다!");
		$("#pwd").focus();
	} else if ($("#name").val() == "") {
		alert("이름을 입력해 주세요!");
		$("#name").focus();
	} else {
		$("#join").attr("action", "join").submit();
	}
}















