<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/body.css" type="text/css" />
</head>
<c:import url="head.jsp"></c:import>
<c:import url="menu.jsp"></c:import>
<body>
	<h1 class="center">登录</h1>
	<div>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<table class="table">
				<tr>
					<td style="text-align: right;width25%">用户名：&nbsp;</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td style="text-align: right;width25%">密码：&nbsp;</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" value="登录" /></td>
				</tr>
			</table>
			<hr />
		</form>
	</div>
	<h2>${error_message}</h2>
</body>
</html>