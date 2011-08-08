$(function() {
	$( "#selectable" ).selectable({
		stop: function() {
			var result = $( "#select-result" ).empty();
			$( ".ui-selected", this ).each(function() {
				var index = $(this).attr("id");
				result.append( "," + index );
			});
			var res = result.text();
			sendSelection(res.substring(1, res.length));
		}
	});
});

function sendSelection(selection) {
	$.post("/timetable/selection",
			{ "name": $("#name").text(), "selection" : selection, "weekidx" : $("#weekStartDate").text() },
			function(data){
				displayTimetable(data.workingTime.x, data.workTime);
			}
			, "json");
}

function displayTimetable(workingTime, workTime) {
	if (workingTime && workingTime.length != 0) {
		var days = new Array("Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi");

		for (var i = 0; i < days.length; i++) {
			$("#" + days[i]).empty();
		}

		for (var i = 0; i < workingTime.length; i++) {
			var d1 = new Date(workingTime[i]._1);
			var d2 = new Date(workingTime[i]._2);
			$('#' + days[d1.getDay()]).append("<span class=\"time-range\" >" + d1.getHours() + "h" + pad2(d1.getMinutes())
					+ " --> " + d2.getHours() + "h" + pad2(d2.getMinutes()) + "</span>");
		}

		var hours = Math.floor(workTime/3600000);
		var divisor_for_minutes = workTime % 3600000;
		var minutes = Math.floor(divisor_for_minutes / 60000);
		$('#total').text(hours + "h" + pad2(minutes));
	}
}

function pad2(number) {
	return (number < 10 ? '0' : '') + number
}
