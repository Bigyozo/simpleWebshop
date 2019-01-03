<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div.head{
		padding-left: 25px;
	}
	span.head{
		 position:absolute;
   		 left:1500px;
   		 top:50px;
   		 font-size: 20px
	}
</style>
</head>
<body>
    <div class="head"><img width=80 height=80 src="${pageContext.request.contextPath}/client/images/head.jpg">
    	<img width=400 height=90 src="${pageContext.request.contextPath}/client/images/title.png">
    	<span class="head">
    	<a href="${pageContext.request.contextPath}/client/cart.jsp">购物车</a>
    	|<a href="${pageContext.request.contextPath}/client/register.jsp">新用户注册</a>
    	|<c:if test="${user!=null}">
    	<a href="${pageContext.request.contextPath}/client/myAccount.jsp">我的账户</a>
    	</c:if>
    	<c:if test="${user==null}">
    	<a href="${pageContext.request.contextPath}/client/login.jsp">登陆</a>
    	</c:if>
    	</span>		
    </div>
		                                                                                                                                                                                                      
</body>
</html>