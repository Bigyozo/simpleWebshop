<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/body.css" type="text/css" />
</head>
<c:import url="head.jsp"></c:import>
<c:import url="menu.jsp"></c:import>
<body>
<c:if test="${user!=null}">
<h1>订单确认</h1>
	<form action="${pageContext.request.contextPath}/createOrder" method="post">
		<table border="1" width="80%" cellspacing="0">
			<tr>
				<td width="10%">序号</td>
				<td width="30%">商品名称</td>
				<td width="20%">价格</td>
				<td width="20%">数量</td>
				<td width="20%">小计</td>
			</tr>
		</table>
		<c:set var="total" value="0" />
		<c:forEach items="${cart}" var="entry" varStatus="vs">
			<table width="80%" border="1" cellspacing="0">
				<tr>
					<td width="10%">${vs.count}</td>
					<td width="30%">${entry.key.name}</td>
					<td width="20%">${entry.key.price }</td>
					<td width="20%">
					<input name="text" type="text"
						value="${entry.value}" style="width: 20px" readonly="readonly"/>
					</td>
					<td width="20%">${entry.key.price*entry.value}</td>
				</tr>
			</table>
			<c:set var="total" value="${total+entry.key.price*entry.value}" />
		</c:forEach>
		<table cellspacing="1" class="carttable">
			<tr>
				<td style="text-align: right; padding-right: 40px;">
				<font style="color:#FF0000">合计：&nbsp;&nbsp;${total}元</font>
				<input type="hidden" name="money" value="${total}"/> 
				</td>
			</tr>
		</table>
		<div style="text-align:left">
		收货地址：<input name="receiverAddress" type="text" value="" style="width:350px"/><br/>
		收货人：<input name="receiverName" type="text" value="" style="width:350px"/><br/>
		联系方式：<input name="receiverPhone" type="text" value="" style="width:350px"/><br/>
		</div>
		<hr/>
		<p style="text-align:right">
		<input type="submit" value="提交订单">
		</p>
	</form>
</c:if>
<c:if test="${user==null}">
		<h1 class="center">您尚未登录请先登录</h1><br/>
		<p class="center">
		<a href="${pageContext.request.contextPath}/client/login.jsp">登录</a>
		<p>
</c:if>
</html>