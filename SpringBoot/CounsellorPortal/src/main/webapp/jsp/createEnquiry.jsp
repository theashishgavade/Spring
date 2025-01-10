<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>Create Enquiry</h1>
    <form action="enquiry/create" method="POST">
        <label for="course">Course:</label>
        <input type="text" name="course" required><br>
        
        <label for="classMode">Class Mode:</label>
        <input type="text" name="classMode" required><br>
        
        <label for="phone">Phone:</label>
        <input type="text" name="phone" required><br>
        
        <label for="status">Status:</label>
        <input type="text" name="status" required><br>
        
        <button type="submit">Create</button>
    </form>

</body>
</html>