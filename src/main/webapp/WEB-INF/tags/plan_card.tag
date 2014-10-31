<%@ tag body-content="scriptless" %>

<%@ attribute name="plan" required="true" type="Plan" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="card people" style="margin:auto;margin-top:15px">
	<div class="card-top blue">

    	<div>
			<form name="remove" class="pull-right" method="post" action="${pageContext.request.contextPath}/contact/delete/${contact.id}">
				<button class="btn btn-default navbar-btn" title="Supprimer le contact" type="submit">
					<i class="fa fa-close"></i>
				</button>
			</form>

			<button class="btn btn-default navbar-btn pull-right"
				title="Edition"
				onclick="window.location ='${pageContext.request.contextPath}/contact/edit/${contact.id}'">
				<i class="fa fa-cog"></i>
			</button>
			<button class="btn btn-default navbar-btn pull-right"
				title="Ajout adresse"
				onclick="window.location ='${pageContext.request.contextPath}/address/create/${contact.id}'">
				<i class="fa fa-plus"></i>
			</button>
		</div>
    </div>
    
    <div class="card-info">
	    <table style="width: 100%">
		    <tr>
			    <td style="width: 30%">
			    	<a href="#">
			    		<img height="146" width="105" src="<c:url value="/resources/assets/img/contact.png"/>" alt=""/>
			    	</a>
			    </td>
			    <td style="width: 70%">
			    	
			    </td>
		    </tr>	
	    </table>
   	</div>
 </div>
 
 

