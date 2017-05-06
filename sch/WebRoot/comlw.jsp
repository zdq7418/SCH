<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--通用JS-->
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/bootstrap-table.css">
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap-table.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap-table-zh-CN.js"></script>

