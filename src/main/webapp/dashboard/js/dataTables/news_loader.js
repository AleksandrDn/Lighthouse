var tags = [
    "<tr class=\"gradeA ",//=>even/odd
    "\" id=\"n", // => id news
    "\"><td>", //=> title
    "</td><td>", //=> short content
    "</td><td><img style='height:25px;' class=\"delete_single_news_btn\" id=\"c", //=>id news
    "\" src=\"/dashboard/img/delete_icon.png\"></td></tr>" //=>end
];
var currentHZ = "odd";
function getPage()
{
    var Url = "http://localhost:8080/allnews";
    $.get(Url, function(data) {
        $.each(data, function(i, news) {
            if (currentHZ == "odd")
                currentHZ = "even"
            else
                currentHZ = "odd";
            $("#all_news_placeholder").append(
                tags[0] + currentHZ +
                 tags[1]+ news.id_news +
                 tags[2] + news.title +
                 tags[3] + news.short_content +
                 tags[4] + news.id_news +
                 tags[5]
            );
            var link = "#c" + news.id_news;
            $(link).click(function(){
                var clickId = this.id;
                var id = clickId.substr(1);
                var deleteUrl = "http://localhost:8080/deletenews?id=" + id;
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