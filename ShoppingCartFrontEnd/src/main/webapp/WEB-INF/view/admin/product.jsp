<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${productsSuccessMessage} ${productsErrorMessage}
	<!-- create 3 text fields -->
	<form action="products/save/" method="post">
		<table>
			<tr>
				<td>ID</td>

				<td><input type="text" name='id' value="${selectedProducts.id}"></td>

			</tr>

			<td>Name</td>

			<td><input type="text" name='name'
				value="${selectedProducts.name}"></td>

			</tr>

			<tr>
				<td>Description</td>

				<td><input type="text" name='description'
					value="${selectedProducts.description}"></td>
			</tr>

			<tr>
				<td>Price</td>

				<td><input type="text" name='price'
					value="${selectedProducts.price}"></td>
			</tr>

			<tr>
				<td>Category</td>
				<td><select name = "categoryID">
				<c:forEach var= "category" items="${categories}"> 
						<option value="${category.id}"> ${category.name} </option>
				</c:forEach>		

				</select></td>
			</tr>




			<tr>
				<td>Supplier</td>
				<td><select name = "supplierID">
						<option value="Sup001">SVG Electronics</option>
						<option value="Sup002">MG Books</option>
						<option value="Sup003">Sangeetha Mobile</option>

				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value='create products'></td>
			</tr>


		</table>

	</form>

	<!--  display all the categories -->

	<div>
		<table border="5" bgcolor="cyan">
			<tr>
				<td>Products ID</td>
				<td>Products Name</td>
				<td>Products Description</td>
				<td>Action</td>
			</tr>


			<c:forEach var="products" items="${products}">
				<tr>
					<td>${products.id}</td>
					<td>${products.name}</td>
					<td>${products.description}</td>

					<td><a href="products/delete/?id=${products.id}">Delete</a></td>

					<td><a href="products/edit/?id=${products.id}">Edit</a></td>




				</tr>

			</c:forEach>

		</table>


	</div>











</body>
</html>