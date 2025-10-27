<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Form</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2><c:if test="${product != null}">Edit</c:if><c:if test="${product == null}">Add New</c:if> Product</h2>
    <form action="product?<c:if test="${product != null}">action=update&id=${product.id}</c:if><c:if test="${product == null}">action=insert</c:if>" method="post">
        <div class="form-group">
            <label>Name</label>
            <input type="text" name="name" value="<c:out value='${product.name}' />" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Price</label>
            <input type="number" name="price" value="<c:out value='${product.price}' />" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Description</label>
            <input type="text" name="description" value="<c:out value='${product.description}' />" class="form-control">
        </div>
        <div class="form-group">
            <label>Category ID</label>
            <input type="number" name="categoryId" value="<c:out value='${product.categoryId}' />" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Status</label>
            <select name="status" class="form-control">
                <option value="active" <c:if test="${product.status == 'active'}">selected</c:if>>Active (On-Shelf)</option>
                <option value="inactive" <c:if test="${product.status == 'inactive'}">selected</c:if>>Inactive (Off-Shelf)</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>