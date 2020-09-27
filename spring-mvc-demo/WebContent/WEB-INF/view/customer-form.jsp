<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>

<html>

<head>

<title>Customer Registration Form</title>

<style type="text/css">
.error {
	color: red
}
</style>
</head>

<body>
	<i>Fill out the form. Asterisk(*) means required.</i>

	<form:form action="processForm" modelAttribute="customer">

First Name: <form:input path="firstName" />

		<br>
		<br>

Last Name(*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"></form:errors>

		<br>
		<br>
		
Free passes(*): <form:input path="freePass" />
		<form:errors path="freePass" cssClass="error"></form:errors>

		<br>
		<br>
		
Postal Code: <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error"></form:errors>

		<br>
		<br>
		
Product ID: <form:input path="productID" />
		<form:errors path="productID" cssClass="error"></form:errors>
		
		<br>
		<br>
		
		<input type="submit" value="Submit">

	</form:form>

</body>

</html>