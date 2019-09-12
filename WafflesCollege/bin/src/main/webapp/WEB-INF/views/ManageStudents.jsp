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
       <a href="ManageStudents.jsp" class="sidebar-button"><b>Manage Students</b></a>
       <a href="ManageLecturers.jsp" class="sidebar-button">Manage Lecturers</a>
       <a href="ManageCourses.jsp" class="sidebar-button">Manage Courses</a>
       <a href="ManageEnrolment.jsp" class="sidebar-button">Manage Enrolment</a>
       <a href="../main/MainPage.jsp" class="sidebar-button">Log Out</a>
  </nav>
  
  <article>
    <h1>Manage Students</h1>
    <a href="${pageContext.request.contextPath}/student/create">Add Students </a>
	
<a href="${pageContext.request.contextPath}/student/lecturer/list">Go to Lecturer</a>
	
<c:if test="${fn:length(students) gt 0}">
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><s:message code="label.student.index" /></th>
			<th><s:message code="label.student.name" /></th>
			<th><s:message code="label.student.nickName" /></th>
			<th><s:message code="label.student.nric" /></th>
			<th><s:message code="label.student.mark" /></th>
			<th><s:message code="label.student.dob" /></th>
			<th><s:message code="label.student.phoneNumber" /></th>
			<th><s:message code="label.student.email" /></th>
			<th><s:message code="label.student.address" /></th>
			<th><s:message code="label.student.userName" /></th>
			<th><s:message code="label.student.password" /></th>
			<th><s:message code="label.student.edit" /></th>
			<th><s:message code="label.student.delete" /></th>
		</tr>
		<c:forEach var="student" items="${students}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index}</td>
				<td class="nowrap">${student.name}</td>
				<td class="nowrap">${student.nickName}</td>
				<td class="nowrap">${student.nric}</td>
				<td class="nowrap">${student.mark}</td>
				<td class="nowrap"><fmt:formatDate value="${student.dob}" pattern="MM.dd.yyyy" /></td>
				<td class="nowrap">${student.phoneNumber}</td>
				<td class="nowrap">${student.email}</td>
				<td class="nowrap">${student.address}</td>
				<td class="nowrap">${student.userName}</td>
				<td class="nowrap">${student.password}</td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/student/edit/${student.nric}.html">
						<s:message code="label.student.edit" />
				</a></td>
				<td><a
					href="${pageContext.request.contextPath}/student/delete/${student.nric}.html">
					<s:message
							code="label.student.delete" /></a></td>

			</tr>
		</c:forEach>
	</table>
</c:if>

   </article>
   </div>
</section>

<footer>
  <p>Contact Us:</p>
  <i class='fas fa-school'></i>  88 Keng Mui Heng Terrace
  <i class='fas fa-phone'></i>  +65 6888 8888
  <i class='fas fa-envelope'></i>  hello@wafflescollege.com
</footer>

