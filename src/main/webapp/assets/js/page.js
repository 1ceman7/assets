
//全局内变量
var pageNum = 1;
var pageCount = 0;
var maxPageNum = 0;
var pageTotal = 0;
function page() {
	$('#first').click(function () {
		pageNum = 1;
		getAll();
		pageCss();
	});
	$('#pre').click(function () {
		pageNum = pageNum - 1;
		getAll();
		pageCss();
	});
	$('#next').click(function () {
		pageNum = pageNum + 1;
		getAll();
		pageCss();
	});
	$('#last').click(function () {
		pageNum = maxPageNum;
		getAll();
		pageCss();
	});

function pageCss() {
	if(maxPageNum == 1)//只有一页
	{
		$("#first").css("display","none");
		$("#pre").css("display","none");
		$("#next").css("display","none");
		$("#last").css("display","none");
	}else if(pageNum == 1)//第一页
	{
		$("#first").css("display","none");
		$("#pre").css("display","none");
		$("#next").css("display","inline");
		$("#last").css("display","inline");
	}else if(pageNum == maxPageNum)//最后一页
	{
		$("#first").css("display","inline");
		$("#pre").css("display","inline");
		$("#next").css("display","none");
		$("#last").css("display","none");
	}else//其他中间页
	{
		$("#first").css("display","inline");
		$("#pre").css("display","inline");
		$("#next").css("display","inline");
		$("#last").css("display","inline");
	}

}


}
