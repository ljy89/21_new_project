
/*
 *  교수, 과목 이름으로 조회 
 */

function season_search() {
	$("#subject_form").attr("action", "season").submit();
}

/* 
 *  전체 조회
 */


function season_subject_total() {
	$("#key").val("");
	$("#subject_form").attr("action", "season").submit();
}

/*
 * 상세 페이지 이동
 */

function go_seasnon_detail(seseq) {
	$("#subject_form").attr("action", "season_detail?seseq="+seseq).submit();
}



/**
 * 장바구니 담기
 */
function go_season_cart(seseq) {
	
	$("#detail_form").attr("action", "season_cart_insert?seseq="+seseq).submit();
}



/*상세페이지에서 --> 계절학기목록으로 이동
 * */

function go_season_list() {
	$("#key").val("");
	$("#detail_form").attr("action", "season").submit();
}


/*장바구니페이지에서 --> 계절학기목록으로 이동
 * */

function season_go_list() {
	$("#key").val("");
	$("#theform").attr("action", "season").submit();
}

/*
 장바구니 삭제 버튼
*/
function season_cart_delete() {
	var count = 0;	// 삭제할 항목의 갯수
	
	/*
	 * if문과 for문의 내용은 삭제할 항목이 체크가 되어있는지 확인.
	 * 체크가 하나도 안되어 있으면 삭제 처리 불가하도록 구현
	 */
	// 삭제할 항목이 0또는 하나만 체크되어 있을 경우
	if (document.formm.secseq.length == undefined) {
		// cseq가 하나만 체크가 되어 있는 경우
		if (document.formm.secseq.checked == true) {
			count++;
		}
	}
	
	// 삭제할 항목이 2개 이상인 경우 
	for (var i=0; i<document.formm.secseq.length; i++) {
		if (document.formm.secseq[i].checked == true) {
			count++;
		}
	}
	
	if (count == 0) {
		alert("삭제할 항목을 선택해 주세요!");
	} else {
		document.formm.action = "season_cart_delete";
		document.formm.submit();
	}
}

/*
 * 장바구니 --> 결제
 */
function season_order_insert() {
var count = 0;	// 삭제할 항목의 갯수
	
	if (document.formm.secseq.length == undefined) {
		// cseq가 하나만 체크가 되어 있는 경우
		if (document.formm.secseq.checked == true) {
			count++;
		}
	}
	 
	for (var i=0; i<document.formm.secseq.length; i++) {
		if (document.formm.secseq[i].checked == true) {
			count++;
		}
	}
	
	if (count == 0) {
		alert("신청할 항목을 선택해 주세요!");
	} else {	
		
		$("#theform").attr("action", "order_insert").submit();
	}

	
}

/*
 * 결제 상세내역 --> 결제 내역
 */

function season_order_list() {
	$("#theform").attr("action", "season").submit();
}

/*
 * 상세 페이지 이동
 */

function go_season_order(seseq) {
	$("#detail_form").attr("action", "season_order_insert?seseq="+seseq).submit();
}




/*내 수강 내역에 이미 있는지 확인
*/

function register_check() {
	// 수강과목 중복 체크를 위한 윈도우 오픈 요청
	var url="register_check_form?sseq=" + $('#sseq').val();
	
	window.open(url, "_blank_1", 
			"toolbar=no, menubar=no, scrollbars=no, resizable=yes, width=350, height=120");
}


//수강 가능한 과목 사용
function sseqok() {
	$("#theform").attr("action", "register_check_confirmed").submit();
	
}

