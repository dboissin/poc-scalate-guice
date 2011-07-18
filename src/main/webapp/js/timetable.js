$(function() {
		$( "#selectable" ).selectable({
			stop: function() {
				var result = $( "#select-result" ).empty();
				$( ".ui-selected", this ).each(function() {
					var index = $(this).attr("id");
					result.append( " #" + index );
				});
			}
		});
	});
