<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>
<link href="../../../css/overall.css" rel="stylesheet" type="text/css" media="all" />
<link href="../../../css/sidebar.css" rel="stylesheet" type="text/css" media="all" />
<title>Waffles College Admin Portal</title>

<header>
<img src="../../../images/pizzaman.jpg" style="width:90px" align="left" alt="">
<h3>Waffles College Admin Portal</h3>

</header>
<style>
table, th, tr, td {
border:none;
}
</style>
<section>
<div class="col-container">
  <nav>
       <a href="${pageContext.request.contextPath}/admin/managestudents/list" class="sidebar-button"><b>Manage Students</b></a>
       <a href="${pageContext.request.contextPath}/admin/managelecturers/load" class="sidebar-button">Manage Lecturers</a>
       <a href="${pageContext.request.contextPath}/admin/managecourses/list" class="sidebar-button">Manage Courses</a>
       <a href="${pageContext.request.contextPath}/admin/manageenrollment/list" class="sidebar-button">Manage Enrollment</a>
       <a href="${pageContext.request.contextPath}/admin/managenewenrollment/new" class="sidebar-button">Check New Enrollment Request</a>
       <a href="${pageContext.request.contextPath}/MainPage/Login" class="sidebar-button">Log Out</a>
  </nav>
  
  <article>


<form:form method="POST" modelAttribute="student"
	action="${pageContext.request.contextPath}/admin/managestudents/edit/${student.stuId}">
		<center>
		    <h1>Edit a Student's Detail</h1>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				<tr>
				   <td><s:message code="Student ID" /> *</td>
				   <td><form:input path="stuId"/>
					<form:errors path="stuId" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="First Mid Name" /></td>
				   <td><form:input path="stuFirstmidname"/>
				   <form:errors path="stuFirstmidname" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="Last Name" /> *</td>
				   <td><form:input path="stuLastname"/>
					<form:errors path="stuLastname" cssStyle="color: red;" /></td>
				 </tr>
				<tr>
				   <td><s:message code="Email" /></td>
				   <td><form:input path="stuEmail"/></td>

				 </tr>
				<tr>
				   <td><s:message code="Phone Number" /></td>
				   <td><form:input path="stuPhoneNo"/>

				 </tr>
				<tr>
				   <td><s:message code="Address" /></td>
				   <td><form:input path="stuAddress"/></td>

				 </tr>
				 <tr>
				<td><s:message code="Student Status" /></td>
				 	<td>
					 <form:select path="stuStatus">
	                 	<form:option value="Inactive" label="Inactive"/>
	                 	<form:option value="Active" label="Active"/>
	                 </form:select>
	                 </td>

				 <tr>
				 <tr>
				 <td><input type="submit" value="Submit"> </td>
				<td><input type="reset" value="Reset"> </td>
				 
				 </tr>
		</table>
		</center>
	
	</form:form>

   </article>
   </div>
</section>

<footer>
  <p>Contact Us:</p>
  <i class='fas fa-school'></i>  88 Keng Mui Heng Terrace
  <i class='fas fa-phone'></i>  +65 6888 8888
  <i class='fas fa-envelope'></i>  hello@wafflescollege.com
</footer>
