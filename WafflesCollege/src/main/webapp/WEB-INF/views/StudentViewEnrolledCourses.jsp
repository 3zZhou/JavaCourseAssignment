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
				<a href="${pageContext.request.contextPath}/student/viewenrolled" class="sidebar-button"><b>View Enrolled Courses</b></a>
				<a href="${pageContext.request.contextPath}/student/gpa" class="sidebar-button">View Grades and GPA</a>
				<a href="${pageContext.request.contextPath}/student/viewall" class="sidebar-button">View All Courses</a>
				<a href="${pageContext.request.contextPath}/student/enrolnew" class="sidebar-button">Enroll into a new Course</a> 
				<a href="${pageContext.request.contextPath}/MainPage/Login" class="sidebar-button">Log Out</a>
			</nav>

			<article>
				<h1>View Enrolled Courses</h1>

				<c:if test="${fn:length(Display) gt 0}">
					<br />
					<table>
						<tr>
							<th><s:message text="&nbspIndex&nbsp"
									code="label.student.index" /></th>
							<th><s:message text="&nbspCourse ID&nbsp"
									code="label.student.cseID" /></th>
							<th><s:message text="&nbspCourse Title&nbsp"
									code="label.student.cseDesc" /></th>
							<th><s:message text="&nbspCredits&nbsp"
									code="label.student.cseCredits" /></th>
							<th><s:message text="&nbsp      Enrollment Status      &nbsp"
									code="label.student.enrollmentstatus" /></th>
									<th><s:message text="&nbsp      Lecturer      &nbsp"
									code="label.student.LecturerName" /></th>
						</tr>
						<c:forEach var="Display" items="${Display}" varStatus="status">
							<tr class="${status.index%2==0?'even':'odd'}">
								<td style="text-align: center;" class="nowrap">${status.index+1}</td>
								<td style="text-align: center;" class="nowrap">${Display[0]}</td>
								<td style="text-align: center;" class="nowrap">${Display[1]}</td>
								<td style="text-align: center;" class="nowrap">${Display[2]}</td>
								<td style="text-align: center;" class="nowrap">${Display[3]}</td>
								<td style="text-align: center;" class="nowrap">${Display[4]}</td>
							</tr>
						</c:forEach>
					</table>
					<%-- <div
						style="align-content: flex-end; display: inline-block; font-weight: bold;">
						<br />Current GPA is ${cGPA}
					</div> --%>
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
