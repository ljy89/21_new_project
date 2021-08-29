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
	$("#theform").attr("action", "go_register_delete").submit();
}