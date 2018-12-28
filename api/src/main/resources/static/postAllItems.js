$(document).ready(
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
                itemName = $(this).find("input[name=name]").val();
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
                        console.log((itemList));

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