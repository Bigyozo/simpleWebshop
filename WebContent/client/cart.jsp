<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/body.css" type="text/css" />
<script type="text/javascript">
	function clearcart(){
		var b=window.confirm("确认清空购物车吗？");
		if(b){
			window.location.href="${pageContext.request.contextPath}/clearcart";
		}
	}	
</script>
</head>
<c:import url="head.jsp"></c:import>
<c:import url="menu.jsp"></c:import>
<body>
<h1 class="center">购物车</h1>
	<table class="table" border="1" width="80%" cellspacing="0" >
		<tr style="font-size:30px">
			<td width="10%">序号</td>
			<td width="30%">商品名称</td>
			<td width="10%">价格</td>
			<td width="20%">数量</td>
			<td width="10%">库存</td>
			<td width="10%">小计</td>
			<td width="10%">取消</td>
		</tr>	
		<c:set var="total" value="0" />
		<c:forEach items="${cart}" var="entry" varStatus="vs">
			
				<tr style="font-size:30px">
					<td width="10%">${vs.count}</td>
					<td width="30%">${entry.key.name}</td>
					<td width="10%">${entry.key.price }</td>
					<td width="20%">
					<a href="${pageContext.request.contextPath}/changecart?id=${entry.key.id}&count=${entry.value-1}"
						style="color: #FF0000; font-weight: bold"> - </a>
					<input name="text" type="text" value="${entry.value}" style="width: 50px" /> 
					<a href="${pageContext.request.contextPath}/changecart?id=${entry.key.id}&count=${entry.value+1}"
					style="color: #FF0000; font-weight: bold"> + </a>
					</td>
					<td width="10%">${entry.key.pnum }</td>
					<td width="10%">${entry.key.price*entry.value }</td>
					<td width="10%"><a
						href="${pageContext.request.contextPath}/changecart?id=${entry.key.id}&count=0"
						style="color: #FF0000; font-weight: bold"> X </a></td>
				</tr>		
			<c:set value="${total+entry.key.price*entry.value}" var="total" />
		</c:forEach>
		</table>
		<br/>
	<table class="table" cellspacing="1">
		<tr>
			<td style="text-align: right; padding-right: 40px;"><span>合计：&nbsp;&nbsp;${total}元</span>
			</td>
			<td><a href="javascript:void(0)" onclick="clearcart()">清空购物车</a>
			</td>
		</tr>
	</table>
	<div class="right">
		<a href="${pageContext.request.contextPath}/client/order.jsp">提交订单</a>&nbsp;
	</div>
	<hr/>
	<div style="text-align: center;">
	<c:if test="${category!=null}">

		<a href="${pageContext.request.contextPath}/showProductByPage?category=${category}">返回商品列表</a>

	</c:if>
	<c:if test="${search!=null}">

		<a href="${pageContext.request.contextPath}/menuSearch?search=${search}">返回商品列表</a>
	
	</c:if>
	</div>
</body>
</html>