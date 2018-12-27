$(document).ready(
    function() {
        //
        $(document).on("change", "#displayAll", function () {
            event.preventDefault();
            ajaxPost();

        });
        function ajaxPost() {
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "changeDisplayType",
                data: JSON.stringify($("#displayAll").prop("checked")),
                dataType : 'json',
                success: function(result) {
                    if (result.status == "success") {

                        $("#tableBody").empty();
                        var itemList = "";
                        var tempTBody = "";

                        if ($("#displayAll").prop("checked")) { // display all items

                            $.each(result.data, function (i, item) {
                                tempTBody = "<tr><td id='itemBought'><input type='checkbox' ";
                                if (item.bought) {
                                    tempTBody += "checked='checked' ";
                                }
                                tempTBody += "></td><td id='itemId'>" + item.id +
                                    "</td><td id='itemName'><input type='text' name='name' value='" + item.name + "'></td></tr>";
                                $("#tableBody").append(tempTBody);
                            })

                        } else { // display only un-bought items

                            $.each(result.data, function (i, item) {

                                if (item.bought == false) {

                                    tempTBody = "<tr><td id='itemBought'><input type='checkbox' ";
                                    if (item.bought) {
                                        tempTBody += "checked='checked' ";
                                    }
                                    tempTBody += "></td><td id='itemId'>" + item.id +
                                        "</td><td id='itemName'><input type='text' name='name' value='" + item.name + "'></td></tr>";
                                    $("#tableBody").append(tempTBody);
                                }
                            })
                        }

                    } else {
                        $("#postResultDiv").html("ERROR");
                    }
                },
                error: function (e) {
                    alert ("ERROR!!!");
                }
            });
        }

    }
)