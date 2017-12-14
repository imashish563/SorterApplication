<%@ include file="common/header.jspf" %>

<div class="container">

	<font color="red">${errorMessage}</font>
	<form:form method="post" action="login" modelAttribute="login">
		<fieldset class="form-group">
			<form:label path="userName">User Name</form:label>
			<form:input  path="userName" type="text" class="form-control" required="required" />
			<form:errors path="userName" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="password">Password</form:label>
			<form:password path="password" class="form-control" required="required" />
			<form:errors path="password" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf" %>