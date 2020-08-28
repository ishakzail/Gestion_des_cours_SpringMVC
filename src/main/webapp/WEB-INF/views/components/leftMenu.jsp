<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="index.html">
		
		<div class="sidebar-brand-text mx-3">
			ADMIN-PANEL
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<c:url value="/admin/home" var="home" />
	<li class="nav-item"><a class="nav-link" href="${home}"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Tableau de bord</span></a>
	</li>
	
	<!-- Divider -->
	<hr class="sidebar-divider">
	<c:url value="/admin/departements" var="departements" />
	<li class="nav-item"><a class="nav-link" href="${departements }"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Gestion des d�partements</span></a>
	</li>
	
	<!-- Divider -->
	<hr class="sidebar-divider">
	<c:url value="/admin/filieres" var="filieres" />
	<li class="nav-item"><a class="nav-link" href="${filieres }"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Gestion des fili�res</span></a>
	</li>

	<!-- Divider -->
	<hr class="sidebar-divider">
	<c:url value="/admin/professeurs" var="profs" />
	<li class="nav-item"><a class="nav-link" href="${profs }"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Gestion des professeurs</span></a>
	</li>
	
	<!-- Divider -->
	<hr class="sidebar-divider">
	<c:url value="/admin/etudiants" var="etudiants" />
	<li class="nav-item"><a class="nav-link" href="${etudiants }"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Gestion des �tudiants</span></a>
	</li>
	
	
	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	

</ul>
