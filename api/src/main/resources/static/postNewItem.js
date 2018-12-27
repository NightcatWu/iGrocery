$(document).ready(
    function() {
        //
        $(document).on("click", "#addItem", function () {
            event.preventDefault();
            ajaxPost();
        });
        function ajaxPost() {

            var data = {};
            data["name"] = $("#newItemName").val();
            data["bought"] = false;

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "addItem",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function(result) {
                    if (result.status == "success") {
                        $("#tableBody").empty();
                        var itemList = "";
                        $.each(result.data, function (i, item) {
                            var tempTBody = "<tr><td id='itemBought'><input type='checkbox' ";
                            if (item.bought) {
                                tempTBody += "checked='checked' ";
                            }
                            tempTBody += "></td><td id='itemId'>" + item.id +
                                "</td><td id='itemName'><input type='text' name='name' value='" + item.name + "'></td></tr>";
                            $("#tableBody").append(tempTBody);
                        })

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