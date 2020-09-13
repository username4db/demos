<%@ include file="include.jspf"  %>

<c:remove var="setVar" scope="session"/>
<c:set var="setVar" scope="session" value="setVarValue"/>
	
<!DOCTYPE html>
<jsp:useBean id="demoBean" class="demo.pojo.DemoBean" scope="request"/>
<html>
<head>
<meta charset="UTF-8">
<title>${demoBean.propString}</title>
</head>
<body>

<jsp:getProperty name="demoBean" property="propInt"/>
<br>
<jsp:getProperty name="demoBean" property="propString"/>
<br>
<jsp:setProperty name="demoBean" property="propString" value="${param.parmString}"/>
<br>
<jsp:getProperty name="demoBean" property="propString"/>
<br>
<c:out value="${setVar}" />
<br>
<form method="post">
	<input type="text" name="parmString" value="${demoBean.propString}"/>
	<input type="submit"/>
</form>

</body>
</html>