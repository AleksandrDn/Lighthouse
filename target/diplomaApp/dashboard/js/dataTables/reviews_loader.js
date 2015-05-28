var tags = [
    "<tr class=\"gradeA ",//=>even/odd
    "\" id=\"n", // => id review
    "\"><td>", //=> user
    "</td><td>", //=> review's text
    "</td><td><img style='height:25px;' class=\"delete_single_news_btn\" id=\"c", //=>id review
    "\" src=\"/dashboard/img/delete_icon.png\"></td></tr>" //=>end
];
var currentHZ = "odd";
function getPage()
{
    var Url = "http://localhost:8080/allreviews";
    $.get(Url, function(data) {
        $.each(data, function(i, reviews) {
            if (currentHZ == "odd")
                currentHZ = "even"
            else
                currentHZ = "odd";
            $("#all_reviews_placeholder").append(
                tags[0] + currentHZ +
                 tags[1]+ reviews.id_review +
                 tags[2] + reviews.account.client.last_name + " " + reviews.account.client.first_name +
                 tags[3] + reviews.content +
                 tags[4] + reviews.id_review +
                 tags[5]
            );
            var link = "#c" + reviews.id_review;
            $(link).click(function(){
                var clickId = this.id;
                var id = clickId.substr(1);
                var deleteUrl = "http://localhost:8080/deletereviews?id=" + id;
                $.get(deleteUrl, function(data){});
                var idRow = "#n" + id;
                $(idRow).html("<td>Удалено</td><td>Удалено</td><td>Удалено</td>");
            });
        });
        $('#dataTables-example').dataTable({"bSort": false});
    });
}

//$(document).ready(function(){
//        getPage();
//});