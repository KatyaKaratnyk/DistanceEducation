<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

	<sec:authorize access="!isAuthenticated()"> <!-- Якщо не залогінений -->
		<ul class="leftUl">
			<li><a href="">Головна</a></li>
			<li><a href="">Навчальні програми</a></li>
			<li><a href="">Інформація</a></li>
			<li><a href="">Допомога</a></li>
			<li><a href="">Контакти</a></li>
		</ul>
	
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<ul class="leftUl">
				<li><a href="">Директора</a></li>
				<li><a href="${pageContext.request.contextPath}/director">Увійти як директор</a></li>
				<li><a href="${pageContext.request.contextPath}/teacher">Увійти як вчитель</a></li>
				<li><a href="${pageContext.request.contextPath}/student">Увійти як учень</a></li>
				<li><a href="${pageContext.request.contextPath}/director/news/1">Новини</a></li>
			</ul>
		</sec:authorize>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<sec:authorize access="hasRole('ROLE_DIRECTOR')">
			<ul class="leftUl">
				<li><a href="${pageContext.request.contextPath}/director/teachers/1">Вчителі</a></li>
				<li><a href="">Учні</a></li>
				<li><a href="${pageContext.request.contextPath}/director/news/1">Новини</a></li>
				<li><a href="">Курси</a></li>
				<li><a href="${pageContext.request.contextPath}/director/class_for_student">Класи</a></li>
				<li><a href="">Групи</a></li>
			</ul>
		</sec:authorize>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<sec:authorize access="hasRole('ROLE_TEACHER')">
			<ul class="leftUl">
				<li><a href="">Новини</a></li>
				<li><a href="">Курси</a></li>
				<li><a href="">Групи</a></li>
			</ul>
		</sec:authorize>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<sec:authorize access="hasRole('ROLE_STUDENT')">
			<ul class="leftUl">
				<li><a href="">Курси</a></li>
			</ul>
		</sec:authorize>
	</sec:authorize>
	

