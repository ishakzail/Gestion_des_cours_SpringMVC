<div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="${pageContext.request.contextPath}/resources/utilisateur/images/icon/avatar-01.jpg" alt="John Doe" />
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#">${prof.nom }  ${prof.prenom }</a>
                                                    </h5>
                                                    <span class="email">${prof.getEmail() }</span>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                <c:url value="/professeur/profile" var="profile" /> 
                                                    <a href="${profile }">
                                                        <i class="zmdi zmdi-account"></i>Account</a>
                                                </div>
                                           	</div>
                                            <div class="account-dropdown__footer">
                                            <c:url value="/professeur/process-logout" var="logout"></c:url>
                                                <a href="${logout }">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    