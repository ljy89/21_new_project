function pro_search() {
	$("#sub_form").attr("action", "pro_subject_list").submit();
}

function pro_total() {
	$("#key").val("");
	$("#sub_form").attr("action", "pro_subject_list").submit();
}


function pro_wrt() {
	$("#sub_form").attr("action", "pro_subject_write_form").submit();
}

/*
 * 상세 페이지로 이동
 * */
function pro_detail(sseq) {
	$("#sub_form").attr("action", "pro_subject_detail?sseq="+sseq).submit();
}

function pro_mod(sseq) {
	$("#detail_form").attr("action", "pro_subject_editionView?sseq="+sseq).submit();
}

function pro_mod_action(sseq){
	$("#detail_form").attr("action", "pro_subject_editionAction?sseq="+sseq).submit();
}

function pro_wrt() {
	$("#sub_form").attr("action", "pro_subject_write_form").submit();
}

function pro_save() {
	
	var $subname = $("#subname");
	var $time = $("#time");
	var $location = $("#location");
	var $content = $("#content");
	
	if($("#subname").val()==""){
		alert("과목명을 입력하세요!");
		$("#subname").focus();
	}else if($("#time").val()==""){
		alert("수업일자를 입력하세요!");
		$("#time").focus();
	}else if($("#location").val()==""){
		alert("수업장소를 입력하세요!");
		$("#location").focus();
	}else if($("#content").val()==""){
		alert("수업상세 소개를 입력하세요!");
		$("#content").focus();
	}else{
		$("#write_form").attr("action", "pro_subject_write").submit();
	}
	
	
	
}