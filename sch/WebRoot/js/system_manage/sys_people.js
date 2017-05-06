/**
 * @author 李龙雨
 * @date: 2017/4/27 22:25
 * @version 0.1
 */
function initTable() {
    var queryUrl = 'personnel!findAll.action';
    $('#para_table').bootstrapTable('destroy');
    $table = $('#para_table').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",
        url: queryUrl,
        pagination: true,
        pageSize:5,
        // pageList:[2,5,10],
        queryParamsType:'limit',
        // queryParams:queryParams(this),
        search: true, //显示 搜索框
        showColumns: false, //不显示下拉框（选择显示的列）
        sidePagination: "client", //客户端请求
        columns: [{
            field: 'lwOptPersonnel.personnelName',
            title: '姓名',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'lwOptPersonnel.personnelSex',
            title: '性别',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'lwOptPersonnel.inductionDate',
            title: '入职日期',
            width: 200,
            align: 'center',
            sortable: true
        }, {
            field: 'loginName',
            title: '账号',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'isUse',
            title: '是否使用',
            width: 100,
            align: 'center',
            formatter : function (value, row, index){
                if(value==0){
                    return "未使用";
                }else{
                    return "使用";
                }
            }
        },{
            field: 'lwOptPersonnel.isTeacher',
            title: '身份',
            width: 100,
            align: 'center',
            formatter : function (value, row, index){
                if(value==0){
                    return "学生";
                }else{
                    return "教师";
                }
            }
        },{
            field: 'loginId',
            title: '操作',
            width: 140,
            align: 'center',
            formatter : function (value, row, index){
                var e = '<button id="reset_pad_'+value+'" type="button" class="btn btn-default  btn-xs" style="margin-right:15px;" onclick="reset_password('+value+')">重置密码</button>';
                var d = '<button id="update_'+value+'" type="button" class="btn btn-default  btn-xs"  style="margin-right:15px;" onclick="update_isuse('+value+')">过期</a> ';
                return e + d;
            }
        }],
        onDblClickRow:function (row,$element,id) {
            alert($element);
            alert(row);
        },
        onLoadSuccess: function () {

        },
        onLoadError: function () {
            mif.showErrorMessageBox("数据加载失败！");
        }
    });
}
function reset_password(value) {
    //重置密码
    
}
function update_isuse(value) {
    //过期
    $.ajax({
        url:"personnel!overdue.action",
        type:"POST",
        dataType:"json",
        data:{
            "loginId":value,
        },
        success:function(data){
            if(data==1){
                initTable();
            }else{
                togglebox("出错了，没有找到ID","update_"+value);
            }
        },
        error:function(){
            togglebox("未知错误！","update_"+value);
        }
    });
}
function selectuserinfo() {
    initTable();
}

function togglebox(info,name) {
    $("#"+name).popover({content:info,container:'body',placement:'auto left'});
    $("#"+name).popover('show');
    setTimeout(function () {
        $("#"+name).popover('destroy');
    },2000);
}