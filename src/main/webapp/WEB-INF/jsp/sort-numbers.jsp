<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<link href="${pageContext.request.contextPath}/resources/static/css/sorterApp.css" rel="stylesheet">

<div class="container">
	<form:form method="post"
		action="${pageContext.request.contextPath}/app/sortNumbers"
		modelAttribute="appData" id="appNumbersForm">
		<fieldset class="form-group">
			<form:label path="numbersBeforeSort">Numbers</form:label>
			<form:input path="numbersBeforeSort" name="numbersBeforeSort"
				type="text" class="form-control" id="numbersBeforeSort"
				data-toggle="tooltip" data-placement="bottom"
				title="Please enter comma(,) separated NUMBERS for sorting !!" />
			<form:errors path="numbersBeforeSort" cssClass="text-warning" />
		</fieldset>

		<button id="sortNumbers" type="submit" class="btn btn-success">Sort
			Numbers</button>
	</form:form>


	<!-- Modal -->
	<div class="modal fade" id="errorModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Error</h4>
				</div>
				<div class="modal-body">
					<p>Please enter valid comma separated Numbers. </p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>
<script src="${pageContext.request.contextPath}/resources/static/js/sorterApp.js"></script>
