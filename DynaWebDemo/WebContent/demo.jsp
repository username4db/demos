<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
	import="java.util.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- JSP comment --%>
<%!
	int i = 0;
	int j = 1;
%>
<%!String str = "A";%>	


<!-- HTML comment -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="TEST" />
	<c:out value="locale" />

<jsp:scriptlet>
	Locale locale = request.getLocale();
	out.println(locale);
	out.println(i);
	out.println(j);
	out.println(str);
	pageContext.setAttribute("LOCALE", locale);
	pageContext.setAttribute("str", "AA");
	pageContext.getAttribute("LOCALE");
</jsp:scriptlet>
<HR>
${str}
<HR>
${LOCALE}
<HR>
<c:out value="${str}" default="default value of c:out"/>
<HR>


</body>
</html>