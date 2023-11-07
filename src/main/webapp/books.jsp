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
    <link href="css/styles.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        form {
            width: 300px;
            margin: 0 auto;
        }

        h1 {
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
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
<header class="py-5 bg-image-full" style="margin-top: -20px; height:300px; background-image: url('https://source.unsplash.com/wfh8dDlNFOk/1600x900')">
    <div class="text-center my-5">
        <h1 class="text-white fs-3 fw-bolder">Shop Book : Lê Thanh Hiền</h1>
        <p class="text-white-50 mb-0">19161232</p>
    </div>
</header>
<!-- Content section-->
<section class="py-5 container">
    <h2>List Book</h2>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Create</button>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Book ID</th>
            <th>ISBN</th>
            <th>Title</th>
            <th>Publisher</th>
            <th>Price</th>
            <th>Description</th>
            <th>Publish Date</th>
            <th>Cover Image</th>
            <th>Quantity</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.bookid}</td>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${book.publisher}</td>
                <td>${book.price}</td>
                <td>${book.description}</td>
                <td>${book.publishDate}</td>
                <td>${book.coverImage}</td>
                <td>${book.quantity}</td>
                <td><button type="button" class="btn btn-warning">Edit</button></td>
                <td><button type="button" class="btn btn-danger" onclick="deleteBook(${book.bookid})">Delete</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <form action="/books" method="post">
            <div class="modal-body">
                    <label for="isbn">ISBN:</label>
                    <input type="text" id="isbn" name="isbn" required><br>

                    <label for="title">Title:</label>
                    <input type="text" id="title" name="title" required><br>

                    <label for="publisher">Publisher:</label>
                    <input type="text" id="publisher" name="publisher" required><br>

                    <label for="price">Price:</label>
                    <input type="text" id="price" name="price" required><br>

                    <label for="description">Description:</label>
                    <input type="text" id="description" name="description"><br>

                    <label for="publishDate">Publish Date:</label>
                    <input type="date" id="publishDate" name="publishDate" required><br>

                    <label for="coverImage">Cover Image URL:</label>
                    <input type="text" id="coverImage" name="coverImage"><br>

                    <label for="quantity">Quantity:</label>
                    <input type="text" id="quantity" name="quantity" required><br>

            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Create</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
            </form>
        </div>

    </div>
</div>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Lê Thanh Hiền &copy; 19161232</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
<script>
    function deleteBook(id) {
        if (confirm("Bạn chắc muốn xóa book chứ")){
            location.href= "/delete?id="+id;
        }
    }
</script>
