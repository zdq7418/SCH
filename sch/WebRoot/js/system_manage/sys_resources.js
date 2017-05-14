/**
 * @author 李龙雨
 * @date: 2017/4/27 22:25
 * @version 0.1
 */
function initTable() {
    var queryUrl = 'resources!findAll.action';
    $('#para_table').bootstrapTable('destroy');
    $table = $('#para_table').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",
        url: queryUrl,
        pagination: true,
        pageSize: 5,
        // pageList:[2,5,10],
        queryParamsType: 'limit',
        // queryParams:queryParams(this),
        search: true, //显示 搜索框
        showColumns: false, //不显示下拉框（选择显示的列）
        sidePagination: "client", //客户端请求
        columns: [{
            field: 'resourceName',
            title: '资源名称',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'resourceParent',
            title: '父节点',
            width: 100,
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                var e="";
                if(value==0){
                     e="根节点";
                }else if(value==3){
                     e="班级管理";
                }else if(value==4){
                     e="课程管理";
                }else if(value==5){
                     e="成绩管理";
                }else if(value==6){
                     e="系统管理";
                }else if(value==8){
                     e="宿舍管理";
                }
                return e;
            }
        }, {
            field: 'resourcePath',
            title: '地址',
            width: 150,
            align: 'center',
            sortable: true
        }
        // ,{
        //     field: 'resourceId',
        //     title: '操作',
        //     width: 140,
        //     align: 'center'
        //     formatter: function (value, row, index) {
        //         var e = '<button id="reset_pad_' + value + '" type="button" class="btn btn-default  btn-xs" style="margin-right:15px;" onclick="update_per(' + value + ')">重置密码</button>';
        //         // var d = '<button id="update_' + value + '" type="button" class="btn btn-default  btn-xs"  style="margin-right:15px;" onclick="update_isuse(' + value + ',2)">过期</a> ';
        //         return e;
        //     }
        // }
        ],
        onDblClickRow: function (row, $element, id) {
            $("#myModalLabel").html("资源信息修改");
            $("#loginId").val(row.resourceId)
            $("#people_name").val(row.resourceName);
            $("#select").val(row.resourceParent);
            $("#dizi").val(row.resourcePath);
            $('#updateLogin').modal('show');
        },
        onLoadSuccess: function () {

        },
        onLoadError: function () {
            mif.showErrorMessageBox("数据加载失败！");
        }
    });
}

function selectuserinfo() {
    initTable();
}

function togglebox(info, name) {
    $("#" + name).popover({content: info, container: 'body', placement: 'auto left'});
    $("#" + name).popover('show');
    setTimeout(function () {
        $("#" + name).popover('destroy');
    }, 2000);
}
function updateLoginAndPer() {
    var id=$("#loginId").val();
    var name=$("#people_name").val();
    var select=$("#select").val();
    var dizi=$("#dizi").val();
    $.ajax({
        url: "resources!attachDirty.action",
        type: "POST",
        dataType: "json",
        data: {
            "id": id,
            "name": name,
            "select": select,
            "dizi": dizi,
        },
        success: function (data) {
            if (data == 1) {
                $('#updateLogin').modal('hide');
                alert("修改成功！");
                initTable();
            } else {
                $('#updateLogin').modal('hide');
                alert("保存成功!");
                initTable();
            }
        },
        error: function () {
            alert("未知错误！");
        }
    });
}
function insert_resource() {
    $("#myModalLabel").html("资源信息添加");
    $("#loginId").val("");
    $("#people_name").val("");
    $("#select").val(0);
    $("#dizi").val("");
    $('#updateLogin').modal('show');
}