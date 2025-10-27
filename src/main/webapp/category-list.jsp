<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category List</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3 bg-light">
            <!-- Repeat sidebar here or include a common JSP -->
            <h4>Menu</h4>
            <ul class="nav flex-column">
                <li class="nav-item"><a class="nav-link" href="category?action=list">Category Management</a></li>
                <li class="nav-item"><a class="nav-link" href="product?action=list">Product Management</a></li>
                <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
            </ul>
        </div>
        <div class="col-md-9">
            <h2>Categories</h2>
            <a href="category?action=new" class="btn btn-success">Add New Category</a>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="category" items="${listCategory}">
                    <tr>
                        <td><c:out value="${category.id}" /></td>
                        <td><c:out value="${category.name}" /></td>
                        <td><c:out value="${category.description}" /></td>
                        <td>
                            <a href="category?action=edit&id=<c:out value='${category.id}' />">Edit</a>
                            &nbsp;
                            <a href="category?action=delete&id=<c:out value='${category.id}' />">Delete</a>
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