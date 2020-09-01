<%@ include file="/WEB-INF/views/includes/includes.jsp"%>

<aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="#">
                    <img src="${pageContext.request.contextPath}/resources/utilisateur/images/logo-est.png" alt="Logo EST" height="400" width="200"/>
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li>
                        	<c:url value="/professeur/${profss.getIdProf() }/cours" var="index"></c:url>
                            <a href="${index }">
                                <i class="fas fa-table"></i>Gestion des cours</a>
                        </li>
                       
     				</ul>
                </nav>
            </div>
        </aside>