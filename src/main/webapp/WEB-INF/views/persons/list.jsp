<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"  %>

<!DOCTYPE html>
    <html>
    	<head>
    		<title>Debt Collector</title>
    		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    		
    		<link href="<c:url value="/resources/css/bootplus.css" />" rel="stylesheet">
    		<link href="<c:url value="/resources/css/bootplus.min.css" />" rel="stylesheet" media="screen">
    		<link href="<c:url value="/resources/css/bootplus-responsive.min.css" />" rel="stylesheet" media="screen">
    		<link href="<c:url value="/resources/css/person.css" />" rel="stylesheet" media="screen">
    		
    		<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    		
    		<script src="http://code.jquery.com/jquery.js"></script>
    		<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    	</head>
    	<body>
    		<tags:navbar_person search_action="${pageContext.request.contextPath}"/>

			<div class="container" style="margin-left: 50px;margin-top: 100px">
				
				<c:forEach items="${users}" var="user">
	 				<tags:person_card person= "${user}"/>
	    		</c:forEach>
		  			
			</div>
    	</body>
    </html>

