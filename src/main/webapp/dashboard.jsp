<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!-- Left Sidebar Menu -->
        <div class="col-md-3 bg-light">
            <h4>Menu</h4>
            <ul class="nav flex-column">
                <li class="nav-item"><a class="nav-link" href="category?action=list">Category Management</a></li>
                <li class="nav-item"><a class="nav-link" href="product?action=list">Product Management</a></li>
                <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
            </ul>
        </div>
        <!-- Main Content -->
        <div class="col-md-9">
            <h2>Welcome, Admin</h2>
            <p>Select a menu item from the left.</p>
        </div>
    </div>
</div>
</body>
</html>