<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />

<a href="${pageContext.request.contextPath}/lecturer/create">Add
	Student</a>
<c:if test="${fn:length(lecturers) gt 0}">
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><s:message code="label.lecturer.index" /></th>
			<th><s:message code="label.lecturer.name" /></th>
			<th><s:message code="label.lecturer.nickName" /></th>
			<th><s:message code="label.lecturer.nric" /></th>
			<th><s:message code="label.lecturer.phoneNumber" /></th>
			<th><s:message code="label.lecturer.email" /></th>
			<th><s:message code="label.lecturer.address" /></th>
			<th><s:message code="label.lecturer.userName" /></th>
			<th><s:message code="label.lecturer.password" /></th>
			<th><s:message code="label.lecturer.edit" /></th>
			<th><s:message code="label.lecturer.delete" /></th>
		</tr>
		<c:forEach var="lecturer" items="${lecturers}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index}</td>
				<td class="nowrap">${lecturer.name}</td>
				<td class="nowrap">${lecturer.nickName}</td>
				<td class="nowrap">${lecturer.nric}</td>
				<td class="nowrap">${lecturer.phoneNumber}</td>
				<td class="nowrap">${lecturer.email}</td>
				<td class="nowrap">${lecturer.address}</td>
				<td class="nowrap">${lecturer.userName}</td>
				<td class="nowrap">${lecturer.password}</td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/student/edit/${lecturer.nric}.html">
						<s:message code="label.student.edit" />
				</a></td>
				<td><a
					href="${pageContext.request.contextPath}/student/delete/${lecturer.nric}.html">
					<s:message
							code="label.student.delete" /></a></td>

			</tr>
		</c:forEach>
	</table>
</c:if>