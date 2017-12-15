$(document).ready(function() {
    $('[data-toggle="tooltip"]').tooltip();  
    
    $("#sortNumbers").on("click", function() {
    	
    	var numbers = $("#numbersBeforeSort").val();
    	console.log("numbers : " + numbers);
    	
    	if (!numbers || numbers.length <= 0) {
    		$('[data-toggle="tooltip"]').tooltip('show');
    		return false;
    	}
    	
    	if (!numbers.match(/^\d+(,( )*\d+)*$/)) {
    		$("#errorModal").modal('show');
    		return false;
        }
    });    
});
