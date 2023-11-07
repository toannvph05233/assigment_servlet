<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author19161232" content=""/>
    <title>Full Width Pics - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="/css/styles.css" rel="stylesheet"/>
</head>
<body>
<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#!">Books</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="/">Product</a></li>
                <c:if test="${sessionScope.user.isAdmin()}">
                    <li class="nav-item"><a class="nav-link" href="/books">Admin</a></li>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                    <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
                </c:if>

                <c:if test="${sessionScope.user != null}">
                    <li class="nav-item"><a class="nav-link" href="/">${sessionScope.user.getFullname()}</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<!-- Header - set the background image for the header in the line below-->
<header class="py-5 bg-image-full" style="background-image: url('https://source.unsplash.com/wfh8dDlNFOk/1600x900')">
    <div class="text-center my-5">
        <h1 class="text-white fs-3 fw-bolder">Shop Book : Lê Thanh Hiền</h1>
        <p class="text-white-50 mb-0">19161232</p>
    </div>
</header>
<!-- Content section-->
<section class="py-5">
    <div class="container my-5 container">
        <c:forEach var="book" items="${books}">
            <div class="row" style=" padding: 15px">
                <div class="col-3">
                    <img src="${book.coverImage}" width="200" height="170">
                </div>
                <div class="col-6">
                    <h3> ${book.title}</h3>
                    <h4> ${book.price}</h4>
                    <h5> ${book.isbn}</h5>
                    <h5> ${book.publisher}</h5>
                    <h5> ${book.quantity}</h5>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Lê Thanh Hiền &copy; 19161232</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/js/scripts.js"></script>
</body>
</html>
