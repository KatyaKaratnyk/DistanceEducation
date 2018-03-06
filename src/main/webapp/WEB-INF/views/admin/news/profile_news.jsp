<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="profileNews">
    <div class="seachAndAdd linkLikeButton">
    	<div class="profileNews"><a class="linkLikeButton" href="${pageContext.request.contextPath}/admin/edit/news${newsModel.getId()}">редагувати новину</a> </div>
    	<div class="profileNews"><a class="linkLikeButton" href="${pageContext.request.contextPath}/admin/remove/news${newsModel.getId()}">видалити новину</a></div>
    </div>
    	
    	<div class="profileNews"><span>${newsModel.getTitle()}</span></div>
    	<div class="profileNews"><span>${newsModel.getDescription()}</span></div>
    	
    	<div class="profileNews">
			<c:choose>
				<c:when test="${not empty newsModel.getPathToFoto()}">
					<img src="data:image/png;base64, ${foto}">
				</c:when>
			</c:choose>
		</div>

    </div>
