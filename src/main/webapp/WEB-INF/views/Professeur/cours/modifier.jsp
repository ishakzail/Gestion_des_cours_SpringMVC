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
    <title>Modifier un cour</title>

    <!-- Fontfaces CSS-->
    <link href="${pageContext.request.contextPath}/resources/utilisateur/css/font-face.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/utilisateur/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
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
                               <h2> La modification d'un cour </h2> 
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
                                       <%@ include file="/WEB-INF/views/Professeur/components/compte.jsp"%>
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
                            
                            <div class="col-lg-6">
                                <div class="card">
                                    <div class="card-header">
                                        <strong>Formulaire pour modifier le cour ${cour.nom }</strong> 
                                       
                                    </div>
                                    <c:url value="/professeur/cour/modifier"  var="md"/>
                                    <f:form modelAttribute="cour"  action="${md }" method="post">
                                    
                                    
	                                    <div class="card-body card-block" >
	                                        <div class="has-success form-group">
	                                            <label for="inputSuccess2i" class=" form-control-label">Nom du Cour</label>
	                                            <f:input type="text" path="nom" class="form-control-success form-control" />
	                                        </div>
	                                       <f:hidden path="idCour" />
	                                        
	                                    </div>
	                                     <div class="card-body card-block" >
	                                        <div class="has-success form-group">
	                                            <label for="inputSuccess2i" class=" form-control-label">Nom du module</label>
	                                            <f:input type="text" path="module" class="form-control-success form-control" />
	                                        </div>
	                                       
	                                        
	                                    </div>
	                                    <div class="form-group" style="text-align: center">
						                    <button type="submit" class="btn btn-primary btn-user">
						                      Modifier
						                    </button>
						                    
					                    </div>
                                    </f:form>
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
                            
                         <div class="col-md-12">
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
