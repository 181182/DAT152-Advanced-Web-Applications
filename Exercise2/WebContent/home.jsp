<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="dat152" uri="dat152-libs" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercise 2</title>
</head>
<body>
	<p><jsp:include page="languages.jsp" /></p>
			
	
	<h1>
		Kaffekopper AS
	</h1>
	<img src="KaffeKopperAS.jpeg" style="height:400px;width:400px;"/>
	
	<fmt:bundle basename="no.hvl.dat152.Messages">
	<p>
		<fmt:message key="infotekst"></fmt:message>
	</p>
	</fmt:bundle>
	
	<dat152:copyright since="2008"> HVL </dat152:copyright>
	

</body>
</html>