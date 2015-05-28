var tags = [
    "<tr class=\"gradeA ",//=>even/odd
    "\" id=\"n", // => id client
    "\"><td>", //=> FIO
    "</td><td>", //=> Phone
    "</td><td><img style='height:25px;' class=\"delete_single_news_btn\" id=\"c", //=>id client
    "\" src=\"/dashboard/img/client_details.png\"></td></tr>" //=>end
];
var currentHZ = "odd";
function getPage()
{
    var Url = "http://localhost:8080/allclients";
    $.get(Url, function(data) {
        $.each(data, function(i, client) {
            if (currentHZ == "odd")
                currentHZ = "even";
            else
                currentHZ = "odd";
            var phone = client.phone;
            if(phone == undefined)
                phone="-";

            $("#all_clients_placeholder").append(
                tags[0] + currentHZ +
                 tags[1]+ client.id_client +
                 tags[2] + client.last_name + " " + client.first_name +
                 tags[3] + phone +
                 tags[4] + client.id_client +
                 tags[5]
            );
            var link = "#c" + client.id_client;
            $(link).click(function(){
                var clickId = this.id;
                var id = clickId.substr(1);
                //TODO: go to the clients personal info
            });
        });
        $('#dataTables-example').dataTable();
    });
}

//$(document).ready(function(){
//        getPage();
//});