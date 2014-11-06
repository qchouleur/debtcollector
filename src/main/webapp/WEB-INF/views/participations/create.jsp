<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE html>
    <html>
    	<head>
    		<title>Debt Collector</title>
    		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    		
    		<link href="<c:url value="/resources/css/bootplus.css" />" rel="stylesheet">
    
    		<link href="<c:url value="/resources/css/bootplus.min.css" />" rel="stylesheet" media="screen">
    		<link href="<c:url value="/resources/css/bootplus-responsive.min.css" />" rel="stylesheet" media="screen">
    		<link href="<c:url value="/resources/css/addressbook.css" />" rel="stylesheet" media="screen">
    		
    		<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
			<!--[if IE 7]>
    		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootplus-ie7.min.css">
    		<![endif]-->
    		
    		<script src="http://code.jquery.com/jquery.js"></script>
    		<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    	</head>
	<body style="padding-top:50px">
		<tags:navbar search_action="${pageContext.request.contextPath}"/>

	<div class="container" style="margin-top:50px">
		<form:form action="${pageContext.request.contextPath}/participations/create/${idPlan}" class="form-horizontal" commandName="participation">
	    	<fieldset>		
	    		<table style="margin-left: 130px">
	    			<tr>
	    				<td>
	    					<label style="text-align: center;">Alias</label>
	    				</td>
	    				<td>
				    		<form:select name="person" path="person" style="margin-left: 20px; margin-bottom: 15px">
							  <c:forEach items="${users}" var="user">
							    <form:option value="${user}">
							        ${user.firstName} ${user.lastName} - ${user.email}
							    </form:option>
							  </c:forEach>
							</form:select>
						</td>
					</tr>
				</table>
		     
		     	<tags:form_field label="Montant" name="amount" placeholder="Amount" path="amount"/>
		     
			    <div class="control-group">
					<div class="controls">
						<button type="submit" class="btn btn-success">Enregistrer</button>
					</div>
				</div>
	    	</fieldset>
		</form:form>
	</div>
</body>
</html>