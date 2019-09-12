<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>
<link href="../../css/overall.css" rel="stylesheet"
 type="text/css" media="all" />
<link href="../../css/sidebar.css" rel="stylesheet" type="text/css" media="all" />
<title>Waffles College Lecturer Portal</title>
</head>
<body>


<header>
<img src="../../images/pizzaman.jpg" style="width:90px" align="left" alt="">
<h3>Waffles College Lecturer Portal</h3>

</header>

<section>
<div class="col-container">
  <nav>
       <a href="${pageContext.request.contextPath}/lecturer/courses" class="sidebar-button">Back to All Courses Taught</a>
       <a href="${pageContext.request.contextPath}/lecturer/enrollmentsofspecificcourse/${cseId}" class="sidebar-button"><b>View Course Enrollment</b></a>
       <a href="${pageContext.request.contextPath}/MainPage/Login" class="sidebar-button">Log Out</a>
  </nav>
  
  <article>
    <h1>View Course Enrollment for Course ${cseId}</h1>
    				<c:if test="${fn:length(enrollments) gt 0}">
					<table style="cellspacing: 2; cellpadding: 2; border: 1;">

						<tr class="listHeading">
							<th>Enrollment ID</th>
							<th>Enrollment Date</th>
							<th>Status</th>
							<th>Course ID </th>
							<th>Student ID  </th>
						</tr>


						<c:forEach var="enrollment" items="${enrollments}">
							<tr class="listRecord">
								<td align="left">${enrollment.enrId}</td>
								<td align="left">${enrollment.enrDate}</td>
								<td align="left">${enrollment.enrStatus}</td>
								<td align="left">${enrollment.course.cseId}</td>
								<td align="left">${enrollment.student.stuId}</td>								

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
  <i class='fas fa-school'></i>  88 Keng Mui Heng Terrace</br>
  <i class='fas fa-phone'></i>  +65 6888 8888</br>
  <i class='fas fa-envelope'></i>  hello@wafflescollege.com</br>
</footer>

</body>
</html>