<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	
	<sec:authorize access="!isAuthenticated()"> <!-- Якщо не залогінений -->
	
		
	
		<form:form action="/login"  method="POST">
			<span class="textLogin">Логін</span>
			<input type="text" placeholder="Логін" name="login"/>
			<span class="textLogin">Пароль</span>
			<input type="password" placeholder="Пароль" name="password"/>
			<div class="flex">
				<input type="checkbox" name="rememberMe" class="rememberMeCheckBox">
				<p class="rememberMeText">Запам'ятати мене</p>
			</div>
			
			<input class="enter" type="submit" value="Вхід">
		</form:form>
		
		<c:if test="${param.fail}">
			<p class="failLogin">
				Ви вказали невірний логін або пароль
			</p>
		</c:if>
	</sec:authorize>
