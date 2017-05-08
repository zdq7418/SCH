<%--
   @author 李龙雨
   @date: 2017/5/4 20:48
   @version 0.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/comlw.jsp" %>
<script type="text/javascript" src="<%=basePath %>js/system_manage/sys_people_insert.js"></script>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form">
                <div class="form-group">
                    <label for="people_name">姓名：</label><input type="text" class="form-control" id="people_name"
                                                               placeholder="请输入姓名"/>
                </div>
                <div class="form-group">
                    <label>性别：</label>
                    <label class="checkbox-inline">
                        <input type="radio" name="optionsRadiosinline" value="男" checked> 男
                    </label>
                    <label class="checkbox-inline">
                        <input type="radio" name="optionsRadiosinline" value="女"> 女
                    </label>
                </div>
                <div class="form-group">
                    <label for="people_name">账户：</label><input type="text" class="form-control" id="login_name"
                                                               placeholder="请输入账户名" onblur="blurLoginName();"/>
                </div>
                <div class="form-group">
                    <label for="login_password1">密码：</label><input type="password" class="form-control"
                                                                   id="login_password1" placeholder="请输入密码"/>
                </div>
                <div class="form-group">
                    <label for="login_password2">确认密码：</label><input type="password" class="form-control"
                                                                     id="login_password2" placeholder="请再输入密码"/>
                </div>
                <div class="checkbox">
                    <label><input type="checkbox" id="is_teacher" />是否是教师</label>
                </div>
                <button type="button" class="btn btn-default btn-lg center-block" onclick="clickSubmit();">保存</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
