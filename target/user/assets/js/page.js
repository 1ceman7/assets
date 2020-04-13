//全局内变量
var qjbl="";
var tb = "";
var tr = "";
//td1
var td = "";
//span
var span = "";
var pageNum = 1;
var pageCount = 0;
var pageTotal = 0;


function page() {

	$('#first').click(function () {
		alert('!!!!!!!!!');
		pageNum = 2;
		pageDate(pageNum,pageCount);
	});
	$('#pre').click(function () {

	});
	$('#next').click(function () {

	});
	$('#last').click(function () {

	});
}
function pageDate(pageNum,pageCount) {
	$.ajax({
		url:'/Test_assets/dept/list',
		type:'post',
		data:{
			"pageNum":pageNum,
			"pageCount":pageCount,
		},
		//dataType:"json",
		success:function (pageModel) {
			pageCount = pageModel.pageCount;
			alert('每页显示几条数据：'+pageCount);
			pageNum = pageModel.pageNum;
			alert('pageNum = '+pageNum);
			/*pageTotal = pageModel.pageTotal;
			alert('几条数据：'+ pageTotal);*/
		}
	})


}
