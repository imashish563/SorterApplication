<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>App Data</caption>
			<thead>
				<tr>
					<th>Numbers Before Sort</th>
					<th>Numbers After Sort</th>
					<th>Time Taken To Sort</th>
					<th>NO# Of Positions Swapped</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${appData}" var="tData">
					<tr>
						<td>${tData.numbersBeforeSort}</td>
						<td>${tData.numbersAfterSort}</td>
						<td>${tData.timeTakenToSort}</td>
						<td>${tData.noOfPositionsSwapped}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
<%@ include file="common/footer.jspf" %>