
<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Accueil</title>

    <!-- Fontfaces CSS-->
    <link href="${pageContext.request.contextPath}/resources/utilisateur/css/font-face.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="${pageContext.request.contextPath}/resources/utilisateur/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
       <%@ include file="/WEB-INF/views/Professeur/components/Menu.jsp"%>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                            <form class="form-header" action="" method="POST">
                               <h2> Liste des Cours </h2> 
                            </form>
                            <div class="header-button">
                               
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/resources/utilisateur/images/icon/avatar-01.jpg" alt="John Doe" />
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#"></a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="${pageContext.request.contextPath}/resources/utilisateur/images/icon/avatar-01.jpg" alt="John Doe" />
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#"></a>
                                                    </h5>
                                                    <span class="email">johndoe@example.com</span>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                    <a href="#">
                                                        <i class="zmdi zmdi-account"></i>Account</a>
                                                </div>
                                           	</div>
                                            <div class="account-dropdown__footer">
                                            <c:url value="/professeur/process-logout" var="logout"></c:url>
                                                <a href="${logout }">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            
            <!-- HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        
                        <div class="row">
                            <div class="col-lg-12">
                            	
                            	
                            
                                
                                
                                <div class="overview-wrap">
                                    
                                </div>
                                <br>
                                <div class="table-responsive table--no-card m-b-40">
                                    <table class="table table-borderless table-striped table-earning">
                                        <thead>
                                            <tr>
                                                <th>Nom du cour</th>
                                                <th>Module</th>
                                                <th>Action</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${cours }" var="cour">
                                            <tr>
                                                <td>${cour.nom }</td>
                                                <td>${cour.module }</td>
                                                <td>
                                                <c:url value="/etudiant/cour/fichier/${cour.getIdCour() }" var="index"></c:url>
                                                <a href="${index }" >Fichier</a>
                                                 </td>
                                               
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            
                        </div>
                        
                    </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/slick/slick.min.js">
    </script>
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/wow/wow.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/animsition/animsition.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/circle-progress/circle-progress.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/utilisateur/vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="${pageContext.request.contextPath}/resources/utilisateur/js/main.js"></script>

</body>

</html>
<!-- end document-->
