<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="seachAndAdd">
	<form:form action="${pageContext.request.contextPath}/director/search/news" method="post" class="seachAndAdd">
		<div><input type="text" name="titleFilter" placeholder="пошук"></div>
		<div><input type="submit" value="здійснити пошук"></div>
	</form:form>
	<form:form action="${pageContext.request.contextPath}/director/remove_filter/news" method="post">
		<div><input type="submit" value="очистити пошук"></div>
	</form:form>
	
	<div class="linkLikeButton"><a class="linkLikeButton" href="${pageContext.request.contextPath}/director/add_news">+додати новину</a></div>
	
</div>
<div class="viewTable">
	<table class="viewTable">
	<thead>
	<tr>
		<td class="newsCol1">Назва новини</td>
		<td class="newsCol2">Опис новини</td>
		<td class="newsCol3">Постер новини</td>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${newsListByPageSize}" var="newOne">
			<tr onclick="openWin('${pageContext.request.contextPath}/director/profile/news${newOne.id}')">
				<td class="newsCol1">${newOne.title}</td>
				<td class="newsCol2">${newOne.description}</td>
				<td class="smallImg newsCol3">
					<c:choose>
						<c:when test="${not empty newOne.encodedToByte}">
							<img src="data:image/png;base64, ${newOne.encodedToByte}">
						</c:when>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
<c:url var="firstUrl" value="${pageContext.request.contextPath}/director/news/1" />
<c:url var="lastUrl" value="${pageContext.request.contextPath}/director/news/${newsList.totalPages}" />
<c:url var="prevUrl" value="${pageContext.request.contextPath}/director/news/${currentIndex-1}" />
<c:url var="nextUrl" value="${pageContext.request.contextPath}/director/news/${currentIndex+1}" />
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
		<c:url var="pageUrl" value="${pageContext.request.contextPath}/director/news/${i+1}" />
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
		
<%-- <form method="get">
	<div>
		<label for="sortByField">Sort by Field</label>
		<select name="field">
			<option value="${sordByField}">${sordByField}</option>
			<option value="name">name</option>
		</select>
		<label for="sortBy">Sort by</label>
		<select name="field">
			<option value="${sordByField}">${sordByField}</option>
			<option value="name">name</option>
		</select>
	</div>

</form>	 --%>