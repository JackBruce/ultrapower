<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<!--
	<script src="lib/jquery-1.12.1.min.js"></script>
 	<script src="lib/DataTables-1.10.15/media/js/jquery.js"></script>
    <link href="lib/DataTables-1.10.15/media/css/jquery.dataTables.css" rel="stylesheet">
    <script src="lib/DataTables-1.10.15/media/js/jquery.dataTables.js"></script>
    <link href="lib/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="lib/bootstrap-3.3.6/js/bootstrap.min.js"></script> 
-->

	<!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css"	href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">
	<!-- jQuery -->
	<script type="text/javascript" charset="utf8"	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	<!-- DataTables -->
	<script type="text/javascript" charset="utf8"	src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
	<!-- bootstrap -->
	<link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"	rel="stylesheet">
	<script	src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
	


</head>
<body>
	<a href='${pageContext.request.contextPath }/emp/queryEmp'>员工管理</a>
	<br>
	<a href='${pageContext.request.contextPath }/freemarker/hello'>hello ftl</a>
	<br>
	<a href='${pageContext.request.contextPath }/freemarker/world'>world jsp</a>
	<br>
	<a href="${pageContext.request.contextPath }/goDataTables">GoDataTables</a>
	<br>
	<a href="${pageContext.request.contextPath }/goHighCharts">GoHighCharts</a>
	<br>
    <a href="${pageContext.request.contextPath }/dtConfirm">DataTablesConfirm</a>
    <br>
</body>
</html>