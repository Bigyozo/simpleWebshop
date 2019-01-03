<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/body.css" type="text/css" />
</head>
<script>
	function changeImg(){
		document.getElementById("imgId").src="${pageContext.request.contextPath}/imageCode?"+new Date();
	}
</script>
<c:import url="head.jsp"></c:import>
<c:import url="menu.jsp"></c:import>
<body>	
	
	<div id="divcontent">
	<form action="${pageContext.request.contextPath}/register" method="post">
	<table class="table" width="1000px" border="0" cellspacing="0">
	<tr>
		<td style="padding:30px">
		<h1 class="center">新会员注册</h1>
		<table width="70%" border="0" cellspacing="2" >
			<tr>
				<td style="text-align:right" width="30%">会员名:&nbsp;</td>
				<td>
				<input type="text" name="username" value="${form.username}"/>
				<span>${form.errors.username}</span>
				</td>				
			</tr>
			<tr>
				<td style="text-align:right" >密码:&nbsp;</td>
				<td>
				<input type="password" name="password" value="${form.password}"/>
				<span>${form.errors.password}</span>
				</td>
			</tr>
			<tr>
				<td style="text-align:right" >重复密码:&nbsp;</td>
				<td>
				<input type="password" name="repassword" value="${form.repassword}" >
				<span>${form.errors.repassword}</span>
				</td>
				
			</tr>
			<tr>
				<td style="text-align:right" >邮箱:&nbsp;</td>
				<td>
				<input type="text" name="email" value="${form.email}"/>
				<span>${form.errors.email}</span>
				</td>
			</tr>
			<tr>
				<td style="text-align:right" >性别:&nbsp;</td>
				<td colspan="2"><input type="radio" name="gender" value="m" checked="checked"/>男&nbsp;
				<input type="radio" name="gender" value="f"/>女
				</td>
			</tr>
			<tr>
				<td style="text-align:right" >联系电话:&nbsp;</td>
				<td><input type="text" name="telephone" value="${form.telephone}"/>			
				</td>
			</tr>
			<tr>
				<td style="text-align:right" >个人介绍:&nbsp;</td>
				<td colspan="2"><textarea rows="3" cols="25" name="introduce">${form.introduce}</textarea></td>
			</tr>
		</table>
		<hr/>
		<h2>注册校验</h2>
		<table width="70%" border="0" cellspacing="2" class="upline">
			<tr>
				<td style="text-align:right" >输入效验码:&nbsp;</td>
				<td>
				<input type="text" name="imageCode" value="${form.imageCode}">
				<span>${form.errors.imageCode}</span>
				</td>
			</tr>
			<tr>
				<td style="text-align:right" >&nbsp;</td>
				<td><img alt="图片无法显示" src="${pageContext.request.contextPath}/imageCode"
				id="imgId" onclick="changeImg()"></td>
			</tr>
		</table>
		<hr/>
		<table width="70%" border="0" cellspacing="2" class="upline">
		<tr>
		<td style="text-align:right" >&nbsp;</td>
		<td><input style="width:89px;height:36px;background:url(images/signup.jpg)" type ="submit" value="" /></td>
		</tr>
		</table>
		</td>
	</tr>	
	</table>
	</form>
	</div>
	<hr/>
<h2>${error_message}</h2>
</body>
</html>