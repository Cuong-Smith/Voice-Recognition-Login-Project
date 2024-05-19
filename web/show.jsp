<%-- 
    Document   : newjsp
    Created on : Feb 19, 2024, 8:08:24 PM
    Author     : Administrator
--%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.StudentDAO"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Students</title>
    <style>
        body {
            background-color: #FFFFFF; /* Màu nền */
            color: #51829B; /* Màu chữ */
            font-family: Arial, sans-serif; /* Kiểu font */
            margin: 0; /* Loại bỏ margin */
            padding: 0; /* Loại bỏ padding */
        }
        h1 {
            text-align: center; /* Căn giữa tiêu đề */
        }
        table {
            width: 100%; /* Độ rộng bảng */
            border-collapse: collapse; /* Gộp đường viền */
        }
        th, td {
            padding: 8px; /* Kích thước padding */
            text-align: left; /* Căn trái nội dung */
            border-bottom: 1px solid #51829B; /* Đường viền dưới */
        }
        tr:nth-child(even) {
            background-color: #f2f2f2; /* Màu nền cho hàng chẵn */
        }
        a {
            color: #51829B; /* Màu chữ cho liên kết */
            text-decoration: none; /* Loại bỏ gạch chân */
        }
        a:hover {
            color: #000000; /* Màu chữ khi di chuột vào liên kết */
        }
        form {
            margin-top: 20px; /* Khoảng cách từ bảng đến form */
            text-align: center; /* Căn giữa form */
        }
        input[type="submit"] {
            background-color: #51829B; /* Màu nền nút */
            color: #FFFFFF; /* Màu chữ nút */
            padding: 10px 20px; /* Kích thước padding */
            border: none; /* Loại bỏ border */
            border-radius: 5px; /* Bo tròn góc */
            cursor: pointer; /* Đổi hình con trỏ khi di chuột */
        }
        input[type="submit"]:hover {
            background-color: #000000; /* Màu nền khi di chuột vào nút */
        }
    </style>    
    </head>
    
    <body>
        <h1>List of Students</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Date of Birth</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <%
                ArrayList<Student> studentList = StudentDAO.getAllStudents();
                for (Student student : studentList) {
            %>
            <tr>
                <td><%= student.getId()%></td>
                <td><%= student.getName()%></td>
                <td><%= student.getGender()%></td>
                <td><%= student.getDateOB()%></td>
                <td><a href="editStudent.jsp?id=<%= student.getId()%>">Edit</a></td>
                <td><a href="deleteStudent?id=<%= student.getId()%>">Delete</a></td>
            </tr>
            <%}%>
        </table>
            
        <form action="addStudent.jsp">
            <input type="submit" value="Add Student">
        </form>
        <form action="searchStudent.jsp" method="post">
            <input type="submit" value="Search Student">
        </form>
        <form action="showStudent" method="get">
            <input type="submit" value="Speech">
        </form>
    </body>

</html>
