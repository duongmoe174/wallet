<<<<<<< HEAD
<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 06/04/2022
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
=======
>>>>>>> duong
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wallet</title>
</head>
<body>
<center>
    <h1>Create New Wallet</h1>
    <p>
    </p>
</center>
<div align="center">
    <form action="" method="post">
        <table border="1px" cellpadding="5px">
            <caption>
                <h2>Create new wallet</h2>
            </caption>
            <tr>
                <th>Wallet name</th>
                <td>
                    <input type="text" name="name", id="name", size="50" required/>
                </td>
            </tr>
            <tr>
                <th>Currency name
                    <td>
                <select name="id_cur" id="currency">
                    <c:forEach var="c" items="${currencies}">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
            </tr>
            <tr>
                <th>User name</th>
                <td>
<<<<<<< HEAD
                    <label for="user"></label>
                    <select name="user" id="user">
                        <c:forEach var="user" items="${userWallet}">
                            <option value="${user.getId()}">${user.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
=======
                   <%
                       String username = (String) session.getAttribute("loginuser");
                       out.println(username);
                   %>
                </td>

>>>>>>> duong
            </tr>
            <tr>
                <th>Wallet current amount</th>
                <td>
                    <input type="number" name="current_amount", id="current_amount", size="50" required/>
                </td>
            </tr>
            <tr>
                <th>Wallet Description</th>
                <td>
                    <input type="text" name="description", id="description", size="50" required/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="create"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>