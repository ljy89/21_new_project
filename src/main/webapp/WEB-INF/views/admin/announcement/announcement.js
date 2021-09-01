
/*
 *  제목으로 조회 
 */
function go_ann_search() {
	$("#ann_form").attr("action", "admin_announcement_list").submit();
}

/* 
 *  전체 조회
 */


function go_ann_total() {
	$("#key").val("");
	$("#ann_form").attr("action", "admin_announcement_list").submit();
}

/*
 * 상세 페이지로 이동
 * */
function ann_detail(aseq) {
	$("#ann_form").attr("action", "admin_announcement_detail?aseq="+aseq).submit();
}

/*상세페이지에서 --> 전공목록으로 이동
 * */
function go_list() {
	$("#key").val("");
	$("#detail_form").attr("action", "major").submit();
}
//수정폼으로 이동
function ann_mod(aseq) {
	$("#detail_form").attr("action", "ann_modify?aseq="+aseq).submit();
}
//수정 
function ann_mod_save(aseq) {
	$("#update_form").attr("action", "ann_modify_action?aseq="+aseq).submit();
}
//목록으로 이동
function ann_go_list() {
	var theForm = document.frm;
	   theForm.action="admin_announcement_list";
	   theForm.submit();
}

//삭제
function ann_del(aseq) {
	$("#detail_form").attr("action", "ann_delete?aseq="+aseq).submit();
}
//새글 폼으로 이동
function ann_wrt() {
	$("#ann_form").attr("action", "ann_write_form").submit();
}
//새글등록
function ann_save() {
	$("#write_form").attr("action", "ann_write").submit();
}


/*
 *  제목으로 조회 
 */
function go_announcement_search() {
	$("#ann_form").attr("action", "announcement_list").submit();
}

/* 
 *  전체 조회
 */


function go_announcement_total() {
	$("#key").val("");
	$("#ann_form").attr("action", "announcement_list").submit();
}	   
/*
 * 상세 페이지로 이동
 * */
function announcement_detail(aseq) {
	$("#ann_form").attr("action", "announcement_detail?aseq="+aseq).submit();
}

//목록으로 이동
function announcement_go_list() {
	var theForm = document.frm;
	   theForm.action="announcement_list";
	   theForm.submit();
}
