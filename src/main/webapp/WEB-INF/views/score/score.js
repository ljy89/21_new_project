function score_search() {
	$("#score_form").attr("action", "score_subject_list").submit();
}

function score_total() {
	$("#key").val("");
	$("#score_form").attr("action", "score_subject_list").submit();
}

function score_update(sseq) {
	$("#score_form").attr("action", "score_student_list?sseq="+sseq).submit();
}

function score_mod_save() {
var count = 0;	// 삭제할 항목의 갯수
	
	if (document.frm.rdseq.length == undefined) {
		// rdseq가 하나만 체크가 되어 있는 경우
		if (document.frm.rdseq.checked == true) {
			count++;
		}
	}
	 
	for (var i=0; i<document.frm.rdseq.length; i++) {
		if (document.frm.rdseq[i].checked == true) {
			count++;
		}
	}
	
	if (count == 0) {
		alert("수정할 항목을 선택해 주세요!");
	} else {	
		$("#prod_form").attr("action", "score_student_update").submit();
	}
	
}
		