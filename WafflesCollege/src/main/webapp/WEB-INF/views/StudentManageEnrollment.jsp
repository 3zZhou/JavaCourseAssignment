<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
	<h1>Enroll into a new Course</h1>

	<c:if test="${fn:length(enrollments) gt 0}">
    <br />
    
<a href="${pageContext.request.contextPath}/admin/manageenrollment/create">Add
	Student</a>
    <br />
    <table>
   	 <tr>
   		 <th><spring:message code="label.enrollment.enrId" /></th>
   		 <th><spring:message code="label.enrollment.stuId" /></th>
   		 <th><spring:message code="label.enrollment.course" /></th>
   		 <th><spring:message code="label.enrollment.enrDate" /></th>
   		 <th><spring:message code="label.enrollment.enrStatus" /></th>
   		 </tr>
   	 <c:forEach var="enrollment" items="${enrollments}" varStatus="status">
   		 <tr>
   			 <td>${enrollment.enrId}</td>
   			 <td>${enrollment.student.stuId}</td>
   			 <td>${enrollment.course.cseId}</td>
   			 <td>${enrollment.enrDate}</td>
   			 <td>${enrollment.enrStatus}</td>
   			 <td><c:url
   							 value="/admin/manageenrollment/edit/${enrollment.enrId}" var="d" />
   						 <a href="${d}"><spring:message code="Update" /></a></td>
    
   		 </tr>
   	 </c:forEach>
   		 </table>
   	 </c:if>

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
