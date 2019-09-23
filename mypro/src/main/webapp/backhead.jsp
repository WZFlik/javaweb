<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>

</head>
<body>
	<div id="head">
		<div id="login">登录账号:<font color="red"> ${sessionScope.emp.name }</font>
		<br>真实姓名:<font color="red"> ${sessionScope.emp.realname }</font></div>
	</div>
</body>
</html>