<%@ tag body-content="empty" %>
<%@ attribute name="search_action" required="true" type="java.lang.String" %>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="${pageContext.request.contextPath}/"><i class="fa fa-calculator"></i>   Debt Collector</a>
			<button class="btn btn-default navbar-btn pull-right" style="margin-top:5px;min-height:35px; margin-right: 10px" 
					title="Liste des utilisateurs" onclick="window.location ='${pageContext.request.contextPath}/persons/list'">
				<i class="fa fa-users fa-2x"></i>
			</button>
			<button class="btn btn-default navbar-btn pull-right" style="margin-top:5px;min-height:35px; margin-right: 10px" 
					title="Nouveau participant" onclick="window.location ='${pageContext.request.contextPath}/persons/create'">
				<i class="fa fa-plus fa-2x"></i>
			</button>
			<button class="btn btn-default navbar-btn pull-right" style="margin-top:5px;min-height:35px; margin-right: 10px" 
					title="Liste des projets" onclick="window.location ='${pageContext.request.contextPath}'">
				<i class="fa fa-list-ul fa-2x"></i>
			</button>
		</div>
	</div>
</div>