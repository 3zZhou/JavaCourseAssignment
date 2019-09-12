<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>
<link href="../../css/overall.css" rel="stylesheet" type="text/css" media="all" />
<link href="../../css/sidebar.css" rel="stylesheet" type="text/css" media="all" />
<title>Waffles College Admin Portal</title>

<header>
<img src="../../images/pizzaman.jpg" style="width:90px" align="left" alt="">
<h3>Waffles College Admin Portal</h3>
</header>

<section>
<div class="col-container">
  <nav>
       <a href="${pageContext.request.contextPath}/admin/managestudents/list" class="sidebar-button">Manage Students</a>
       <a href="${pageContext.request.contextPath}/admin/managelecturers/load" class="sidebar-button">Manage Lecturers</a>
       <a href="${pageContext.request.contextPath}/admin/managecourses/list" class="sidebar-button">Manage Courses</a>
       <a href="${pageContext.request.contextPath}/admin/manageenrollment/list" class="sidebar-button">Manage Enrollment</a>
       <a href="${pageContext.request.contextPath}/admin/managenewenrollment/new" class="sidebar-button"><b>Check New Enrollment Request</b></a>
       <a href="${pageContext.request.contextPath}/MainPage/Login" class="sidebar-button">Log Out</a>
  </nav>
  
  <article>
    <h1>Check New Enrollment Request</h1>

    <c:if test="${fn:length(enrollment) gt 0}">
	<br />
	<br />
	<table>
		<tr>
			<th><spring:message code="label.enrollment.enrId" /></th>
			<th><spring:message code="label.enrollment.stuId" /></th>
			<th><spring:message code="label.enrollment.course" /></th>
			<th><spring:message code="label.enrollment.enrDate" /></th>
			<th><spring:message code="label.enrollment.enrStatus" /></th>
			</tr>
		<c:forEach var="enrollment" items="${enrollment}" varStatus="status">
			<tr>
				<td>${enrollment.enrId}</td>
				<td>${enrollment.student.stuId}</td>
				<td>${enrollment.course.cseId}</td>
				<td>${enrollment.enrDate}</td>
				<td>${enrollment.enrStatus}</td>
				<td><c:url
								value="/admin/managenewenrollment/new/display/${enrollment.enrId}.html" var="d" />
							<a href="${d}"><spring:message code="caption.detail" /></a></td>
	
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
