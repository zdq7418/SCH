<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="comlw.jsp" %>--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>学生管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-table.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <%--<script type="text/javascript" src="js/bootstrap-table.js"></script>--%>
</head>
<body>
<div class="container">
    <div class="row" style="background-color: #F6F4F0;height: 10%;">
        <div class="col-md-4 col-lg-4">
            <h3>学生管理系统</h3>
        </div>
        <div class="col-md-4 col-lg-4">
        </div>
        <div class="col-md-4 col-lg-4">
            <img src="img/tick.png"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 col-lg-2" style="background-color: #F6F4F0;height: 90%;">
            <ul class="nav nav-tabs nav-stacked">
                <li>
                    <a href="#">首页</a>
                </li>
                <li>
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">系统管理</a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="jsp/system_manage/sys_people_insert.jsp" target="right">人员录入</a>
                        </li>
                        <li>
                            <a href="jsp/system_manage/sys_people.jsp" target="right">人员管理</a>
                        </li>
                        <li>
                            <a href="#">角色管理</a>
                        </li>
                        <li>
                            <a href="#">权限管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">信息</a>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉</a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">操作</a>
                        </li>
                        <li>
                            <a href="#">设置栏目</a>
                        </li>
                        <li>
                            <a href="#">更多设置</a>
                        </li>
                        <li>
                            <a href="#">分割线</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="col-md-10 col-lg-10">
            <iframe  width="100%" height="90%" scrolling="no" frameborder="0" name="right"></iframe>
        </div>
    </div>
</div>
</body>
</html>
