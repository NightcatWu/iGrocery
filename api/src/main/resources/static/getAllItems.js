$(document).ready(
    function() {
        // get request
        $("#displayAll").click(function (event) {

            event.preventDefault();
            ajaxGet();

        });

        function ajaxGet() {

            $.ajax( {
                type: "GET",
                url : "getAllItems",
                success: function (result) {
                    if (result.status == "success") {
                        $("#tableBody tr").empty();
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

                        //
                    } else {
                        $("#getResultDiv").html("ERROR");
                    }
                },
                error : function (e) {
                    $("#getResultDiv").html(e.toString());
                }
            })
         }
    }
)