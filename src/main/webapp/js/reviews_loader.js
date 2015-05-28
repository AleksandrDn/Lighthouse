var pageNumber = 0;

var tags = [
    "<div class=\"news\"><div class=\"panel panel-primary\"><div class=\"panel-heading\"><h3 class=\"panel-title\">", // => Title
    "</h3></div><div class=\"panel-body\"><p>", //=>content
    "</p></div></div></div>"
];

var rateStars=["<br><br><div style=\"width:100%; text-align:right; \"><label style=\"font-weight:bold; font-size: 16px\">Моя оценка </label><span class=\"starRatingE\">"+
"<input id=\"rating5\" type=\"radio\" name=\"rating","\" value=\"5\" ",
"><label for=\"rating5\">5</label>",
"<input id=\"rating4\" type=\"radio\" name=\"rating","\" value=\"4\" ",
"><label for=\"rating4\">4</label>",
"<input id=\"rating3\" type=\"radio\" name=\"rating","\" value=\"3\" ",
"><label for=\"rating3\">3</label>",
"<input id=\"rating2\" type=\"radio\" name=\"rating","\" value=\"2\" ",
"><label for=\"rating2\">2</label>",
"<input id=\"rating1\" type=\"radio\" name=\"rating","\" value=\"1\" ",
"><label for=\"rating1\">1</label>",
"</span></div>"];

function getPage()
{
    $(".preload-anim").css('display', 'block');
    var Url = "http://localhost:8080/reviewspager?count=2&block=" + pageNumber;
    $.get(Url, function(data) {
        $.each(data, function(i, reviews) {
            var RateString = "";
            for (var i = 5, j = 0; i > 0; i--, j += 3)
            {
                RateString += rateStars[j];
                RateString += reviews.id;
                RateString += rateStars[j + 1];
                if (reviews.rate == (i))
                    RateString += "checked"
                RateString += rateStars[j + 2];

            }
            $("#reviews_placeholder").append(
                 tags[0]+ "<img src=\"" + reviews.avatar + "\"/>&nbsp;&nbsp;" + reviews.first_name + " (" + reviews.date + ")" +
                tags[1] + reviews.content +
                 RateString +
                 tags[2]
            );
        });
        $(".preload-anim").css('display', 'none');
    });
    pageNumber++;
}

$(document).ready(function(){
        getPage();
    $("#sendReview").click(function(){
        var Url = "http://localhost:8080/sendreview?email=" +
                $("#userId").html() + "&content=" +
                $("#reviewContent").val() + "&rate=" +
                $('input[name=ratingnew]:checked', '.starRating').val();
        console.log($('input[name=ratingnew]:checked', '.starRating').val());
        $.post(Url);
        location.reload();
    });
    $("#getMoreReviews").click(function(){
        getPage();
    });
});