<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人账户</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/body.css" type="text/css" />
</head>
<c:import url="head.jsp"></c:import>
<c:import url="menu.jsp"></c:import>
<body>
<h1 class="center">欢迎您，${user.username}</h1>
<h3 class="center"><a href="${pageContext.request.contextPath}/orderShow">查看我的订单</a>
<br/>
<c:if test="${orders!=null}">
	<table class="table"  border="1" width="80%" cellspacing="0">
		<tr>
		<td width="20%">下单时间</td>
		<td width="10%">金额</td>
		<td width="10%">收货人</td>
		<td width="20%">收货地址</td>
		<td width="20%">联系电话</td>
		<td width="20%">支付状态</td>
		</tr>
		<c:forEach items="${orders}" var="entry">
		<tr>
		<td width="20%"><fmt:formatDate type="date" value="${entry.ordertime}" dateStyle="default"/></td>
		<td width="10%">${entry.money}</td>
		<td width="10%">${entry.receiverName}</td>
		<td width="20%">${entry.receiverAddress}</td>
		<td width="20%">${entry.receiverPhone}</td>
		<td width="20%"><c:if test="${entry.paystate==1}">已支付</c:if>
		<c:if test="${entry.paystate==0}">未支付</c:if>
		</td>
		</tr>
		</c:forEach>
	</table>
</c:if>
<br/>
<hr/>
<div class="right">
<a href="${pageContext.request.contextPath}/loginout">注销</a>
</div>
</body>
</html>