
/**
 * 장바구니 담기
 */
function go_excart() {
	
		$("#detail_form").attr("action", "cart_insert").submit();
}

/**
 *  장바구니 항목 삭제
 */
function go_cart_delete() {
	var count = 0;	// 삭제할 항목의 갯수
	
	/*
	 * if문과 for문의 내용은 삭제할 항목이 체크가 되어있는지 확인.
	 * 체크가 하나도 안되어 있으면 삭제 처리 불가하도록 구현
	 */
	// 삭제할 항목이 0또는 하나만 체크되어 있을 경우
	if (document.formm.cseq.length == undefined) {
		// cseq가 하나만 체크가 되어 있는 경우
		if (document.formm.cseq.checked == true) {
			count++;
		}
	}
	
	// 삭제할 항목이 2개 이상인 경우 
	for (var i=0; i<document.formm.cseq.length; i++) {
		if (document.formm.cseq[i].checked == true) {
			count++;
		}
	}
	
	if (count == 0) {
		alert("삭제할 항목을 선택해 주세요!");
	} else {
		document.formm.action = "cart_delete";
		document.formm.submit();
	}
}


/*
 * 장바구니에 저장된 내역을 주문처리 요청
 */
function go_register_insert() {
	var count = 0;	// 삭제할 항목의 갯수
	
	if (document.formm.cseq.length == undefined) {
		// cseq가 하나만 체크가 되어 있는 경우
		if (document.formm.cseq.checked == true) {
			count++;
		}
	}
	 
	for (var i=0; i<document.formm.cseq.length; i++) {
		if (document.formm.cseq[i].checked == true) {
			count++;
		}
	}
	
	if (count == 0) {
		alert("신청할 항목을 선택해 주세요!");
	} else {	
		$("#theform").attr("action", "register_insert").submit();
	}
}


function go_register() {
	$("#detail_form").attr("action", "go_register_insert").submit();
}


function cart_register_check_form() {
	// 수강과목 중복 체크를 위한 윈도우 오픈 요청
var count = 0;	// 삭제할 항목의 갯수
var choice = null;
var url="register_insert?";
	if (document.formm.cseq.length == undefined) {
		// cseq가 하나만 체크가 되어 있는 경우
		if (document.formm.cseq.checked == true) {
			count++;
		}
	}
	 
	for (var i=0; i<document.formm.cseq.length; i++) {
		if (document.formm.cseq[i].checked == true) {
			count++;
		}
	}
	
	if (count == 0) {
		alert("신청할 항목을 선택해 주세요!");
	} else {
		
		if(count==1){
			if (document.formm.cseq.checked == true) {
				choice =document.formm.cseq.value;
				//alert("choice = "+choice);
				choice = Number(choice);
				//alert("choice = "+choice);
				url = url+"cseq="+choice;
			}
		}
		
		for (var i=0; i<document.formm.cseq.length; i++) {
			
			if (document.formm.cseq[i].checked == true) {
					
					choice =document.formm.cseq[i].value;
					//alert("choice = "+choice);
					choice = Number(choice);
					//alert("choice = "+choice);
					url = url+"cseq="+choice+"&";
				
			}
		}
		
		//url = url+choice;
		//alert("url = "+url);
		
		
		
		window.open(url, "_blank_1", 
		"toolbar=no, menubar=no, scrollbars=no, resizable=yes, width=350, height=120");
		
	}
	
	
	
	
}

/*

function cart_register_check_form() {
	// 수강과목 중복 체크를 위한 윈도우 오픈 요청
	
var count = 0;	// 삭제할 항목의 갯수
var url="register_insert?cseq="+$('#cseq').val();

	if (document.formm.cseq.length == undefined) {
		// cseq가 하나만 체크가 되어 있는 경우
		if (document.formm.cseq.checked == true) {
			count++;
		}
	}
	 
	for (var i=0; i<document.formm.cseq.length; i++) {
		if (document.formm.cseq[i].checked == true) {
			count++;
		}
	}
	
	if (count == 0) {
		alert("신청할 항목을 선택해 주세요!");
	} else {	
		//$("#theform").attr("action", "register_insert").submit();
		
		window.open(url, "_blank_1", 
		"toolbar=no, menubar=no, scrollbars=no, resizable=yes, width=350, height=120");
	}
	
	
	
	
}

*/