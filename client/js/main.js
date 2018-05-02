$(function () {
    var url = "http://localhost:8080"
    $.get(url + "/api/products", function (result) {
        $("#main-content")
            .html(JSON.stringify(result));
    });
});