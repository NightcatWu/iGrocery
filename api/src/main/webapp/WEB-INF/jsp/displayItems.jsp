<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>iGrocery Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script>
        GET: $(document).ready(
            function() {
                //
                $(document).on("change", "#tableBody", function () {
                    event.preventDefault();
                    ajaxPost();

                });
                function ajaxPost() {
                    var data=[];
                    var itemId, itemBought, itemName;
                    $("#tableBody tr").each(function (index, item) {
                         itemId = $(this).find("#itemId").text();
                         itemBought = $(this).find("input[type=checkbox]").prop("checked");
                         itemName = $(this).find("#itemName").text();
                         data.push({
                             id: itemId,
                             bought : itemBought,
                             name: itemName
                         });
                    });
                    submitFormData(data);
                }
                function submitFormData(formData) {
                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: "submitItems",
                        data: JSON.stringify(formData),
                        dataType : 'json',
                        success: function(result) {
                            if (result.status == "success") {
                                var itemList = "";
                                $.each(result.data, function (i, item) {
                                    itemList += item.id + " " + item.bought + " " + item.name + "<br>";
                                })
                                $("#postResultDiv").html(itemList) + "Success!!";

                            } else {
                                $("#postResultDiv").html("ERROR");
                            }
                        },
                        error: function (e) {
                            alert ("ERROR!!!");
                        }
                    });
                }

                // get request
                $("#getAllItems").click(function (event) {

                    console.log("Get Request starting...");
                    event.preventDefault();
                    ajaxGet();

                });
                // get
                function ajaxGet() {
                    $.ajax( {
                        type: "GET",
                        url : "getAllItems",
                        success: function (result) {
                            if (result.status == "success") {
                                $("#getResultDiv").empty();
                                var itemList = "";
                                $.each(result.data, function (i, item) {
                                    var tempTBody = "<tr><td id='itemId'>" + item.id + "</td><td id='itemBought'><input type='checkbox' ";
                                    if (item.bought) {
                                        tempTBody += "checked='checked' ";
                                    }
                                    tempTBody += "></td><td id='itemName'>" + item.name + "</td></tr>";
                                    $("#tableBody").append(tempTBody);
                                })

                                //
                            } else {
                                $("#getResultDiv").html("ERROR");
                            }
                        },
                        error : function (e) {
                            $("#getResultDiv").html("Error");
                        }
                    });
                }


            }
        )
    </script>
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
                            <form:checkbox path="items[${status.index}].bought" id="items[${status.index}].bought" value="${item.bought}"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><form:input path="items[${status.index}].id" value="${item.id}"/>
                <td><form:input path="items[${status.index}].name" value="${item.name}"/></td>
                <td><form:input path="items[${status.index}].bought" value="${item.bought}"/></td>
                <td><form:hidden path="items[${status.index}].boughtWho" value="${item.boughtWho}"/></td>
            </tr>
        </c:forEach>
    </table>

    <input type="submit" value="Submit"/>
    </rep>


    <hr>
        <button id="getAllItems" type="button">Get all items</button>
        <div id="getResultDiv">
            <ul class="list-group">

            </ul>
        </div>

        <div>
            <table id="tableItems">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Bought</th>
                        <th>Items</th>
                    </tr>
                </thead>
                <tbody id="tableBody">

                </tbody>
            </table>
        </div>
        <div id="postResultDiv" align="center"></div>
    </form:form>

</body>
</html>