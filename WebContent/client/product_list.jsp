<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/body.css" type="text/css" />
</head>
<c:import url="head.jsp"></c:import>
<c:import url="menu.jsp"></c:import>
<body>
<h1 class="center">商品列表</h1>
<div>
	<table class="table" width="70%" border="1">
		<tr style="font-size:30px">			
			<td width="25%">商品图片</td>
			<td width="15%">商品名称</td>
			<td width="10%">价格</td>	
			<td width="10%">库存</td>	
			<td width="10%">操作</td>		
		</tr>
	
	<c:forEach var="entry" items="${bean.map}">
		<tr style="font-size:30px">			
			<td width="25%"><img width=300 height=200 src="${pageContext.request.contextPath}/client/productImages/${entry.value.id}.jpg"/></td>
			<td width="15%">${entry.value.name }</td>
			<td width="10%">${entry.value.price }</td>	
			<td width="10%">${entry.value.pnum }</td>
			<td width="10%"><a href="${pageContext.request.contextPath}/AddCart?id=${entry.key}&category=${bean.category}" target="_blank">购买</a></td>	
						
		</tr>
	</c:forEach>
	
	</table>
	</div>
	<br/>
	<p class="table">
	<c:if test="${bean.currentPage>1}">
	<a href="${pageContext.request.contextPath}/showProductByPage?category=${bean.category}
	&currentPage=${bean.currentPage-1}">上一页</a>
	</c:if>
	&nbsp;第${bean.currentPage}页,共${bean.pageSize}页 &nbsp;
	<c:if test="${bean.currentPage < bean.pageSize}">
	<a href="${pageContext.request.contextPath}/showProductByPage?category=${bean.category}
	&currentPage=${bean.currentPage+1}">下一页</a>
	</c:if>
	</p>
	<br/>
	<hr/>
	<p class="right">
	<a href="${pageContext.request.contextPath}/client/index.jsp">返回首页</a>
	</p>
</body>
</html>