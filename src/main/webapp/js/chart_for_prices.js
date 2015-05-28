function readPreferences() {
	chosenRoom = sessionStorage.getItem('CHOSEN_ROOM');
    document.getElementById('places_container').style.display = 'none';
	document.getElementById('survey_container').style.display = 'none';
} 

function expandPlacesButtons(personsCount)
{
	sessionStorage.setItem('PERSONS_COUNT', personsCount);
	document.getElementById('places_container').style.display = 'visible';
}

function expandSurvey(chosenRoom)
{
	sessionStorage.setItem('CHOSEN_ROOM', document.getElementById(chosenRoom + '_description').innerHTML);
	sessionStorage.setItem('CHOSEN_ROOM_PRICE', document.getElementById(chosenRoom + '_price').innerHTML);
	alert("Chosen:" + document.getElementById(chosenRoom + '_description').innerHTML);
	alert("Chosen price:" + document.getElementById(chosenRoom + '_price').innerHTML);
	document.getElementById('survey_container').style.display = 'visible';
}

/*Global variables*/
var roomDescription = document.getElementById('table_room_description');
var roomCost = document.getElementById('table_room_cost');

var surveyDescription = document.getElementById('table_survey_description');
var surveyCost = document.getElementById('table_survey_cost');

var personDescription = document.getElementById('table_person_description');
var personCost = document.getElementById('table_person_cost');

var EURCurrent;
var RURCurrent;
var USDCurrent;

var currencySymbolUAH = "₴ ";
var currencySymbolRUB = "P";
var currencySymbolUSD = "$";


/*Input data in the table and calculate total cost*/
/*Rooms*/
$('#standart_room').click(function(event){
	event.preventDefault();
    roomDescription.innerHTML = document.getElementById('standart_room_description').innerHTML;
	roomCost.innerHTML = document.getElementById('standart_room_price').innerHTML;
	calculateCost();
});

$('#premium_room').click(function(event){
	event.preventDefault();
    roomDescription.innerHTML = document.getElementById('premium_room_description').innerHTML;
	roomCost.innerHTML = document.getElementById('premium_room_price').innerHTML;
	calculateCost();
});

$('#lux_room').click(function(event){
	event.preventDefault();
    roomDescription.innerHTML = document.getElementById('lux_room_description').innerHTML;
	roomCost.innerHTML = document.getElementById('lux_room_price').innerHTML;
	calculateCost();
});

/*Survey*/
$('#base_survey').click(function(event){
	event.preventDefault();
    surveyDescription.innerHTML = document.getElementById('base_survey_description').innerHTML;
	surveyCost.innerHTML = document.getElementById('base_survey_price').innerHTML;
	calculateCost();
});

$('#standart_survey').click(function(event){
	event.preventDefault();
    surveyDescription.innerHTML = document.getElementById('standart_survey_description').innerHTML;
	surveyCost.innerHTML = document.getElementById('standart_survey_price').innerHTML;
	calculateCost();
});

$('#premium_survey').click(function(event){
	event.preventDefault();
    surveyDescription.innerHTML = document.getElementById('premium_survey_description').innerHTML;
	surveyCost.innerHTML = document.getElementById('premium_survey_price').innerHTML;
	calculateCost();
});

$('#professional_survey').click(function(event){
	event.preventDefault();
    surveyDescription.innerHTML = document.getElementById('professional_survey_description').innerHTML;
	surveyCost.innerHTML = document.getElementById('professional_survey_price').innerHTML;
	calculateCost();
});

/*persons count*/
$('.btn').click(function(event){
	event.preventDefault();
	console.log($(this).text());
    personDescription.innerHTML = $(this).text();
	personCost.innerHTML = 'x' + $(this).text();
	calculateCost();
});

/*calculate total cost*/

function calculateCost()
{
	if (personDescription.innerHTML == "0") return;
	console.log(getNumber(roomCost.innerHTML) + "+" + getNumber(surveyCost.innerHTML) + "+" + Number(personDescription.innerHTML))
	var number = (getNumber(roomCost.innerHTML)
					+ getNumber(surveyCost.innerHTML))
						* Number(personDescription.innerHTML);
	number = number.toFixed(2);
	document.getElementById('table_total_cost').innerHTML = currencySymbolUAH + number;
	var costInUAH = number;
	document.getElementById('table_EUR_total_cost').innerHTML = (costInUAH / EURCurrent).toFixed(2);
	document.getElementById('table_USD_total_cost').innerHTML = (costInUAH / USDCurrent).toFixed(2);
	document.getElementById('table_RUR_total_cost').innerHTML = (costInUAH / RURCurrent).toFixed(2);
	if (number > 0.00)
	{
		writeToStorage();
		//getChartFromStorage();
	}
}

/*deleting FIRST symbol and converting in the Number*/
function getNumber(stringPrice)
{
	return Number(stringPrice.substr(2));
}

/**
*write in storage
*CHOSEN_ROOM - description
*CHOSEN_SURVEY - description
*CHOSEN_PERSONS - description
*TOTAL_PRICE - price	
*/

function writeToStorage()
{
	/*sessionStorage.setItem('CHOSEN_ROOM', roomDescription.innerHTML);
	sessionStorage.setItem('CHOSEN_SURVEY', surveyDescription.innerHTML);
	sessionStorage.setItem('CHOSEN_PERSONS', personDescription.innerHTML);
	sessionStorage.setItem('TOTAL_PRICE', document.getElementById('table_total_cost').innerHTML);*/
	var chart = '{"room":"'+ roomDescription.innerHTML +
					'", "survey": "' + surveyDescription.innerHTML +
					'", "persons": "'+ personDescription.innerHTML +
					'", "price": "'+document.getElementById('table_total_cost').innerHTML+'"}';
	localStorage.setItem('CHART', chart);
	console.log(chart);
}
            
$(document).ready(function() {
$.ajax({
    type: 'GET',
    url: "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=3&jsonp=callback",
    dataType: "jsonp",
    //OR
    //beforeSend: function(xhr) { 
    //  xhr.setRequestHeader("My-First-Header", "first value"); 
    //  xhr.setRequestHeader("My-Second-Header", "second value"); 
    //}
});/*.done(function(data) { 
    alert(data);
});*/
	parseJsonSevices("DATA goes here"); //put json here
});

function callback(data)
{
	json = JSON.stringify(data);
	var obj = jQuery.parseJSON(json);
	
	for (i = 0; i < obj.length; i++)
	{
		if (obj[i].ccy == "RUR")
			RURCurrent = obj[i].buy;
		if (obj[i].ccy == "USD")
			USDCurrent = obj[i].buy;
		if (obj[i].ccy == "EUR")
			EURCurrent = obj[i].buy;
	}
}

function parseJsonSevices(data)
{
	//json = JSON.stringify(data);
	json = JSONv;
	var obj = jQuery.parseJSON(json);
	
	/*rooms*/
	fillRooms(obj);
	    document.getElementById('room_container').style.display = 'block';
	/*survey*/
	fillSurvey(obj);
		document.getElementById('survey_container').style.display = 'block';
		document.getElementById('places_container').style.display = 'block';
		document.getElementById('table_container').style.display = 'block';
}

function fillRooms(obj)
{
	rooms = obj.rooms;
	maxCountItems = rooms[2].content.length;

	room  = rooms[0];
	document.getElementById('standart_room_description').innerHTML = room.description; // description
	document.getElementById('standart_room_price').innerHTML = currencySymbolUAH + room.price; //price
	pastContent(room, maxCountItems, "#services_1");
	
	room  = rooms[1];
	document.getElementById('premium_room_description').innerHTML = room .description; // description
	document.getElementById('premium_room_price').innerHTML = currencySymbolUAH + room .price; //price
	pastContent(room, maxCountItems, "#services_2");
	
	room  = rooms[2];
	document.getElementById('lux_room_description').innerHTML = room .description; // description
	document.getElementById('lux_room_price').innerHTML = currencySymbolUAH + room .price; //price
	pastContent(room, maxCountItems, "#services_3");
	
}

function fillSurvey(obj)
{
	surveys = obj.survey;
	maxCountItems = surveys[3].content.length;
	

	survey = surveys[0];
	document.getElementById('base_survey_description').innerHTML = survey.description; // description
	document.getElementById('base_survey_price').innerHTML = currencySymbolUAH + survey.price; //price
	pastContent(survey, maxCountItems, "#survey_1");
	
	survey = surveys[1];
	document.getElementById('standart_survey_description').innerHTML = survey.description; // description
	document.getElementById('standart_survey_price').innerHTML = currencySymbolUAH + survey.price; //price
	services = document.getElementById('survey_2').innerHTML;
	pastContent(survey, maxCountItems, "#survey_2");
	
	survey = surveys[2];
	document.getElementById('premium_survey_description').innerHTML = survey.description; // description
	document.getElementById('premium_survey_price').innerHTML = currencySymbolUAH + survey.price; //price
	services = document.getElementById('survey_3').innerHTML;
	pastContent(survey, maxCountItems, "#survey_3");
	
	survey = surveys[3];
	document.getElementById('professional_survey_description').innerHTML = survey.description; // description
	document.getElementById('professional_survey_price').innerHTML = currencySymbolUAH + survey.price; //price
	services = document.getElementById('survey_4').innerHTML;
	pastContent(survey, maxCountItems, "#survey_4");
}

function pastContent(arr, maxCountItems, DomElement)
{
var wrap = $(DomElement)
var inputString = "";
	for (i = 0; i < maxCountItems; i++)
		if (i < arr.content.length)
			 inputString += "<li>" + arr.content[i] + "</li>";
		else
			inputString += "<li>&nbsp;</li>";
$(wrap).append(inputString);
}


JSONv = '{"rooms":[{"description":"Стандарт","price":"99","content":["Общий корпус","Общий санузел","Общий холодильник"]},{"description":"Премиум","price":"199","content":["Общий корпус","Индивидуальный санузел","Индивидуальный холодильник","Кондиционер"]},{"description":"Люкс","price":"299","content":["Отдельный дом","Индивидуальный санузел","Индивидуальный холодильник","Кондиционер","Индивидуальная кухня"]}],"survey":[{"description":"Базовое","price":"299","content":["Терапевт","Физиолог","Диетолог"]},{"description":"Стандартное","price":"599","content":["Терапевт","Физиолог","Диетолог","Врач ЛФК","Кардиолог"]},{"description":"Премиум","price":"1299","content":["Терапевт","Физиолог","Диетолог","Врач ЛФК","Кардиолог","Хирург","УЗИ-врач","Рентгенолог"]},{"description":"Профессиональное","price":"1499","content":["Терапевт","Физиолог","Диетолог","Врач ЛФК","Кардиолог","Хирург","УЗИ-врач","Рентгенолог","Иммунолог","Невролог","Стоматолог"]}]}';
