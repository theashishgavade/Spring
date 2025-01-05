<%@page import="com.ty.empapp.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<h1>Employee</h1>
		<h6>${msg}</h6>
		<form action="add" method="post">
			<%
			Employee employee = (Employee) request.getAttribute("employee");
			/* out.print(employee); */
			%>
			<div class="mb-3">
				<label for="ex1" class="form-label"></label> <input
					name="eid" type="hidden" class="form-control"
					id="ex1" placeholder="ex:Dinga"
					value="<%=employee.getEid()%>" required>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Name</label>
				<input name="name" type="text" class="form-control"
					id="exampleFormControlInput1" placeholder="ex:Dinga"
					value="<%=employee.getName()%>" required>
			</div>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Email
					address</label> <input type="email" name="email" class="form-control"
					id="exampleFormControlInput1" placeholder="name@example.com"
					value="<%=employee.getEmail()%>" required>
			</div>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Phone</label>
				<input type="number" name="phone" class="form-control"
					id="exampleFormControlInput1" placeholder="99******12"
					value="<%=employee.getPhone()%>" required>
			</div>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label"></label> <input
					type="hidden" name="password" class="form-control"
					id="exampleFormControlInput1" placeholder="dinga@123"
					value="<%=employee.getPassword()%>" required>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>

		</form>
		<a href="home">Home Page</a>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>