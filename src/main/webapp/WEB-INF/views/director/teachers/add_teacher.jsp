<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form:form method="POST" action="${pageContext.request.contextPath}/director/add_teacher" modelAttribute="teacherAddRequestModel">
	<table class="addTable">
		<tr>
			<td>Прізвище</td>
			<td>
				<form:input path="firstName" maxlength="50" size="50"/>
				<span class="valid">*</span>
				<form:errors  path="firstName" cssClass="error"></form:errors>
			</td>	
		</tr>
		
		<tr>
			<td>Ім'я</td>
			<td>
				<form:input path="lastName" maxlength="50" size="50"/>
				<span class="valid">*</span>
				<form:errors  path="lastName" cssClass="error"></form:errors>
			</td>	
		</tr>
		
		<tr>
			<td>По-батькові</td>
			<td>
				<form:input path="middleName" maxlength="50" size="50"/>
				<span class="valid">*</span>
				<form:errors  path="middleName" cssClass="error"></form:errors>
			</td>	
		</tr>
		
		<tr>
			<td>Логін</td>
			<td>
				<form:input path="login" maxlength="50" size="50"/>
				<span class="valid">*</span>
				<form:errors  path="login" cssClass="error"></form:errors>
			</td>	
		</tr>
		
		<tr>
			<td>Пароль</td>
			<td>
				<form:password path="password" maxlength="50" size="50"/>
				<span class="valid">*</span>
				<form:errors  path="password" cssClass="error"></form:errors>
			</td>	
		</tr>
		
		<tr>
			<td>Предмет</td>
			<td>
				<form:select path="subject">
					<c:forEach items="${subjectModel}" var="subject">
						<form:option value="${subject}">${subject.title}</form:option>
					</c:forEach>
				</form:select>
			</td>	
		</tr>

	</table>
	<input class="button" type="submit" value="Додати вчителя">
</form:form>