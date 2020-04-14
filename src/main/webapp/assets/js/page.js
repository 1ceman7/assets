
//全局内变量
/*var qjbl="";
var tb = "";
var tr = "";
//td1
var td = "";
//span
var span = "";
var pageNum = 1;
var pageCount = 0;
*/
var pageNum = 1;
var pageCount = 0;
var maxPageNum = 0;
var pageTotal = 0;
function page() {


	$('#first').click(function () {
		pageNum = 1;
		getAll();
		if (pageNum == 1){
			$("#first").css("display","none");
			$("#pre").css("display","none");
			$("#next").css("display","inline");
			$("#last").css("display","inline");
		}else{
			$("#first").css("display","inline");
			$("#pre").css("display","inline");
		}
	});
	$('#pre').click(function () {
		pageNum = pageNum - 1;
		getAll();
		if (pageNum == 1){
			$("#first").css("display","none");
			$("#pre").css("display","none");
			$("#next").css("display","inline");
			$("#last").css("display","inline");
		}else{
			$("#first").css("display","inline");
			$("#pre").css("display","inline");
		}
	});
	$('#next').click(function () {
		pageNum = pageNum + 1;
		getAll();
		if (pageNum > 1 ){
			$("#first").css("display","inline");
			$("#pre").css("display","inline");
			/*$("#next").css("display","inline");
			$("#last").css("display","inline");*/
		}
		if (pageNum == maxPageNum){
			$("#next").css("display","none");
			$("#last").css("display","none");
		}
	});
	$('#last').click(function () {
		pageNum = maxPageNum;
		getAll();
		if (pageNum == maxPageNum){
			$("#first").css("display","inline");
			$("#pre").css("display","inline");
			$("#next").css("display","none");
			$("#last").css("display","none");
		}else{
			$("#last").css("display","inline");
			$("#next").css("display","inline");
		}
	});

	if(maxPageNum == 1)//只有一页
	{
		$("#first").css("display","none");
		$("#pre").css("display","none");
		$("#next").css("display","none");
		$("#last").css("display","none");
	}else if (pageNum == 1){
		$("#first").css("display","none");
		$("#pre").css("display","none");
		$("#next").css("display","inline");
		$("#last").css("display","inline");
	}



}
