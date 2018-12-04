<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>iGrocery Application</title>
</head>
<body>

<h2>Items</h2>

    <form:form method="post" action="submitItems" modelAttribute="itemsForm">
    <rep>
    <table>
        <tr>
            <th>Bought</th>
            <th>Id</th>
            <th>Item</th>
            <th>Who</th>
            <th>Date</th>
        </tr>
        <c:forEach var="item" items="${itemsForm.items}" varStatus="status">
            <tr>
                <td align="center">${status.count}</td>
                <td>
                    <c:choose>
                        <c:when test = "${item.bought}">
                            <form:checkbox path="items[${status.index}].bought" id="items[${status.index}].bought" value="${item.bought}" checked="checked"/>
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="items[${status.index}].bought" value="${item.bought}"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><input name="items[${status.index}].id" value="${item.id}"/></td>
                <td><input name="items[${status.index}].name" value="${item.name}"/></td>
                <td><input name="items[${status.index}].bought" value="${item.bought}"/></td>
                <td><input name="items[${status.index}].boughtWho" value="${item.boughtWho}"/></td>
                <td><input hidden name="items[${status.index}].boughtTime" value="${item.boughtTime}"/></td>
                <td><input hidden name="items[${status.index}].addedTime" value="${item.addedTime}"/></td>
            </tr>
        </c:forEach>
    </table>

    <input type="submit" value="Submit"/>
    </rep>
    </form:form>

</body>
</html>