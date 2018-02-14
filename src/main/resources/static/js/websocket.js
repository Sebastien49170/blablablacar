/**
 * 
 */

$(document).ready(function () {
    var stompClient = null;
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/rideNotification', function (ride) {
        	var jsonObject = JSON.parse(ride.body);
            updateRide(jsonObject);
        });
    });

    function sendName() {
        stompClient.send("/app/rideNotification", {}, JSON.stringify({'fromCity': $("#name").val()}));
    }

    function updateRide(message) {
    	console.log(message);
//    	var tableRides= $("#rides");
//    	tableRides.appends("<tr>") 
//    	tableRides.appends("<td>" + message.fromCity + "</td>")
//    	tableRides.appends("<td>" + message.toCity + "</td>")
//    	tableRides.appends("<td>" + message.cost + "</td>")
//    	tableRides.appends("<td>" + message.seat + "</td>")
//    	tableRides.appends("<td>" + message.startDate + "</td>")
//    	tableRides.appends("<tr>");
    	
        $("#rides").append("<tr><td>" + message.fromCity + "</td></tr>");
    }

});