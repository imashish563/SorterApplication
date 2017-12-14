<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<form:form method="post" action="${pageContext.request.contextPath}/app/sortNumbers" modelAttribute="appData" id="appNumbersForm">
		<fieldset class="form-group">
			<form:label path="numbersBeforeSort">Numbers</form:label>
			<form:input path="numbersBeforeSort" name="numbersBeforeSort" type="text" class="form-control" id="numbersBeforeSort" 
									data-toggle="tooltip" data-placement="bottom" title="Please enter comma(,) separated NUMBERS for sorting !!" />
			<form:errors path="numbersBeforeSort" cssClass="text-warning" />
		</fieldset>

		<button id="sortNumbers" type="submit" class="btn btn-success">Sort Numbers</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf" %>

<script>
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
    		$('[data-toggle="tooltip"]').tooltip('show');
    		return false;
        }
    });
    
    
    /* if (!$(this).val().match($regexname)) {
    	
    } */
    
});




</script>