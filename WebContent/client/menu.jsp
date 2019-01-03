<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.menu {
	height: 40px;
	background-color: #AAAAAA;
	font-size: 25px;
	text-align: center;
}

.search {
	height: 25px;
	background-color: #CCCCCC;
}
</style>
</head>
<body>
	<div class="menu">
		<a
			href="${pageContext.request.contextPath}/showProductByPage?category=书籍">书籍</a>&emsp;
		<a
			href="${pageContext.request.contextPath}/showProductByPage?category=手机">手机</a>
		&emsp; <a
			href="${pageContext.request.contextPath}/showProductByPage?category=食品">食品</a>
		&emsp; <a
			href="${pageContext.request.contextPath}/showProductByPage?category=家电">家电</a>
		&emsp; <a
			href="${pageContext.request.contextPath}/showProductByPage?category=日用品">日用品</a>
		&emsp; <a
			href="${pageContext.request.contextPath}/showProductByPage?category=电脑主机">电脑主机</a>
		&emsp;<a href="${pageContext.request.contextPath}/showProductByPage">全部商品目录</a>
	</div>
	<div class="search">
		<form action="${pageContext.request.contextPath}/menuSearch">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td style="text-align: right; padding-right: 220px">Search <input
						type="text" name="search" value="请输入商品名" /> <input type="submit"
						value="搜索" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>