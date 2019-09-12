<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<link href="../../css/overall.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="../../css/sidebar.css" rel="stylesheet" type="text/css"
	media="all" />
<title>Waffles College Student Portal</title>
</head>
<style>
table, th, tr, td {
border:none;
}
</style>
<body>


	<header>
		<img src="../../images/pizzaman.jpg" style="width: 90px" align="left"
			alt="">
		<h1>Waffles College Student Portal</h1>

	</header>

	<section>
		<div class="col-container">
			<nav>

				<a href="${pageContext.request.contextPath}/student/enrolnew" class="sidebar-button"><b>Back to All Courses</b></a> 
				<a href="${pageContext.request.contextPath}/MainPage/Login" class="sidebar-button">Log Out</a>
			</nav>

	<article>
				<h1>View All Available Courses</h1>
<form:form method="POST" modelAttribute="course"
	action="${pageContext.request.contextPath}/student/enrolnewform/${course.cseId}">
		<center>
		    
			<table>
			<tr>
				   <td>Are u sure wanna enroll the course ${course.cseDesc}</td>
				   
				 <td><input type="submit" value="Enroll"> </td>
				 </tr>
		</table>
		</center>
	
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
