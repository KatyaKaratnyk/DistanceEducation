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
	<form:form method="POST" action="${pageContext.request.contextPath}/teacher/edit-theoretical-task${taskModel.idTask}" modelAttribute="taskModel" enctype="multipart/form-data">
		<nav aria-label="breadcrumb">
  			<ol class="breadcrumb menu-ul-nothover">
    			<li class="breadcrumb-item"><a href="/teacher/theoretical-tasks/1">ТЕОРЕТИЧНИЙ МАТЕРІАЛ</a></li>
    			<li class="breadcrumb-item"><a href="/teacher/theoretical-task-profile${taskModel.idTask}">ДЕТАЛІ</a></li>
   			 	<li class="breadcrumb-item active" aria-current="page">РЕДАГУВАТИ</li>
  			</ol>
		</nav>
	</form:form>
	<form:form method="POST" action="${pageContext.request.contextPath}/teacher/edit-theoretical-task${taskModel.idTask}" modelAttribute="taskModel" enctype="multipart/form-data">
    	    	<div class="form-group row required">
    		<div class="col-md-12">
     			 <label class="control-label col-sm-2" for="title">Назва:</label>
      				<form:input path="title" maxlength="50" size="500" class="form-control is-invalid" id="title" placeholder="Назва"></form:input>
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
		<div class="form-group row">
			<div class="form-inline">
				<div class="form-group">
					<label class="col-sm-5 control-label">Файл:</label>
						<div class="col-sm-12">
							<span>${taskModel.nameFile}</span>
    					</div>
    			</div>
			</div>
    	</div>
    	<div class="form-group row">
    		<div class="col-md-12">
    			<div class="input-group">
                	<label class="btn btn-primary buttonsAll" for="my-file-selector">
 						<form:input path="file" id="my-file-selector" type="file" style="display:none" 
    						onchange="$('#upload-file-info').html(this.files[0].name)" accept="application/pdf" />Вибрати PDF файл...
               				 </label>   <span  id="upload-file-info"></span>   
						<form:errors path="file" cssClass="error"></form:errors>				              
				</div>    			
        	</div>
        </div>		
     	<div class="form-group row">
     		<div class="col-md-6 mb-3">
  				<button class="btn btn-primary buttonsAll" type="submit"><span class="glyphicon glyphicon-ok"></span> Зберегти</button>
  			</div>
  		</div>
	</form:form>
</div>