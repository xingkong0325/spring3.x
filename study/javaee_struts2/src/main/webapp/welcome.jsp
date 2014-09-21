<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><s:text name="succPage"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<s:text name="succTip">
		<s:param>${sessionScope.user}</s:param><br/>
	</s:text><br/>
	本站访问次数为：${applicationScope.counter}<br/>
	${requestScope.tip }<br/>
	从系统读取cookie的值：${cookie.user.value }<br/>
</body>
</html>
