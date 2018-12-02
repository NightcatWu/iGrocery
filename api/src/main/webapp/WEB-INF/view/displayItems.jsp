<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>iGrocery Application</title>
</head>
<body>

<h2>Items</h2>

<form>
    <table>
        <tr>
            <th>Id</th>
            <th>Item</th>
            <th>Bought</th>
            <th>Who</th>
            <th>Date</th>
        </tr>
        <c:forEach var="item" items="${itemsList}">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.bought}</td>
                <td>${item.boughtWho}</td>
                <td>${item.boughtTime}</td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>