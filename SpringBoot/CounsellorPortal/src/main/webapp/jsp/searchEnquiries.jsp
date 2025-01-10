<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Search Enquiries</h1>
    <form action="enquiry/search" method="GET">
        <label for="status">Search by Status:</label>
        <select name="status">
            <option value="">-- Select Status --</option>
            <option value="Pending">Pending</option>
            <option value="Completed">Completed</option>
            <option value="In Progress">In Progress</option>
        </select><br>

        <label for="classMode">Search by Class Mode:</label>
        <input type="text" name="classMode" placeholder="Online/Offline"><br>

        <label for="course">Search by Course:</label>
        <input type="text" name="course" placeholder="Enter Course Name"><br>

        <button type="submit">Search</button>
    </form>
    <br>
    <h2>Search Results:</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Course</th>
                <th>Class Mode</th>
                <th>Phone</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <%-- Dynamic rows populated based on search results from the backend --%>
        </tbody>
    </table>
</body>
</html>