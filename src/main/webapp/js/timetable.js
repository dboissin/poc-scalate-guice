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
		{ "name": $("#name").text(), "selection" : selection, "weekidx" : "201107180830" },
		function(data){
		   alert(data.name)
		}
	, "json");
}
