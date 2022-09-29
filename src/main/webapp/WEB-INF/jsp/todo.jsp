<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">CREATE PROJECT</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="todo">
						<form:hidden path="id" />

						<fieldset class="form-group">
							<form:label path="projectName">Project Name</form:label>
							<form:input path="projectName" type="text" class="form-control"
										required="required" />
							<form:errors path="projectName" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="owner">Owner</form:label>
							<form:input path="owner" type="text" class="form-control"
										required="required" />
							<form:errors path="owner" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="description">Introduction</form:label>
							<form:input path="description" type="text" class="form-control"
								required="required" />
							<form:errors path="description" cssClass="text-warning" />
						</fieldset>

<%--						<fieldset class="form-group">--%>
<%--							<form:label path="targetDate">Target Date</form:label>--%>
<%--							<form:input path="targetDate" type="text" class="form-control"--%>
<%--								required="required" />--%>
<%--							<form:errors path="targetDate" cssClass="text-warning" />--%>
<%--						</fieldset>--%>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>