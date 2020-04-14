//全局内变量
var qjbl="";
var tb = "";
var tr = "";
//td1 装span
var td1 = "";
//span 装修改和删除按钮
var span = "";
var update = "";
var del = "";
var queryName = "";
var queryTel = "";

//封装添加数据的方法
var appendTd = function (tr, item, prop) {
	var value = item[prop];
	var td = $('<td width="13%" height="30">' + value + '</td>');
	tr.append(td);
}

//展示数据

function getAll() {
	$.ajax({
		url:"/Test_assets/dept/list",
		method:"POST",
		async : false,
		data:{
			name:queryName,
			tel:queryTel,
			pageNum: pageNum,
            //pageCount: pageCount
		},
		success:function (pageModel) {
			var deptList = pageModel.rows;
			pageNum = pageModel.pageNum;
			maxPageNum = pageModel.maxPageNum;
			pageTotal = pageModel.pageTotal;
			tb = $("#Ttest1");
			$('#total').html(pageTotal);
			$('#inTotal').html(pageNum+"/"+maxPageNum)
			// 清空 tbody 的所有元素
			tb.html('');
			for (var i = 0; i < deptList.length; i++){
				//将id赋值到全局变量里，删除时使用。
				qjbl=deptList[i].id;
				tr = $('<tr align="center" bgcolor="#FFFFFF">');
				td1 = $('<td width="13%" height="30">');
				span = $('<span style="line-height:12px; text-align:center;">');
				update = $('<a href="" class="xiu" id="update">修改&nbsp&nbsp</a>');
				del = $('<a href="" class="xiu" id="dele" onclick="">删除</a>');
				//将"修改、删除“的按钮添加到span中
				span.append(update);
				span.find(update).attr("href","/Test_assets/assets/jsps/department/input.html?id="+deptList[i].id);
				span.append(del);
				td1.append(span);
				//添加数据
				appendTd(tr,deptList[i],'id');
				appendTd(tr,deptList[i],'name');
				appendTd(tr,deptList[i],'tel');
				tr.append(td1);
				tb.append(tr);
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

