<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="seachAndAdd">
	<form:form action="" method="post" class="seachAndAdd">
		<div><input type="text" name="titleFilter" placeholder="пошук"></div>
		<div><input type="submit" value="здійснити пошук"></div>
	</form:form>
	<form:form action="" method="post">
		<div><input type="submit" value="очистити пошук"></div>
	</form:form>
	
	<div class="linkLikeButton"><a class="linkLikeButton" href="${pageContext.request.contextPath}/director/add_teacher">+додати вчителя</a></div>
	
</div>
<div class="viewTable">
	<table class="viewTable">
	<tr>
		<td class="newsCol1">Прізвище</td>
		<td class="newsCol2">Ім'я</td>
		<td class="newsCol2">По-батькові</td>
		<td class="newsCol3">Предмет</td>
	</tr>
	<c:forEach items="${teacherListModel}" var="one">
		<tr>
		<td class="newsCol1">
			<a  class="linkLikeText" href="">${one.lastName}</a>
		</td>
		<td class="newsCol2">${one.firstName}</td>
		<td class="newsCol2">${one.middleName}</td>
		<td class="newsCol3">${one.subject}</td>
	</tr>
	</c:forEach>
	<tr></tr>
</table>
</div>
<c:url var="firstUrl" value="${pageContext.request.contextPath}/director/teachers/1" />
<c:url var="lastUrl" value="${pageContext.request.contextPath}/director/teachers/${newsList.totalPages}" />
<c:url var="prevUrl" value="${pageContext.request.contextPath}/director/teachers/${currentIndex-1}" />
<c:url var="nextUrl" value="${pageContext.request.contextPath}/director/teachers/${currentIndex+1}" />
<ul class = "ulLikePage">
	<c:choose>
		<c:when test="${currentIndex == 1}">
				<li class="liLikePage"><a href="#">&lt;&lt;</a></li>
				<li class="liLikePage"><a href="#">&lt;</a></li>
				<li class="liLikePage"><a href="${firstUrl}">1</a></li>
		</c:when>
		<c:otherwise>
				<li class="liLikePage"><a href="${firstUrl}">&lt;&lt;</a></li>
				<li class="liLikePage"><a href="${prevUrl}">&lt;</a></li>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
		<c:url var="pageUrl" value="${pageContext.request.contextPath}/director/teachers/${i+1}" />
		<c:choose>
			<c:when test="${i+1 == currentIndex}">
				<li class="liLikePage"><a href="${pageUrl}" /><c:out value="${i+1}"></c:out></a></li>
			</c:when>
			<c:otherwise>
				<li class="liLikePage"><a href="${pageUrl}" /><c:out value="${i+1}"></c:out></a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:choose>
		<c:when test="${currentIndex == newsList.totalPages}">
			<li class="liLikePage"><a href="#">&gt;</a></li>
			<li class="liLikePage"><a href="#">&gt;&gt;</a></li>
		</c:when>
		<c:otherwise>
			<li class="liLikePage"><a href="${nextUrl}">&gt;</a></li>
			<li class="liLikePage"><a href="${lastUrl}">&gt;&gt;</a></li>
		</c:otherwise>
	</c:choose>
</ul>