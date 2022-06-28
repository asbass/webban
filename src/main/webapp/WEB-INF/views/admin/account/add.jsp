<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
</head>
<body>
	<main class="container">
		<section class="row">
			<div class="col-6 offset-3 mt-4">
				<form:form action="/admin/account/add" method="post"
					modelAttribute="item" enctype="multipart/form-data">
					<div class="card">
						<div class="card-header">
							<h2>Add New Product</h2>
						</div>
						<div class="card-body"> 
							<div class="row">
								<div class="col-7">
									<h3>${message }</h3>
									<div class="form-group">
										<label for="username">username </label>
										<form:input type="text" class="form-control" path="username" />
									</div>
									<div class="form-group">
										<label for="username">password </label>
										<form:input type="text" class="form-control" path="password"
											aria-describedby="categoryIdHid" placeholder="" />
									</div>
									<div class="form-group">
										<label for="username">Name </label>
										<form:input type="text" class="form-control" path="fullname"
											aria-describedby="categoryIdHid" placeholder="" />
									</div>
									<div class="form-group">
										<label for="username">email </label>
										<form:input type="text" class="form-control" path="email"
											aria-describedby="categoryIdHid" placeholder="" />
									</div>
									<div class="form-group">
										<label for="username">admin </label>
										<form:radiobutton path="admin" value="true" />admin	
										<form:radiobutton path="admin" value="false" />user
									</div>
									<div class="form-group">
										<label for="username">activated </label>
										<form:radiobutton path="activated" value="true" />activated	
										<form:radiobutton path="activated" value="false" />notactivated
									</div>
								</div>
								<div class="col-3">
									<img src="/images/${item.photo}" width="90%"
										class="border border-primary">
									<div class="form-group">
										<label for="productImage">Image file</label> <input
											type="file" class="form-control" name="images"
											aria-describedby="productImage" placeholder="">
									</div>

								</div>
							</div>
						</div>
						<div class="card-footer text-muted">
							<button class="btn btn-primary">Save</button>
							<button class="btn btn-success">New</button>
							<button class="btn btn-primary float-right"
								formaction="/admin/account/update">update</button>
							<button class="btn btn-primary"
								formaction="/admin/account/search">
								<i class="fas fa-save"></i> list product
							</button>
							<button class="btn btn-danger float-right">Delete</button>
						</div>
					</div>

				</form:form>
			</div>
		</section>
		<footer></footer>
	</main>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>