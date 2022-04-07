<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 06/04/2022
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Wallet</title>
</head>
<body>
<h2>
    <a href="wallets?action=wallets">Back to list of wallets</a>
</h2>
<div>
    <form method="post">
        <table>
            <caption>
                <h2>Edit Wallet</h2>
            </caption>
            <c:if test="${editingWallet != null}">
                <input type="hidden" name="id" value="<c:out value='${editingWallet.id_wallet}' />"/>
            </c:if>
            <tr>
                <th>Wallet Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${editingWallet.name_wallet}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Balance:</th>
                <td>
                    <input type="text" name="balance" size="45"
                           value="<c:out value='${editingWallet.balance}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" size="15"
                           value="<c:out value='${editingWallet.description}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Update"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
