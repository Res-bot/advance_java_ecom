<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.UsersModel" %>
<%@page import="util.StringUtils" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
        __integrity__="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
        __crossorigin__="anonymous" __referrerpolicy__="no-referrer" />
          <!-- code for __boxicons__  -->
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <!-- code for __boxicons__  -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/styles/signup.css">

<style>
    /* Style for admin checkbox */
    .admin-checkbox-control {
        display: flex;
        align-items: center;
        margin: 15px 0;
        padding: 10px;
        background-color: #f0f0f0;
        border-radius: 5px;
    }
    .admin-checkbox-control input[type="checkbox"] {
        width: auto;
        height: 18px;
        margin-right: 10px;
        cursor: pointer;
    }
    .admin-checkbox-control label {
        cursor: pointer;
        margin: 0;
        font-size: 14px;
        font-weight: 500;
        color: #333;
    }
</style>

</head>
<body>

 <div class="container">
        <div class="signup-box">
            <h1 class="sign-head">SIGN UP</h1>
<form action="${pageContext.request.contextPath}/SignupServlet" method="post" enctype="multipart/form-data">

<div class="input-control">
<label>UserName:</label>
<input type="text" id="userName" name="userName" required>
</div>

<div class="input-control">
<label>Email:</label>
<input type="email" id="email" name="email" required>
</div>

<div class="input-control">
<label>Location:</label>
<input type="text" id="location" name="location" required>
</div>

<div class="input-control">
<label>Phone:</label>
<input type="text" id="phone" name="phone" required>
</div>

<div class="input-control">
<label>Password:</label>
<input type="password" id="password" name="password" required>
</div>

<div class="input-control">
<label>Retype Password:</label>
<input type="password" id="retypePassword" name="retypePassword" required>
</div>

<div class="input-control">
<label for="image">Profile Picture</label> 
<input type="file" id="image" name="image">
</div>

<!-- ADMIN CHECKBOX - NEW ADDITION -->
<div class="admin-checkbox-control">
    <input type="checkbox" id="is_admin" name="is_admin" value="1">
    <label for="is_admin">
        <i class="fas fa-user-shield"></i> Register as Admin
    </label>
</div>

 <div class="group">
    <p class="sign-para"><a href="${pageContext.request.contextPath}/pages/login.jsp">Already have an account? </a></p>
</div>

<div class="button">
<button type="submit">Sign up</button>
</div>

 <%
        String errorMessage = (String) request.getAttribute(StringUtils.ERROR_MESSAGE);
        String successMessage = (String) request.getAttribute(StringUtils.SUCCESS_MESSAGE);

        if (errorMessage !=null && !errorMessage.isEmpty()) {
    %>
        <div class="error" role="alert">
            <%= errorMessage %>
        </div>
        <%
        }
        
        if (successMessage != null && !successMessage.isEmpty()) {
        %>
        <div class="success" role="alert">
            <%= successMessage %>
        </div>
        <%
        }
        %>
</form>

</div>
</div>

</body>
</html>