/**
 * @author 李龙雨
 * @date: 2017/5/4 20:49
 * @version 0.1
 */
function clickSubmit() {
    var people_name=$("#people_name").val().trim();
    var login_name=$("#login_name").val().trim();
    var login_password1=$("#login_password1").val().trim();
    var login_password2=$("#login_password2").val().trim();
    var is_teacher=$("#is_teacher").is(':checked');
    var login_sex=$("input[name='optionsRadiosinline']:checked").val();
    if(people_name==null || people_name==""){
        togglebox("姓名不能为空！","people_name");
        return false;
    }
    if(people_name.length>5 || people_name<2){
        togglebox("姓名长度必须在2个到5个之间！","people_name");
        return false;
    }
    if(login_name==null || login_name==""){
        togglebox("用户名不能为空！","login_name");
        return false;
    }
    if(people_name.length>14){
        togglebox("用户名长度不得超过14位！","login_name");
        return false;
    }
    if(login_password1==null || login_password1==""){
        togglebox("密码不能为空！","login_password1");
        return false;
    }
    if(login_password2==null || login_password2==""){
        togglebox("确认密码不能为空！","login_password2");
        return false;
    }
    if(login_password1!=login_password2){
        togglebox("两次密码不一致！","login_password2");
        return false;
    }
    var te=0;
    if(is_teacher){
        te=1;
    }
    $.ajax({
        url:"personnel!savePersonnel.action",
        type:"POST",
        dataType:"json",
        data:{
            "peopleName":people_name,
            "loginName":login_name,
            "loginPassword":login_password1,
            "isTeacher":te,
            "loginSex":login_sex,
        },
        success:function(data){
            if(data==0){
                togglebox("用户名存在","login_name");
            }else{
                alert("保存成功");
                $("#people_name").val("");
                $("#login_name").val("");
                $("#login_password1").val("");
                $("#login_password2").val("");
            }
        },
        error:function(){
            togglebox("未知错误！","update_"+value);
        }
    });
    return true;
}
function togglebox(info,name) {
    $("#"+name).popover({content:info,container:'body',placement:'auto left'});
    $("#"+name).popover('show');
    setTimeout(function () {
        $("#"+name).popover('destroy');
    },2000);
}
function blurLoginName() {
    var login_name=$("#login_name").val().trim();
    $.ajax({
        url:"personnel!checkLoginName.action",
        type:"POST",
        dataType:"json",
        data:{
            "loginName":login_name,
        },
        success:function(data){
            if(data==0){
                togglebox("用户名存在","login_name");
                $("#login_name").val("");
            }
        }
    });
}