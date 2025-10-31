<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="util.StringUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<!-- Code for font awesome __cdn__ -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        __integrity__="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        __crossorigin__="anonymous" __referrerpolicy__="no-referrer" />
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/styles/login.css">

<style>
    .admin-checkbox {
        display: flex;
        align-items: center;
        margin: 15px 0;
        font-size: 14px;
    }
    .admin-checkbox input[type="checkbox"] {
        width: auto;
        margin-right: 8px;
        cursor: pointer;
    }
    .admin-checkbox label {
        cursor: pointer;
        margin: 0;
    }
</style>

</head>
<body>

<div>
  <div class="container">
        <div class="signin-box">
            <h1>LOG IN</h1>
            <a href="#"><i class="ri-arrow-left-line"></i></a>
            <form action="${pageContext.request.contextPath}/LoginServlet" method="post">

                <label for="email">Email:</label>
                <input type="text" id="email" name="email" required>
                
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                
                <!-- ADMIN CHECKBOX - THIS IS THE FIX -->
                <div class="admin-checkbox">
                    <input type="checkbox" id="is_admin" name="is_admin" value="1">
                    <label for="is_admin">Login as Admin</label>
                </div>
                
                <p><a href="${pageContext.request.contextPath}/pages/signup.jsp">Don't have an account?</a></p>
                <input type="submit" value="Log In">
                
                <%
                String successMessage = (String) request.getAttribute(StringUtils.SUCCESS_MESSAGE);
                String errorMessage = (String) request.getAttribute(StringUtils.ERROR_MESSAGE);

                if (errorMessage != null && !errorMessage.isEmpty()) {
                %>
                <!-- Display error message -->
                <div style="color: #ff3860; font-size: 15px; height: 13px;">
                    <%= errorMessage %>
                </div>
                <% } %>

                <%
                if (successMessage != null && !successMessage.isEmpty()) {
                %>
                <!-- Display success message -->
                <div class="alert alert-success mt-2" role="alert">
                    <%= successMessage %>
                </div>
                <% } %>
            </form>
        </div>
    </div>
</div>

</body>
</html>