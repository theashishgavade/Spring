<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


    <h1>Update Counsellor Profile</h1>
    <form action="counsellor/update/{id}" method="POST">
        <label for="name">Name:</label>
        <input type="text" name="name"><br>
        
        <label for="email">Email:</label>
        <input type="email" name="email"><br>
        
        <label for="password">Password:</label>
        <input type="password" name="password"><br>
        
        <button type="submit">Update</button>
    </form>

</body>
</html>