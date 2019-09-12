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
<link href="../css/overall.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="../css/sidebar.css" rel="stylesheet" type="text/css"
	media="all" />
<title>Waffles College Lecturer Portal</title>
</head>

<body>


<header>
		<img src="../images/pizzaman.jpg" style="width: 90px" align="left"
			alt="">
		<h3>Waffles College Lecturer Portal</h3>

</header>

<section>
	<div class="col-container">
		<nav>
			<a href="${pageContext.request.contextPath}/lecturer/courses" class="sidebar-button"><b>View Courses Taught</b></a>

      		<a href="${pageContext.request.contextPath}/MainPage/Login" class="sidebar-button">Log Out</a>
		</nav>

			<article>
				<h1>View Courses Taught</h1>
				<h4>Select a course to manage</h4>
				<c:if test="${fn:length(courses) gt 0}">

					<table class=borderAll
						style="cellspacing: 2; cellpadding: 2; border: 1;">

						<tr class="listHeading">
							<th>Course ID</th>
							<th>Course Name</th>
							<th>Course Credit</th>
							<th>Max Size</th>
							<th>Start Date</th>
							<th>Status</th>
						</tr>
						
						<c:forEach var="course" items="${courses}">
							<tr class="listRecord">
								<td align="left">${course.cseId}</td>
								<td align="left">${course.cseDesc}</td>
								<td align="left">${course.cseCredit}</td>
								<td align="left">${course.cseMaxSize}</td>
								<td align="left">${course.cseStartdate}</td>
								<td align="left">${course.cseStatus}</td>
								<td align="center"><a
									href="${pageContext.request.contextPath}/lecturer/enrollmentsofspecificcourse/${course.cseId}">View
										Enrollments</a></td>
								<td align="center"><a
									href="${pageContext.request.contextPath}/lecturer/studentgradesofspecificcourse/${course.cseId}">Grading</a></td>
								<td align="center"><a
									href="${pageContext.request.contextPath}/lecturer/studentsofspecificcourse/${course.cseId}">View
										Students</a></td>
							</tr>
						</c:forEach>

					</table>
				</c:if>

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