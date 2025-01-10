<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


    <h1>Update Enquiry</h1>
    <form action="enquiry/update/{id}" method="POST">
        <label for="course">Course:</label>
        <input type="text" name="course" required value=""><br>

        <label for="classMode">Class Mode:</label>
        <input type="text" name="classMode" required value=""><br>

        <label for="phone">Phone:</label>
        <input type="text" name="phone" required value=""><br>

        <label for="status">Status:</label>
        <select name="status" required>
            <option value="Pending">Pending</option>
            <option value="Completed">Completed</option>
            <option value="In Progress">In Progress</option>
        </select><br>

        <button type="submit">Update Enquiry</button>
    </form>


</body>
</html>