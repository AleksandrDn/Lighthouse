
function getFormData()
{
	var jsonToServer = "";
	startDate = new Date(document.getElementById("start_calendar").value);
	var startMonth = (startDate.getMonth() + 1);
	var startDay = startDate.getDate();
	var endMonth = (endDate.getMonth() + 1);
	var endDay = endDate.getDate();
	if (startMonth < 10) startMonth = "0"+startMonth;
	if (startDay < 10) startDay = "0"+startDay;
	if (endMonth < 10) endMonth = "0"+endMonth;
	if (endDay < 10) endDay = "0"+endDay;
	endDate = new Date(document.getElementById("end_calendar").value);
	jsonToServer += '{"lastName":"' + document.getElementById("last_name_booking").value + '",' +
	'"firstName":"' + document.getElementById("first_name_booking").value + '",' +
	'"room":"' + document.getElementById("room_booking").value + '",' +
	'"phone":"' + document.getElementById("phone_booking").value + '",' +
	'"survey":"' + document.getElementById("survey_booking").value + '",' +
	'"persons":"' + document.getElementById("persons_booking").value + '",' +
	'"startDate":"' + startDate.getFullYear() + '-' + startMonth + '-' + startDay+ '",' +
	'"endDate":"' + endDate.getFullYear() + '-' + endMonth + '-' + endDay+ '"}';
	return jsonToServer;
}

function booking()
{
	var jsonToServer = getFormData();
	var Url = "http://localhost:8080/checkBooking?jsonInfo=" + jsonToServer;
	var data;
	$.ajax({
		url: Url,
		data: data,
		complete: function(data){
			if (data.responseText != "not") {
				$("#get_form_btn").css("display", "block");
				$("#booking-success-message").append("Номер заказа: <span id=\"token\">" + data.responseText + "</span>");
			}
			else
				$("booking-fail-message").html("Что-то не так");
		}
	});
	console.log(jsonToServer);
					
}

var ERR_MSG;

function validate()
{
	ERR_MSG = "Проверьте поля:<br>"
	flag = true;
	dayInMilisec = 86400000;
	if (document.getElementById("room_booking").value == '-')
	{
		ERR_MSG += "Номер <br>";
		flag = false;
	}			
	if (document.getElementById("persons_booking").value == '-')
	{
		ERR_MSG += "Количество человек <br>";
		flag = false;
	}	
	startDate = new Date(document.getElementById("start_calendar").value);
	endDate = new Date(document.getElementById("end_calendar").value);
	if ((endDate - startDate) < dayInMilisec)
	{
		ERR_MSG += "Длительность отдыха больше 1го дня <br>";
		flag = false;
	}	
	
	return flag;
}

function getChartFromStorage()
{
	//localStorage.setItem('CHART', ""); //drop down

	var objChart = jQuery.parseJSON(localStorage.getItem('CHART'));
	if (objChart == null) return;
	document.getElementById("room_booking").value = objChart.room;
	document.getElementById("survey_booking").value = objChart.survey;
	document.getElementById("persons_booking").value = objChart.persons;
}

function setCalendar()
{
	startCalendar = document.getElementById("start_calendar");
	endCalendar = document.getElementById("end_calendar");
	dateNow = new Date();
	
	dayMonthString = "";
	if ((dateNow.getMonth() + 1) < 10)
		dayMonthString += '0' + (dateNow.getMonth() + 1);
	else
		dayMonthString += (dateNow.getMonth() + 1);
	
	if (dateNow.getDate() < 10)
		dayMonthString += '-0' + dateNow.getDate();
	else
		dayMonthString += '-' + dateNow.getDate();
	
	console.log(dateNow.getFullYear() + "-" + dayMonthString);
	
	startCalendar.min = dateNow.getFullYear() + "-" + dayMonthString;
	endCalendar.max = (dateNow.getFullYear() + 1) + "-" + dayMonthString;
	
	startCalendar.value = dateNow.getFullYear() + "-" + dayMonthString;
	endCalendar.value = dateNow.getFullYear() + "-" + dayMonthString;
}

$(document).ready(function() {
	parseJsonSevices("a");
	getChartFromStorage();
	setCalendar();
	$( "#get_form_btn" ).click(function() {window.open(
		"http://localhost:8080/payForm?token=" + $("#token").html(),
		"Форма оплаты");
	});
});
$( "#booking_submit" ).click(function() {
  if (validate())
  {
	booking();
	document.getElementById("booking-fail-message").style.display = "none";
	document.getElementById("booking-success-message").style.display = "block";
  }
else
{
	document.getElementById("booking-fail-message").style.display = "block";
	document.getElementById("booking-fail-message").innerHTML = ERR_MSG;
}
});

function parseJsonSevices(data)
{
	//json = JSON.stringify(data);
	json = JSONv;
	var obj = jQuery.parseJSON(json);
	
	tempStr = "";
	
	/*room*/
	rooms = obj.rooms;
	for (i = 0; i < rooms.length; i++)
		tempStr += "<option value='" + rooms[i].description + "'>" + rooms[i].description + "</option>";
	$("#room_booking").append(tempStr);
	
	/*survey*/
	tempStr = "";
	surveys = obj.survey;
	for (i = 0; i < surveys.length; i++)
		tempStr += "<option value='" + surveys[i].description + "'>" + surveys[i].description + "</option>";
	$("#survey_booking").append(tempStr);
}

JSONv = '{"rooms":[{"description":"Стандарт","price":"99","content":["Общий корпус","Общий санузел","Общий холодильник"]},{"description":"Премиум","price":"199","content":["Общий корпус","Индивидуальный санузел","Индивидуальный холодильник","Кондиционер"]},{"description":"Люкс","price":"299","content":["Отдельный дом","Индивидуальный санузел","Индивидуальный холодильник","Кондиционер","Индивидуальная кухня"]}],"survey":[{"description":"Базовое","price":"299","content":["Терапевт","Физиолог","Диетолог"]},{"description":"Стандартное","price":"599","content":["Терапевт","Физиолог","Диетолог","Врач ЛФК","Кардиолог"]},{"description":"Премиум","price":"1299","content":["Терапевт","Физиолог","Диетолог","Врач ЛФК","Кардиолог","Хирург","УЗИ-врач","Рентгенолог"]},{"description":"Профессиональное","price":"1499","content":["Терапевт","Физиолог","Диетолог","Врач ЛФК","Кардиолог","Хирург","УЗИ-врач","Рентгенолог","Иммунолог","Невролог","Стоматолог"]}]}';
