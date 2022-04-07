<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 06/04/2022
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add New Wallet</title>
</head>
<body>
<h2>
    <a href="wallets?action=wallets">Back to list of wallets</a>
</h2>
<div>
    <form method="post">
        <table>
            <caption>
                <h2>Create new wallet</h2>
            </caption>
            <tr>
                <th>Wallet name</th>
                <td>
                    <label for="name"></label>
                    <input type="text" name="name" id="name" size="50"/>
                </td>
            </tr>
            <tr>
                <th>Id_Currency</th>
                <td>
                    <label for="currency"></label>
                    <select name="currencies" id="currency">
                        <c:forEach var="currency" items="${currencies}">
                            <option value="${currency.getId()}">${currency.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Id_User</th>
                <td>
                    <label for="user"></label>
                    <select name="user" id="user">
                        <c:forEach var="user" items="${userWallet}">
                            <option value="${user.getId()}">${user.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Balance</th>
                <td>
                    <label for="balance"></label>
                    <input type="number" name="balance" id="balance" placeholder="Số tiền hiện tại" size="50"/>
                </td>
            </tr>
            <tr>
                <th>Description</th>
                <td>
                    <label for="description"></label>
                    <input type="text" name="description" id="description" placeholder="Mô tả" size="50"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Create"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
