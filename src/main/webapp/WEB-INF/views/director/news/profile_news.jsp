<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="profileNews">
    <div class="seachAndAdd linkLikeButton">
    	<div class="profileNews"><a class="linkLikeButton" href="${pageContext.request.contextPath}/director/edit/news${newsModel.getId()}">редагувати новину</a> </div>
    	<div class="profileNews"><a class="linkLikeButton" href="${pageContext.request.contextPath}/director/remove/news${newsModel.getId()}">видалити новину</a></div>
    </div>
    	
    	<div class="profileNews"><span>${newsModel.title}</span></div>
    	
		<div class="profileNews"><span></span>Опис:</div>
    	<div class="profileNews"><span>${newsModel.description}</span></div>
    	
    	<div class="profileNews">
			<c:choose>
				<c:when test="${not empty newsModel.encodedToByte}">
					<img src="data:image/png;base64, ${newsModel.encodedToByte}">
				</c:when>
			</c:choose>
		</div>
		
		<div class="profileNews"><span>Автор:</span></div>
		<div class="profileNews"><span>${newsModel.fullNameUser}</span></div>
		

    </div>
