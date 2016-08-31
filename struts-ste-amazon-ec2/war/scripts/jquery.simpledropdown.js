/*
Name: jQuery Simple Drop Down Plugin
Author: Etienne Fardet
Version: 1.3
Comments: Unpacked version
*/

(function($){  
 $.simpledropdown = function(selector) {

	// Starts jQuery list 'transformation'
	$(selector).children("ul").addClass("dropdown");
	$("ul.dropdown>li:first-child").addClass("selected");
	$("ul.dropdown>li").not(".dropdown>li:first-child").addClass("drop");	

	// Prints a canvas for my corners
	$(selector).prepend("<div class='mycorners'></div>");
	
	// Creates an array of the classes for each of my corners
	var cornersClasses = ['TopLeft','TopMiddle','TopRight','VerticalLeft','Middle','VerticalRight'];
	var bottomCorners = ['BottomLeft','BottomMiddle','BottomRight'];
	var bottomCornersSelected = ['BottomLeftSelected','BottomMiddleSelected','BottomRightSelected'];
	
	// Adds our top and middle corners as divs into a div
	for (i in cornersClasses) {
		cornersTop = $("<div/>").attr("class", cornersClasses[i]);
		$(".mycorners").append(cornersTop);
	}
	
	// Adds our top and middle corners in three div after oiur list (so it inhrits the toggle effect)
	for (i in bottomCorners) {
		cornersBottom = $("<div/>").attr("class", bottomCorners[i]);
		$(".drop").append(cornersBottom);
	}
		
	// Starts defining click behavior
	$("ul.dropdown").bind("click", function() {
		var parentEl = $(this).parent().attr("id") == 'undefined' ? "." + $(this).parent().attr("class") : "#" + $(this).parent().attr("id");
		var subitems = $(this).find(".drop ul li");
		var selecteditem = $(this).find(".selected");
		
		// Add class "current" class to selected list to identify it
		$(parentEl+ " ul.dropdown").toggleClass("current");
		
		// Expanding the list, setting selected text
		subitems.slideToggle("fast", function() {
			subitems.click(function() {
				var selection = $(this).text();
					selecteditem.text(selection).fadeOut(5, function() {
					$(this).fadeIn(400);
				});
			});
		});
		
		// Sets selected state for hovered last child of the list, which needs to have rounded corners as well when selected
		$(parentEl+ " .current ul li:last-child").hover(function() {
			for (i in bottomCorners) {
				$(parentEl+ " .current")
				.parents("div")
				.find("." + bottomCorners[i])
				.toggleClass(bottomCornersSelected[i]);
			}
		});
		
		// In case selected list doesn't appear to have the "current" class set, we check and assign it if needed - in case it's already set on the selection click, it's going to be 'toggled' (removed)
		if (!$(parentEl+ " ul.dropdown").hasClass("current")) $(parentEl+ " ul.dropdown").toggleClass("current");

	}); // End click behavior
};})(jQuery);