<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="seachAndAdd">
	<form:form action="${pageContext.request.contextPath}/director/search/classes/1" method="get" class="seachAndAdd">
		<div>
			<select name="gradeFilter">
				<option value="${null}">Всі класи</option>
				<c:forEach items="${gradeModel}" var="grade">
					<option value="${grade}">${grade.title}-і класи</option>
				</c:forEach>
			</select>
		
		</div>
		<div><input type="submit" value="здійснити пошук"></div>
	</form:form>
	<form:form action="${pageContext.request.contextPath}/director/classes/remove-filter" method="get">
		<div><input type="submit" value="очистити пошук"></div>
	</form:form>
	
	<div class="linkLikeButton"><a class="linkLikeButton" href="${pageContext.request.contextPath}/director/add_class">+додати клас</a></div>
	
</div>
<div class="viewTable">
	<table class="viewTable">
	<thead>
	<tr>
		<td class="col1">Назва класу</td>
		<td class="col2">Класний керівник</td>
		<td class="col3">Кількість учнів в класі</td>
	</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${classesListModel}" var="one">
			<tr onclick="openWin('${pageContext.request.contextPath}/director/profile-class${one.id}')">
				<td class="col1">${one.titleClass}</td>
				<td class="col2">${one.classTeacher}</td>
				<td class="col3">${one.listStudentsInClass.size()}</td>
			</tr>
		</c:forEach>
	</tbody>
	
</table>
</div>
<c:url var="firstUrl" value="${pageContext.request.contextPath}/director/classes/1" />
<c:url var="lastUrl" value="${pageContext.request.contextPath}/director/classes/${classesList.totalPages}" />
<c:url var="prevUrl" value="${pageContext.request.contextPath}/director/classes/${currentIndex-1}" />
<c:url var="nextUrl" value="${pageContext.request.contextPath}/director/classes/${currentIndex+1}" />
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
		<c:url var="pageUrl" value="${pageContext.request.contextPath}/director/classes/${i+1}" />
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
		<c:when test="${currentIndex == classesList.totalPages}">
			<li class="liLikePage"><a href="#">&gt;</a></li>
			<li class="liLikePage"><a href="#">&gt;&gt;</a></li>
		</c:when>
		<c:otherwise>
			<li class="liLikePage"><a href="${nextUrl}">&gt;</a></li>
			<li class="liLikePage"><a href="${lastUrl}">&gt;&gt;</a></li>
		</c:otherwise>
	</c:choose>
</ul>