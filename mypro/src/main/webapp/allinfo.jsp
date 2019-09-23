<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 显示优秀项目的详细信息页面-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="background-color:#000000;">
	<div style="width:70%;height:auto;margin:0 auto;">
		<div style="width:100%;height:80px;color:#FFFFFF;border-bottom:2px #FFFFFF solid;margin-top:60px;">
			<div style="text-align:center;">
			<!-- 显示本条题目 -->
				<h2>${sessionScope.item.title }</h2>
			</div>
			<h4>${sessionScope.item.time }</h4>
		</div>
		<div style="width:100%;height:600px;text-indent:2em;color:#FFFFFF;">
			正文
			<p>
				${sessionScope.item.context}
			</p>
		</div>
	</div>
</body>
</html>