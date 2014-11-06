<%@ tag body-content="scriptless" %>

<%@ attribute name="person" required="true" type="models.Person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="card person" style="margin:auto;margin-top:15px">
	<div class="card-top blue">

    	<div>
			<form name="remove" class="pull-right" method="post" action="${pageContext.request.contextPath}/persons/delete/${person.id}">
				<button class="btn btn-default navbar-btn" title="Supprimer" type="submit">
					<i class="fa fa-close"></i>
				</button>
			</form>

			<button class="btn btn-default navbar-btn pull-right"
				title="Edition"
				onclick="window.location ='${pageContext.request.contextPath}/persons/edit/${person.id}'">
				<i class="fa fa-cog"></i>
			</button>
		</div>
    </div>
    
    <div class="card-info">
	    <table style="width: 100%">
		    <tr>
			    <td style="width: 100%">
			    	<a class="title" href="#" style="text-align: center; ">${person.lastName} ${person.firstName}</a>
			    	<br />
			    	<div class="desc"><i class="fa fa-at" style="margin-right:10px"></i><a href="mailto:${person.email}">${person.email}</a></div>
			    </td>
		    </tr>	
	    </table>
   	</div>
 </div>
 
 

