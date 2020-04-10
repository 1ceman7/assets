//全局变量
var id = "";
//回显数据
function input_list() {
		$.ajax({
			url:"/Test_assets/dept/update_list",
			method:"POST",
			data:{"id": window.location.search.split("id=")[1]},
			success:function (deptModel) {
				if (deptModel.id==null){
					//修改页面标题
					$('#title').append('部门管理-新增部门');
				}else{
					$('#title').append('部门管理-修改部门');
					//设置数据回显
					$('#update_name').val(deptModel.name);
					$('#update_tel').val(deptModel.tel);
				}
			}
		});
}
//根据id判断使用save或update
function save_update() {
	$('#commit').on('click',function () {
		id = window.location.search.split("id=")[1];
		if (id == null){
			save();
		}else{
			update();
		}

	})
}
//保存
function save() {
	var update_name = $('#update_name').val();
	var update_tel = $('#update_tel').val();
		if (!update_name){
			alert("部门名称不能为空");
			return false;
		};
		if (!update_tel){
			alert("部门电话不能为空");
			return false;
		}
	$.ajax({
		url:"/Test_assets/dept/save",
		method: 'POST',
		data:{
			name:update_name,
			tel:update_tel
		},
		datatype: "TEXT",
		success: function (data) {
			if (data == 'saveOk'){
				alert('保存成功,点击确定跳转页面');
				window.location.href = "list.html";
			}
		}
	})
}
//修改
function update() {
	//var id = window.location.search.split("id=")[1];
	var update_name = $('#update_name').val();
	var update_tel = $('#update_tel').val();
	if (!update_name){
		alert("部门名称不能为空");
		return false;
	};
	if (!update_tel){
		alert("部门电话不能为空");
		return false;
	}
	$.ajax({
		url:"/Test_assets/dept/update",
		method: 'POST',
		data:{
			id:id,
			name:update_name,
			tel:update_tel
		},
		datatype: "TEXT",
		success: function (data) {
			if (data == 'updateOk'){
				alert('修改成功,点击确定跳转页面');
				window.location.href = "list.html";
			}
		}
	})
}
