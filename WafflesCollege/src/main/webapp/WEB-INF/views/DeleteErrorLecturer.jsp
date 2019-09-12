<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

<header>
	<img
		src="C:\Users\Htet Htet Lin\git\CAgit\WafflesCollege\WafflesCollege\src\main\webapp\images\pizzaman.jpg"
		style="width: 90px" align="left" alt="">
	<h3>Waffles College Lecturer Portal</h3>

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
			<h1><header>Error Message</header></h1>

				
<center>
					<table cellpadding=4 cellspacing=2 border=0>

						<tr>

							<td><h3><s:message code="Selected Lecturer is currently still teaching."/></h3><br>
							
							<h3><s:message code="You can't delete!!."/></h3>
							</td>

							

						</tr>
						</table></center>
						
						
		</article>
	</div>
</section>

<footer>
	<p>Contact Us:</p>
	<i class='fas fa-school'></i> 88 Keng Mui Heng Terrace <i
		class='fas fa-phone'></i> +65 6888 8888 <i class='fas fa-envelope'></i>
	hello@wafflescollege.com
</footer>

