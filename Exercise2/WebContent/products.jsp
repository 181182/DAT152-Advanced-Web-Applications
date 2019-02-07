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
<title>Products</title>
</head>

<body>
	<p><jsp:include page="languages.jsp" /></p>
	<fieldset>
		<fmt:bundle basename="no.hvl.dat152.Messages">

			<form action="products" method="post">
				<c:forEach items="${vare}" var="emp">
					<table>
						<tr>
							<td><h1>${emp.navn}</h1></td>
						</tr>

						<tr>

							<td><img src="${emp.imgFile}"
								style="weight: 300px; height: 300px;" alt="" /></td>
							<td>
								<p>
									<fmt:message key="navn"></fmt:message>
									${emp.navn}
								</p>



								<p>
									<c:if test="${pageContext.response.locale eq 'no_NO'}">
										<fmt:formatNumber value="${(emp.pris * 9.7)}" type="currency" />
									</c:if>
									<c:if test="${pageContext.response.locale eq 'en_US'}">
										<fmt:formatNumber value="${(emp.pris * 1.15)}" type="currency" />
									</c:if>
									<c:if test="${pageContext.response.locale eq 'de_DE'}">
										<fmt:formatNumber value="${emp.pris}" type="currency" />
									</c:if>
								</p>
								<p>
									<fmt:message key="beskrivelse"></fmt:message>
								</p> <c:forEach items="${emp.beskrivelse}" var="beskrivelse">
									<c:if
										test="${beskrivelse.landKode eq pageContext.response.locale}">
										<c:out value="${beskrivelse.text}"></c:out>
									</c:if>
								</c:forEach>
								<p>
									<c:if test="${pageContext.response.locale eq 'no_NO'}">
										<input type="submit" value="Legg til handlevogn">
									</c:if>
									<c:if test="${pageContext.response.locale eq 'en_US'}">
										<input type="submit" value="Add to cart">
									</c:if>
									<c:if test="${pageContext.response.locale eq 'de_DE'}">
										<input type="submit" value="In den Warenkorb legen">
									</c:if>
									<input type="hidden" name="verdi" value="${emp.navn}">
								</p>
							</td>
						</tr>
					</table>
				</c:forEach>
			</form>
			<p>
				<a href="home.jsp"><fmt:message key="hjem"></fmt:message></a> <a
					href="cart"><fmt:message key="handlevogn"></fmt:message></a>
			</p>
		</fmt:bundle>

	</fieldset>
	<dat152:copyright since="2008"> HVL </dat152:copyright>
	
</body>
</html>















