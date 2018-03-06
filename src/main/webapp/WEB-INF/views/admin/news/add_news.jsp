<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form method="POST" action="${pageContext.request.contextPath}/admin/addNews" modelAttribute="newsModel" enctype="multipart/form-data">
	<table class="addTable">
		<tr>
			<td>Назва новини</td>
			<td>
				<form:input path="title" maxlength="50" size="50"/>
				<span class="valid">*</span>
				<form:errors  path="title" cssClass="error"></form:errors>
			</td>	
		</tr>
		
		<tr>
			<td>Опис новини</td>
			<td>
				<form:textarea path="description" rows="5" cols="80"/>
				<span class="valid">*</span>
				<form:errors path="description" cssClass="error"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>Додати постер новини</td>
			<td>
				<input type="file" name="uploadFile" accept="image/jpeg,image/png,image/gif,image/bmp,image/jpg" > <br> <br>
			</td>
		</tr>
	
	</table>
	<input class="button" type="submit" value="Додати новину">
</form:form>