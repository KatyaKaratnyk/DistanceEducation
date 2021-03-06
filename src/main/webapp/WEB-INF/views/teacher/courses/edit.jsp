<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.1.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js" ></script>
<link type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<div class="col-md-8">
<form:form method="POST" action="${pageContext.request.contextPath}/teacher/course/edit/profile${requestModelEdit.idCourse}" modelAttribute="requestModelEdit">
	<nav aria-label="breadcrumb">
  		<ol class="breadcrumb menu-ul-nothover">
   			 <li class="breadcrumb-item"><a href="/teacher/courses/1">КУРСИ</a></li>
   			 <li class="breadcrumb-item"><a href="/teacher/course/profile${requestModelEdit.idCourse}/1">ДЕТАЛІ</a></li>
   			 <li class="breadcrumb-item active" aria-current="page">РЕДАГУВАТИ</li>
  		</ol>
	</nav>
	</form:form>
	<form:form method="POST" action="${pageContext.request.contextPath}/teacher/course/edit/profile${requestModelEdit.idCourse}" modelAttribute="requestModelEdit">
    	<div class="form-group row required">
    		<div class="col-md-12">
     			 <label class="control-label col-sm-2" for="title">Назва:</label>
      				<form:input path="title" maxlength="80" size="500" class="form-control is-invalid" id="title" placeholder="Назва"></form:input>
					<form:errors  path="title" cssClass="error"></form:errors>
        	</div>
		</div>
      
		<div class="form-group row">
   	 		<div class="col-md-12">
				<label class="control-label col-sm-2" for="description">Опис:</label>
      			<form:textarea path="description" maxlength="1000" size="1000" type="text" rows="10" style="resize:none" class="form-control is-invalid" id="description" placeholder="Опис"></form:textarea>
      			<form:errors  path="description" cssClass="error"></form:errors>
    		</div>
    	</div>
  		<div class="form-group row required">
    		<div class="col-md-12">
     		 	<label class="control-label col-sm-2" for="grade">Рік:</label>
					<form:select class="form-control selectpicker input_border" data-style="btn-primary" path="grade">
						<form:option  value="${requestModelEdit.grade}">${requestModelEdit.grade.title}</form:option>
							<c:forEach items="${gradeModel}" var="grade">
							<form:option value="${grade}">${grade.title}</form:option>
							</c:forEach>
					</form:select>
					<form:errors  path="grade" cssClass="error"></form:errors>
        	</div>
   		</div>    	
     	<div class="form-group row">
     		<div class="col-md-6 mb-3">
  				<button class="btn btn-primary buttonsAll" type="submit"><span class="glyphicon glyphicon-ok"></span> Зберегти</button>
  			</div>
  		</div>
	</form:form>
</div>