$(document).ready(
    function() {
        //
        $(document).on("click", "#addItem", function () {
            if (!$("#newItemName").val()) {
                $("#errorMsg").show();
                event.preventDefault();
                return;
            } else {
                $("#errorMsg").hide();
                event.preventDefault();
                ajaxPost();
                $("#newItemName").val('');
            }
        });
        function ajaxPost() {

            var data = {};
            data["name"] = $("#newItemName").val();
            data["bought"] = false;
            //data["events"] = $("#myTab li a.active").attr("aria-controls");
            data["event"] = 1;

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
                        var tempTBody = "";

                        if ($("#displayAll").prop("checked")) { // display all items

                            $.each(result.data, function (i, item) {
                                tempTBody = "<tr><td id='itemBought'><input type='checkbox' ";
                                if (item.bought) {
                                    tempTBody += "checked='checked' ";
                                }
                                tempTBody += "></td><td id='itemId' style=\"visibility: hidden;\">" + item.id +
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
                                    tempTBody += "></td><td id='itemId' style=\"visibility: hidden;\">" + item.id +
                                        "</td><td id='itemName'><input type='text' name='name' value='" + item.name + "'></td></tr>";
                                    $("#tableBody").append(tempTBody);
                                }
                            })
                        }

                    } else {
                        console.log("ERROR");
                    }
                },
                error: function (e) {
                    console.log(e.toString());
                }
            });
        }
    }
)