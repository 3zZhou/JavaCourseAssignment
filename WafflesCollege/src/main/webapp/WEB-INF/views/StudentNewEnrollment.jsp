
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.5.0/css/all.css'
	integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU'
	crossorigin='anonymous'>
<link href="../css/overall.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="../css/sidebar.css" rel="stylesheet" type="text/css"
	media="all" />
<title>Waffles College Student Portal</title>
</head>
<body>


	<header>
		<img src="../images/pizzaman.jpg" style="width: 90px" align="left"
			alt="">
		<h1>Waffles College Student Portal</h1>

	</header>

	<section>
		<div class="col-container">
			<nav>
				<a href="${pageContext.request.contextPath}/student/viewenrolled" class="sidebar-button">View Enrolled Courses</a>
				<a href="${pageContext.request.contextPath}/student/gpa" class="sidebar-button">View Grades and GPA</a>
				<a href="${pageContext.request.contextPath}/student/viewall" class="sidebar-button">View All Courses</a>
				<a href="${pageContext.request.contextPath}/student/enrolnew" class="sidebar-button">Enroll into a new Course</a> 
				<a href="${pageContext.request.contextPath}/MainPage/Login" class="sidebar-button">Log Out</a>
			</nav>

  <article>
	<h1>Enroll into a New Course</h1>

    <br />
<form:form method="POST" modelAttribute="enrollment"
	action="${pageContext.request.contextPath}/student/enrolnew">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				<tr>
				   <td><s:message code="label.enrollment.cseId" /> *</td>
				   <td><form:input path="course.cseId"/>
				   <form:errors path="course.cseId" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.stuId" /></td>
				   <td><form:input path="student.stuId"/>
				   <form:errors path="student.stuId" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.enrollment.enrStatus" /> *</td>
				   <td><form:input path="enrStatus"/>
				   <form:errors path="enrStatus" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="label.enrollment.date" /></td>
				   <td><form:input path="enrDate"/>
				   <form:errors path="enrDate" cssStyle="color: red;" /></td>
				 </tr>
				
		</table>
		<p id="button"> <input id="submit" type="submit" value="Confirm Enrollment">
		</center>
	
	</form:form>

   
   </article>
   </div>
</section>

<footer>
  <p>Contact Us:</p>
  <i class='fas fa-school'></i>  88 Keng Mui Heng Terrace</br>
  <i class='fas fa-phone'></i>  +65 6888 8888</br>
  <i class='fas fa-envelope'></i>  hello@wafflescollege.com</br>
</footer>

</body>
</html>
