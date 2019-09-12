<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.5.0/css/all.css' integrity='sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU' crossorigin='anonymous'>
<title>Waffles College Online Portal</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../css/overall.css" rel="stylesheet" type="text/css" media="all" /> 
<link href="../css/sidebar.css" rel="stylesheet" type="text/css" media="all" />
</head>
<style>
table, th, tr, td {
border:none;
}
</style>
<body>
<header>
<img src="../images/pizzaman.jpg" style="width:90px" align="left" alt="">
<h3>Waffles College Online Portal Login</h3>
</header>
<section>
<div class="col-container">
   <nav>
       <a href="${pageContext.request.contextPath}/MainPage" class="sidebar-button">Back To Main Page</a>
  </nav>

 
  <article>
<form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/MainPage/Login" > 
	<table class="noborder">
		<tr>
			<td>
			<spring:message code="fieldLabel.username" /></td>
			<td colspan="3"><form:input path="useId" size="40" />
			<form:errors path="useId" cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.password" /></td>
			<td colspan="3"><form:password path="usePassword" size="40" />
			<form:errors path="usePassword" cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
			<form>
			<input type="submit" value="Submit" name="submit">
						<input type="reset" value="Clear" name="clear">
			</form>
				</td>
		</tr>

		</tr>
		
	</table>
</form:form>

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
