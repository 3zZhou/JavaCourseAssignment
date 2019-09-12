<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<title>Waffles College Lecturer Portal</title>
</head>

<body>


	<header>
		<img src="../../images/pizzaman.jpg" style="width: 90px" align="left"
			alt="">
		<h3>Waffles College Lecturer Portal</h3>

	</header>

	<section>
		<div class="col-container">
			<nav>
				<a href="${pageContext.request.contextPath}/lecturer/courses"
					class="sidebar-button">Back to All Courses Taught</a>  <a
					href="${pageContext.request.contextPath}/lecturer/studentsofspecificcourse/${cseId}"
					class="sidebar-button"><b>Course Performance</b></a> <a
					href="${pageContext.request.contextPath}/MainPage/Login"
					class="sidebar-button">Log Out</a>
			</nav>

			<article>
				<h1>View Students' Performance under Course ${cseId}</h1>
				<h4>Choose a student to view performance</h4>
				<c:if test="${fn:length(students) gt 0}">
						<table style="cellspacing: 2; cellpadding: 2; border: 1;">
							<tr class="listHeading">
								<th>Student ID</th>
								<th>Student Name</th>
								<th>Course ID</th>
								<th>Course Name</th>
								<th>Student Email</th>
								<th>Student Phone Number</th>
								<th>Student Address</th>
							</tr>

							<c:forEach var="student" items="${students}">
								<tr class="listRecord">
									<td align="center">${student.stuId}</td>
									<td align="center">${student.stuFirstmidname} ${student.stuLastname}</td>
									<td align="center">${cseId}</td>
									<td align="center">${course.cseDesc}</td>
									<td align="center">${student.stuEmail}</td>
									<td align="center">${student.stuPhoneNo}</td>
									<td align="center">${student.stuAddress}</td>
									<td align="center"><a
										href="${pageContext.request.contextPath}/lecturer/studentsofspecificcourse/${cseId}/viewperformance/${student.stuId}">View Performance</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
</br></br>
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