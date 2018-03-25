<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="profile">
    <div class="seachAndAdd linkLikeButton">
    	<div class="profile"><a class="linkLikeButton" href="${pageContext.request.contextPath}/director/edit/news${newsModel.getId()}">редагувати новину</a> </div>
    	<div class="profile"><a class="linkLikeButton" href="${pageContext.request.contextPath}/director/remove/news${newsModel.getId()}" onclick="return deleteNews()">видалити новину</a></div>
    </div>
    	
    	<div class="profile"><span>${newsModel.title}</span></div>
    	
		<div class="profile"><span></span>Опис:</div>
    	<div class="profile"><span>${newsModel.description}</span></div>
    	
    	<div class="profile">
			<c:choose>
				<c:when test="${not empty newsModel.encodedToByte}">
					<img src="data:image/png;base64, ${newsModel.encodedToByte}">
				</c:when>
			</c:choose>
		</div>
		
		<div class="profile"><span>Автор:</span></div>
		<div class="profile"><span>${newsModel.fullNameUser}</span></div>
		

    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/javascriptAfter.js" ></script>
    <div class="profile"><a href="#" class="linkLikeButton" onclick="javascript: history.go(-1);">Повернутися</a></div>