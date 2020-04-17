//全局内变量
var qjbl="";
var tb = "";
var tr = "";
//td1 装"修改"和"删除"按钮
var td1 = "";
//span 装td1
var span = "";
var update = "";
var del = "";
var queryName = "";
var queryTel = "";
var total = "";
var inTotal = "";
var num = "";
var dep = "";
/* 封装添加数据的方法 */
var appendTd = function (tr, item, prop) {
	var value = item[prop];
	var td = $('<td width="5%" height="30">' + value + '</td>');
	tr.append(td);
}

/* 展示数据 */
function getAll() {
	$.ajax({
		url:"/Test_assets/emp/list",
		method:"POST",
		async : false,
		data:{
			/*name:queryName,
			tel:queryTel,*/
			//pageNum: pageNum,
            //pageCount: pageCount
		},
		success:function (pageModel) {
			var empList = pageModel.rows;
			pageNum = pageModel.pageNum;
			maxPageNum = pageModel.maxPageNum;
			pageTotal = pageModel.pageTotal;
		/* 查询时无数据展示提示，和底边栏”共几条”数据 */
			total = $('#total');
			inTotal = $('#inTotal');
			num = empList.length;
			if (num == 0){
				$("#noThing").html('没有查找到满足条件的数据！');
			}
		/* 清空 tbody 的所有元素 */
			tb = $("#empTd");
			tb.html('');

			total.html(pageTotal);
			inTotal.html(pageNum+"/"+maxPageNum);

		/* 为字段赋值*/
			for (var i = 0; i < empList.length; i++){
			//将id赋值到全局变量里，做删除功能时会用到。
				qjbl = empList[i].id;
				tr = $('<tr align="center" bgcolor="#FFFFFF">');
				td1 = $('<td width="13%" height="30">');
				span = $('<span style="line-height:12px; text-align:center;">');
				update = $('<a href="" class="xiu" id="update">修改&nbsp&nbsp</a>');
				del = $('<a href="" class="xiu" id="dele" onclick="">删除</a>');
			//将"修改、删除“的按钮添加到span中
				span.append(update);
				span.find(update).attr("href","/Test_assets/assets/jsps/department/input.html?id="+empList[i].id);
				span.append(del);
				td1.append(span);
			//添加数据
				appendTd(tr,empList[i],'id');
				appendTd(tr,empList[i],'name');
				appendTd(tr,empList[i],'genderView');
				appendTd(tr,empList[i],'tel');
				appendTd(tr,empList[i],'email');
				appendTd(tr,empList[i],'intime');
				appendTd(tr,empList[i],'outtime');
				appendTd(tr,empList[i].dm.name,'dm');
				tr.append(td1);
				tb.append(tr);

				/*private Date intime;
				private Date outtime;
				private Integer deptid;
				private DeptModel dm;*/
			}
		}
	})
}

	//查询
function getQuery() {
	$('#query').live('click','a',function(){
		queryName = $('#queryName').val();
		queryTel = $('#queryTel').val();
		alert('输入的查询信息是：'+queryName+queryTel);
		getAll();
	})
}

	//删除
function dele() {
	$('#dele').live('click','a',function(){
		var c = confirm("是否确定删除")//按确认和取消输出不同的内容
		if(c ==true){
			$.ajax({
				url:"/Test_assets/dept/del",
				method:"POST",
				data:{
					id:qjbl
				},
				success:function (data) {
					alert('删除成功,点击确定跳转页面');
					window.location.href = "list.html";
				}
			})
		}else{
               window.location.href = "list.html";
		}

	})
}

