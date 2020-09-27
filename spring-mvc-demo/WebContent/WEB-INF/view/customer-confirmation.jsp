<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>Customer Confirmation</title>
</head>


<body>

	The Customer ${customer.firstName} ${customer.lastName} is CONFIRMED
	<br>
	<br> You have ${customer.freePass} free Passes Left
	<br>
	<br>
	Your Postal Code is ${customer.postalCode}
	
	<br>
	<br>
	The Product ID is : ${customer.productID}
	
	

</body>
</html>