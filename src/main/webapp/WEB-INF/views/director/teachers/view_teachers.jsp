<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="seachAndAdd">
	<form:form action="${pageContext.request.contextPath}/director/search/teachers/1" method="get" class="seachAndAdd" modelAttribute="filterModel">
		<div><form:input path="search" placeholder="пошук"/></div>
		<div><form:select path="subject">
			<option value="${null}">Всі предмети</option>
			<c:forEach items="${subjectModel}" var="subject">
				<option value="${subject}">${subject.title}</option>
			</c:forEach>
		</form:select></div>
		<div><input type="submit" value="здійснити пошук"></div>
	</form:form>
	<form:form action="${pageContext.request.contextPath}/director/teachers/remove-filter" method="get">
		<div><input type="submit" value="очистити пошук"></div>
	</form:form>
	
	<div class="linkLikeButton"><a class="linkLikeButton" href="${pageContext.request.contextPath}/director/add_teacher">+додати вчителя</a></div>
	
</div>
<div class="viewTable">
	<table class="viewTable">
	<thead>
	<tr>
		<td class="col1">Прізвище</td>
		<td class="col2">Ім'я</td>
		<td class="col2">По-батькові</td>
		<td class="col3">Предмет</td>
	</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${teacherListModel}" var="one">
			<tr onclick="openWin('${pageContext.request.contextPath}/director/profile-teacher${one.id}')">
				<td class="col1">${one.lastName}</td>
				<td class="col2">${one.firstName}</td>
				<td class="col2">${one.middleName}</td>
				<td class="col3">${one.subject}</td>
			</tr>
		</c:forEach>
	</tbody>
	
</table>
</div>
<c:url var="firstUrl" value="${pageContext.request.contextPath}/director/teachers/1" />
<c:url var="lastUrl" value="${pageContext.request.contextPath}/director/teachers/${teachersList.totalPages}" />
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
		<c:when test="${currentIndex == teachersList.totalPages}">
			<li class="liLikePage"><a href="#">&gt;</a></li>
			<li class="liLikePage"><a href="#">&gt;&gt;</a></li>
		</c:when>
		<c:otherwise>
			<li class="liLikePage"><a href="${nextUrl}">&gt;</a></li>
			<li class="liLikePage"><a href="${lastUrl}">&gt;&gt;</a></li>
		</c:otherwise>
	</c:choose>
</ul>