//全局内变量
var tb = "";
var td = "";
var tr = "";
//td1 装"修改"和"删除"按钮
var td1 = "";
var span = "";
var queryName = "";
var queryTel = "";
var total = "";
var inTotal = "";
var num = "";
/* 封装添加数据的方法 */
var appendTd = function (tr, item, prop) {
	var value = item[prop];
	td = $('<td width="8%" height="30">' + value + '</td>');
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
			var empId = empList.id;
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
			tb = $("#dg");
			tb.html('');
			total.html(pageTotal);
			inTotal.html(pageNum+"/"+maxPageNum);
				tb.datagrid({
					data:
						 empList,
					columns:[[
						{field:'id',title:'编号',width:'5%',align:"center"},
						{field:'name',title:'姓名',width:'12%',align:"center"},
						{field:'tel',title:'电话',width:'15%',align:"center"},
						{field:'genderView',title:'性别',width:'5%',align:"center"},
						{field:'email',title:'email',width:'20%',align:"center"},
						{field:'intime',title:'入职时间',width:'15%',align:"center"},
						{field:'outtime',title:'离职时间',width:'15%',align:"center", formatter: function( value ) {
								if( !value ) {
									return '在职'
								}
								return value
							}},
						{field:'123',title:'操作',width:'15.5%',align:"center", formatter: function( value,row,index) {
								var url ='/Test_assets/assets/jsps/department/input.html';
								var str  ='<a href='+url+'?id='+row.id+' class="xiu">修改</a>&nbsp;&nbsp;' +
									'<a href="javascript:void(0)" id="del" onclick="dele('+row.id+')" class="xiu"  >删除</a>'
								return str ;
							}}

					]]
				});

		/*/!* 为字段赋值*!/
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
				appendTd(tr,empList[i],'outTimeView');
				appendTd(tr,empList[i].dm,'name');
				tr.append(td1);
				tb.append(tr);
			}*/
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
function dele(data) {
		var c = confirm("是否确定删除")//按确认和取消输出不同的内容
		if(c ==true){
			$.ajax({
				url:"/Test_assets/emp/del",
				method:"POST",
				data:{
					id:data
				},
				success:function (data) {
					alert('删除成功,点击确定跳转页面');
					window.location.href = "list.html";
				}
			})
		}else{
               window.location.href = "list.html";
		}

}

	//部门查询下拉框
function onLoadRead() {
		$.ajax({
			type:"post",
			url:"/Test_assets/dept/list",
			dataType:"json",
			async:true,
			cache:false,//不缓存
			timeout:5000,
			success:function(pageModel)
			{
				if(pageModel)
				{
					var deptList = pageModel.rows;
					$("#queryDept").append("<option selected='selected' value='0'>请选择</option>");
					for(var i=0;i<deptList.length;i++)
					{
						$("#queryDept").append("<option value='"+deptList[i].name+"'>"+deptList[i].name+"</option>");
					}
				}else{
					alert("加载失败")
				}
			},
		});
}
