
/*
 * 상세 페이지로 이동
 * */
function board_detail(nseq) {
	$("#prod_form").attr("action", "board_detail?nseq="+nseq).submit();
}

function board_mod(nseq) {
	$("#detail_form").attr("action", "board_modify?nseq="+nseq).submit();
}

function notice_mod_save(nseq) {
	$("#update_form").attr("action", "board_modify_action?nseq="+nseq).submit();
}


function board_del(nseq) {
	$("#detail_form").attr("action", "board_delete?nseq="+nseq).submit();
}

function board_wrt() {
	$("#prod_form").attr("action", "board_write_form").submit();
}

function board_save() {
	$("#write_form").attr("action", "board_write").submit();
}
