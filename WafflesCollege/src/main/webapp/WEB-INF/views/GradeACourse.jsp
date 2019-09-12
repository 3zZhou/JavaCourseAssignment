<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.5.0/css/all.css'
	integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU'
	crossorigin='anonymous'>
<link href="../../../../css/overall.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="../../../../css/sidebar.css" rel="stylesheet" type="text/css"
	media="all" />
<title>Waffles College Lecturer Portal</title>
</head>

<style>
table, th, tr, td {
border:none;
}
</style>
<body>


	<header>
		<img src="../../../../images/pizzaman.jpg" style="width: 90px" align="left"
			alt="">
		<h3>Waffles College Lecturer Portal</h3>

	</header>

	<section>
		<div class="col-container">
			<nav>
	<a href="${pageContext.request.contextPath}/lecturer/studentgradesofspecificcourse/${cseId}" class="sidebar-button">Back to Course Grading</a>
       		<a href="${pageContext.request.contextPath}/lecturer/courses" class="sidebar-button"><b>Grade a Student</b></a>
      		<a href="${pageContext.request.contextPath}/MainPage/Login" class="sidebar-button">Log Out</a>
			</nav>

				<article>
				<h1>Grade a Student under Course ${cseId}</h1>
				<form:form method="POST" modelAttribute="studentgrade"
					action="${pageContext.request.contextPath}/lecturer/studentgradesofspecificcourse/${cseId}/grading/${stgId}">
					<table>
						<tbody>
							<tr>
								<td>Studentgrade ID: </td>
								<td><form:input path="stgId" size="10" readonly="true" /></td>
								<td><form:errors path="stgId" cssStyle="color: red;" /></td>
							</tr>	
							<tr>
								<td>Course ID: </td>
								<td><form:input path="course.cseId" 
										size="10" readonly="true"/></td>
								<td><form:errors path="course.cseId" cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>Course Name: </td>
								<td><form:input path="course.cseDesc" 
										size="40" readonly="true"/></td>
								<td><form:errors path="course.cseDesc" cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>Student ID: </td>
								<td><form:input path="student.stuId" 
										size="10" readonly="true"/></td>
								<td><form:errors path="student.stuId"
										cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>Student First Name: </td>
								<td><form:input path="student.stuFirstmidname" 
										size="10" readonly="true"/></td>
								<td><form:errors path="student.stuFirstmidname"
										cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>Student Last Name: </td>
								<td><form:input path="student.stuLastname" 
										size="10" readonly="true"/></td>
								<td><form:errors path="student.stuLastname"
										cssStyle="color: red;" /></td>
							</tr>
							<tr>
								<td>Course Scoring: </td>
								<td><form:input path="stgGrade" value="Input the actual scoring"
										size="40" /></td>
								<td><form:errors path="stgGrade" cssStyle="color: red;" /></td>
							</tr>

							<tr>
			<form>
			<input type="submit" value="Submit" name="submit">
						<input type="reset" value="Clear" name="clear">
			</form>
							</tr> 
						</tbody>
					</table>
				</form:form>
</article>
		</div>
	</section>

	<footer>
		<p>Contact Us:</p>
		<i class='fas fa-school'></i> 88 Keng Mui Heng Terrace</br> <i
			class='fas fa-phone'></i> +65 6888 8888</br> <i class='fas fa-envelope'></i>
		hello@wafflescollege.com</br>
	</footer>

</body>
</html>