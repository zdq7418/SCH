<%--
   @author 李龙雨
   @date: 2017/4/27 22:15
   @version 0.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/comlw.jsp" %>
<script type="text/javascript" src="<%=basePath %>js/system_manage/sys_people.js"></script>
<html>
<head>
    <title></title>
</head>
<body onload="selectuserinfo();">
<div class="modal fade" id="updateLogin" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    信息修改
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <input type="hidden" id="loginId"/>
                        <label for="people_name" class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="people_name" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="people_name" class="col-sm-2 control-label">性别：</label>
                        <label class="checkbox-inline">
                            <input type="radio" name="optionsRadiosinline" value="男"> 男
                        </label>
                        <label class="checkbox-inline">
                            <input type="radio" name="optionsRadiosinline" value="女"> 女
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="people_name" class="col-sm-2 control-label">账户：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="login_name" placeholder="请输入账户名" onblur="blurLoginName();"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="people_name" class="col-sm-2 control-label">身份：</label>
                        <label class="checkbox-inline">
                            <input type="radio" name="isTeacher" value="1"> 教师
                        </label>
                        <label class="checkbox-inline">
                            <input type="radio" name="isTeacher" value="0"> 学生
                        </label>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updateLoginAndPer();">保存</button>
            </div>
        </div>
    </div>
</div>
<table class="table" id="para_table">

</table>
</body>
</html>
