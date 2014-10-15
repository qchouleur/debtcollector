<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.List" %>

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
    		<link href="<c:url value="/resources/css/addressbook.css" />" rel="stylesheet" media="screen">
    		
    		<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    	</head>
    	<body>
    		<tags:navbar search_action="${pageContext.request.contextPath}"/>
    		
    		<div id="wrapper">

		        <!-- Sidebar -->
		        <div id="sidebar-wrapper">
		            <ul class="sidebar-nav">
		                <li class="sidebar-brand">
		                    <a href="#">
		                        Start Bootstrap
		                    </a>
		                </li>
		                <li>
		                    <a href="#">Dashboard</a>
		                </li>
		                <li>
		                    <a href="#">Shortcuts</a>
		                </li>
		                <li>
		                    <a href="#">Overview</a>
		                </li>
		                <li>
		                    <a href="#">Events</a>
		                </li>
		                <li>
		                    <a href="#">About</a>
		                </li>
		                <li>
		                    <a href="#">Services</a>
		                </li>
		                <li>
		                    <a href="#">Contact</a>
		                </li>
		            </ul>
		        </div>
		        <!-- /#sidebar-wrapper -->
		
		        <!-- Page Content -->
		        <div id="page-content-wrapper">
		            <div class="container-fluid">
		                <div class="row">
		                    <div class="col-lg-12">
		                        <h1>Simple Sidebar</h1>
		                        <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
		                        <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>
		                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
		                    </div>
		                </div>
		            </div>
		        </div>
		        <!-- /#page-content-wrapper -->
		
		    </div>
		    <!-- /#wrapper -->
    		
			<div class="container">
			
				Hello World...
			
			</div>
    	</body>
    </html>

