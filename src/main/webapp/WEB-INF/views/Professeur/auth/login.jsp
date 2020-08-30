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
    <title>Login Professeur</title>

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
        <div class="page-content--bge5">
            <div class="container">
                <div class="login-wrap">
                    <div class="login-content">
                        <div class="login-logo">
                            <a href="#">
                                <img src="images/icon/logo.png" alt="CoolAdmin">
                            </a>
                        </div>
                        <div class="login-form">
                        ${msg }
                            <form action="${pageContext.request.contextPath}/professeur/process-login" method="post">
                                <div class="form-group">
                                    <label>Email Address</label>
                                    <input class="au-input au-input--full" type="email" name="email" placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input class="au-input au-input--full" type="password" name="motdepass" placeholder="Password">
                                </div>
                                <div class="login-checkbox">
                                    <label>
                                        <input type="checkbox" name="remember">Remember Me
                                    </label>
                                    <label>
                                        <a href="#">Forgotten Password?</a>
                                    </label>
                                </div>
                                <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">sign in</button>
                                
                            </form>
                            <div class="register-link">
                                <p>
                                    Don't you have account?
                                    <a href="#">Sign Up Here</a>
                                </p>
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