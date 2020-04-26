//全局内变量
var qjbl = "";
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

/* 封装添加数据的方法 */
var appendTd = function (tr, item, prop) {
    var value = item[prop];
    var td = $('<td width="13%" height="30">' + value + '</td>');
    tr.append(td);
}

/* 展示数据 */
function getAll() {
    $.ajax({
        url: "/Test_assets/dept/list",
        method: "POST",
        async: false,
        data: {
            name: queryName,
            tel: queryTel,
            pageNum: pageNum,
            //pageCount: pageCount
        },
        success: function (pageModel) {
            var deptList = pageModel.rows;
            pageNum = pageModel.pageNum;
            maxPageNum = pageModel.maxPageNum;
            pageTotal = pageModel.pageTotal;
            /* 查询时无数据展示提示，和底边栏”共几条”数据 */
            total = $('#total');
            inTotal = $('#inTotal');
            num = deptList.length;

            if (num == 0) {
                $("#noThing").html('没有查找到满足条件的数据！');
                /*$("#tdTotal").css("display","none");
                $("#tdIntotal").css("display","none");*/
            }
            /* 清空 tbody 的所有元素 */
            tb = $("#Ttest1");
            tb.html('');
            total.html(pageTotal);
            inTotal.html(pageNum + "/" + maxPageNum);

            /* 为字段赋值*/
            for (var i = 0; i < deptList.length; i++) {
                tr = $('<tr align="center" bgcolor="#FFFFFF">');
                td1 = $('<td width="13%" height="30">');
                span = $('<span style="line-height:12px; text-align:center;">');
                update = $('<a href="" class="xiu" id="update">修改&nbsp&nbsp</a>');
                del = $('<a href="" class="xiu" id="dele" onclick="dele(' + deptList[i].id + ')">删除</a>');
                //将"修改、删除“的按钮添加到span中
                span.append(update);
                span.find(update).attr("href", "/Test_assets/assets/jsps/department/input.html?id=" + deptList[i].id);
                span.append(del);
                td1.append(span);
                //添加数据
                appendTd(tr, deptList[i], 'id');
                appendTd(tr, deptList[i], 'name');
                appendTd(tr, deptList[i], 'tel');
                tr.append(td1);
                tb.append(tr);

            }
        }
    })
}

//查询
function getQuery() {
    $('#query').live('click', 'a', function () {
        queryName = $('#queryName').val();
        queryTel = $('#queryTel').val();
        alert('输入的查询信息是：' + queryName + queryTel);
        getAll();
    })
}

//删除
function dele(data) {
    alert('要删除的id=' + data)
    var c = confirm("是否确定删除")//按确认和取消输出不同的内容
    if (c == true) {
        $.ajax({
            url: "/Test_assets/dept/del",
            method: "POST",
            // async用于控制同步和异步，默认是true,即ajax请求默认是异步请求，
			// 这个同步的意思是当JS代码加载到当前AJAX的时候会把页面里所有的代码停止加载，
			// 页面出现假死状态，当这个AJAX执行完毕后才会继续运行其他代码页面假死状态解除。
			// 而异步则这个AJAX代码运行中的时候其他代码一样可以运行。
            async: false,
            data: {
                id: data
            },
            success: function (empCount) {
                if (empCount <= 0) {
                    alert('删除成功,点击确定跳转页面');
                    window.location.href = "#";
                } else {
                    var d = confirm("还有" + empCount + "名员工未调离，请调离后再删除部门，是否跳转员工模块进行操作");
                    if (d == true) {
                        //可以把参数传到后台方法，后台能查到数据，但没法跳转页面展示
                        /*$.ajax({
                            url: "/Test_assets/emp/list",
                            type: "POST",
                            data:{
                                deptid:data
                            },
                            success: function(){
                                alert('!!!!!!!!!!!!')
                            }})*/
                        //可以跳转页面，但参数没传过去
                        /*var url ='/Test_assets/assets/jsps/employee/list.html?deptid=';
                        window.location.href =url+'+data+';*/
                        //将data值直接传给emp.js中的getEmp方法，接收不到值
                        //getEmp('data');
                        // 可以单纯跳转页面
                        window.location.href = "../../jsps/employee/list.html";
                        return;
                    }
                }
            }
        })
    } else {
        window.location.href = "#";
    }
}

