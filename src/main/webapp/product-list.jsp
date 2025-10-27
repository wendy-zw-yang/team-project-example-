<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3 bg-light">
            <h4>Menu</h4>
            <ul class="nav flex-column">
                <li class="nav-item"><a class="nav-link" href="category?action=list">Category Management</a></li>
                <li class="nav-item"><a class="nav-link" href="product?action=list">Product Management</a></li>
                <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
            </ul>
        </div>
        <div class="col-md-9">
            <h2>Products</h2>
            <a href="product?action=new" class="btn btn-success">Add New Product</a>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Category ID</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${listProduct}">
                    <tr>
                        <td><c:out value="${product.id}" /></td>
                        <td><c:out value="${product.name}" /></td>
                        <td><c:out value="${product.price}" /></td>
                        <td><c:out value="${product.description}" /></td>
                        <td><c:out value="${product.categoryId}" /></td>
                        <td><c:out value="${product.status}" /></td>
                        <td>
                            <a href="product?action=edit&id=<c:out value='${product.id}' />">Edit</a>
                            &nbsp;
                            <a href="product?action=delete&id=<c:out value='${product.id}' />">Delete</a>
                            &nbsp;
                            <a href="product?action=toggleStatus&id=<c:out value='${product.id}' />">Toggle Status</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>