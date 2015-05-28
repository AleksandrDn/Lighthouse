var pageNumber = 0;

var tags = [
    "<div class=\"news\"><div class=\"panel panel-primary\"><div class=\"panel-heading\"><h3 class=\"panel-title\">", // => Title
    "</h3></div><div class=\"panel-body\"><img class=\"newsImageStyle\" src=\"", //=>Image URL
    "\"/><p id=\"t", //=>id newss
    "\">",//=>short content
    "</p><a class=\"expandText\" id=\"s", //=>id news
    "\">Читать больше...</a></div></div></div>"
];

function fillContent(type, id)
{
    var Url = "http://localhost:8080/singlenews?id=" + id;
    var ContentBlock = "#t" + id;
    var link = "#s" + id;
    if (type == "Читать больше...")
    {
        $.get(Url, function(data) {
                $(ContentBlock).text(data.content);
        });
        $(link).text("Свернуть...");
    }
    else
    {
        $.get(Url, function(data) {
                $(ContentBlock).text(data.short_content);
        });
        $(link).text("Читать больше...");
    }

}

function getPage()
{
    $(".preload-anim").css('display', 'block');
    var Url = "http://localhost:8080/newspager?count=2&block=" + pageNumber;
    $.get(Url, function(data) {
        $.each(data, function(i, news) {
            $("#news_placeholder").append(
                 tags[0]+ news.title + " (" + news.date_news + ")" +
                tags[1] + news.image +
                 tags[2] + news.id_news +
                 tags[3] + news.short_content +
                 tags[4] + news.id_news +
                 tags[5]
            );
            var link = "#s" + news.id_news;
            $(link).click(function(){
                var clickId = this.id;
                fillContent(this.text, clickId.substr(1));
            });
        });
        $(".preload-anim").css('display', 'none');
    });
    pageNumber++;
}

$(document).ready(function(){
        getPage();
    $("#getMoreNews").click(function(){
        getPage();
    });
});