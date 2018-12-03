<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>iGrocery Application</title>
</head>
<body>

<h2>Items</h2>

    <table>
        <tr>
            <th>Bought</th>
            <th>Id</th>
            <th>Item</th>
            <th>Who</th>
            <th>Date</th>
        </tr>
        <c:forEach var="item" items="${itemsList}">
            <tr>
                <td>
                    <form action="changeBoughtStatus" method="post">
                    <c:choose>
                        <c:when test = "${item.bought}">
                            <input type="checkbox" name="boughtStatus" checked=checked/>
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="boughtStatus"/>
                        </c:otherwise>
                    </c:choose>
                    </form>
                </td>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.boughtWho}</td>
                <td>${item.boughtTime}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>