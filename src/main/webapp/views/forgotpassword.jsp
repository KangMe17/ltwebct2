<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<style>
/* Add your existing CSS styles here */
</style>
</head>
<body>
	<c:if test="${alert != null}">
		<h3 class="alert alertdanger">${alert}</h3>
	</c:if>
	<form action="/helloworld/forgotpassword" method="post">
		<div class="container">
			<label for="email"><b>Email</b></label>
			<input type="text" placeholder="Enter your email" name="email" required>

			<button type="submit">Reset Password</button>
		</div>
	</form>
</body>
</html>
