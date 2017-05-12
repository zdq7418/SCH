/**
 * @author 李龙雨
 * @date: 2017/4/27 22:25
 * @version 0.1
 */
function initTable() {
    var queryUrl = 'role!findAll.action';
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
            field: 'roleName',
            title: '角色名称',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'roleIntroduce',
            title: '角色描述',
            width: 100,
            align: 'center',
            sortable: true
        },{
            field: 'roleId',
            title: '操作',
            width: 140,
            align: 'center',
            formatter: function (value, row, index) {
                var e = '<button id="reset_pad_' + value + '" type="button" class="btn btn-default  btn-xs" style="margin-right:15px;" onclick="selectResources(' + value + ')">角色权限修改</button>';
                // var d = '<button id="update_' + value + '" type="button" class="btn btn-default  btn-xs"  style="margin-right:15px;" onclick="update_isuse(' + value + ',2)">过期</a> ';
                return e ;
            }
        }],
        // onDblClickRow: function (row, $element, id) {
        //     $("#people_name").val(row.lwOptPersonnel.personnelName)
        //     $("#login_name").val(row.loginName);
        //     $("#loginId").val(row.loginId);
        //     if (row.lwOptPersonnel.personnelSex == "男") {
        //         $("input[name=optionsRadiosinline]").get(0).checked = true;
        //     } else {
        //         $("input[name=optionsRadiosinline]").get(1).checked = true;
        //     }
        //     if (row.lwOptPersonnel.isTeacher == 1) {
        //         $("input[name=isTeacher]").get(0).checked = true;
        //     } else {
        //         $("input[name=isTeacher]").get(1).checked = true;
        //     }
        //     $('#updateLogin').modal('show');
        // },
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

function selectResources(id) {
    $.ajax({
        url: "role!selectRessourcesByRole.action",
        type: "POST",
        dataType: "json",
        data: {
            "id": id,
        },
        success: function (data) {
            
            $('#select_per').modal('show');
        },
        error:function(){
            alert("未知错误！");
        }
    });
}