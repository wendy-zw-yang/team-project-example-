<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category Form</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2><c:if test="${category != null}">Edit</c:if><c:if test="${category == null}">Add New</c:if> Category</h2>
    <form action="category?<c:if test="${category != null}">action=update&id=${category.id}</c:if><c:if test="${category == null}">action=insert</c:if>" method="post">
        <div class="form-group">
            <label>Name</label>
            <input type="text" name="name" value="<c:out value='${category.name}' />" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Description</label>
            <input type="text" name="description" value="<c:out value='${category.description}' />" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>