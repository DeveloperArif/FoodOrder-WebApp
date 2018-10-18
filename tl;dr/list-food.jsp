<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Foods</title>
<!-- Link the bootstrap CSS -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
<!-- Or in this case, a variation theme... -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<!-- With boostrap, pages should generally be surrounded with a container element. -->
	<main class="container">
		<h1>
			Foods
			<!-- Images found in the src/main/resources/static folder.
				 The bootstrap classes make them hidden at small screen sizes.
			 -->
			<img src="/images/apple.png" class="d-none d-md-inline-block" />
		</h1>
		
		<form class="form-inline" action="/food" autocomplete="off">
		  <label class="sr-only" for="inlineFormInputName2">Category</label>
		  <%-- prefill a form input using the value attribute. --%>
		  <input type="text" value="${category}" class="form-control mb-2 mr-sm-2" id="category" name="category" placeholder="Category">
		
		  <button type="submit" class="btn btn-primary mb-2 mr-2">Search</button>
		  <c:if test="${not empty category}">
		    <%-- c:if determines whether its contents should show or not --%>
		  	<a href="/food" class="btn btn-secondary mb-2">Clear</a>
	  	  </c:if>
		</form>
		
		<table class="table">
			<thead>
			<tr>
				<th>Food</th><th>Category</th><th>Description</th>
			</tr>
			</thead>
			<tbody>
			<%-- c:forEach is loops through the items and repeats the content for each one.
			     Think of this as:   for (Food food : foods) { ... }
			--%>
			<c:forEach items="${foods}" var="food">
				<tr>
					<%-- Access properties of the java bean using simple . notation.
					     This actually calls the getters behind the scenes. --%>
					<td>${food.name}</td><td>${food.category}</td><td>${food.description}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<a class="btn btn-secondary" href="/add-food">Add</a>
	</main>
</body>
</html>