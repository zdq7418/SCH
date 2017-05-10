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
    <style type="text/css">
        a:link {
            text-decoration: none;
        }

        a:hover {
            text-decoration: none;
        }
    </style>
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
            <div class="panel-group" id="panel-731035">
                <div class="panel panel-default">
                    <a class="panel-title" data-toggle="collapse" data-parent="#panel-731035"
                       href="#panel-element-881532">
                        <div class="panel-heading bg-success">
                            系统管理
                        </div>
                    </a>
                    <div id="panel-element-881532" class="panel-collapse">
                        <a href="jsp/system_manage/sys_people_insert.jsp" target="right">
                            <div class="panel-body">人员录入</div>
                        </a>
                        <a href="jsp/system_manage/sys_people.jsp" target="right">
                            <div class="panel-body">人员管理</div>
                        </a>
                        <a href="jsp/system_manage/sys_resources.jsp" target="right">
                            <div class="panel-body">资源管理</div>
                        </a>
                    </div>
                </div>
                <div class="panel panel-default">
                    <a class="panel-title" data-toggle="collapse" data-parent="#panel-731035" href="#panel-element-757284">
                        <div class="panel-heading">
                            111
                        </div>
                    </a>
                    <div id="panel-element-757284" class="panel-collapse collapse">
                        <div class="panel-body">111</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-10 col-lg-10">
            <br/>
            <iframe width="100%" height="89%" scrolling="no" frameborder="0" name="right"></iframe>
        </div>
    </div>
</div>
</body>
</html>
