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
      <a href="${pageContext.request.contextPath}/admin/managecourses/list" class="sidebar-button"><b>Manage Courses</b></a>
       <a href="${pageContext.request.contextPath}/admin/manageenrollment/list" class="sidebar-button">Manage Enrollment</a>
       <a href="${pageContext.request.contextPath}/admin/managenewenrollment/new" class="sidebar-button">Check New Enrollment Request</a>
       <a href="${pageContext.request.contextPath}/MainPage/Login" class="sidebar-button">Log Out</a>
  </nav>
  <article>
    <h1>Manage Courses</h1>
    <a href="${pageContext.request.contextPath}/admin/managecourses/add">Add New Course </a>
	
<c:if test="${fn:length(CourseList) gt 0}">
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><s:message code="Number" /></th>
			<th><s:message code="Course ID" /></th>
			<th><s:message code="Course Name" /></th>
			<th><s:message code="Credits" /></th>
			<th><s:message code="Course Max Size" /></th>
			<th><s:message code="Course Start Date" /></th>
			<th><s:message code="Course Status" /></th>
			<th><s:message code="Edit Course" /></th>
			<th><s:message code="Delete Course" /></th>
		</tr>
		<c:forEach var="course" items="${CourseList}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index+1}</td>
				<td class="nowrap">${course.cseId}</td>
				<td class="nowrap">${course.cseDesc}</td>
				<td class="nowrap">${course.cseCredit}</td>
				<td class="nowrap">${course.cseMaxSize}</td>
				<td class="nowrap"><fmt:formatDate value="${course.cseStartdate}" pattern="MM.dd.yyyy" /></td>
				<td class="nowrap">${course.cseStatus}</td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/admin/managecourses/edit/${course.cseId}">
						<s:message code="Edit" />
				</a></td>
				<td><a
					href="${pageContext.request.contextPath}/admin/managecourses/delete/${course.cseId}">
					<s:message
							code="Delete" /></a></td>

			</tr>
		</c:forEach>
	</table>
</c:if>
<br/>

   </article>
   </div>
</section>

<footer>
  <p>Contact Us:</p>
  <i class='fas fa-school'></i>  88 Keng Mui Heng Terrace
  <i class='fas fa-phone'></i>  +65 6888 8888
  <i class='fas fa-envelope'></i>  hello@wafflescollege.com
</footer>
