
/*
 *  교수, 과목 이름으로 조회 
 */
function go_search_major() {
	$("#subject_form").attr("action", "major").submit();
}

function go_search() {
	$("#subject_form").attr("action", "liberalArts").submit();
}

/* 
 *  전체 조회
 */
function go_total_major() {
	$("#key").val("");
	$("#subject_form").attr("action", "major").submit();
}

function go_total() {
	$("#key").val("");
	$("#subject_form").attr("action", "liberalArts").submit();
}

/*
 * 상세 페이지로 이동
 * */
function go_detail(sseq) {
	$("#subject_form").attr("action", "subject_detail?sseq="+sseq).submit();
}

/*상세페이지에서 --> 전공목록으로 이동
 * */
function go_list() {
	$("#key").val("");
	$("#detail_form").attr("action", "major").submit();
}


/*
 * 내 수강 내역에서 강의 삭제
 * 
 */

function go_register_delete() {
var count = 0;	// 삭제할 항목의 갯수
	
	/*
	 * if문과 for문의 내용은 삭제할 항목이 체크가 되어있는지 확인.
	 * 체크가 하나도 안되어 있으면 삭제 처리 불가하도록 구현
	 */
	// 삭제할 항목이 0또는 하나만 체크되어 있을 경우
	if (document.formm.rdseq.length == undefined) {
		// rdseq가 하나만 체크가 되어 있는 경우
		if (document.formm.rdseq.checked == true) {
			count++;
		}
	}
	
	// 삭제할 항목이 2개 이상인 경우 
	for (var i=0; i<document.formm.rdseq.length; i++) {
		if (document.formm.rdseq[i].checked == true) {
			count++;
		}
	}
	
	if (count == 0) {
		alert("삭제할 항목을 선택해 주세요!");
	} else {
		$("#theform").attr("action", "go_register_delete").submit();
	}
	
	
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

