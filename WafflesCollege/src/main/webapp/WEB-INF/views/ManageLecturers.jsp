<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
       <a href="${pageContext.request.contextPath}/admin/managelecturers/load" class="sidebar-button"><b>Manage Lecturers</b></a>
       <a href="${pageContext.request.contextPath}/admin/managecourses/list" class="sidebar-button">Manage Courses</a>
       <a href="${pageContext.request.contextPath}/admin/manageenrollment/list" class="sidebar-button">Manage Enrollment</a>
       <a href="${pageContext.request.contextPath}/admin/managenewenrollment/new" class="sidebar-button">Check New Enrollment Request</a>
       <a href="${pageContext.request.contextPath}/MainPage/Login" class="sidebar-button">Log Out</a>
  </nav>
  
  <article>
    <h1>Manage Lecturers</h1>
    <a href="${pageContext.request.contextPath}/admin/managelecturers/add">Add Lecturer </a><br />
	
	<%-- <a href="${pageContext.request.contextPath}/lecturer/lecturer/list">Go to Lecturer</a> --%>
	
<c:if test="${fn:length(lecturers) gt 0}">
	
	<br />
	<table class="borderAll">
		<tr>
			<th><s:message code="index" /></th>
			<th><s:message code="Firstmid Name" /></th>
			<th><s:message code="Last Name" /></th>
			<th><s:message code="edit" /></th>
			<th><s:message code="delete" /></th>
		</tr>
		<c:forEach var="lecturer" items="${lecturers}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index+1}</td>
				<td class="nowrap">${lecturer.lecFirstmidname}</td>
				<td class="nowrap">${lecturer.lecLastname}</td>
				
				<td align="center"><a
					href="${pageContext.request.contextPath}/admin/managelecturers/edit/${lecturer.lecId}.html">
						<s:message code="edit" />
				</a></td>
				<td><a
					href="${pageContext.request.contextPath}/admin/managelecturers/delete/${lecturer.lecId}.html">
					<s:message
							code="delete" /></a></td>

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
  <i class='fas fa-school'></i>  88 Keng Mui Heng Terrace
  <i class='fas fa-phone'></i>  +65 6888 8888
  <i class='fas fa-envelope'></i>  hello@wafflescollege.com
</footer>

