<%@ page import="java.util.ArrayList" %>
<%@ page import="com.todo.jsp_hibernate_mysql.Tasks" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ToDo List</title>
    <link rel='stylesheet' type='text/css' media='screen' href='style.css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<br/>
<div class="container" style="background-color: #bdbdca; opacity: 0.93; backdrop-filter: blur(10px)">
    <h1>ToDo List</h1>
    <!--form used to display items form ToDo app-->
    <form action="hello-servlet" method ="post">
         <input type="submit" id="view" value="Display Items" name="task">
    </form>
    <!--form used to add items to ToDo app -->
    <form action="hello-servlet" method="post" id="todo-form" >
        <input type="text" id="todo-input" name="taskName" placeholder="Add a new task">
        <input type="submit" value="Add" name = "task" style="color: black; background-color: #ffdb58">
    </form>
   <!-- Java scriptlet to get the items from HelloServlet controller and display them on the page-->
    <%
        ArrayList<Tasks> myList = (ArrayList<Tasks>) request.getAttribute("x");
        int count=0;
        if (myList != null && !myList.isEmpty()) {%>
             <table class="itemsTable">
        <tr>
            <th id="header">Task Name</th>
            <th></th>
        </tr><%
            for (Tasks item : myList) {
    %>
    <tr id="todo-list">
                <td><%=++count%>.  <%=item.getTaskName()%></td>
<!-- sending get variable to controller to identify the item that needs to be deleted-->
        <td><a href="hello-servlet?delId=<%=item.getId()%>"><i class="fas fa-trash fa-2x" style="color:#537895"></i></a></td>
            </tr>
    <%}}%>
    </table>
</div>
</body>
</html>