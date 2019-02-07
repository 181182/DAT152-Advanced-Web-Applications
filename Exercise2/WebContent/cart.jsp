<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.ArrayList, no.hvl.dat152.modell.Vare"%>
<%@ taglib prefix="dat152" uri="dat152-libs" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<p><jsp:include page="languages.jsp" /></p>
	<fmt:bundle basename="no.hvl.dat152.Messages">
		<h1>
			<fmt:message key="handle"></fmt:message>
		</h1>
		<table>
			<tr>
				<th><fmt:message key="cnavn"></fmt:message></th>
				<th><fmt:message key="cdesc"></fmt:message></th>
				<th><fmt:message key="cpris"></fmt:message></th>
				<th><fmt:message key="antall"></fmt:message></th>
				<th><fmt:message key="total"></fmt:message></th>
			</tr>
			<c:forEach items="${map}" var="emp">
				<tr>
					<td>${emp.key.navn}</td>
					<td><c:forEach items="${emp.key.beskrivelse}"
							var="beskrivelse">
							<c:if
								test="${beskrivelse.landKode eq pageContext.response.locale}">
								<dat152:forkorter>${beskrivelse.text}</dat152:forkorter>
							</c:if>
						</c:forEach></td>
					<td><c:if test="${pageContext.response.locale eq 'no_NO'}">
							<fmt:formatNumber value="${(emp.key.pris * 9.7)}" type="currency" />
						</c:if> <c:if test="${pageContext.response.locale eq 'en_US'}">
							<fmt:formatNumber value="${(emp.key.pris * 1.15)}"
								type="currency" />
						</c:if> <c:if test="${pageContext.response.locale eq 'de_DE'}">
							<fmt:formatNumber value="${emp.key.pris}" type="currency" />
						</c:if></td>
					<td>${emp.value}</td>
					<td><c:if test="${pageContext.response.locale eq 'no_NO'}">
							<fmt:formatNumber value="${(emp.key.pris * 9.7*emp.value)}"
								type="currency" />
						</c:if> <c:if test="${pageContext.response.locale eq 'en_US'}">
							<fmt:formatNumber value="${(emp.key.pris * 1.15*emp.value)}"
								type="currency" />
						</c:if> <c:if test="${pageContext.response.locale eq 'de_DE'}">
							<fmt:formatNumber value="${emp.key.pris*emp.value}"
								type="currency" />
						</c:if></td>
				</tr>
			</c:forEach>
			<tr>
				<td>Total Amount:</td>
				<td><c:if test="${pageContext.response.locale eq 'no_NO'}">
						<fmt:formatNumber value="${(sum * 9.7)}" type="currency" />
					</c:if> <c:if test="${pageContext.response.locale eq 'en_US'}">
						<fmt:formatNumber value="${(sum * 1.15)}" type="currency" />
					</c:if> <c:if test="${pageContext.response.locale eq 'de_DE'}">
						<fmt:formatNumber value="${sum}" type="currency" />
					</c:if></td>
			</tr>
		</table>
		<p>
			<a href="home.jsp"><fmt:message key="hjem"></fmt:message></a> <a
				href="products"><fmt:message key="handlevogn"></fmt:message></a>
		</p>
		<p>
			<dat152:copyright since="2008"> HVL </dat152:copyright>
		</p>

	</fmt:bundle>


</body>
</html>