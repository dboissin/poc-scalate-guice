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
			{ "name": $("#name").text(), "selection" : selection, "weekidx" : $("#weekStartDate").text().replace(/\s+/g, "") },
			function(data){
				var work = data.workingTime;
				$('#cashier-timetable').empty();
				if (work) {
					for (var i = 0; i < work.length; i++) {
						$('#cashier-timetable').append("<br />" + new Date(work[i]._1) + " --> " + new Date(work[i]._2));
					}
				}
			}
			, "json");
}
