<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
   @author 李龙雨
   @date: 2017/5/8 20:54
   @version 0.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/comlw.jsp" %>
<script type="text/javascript" src="<%=basePath %>js/system_manage/sys_resources.js"></script>
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
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <input type="hidden" id="loginId"/>
                        <label for="people_name" class="col-sm-2 control-label">资源名称：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="people_name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="people_name" class="col-sm-2 control-label">父节点：</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="select">
                                <option value="0">根节点</option>
                                <c:forEach items="${listRoleRes}" var="listRoleRes">
                                    <option value="${listRoleRes.resourceId}">${listRoleRes.resourceName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="people_name" class="col-sm-2 control-label">地址：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="dizi"/>
                        </div>
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
<button type="button" class="btn btn-primary btn-lg" onclick="insert_resource()">+ 新增</button>
<table class="table" id="para_table">

</table>
</body>
</html>
