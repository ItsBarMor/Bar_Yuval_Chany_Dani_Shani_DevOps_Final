<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>DevOps Final Project - HIT</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9;}
        .container { background: white; border: 1px solid #ccc; padding: 20px; border-radius: 5px; max-width: 500px; box-shadow: 2px 2px 10px rgba(0,0,0,0.1); }
        .input-group { margin-bottom: 15px; }
        button { padding: 8px 15px; background-color: #28a745; color: white; border: none; border-radius: 3px; cursor: pointer; }
        button:hover { background-color: #218838; }
        input[type="text"] { padding: 8px; width: 80%; border: 1px solid #ccc; border-radius: 3px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>DevOps Final Project</h1>
        <h3>Team: Daniel, Yuval, Bar, Chany, Shani</h3>

        <form action="index.jsp" method="POST">
            <div class="input-group">
                <label for="nameInput">Enter a test value:</label><br><br>
                <input type="text" id="nameInput" name="testValue" placeholder="Type something here..." required>
            </div>

            <div class="input-group">
                <button type="submit" id="submitBtn">Submit</button>
            </div>
        </form>

        <%
            String val = request.getParameter("testValue");
            if (val != null && !val.trim().isEmpty()) {
                out.println("<p id='resultMsg' style='color: blue;'>You submitted: <strong>" + val + "</strong></p>");
            }
        %>

        <hr>
        <p>Check out our code on <a href="https://github.com/ItsBarMor/Bar_Yuval_Chany_Dani_Shani_DevOps_Final.git" id="repoLink" target="_blank">GitHub</a>.</p>
    </div>
</body>
</html>