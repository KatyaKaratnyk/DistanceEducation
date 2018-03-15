 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <header>
	<div class="headerText">
		<span>Дистанційне навчання<br>Школа №1024</span>
	</div>
	<div class="logoImage">
		<img src="${pageContext.request.contextPath}/resources/img/logo.png">
	</div>
	<div>
		<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username" var="username"/>
	     	<li><a href="/user">${username}</a></li>
					<form:form action="/logout" method="post">
						<li><input type="submit" value="logout" /></li>
					</form:form>
			</sec:authorize>     
	
	</div>  
</header>

<nav>
	<ul>
		<li><a href="${pageContext.request.contextPath}/">Головна</a></li>
		<li><a href="">Навчальні програми</a></li>
		<li><a href="">Інформація</a></li>
		<li><a href="">Допомога</a></li>
		<li><a href="">Контакти</a></li>
	</ul>
	<span> 
	<hr class="horizontalLine">
	</span>
</nav>