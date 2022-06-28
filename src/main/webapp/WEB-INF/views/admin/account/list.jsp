<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

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
			<div class="col mt-4">
				<div class="card">
					<div class="card-header">
						<h2>List of Categories</h2>
					</div>
					<div class="card-body">
						<table class="table table-striped table-inverse">
							<thead class="thead-inverse">
								<tr>
									<th><input type="checkbox" class="form-check-input"></th>
									<th></th>
									<th>username</th>
									<th>password</th>
									<th>fullname</th>
									<th>email</th>
									<th>activated</th>
									<th>admin</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${page.content}">
									<tr>

										<td><input type="checkbox" class="form-check-inline"></td>
										<td><img src="/images/${item.photo}" width="70"
											class="img-fluid"></td>
										<td>${item.username}</td>
										<td>${item.password}</td>
										<td>${item.fullname}</td>
										<td>${item.email}</td>
										<td>${item.activated}</td>
										<td>${item.admin}</td>

										<td><a href="" class="btn btn-outline-info"><i
												class="fa fa-info"></i></a> <a href="edit/${item.username}"
											class="btn btn-outline-warning"><i class="fas fa-edit"></i></a>
											<a href="delete/${item.username}"
											class="btn btn-outline-danger"><i class="fa fa-recycle"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="card-footer text-muted">
						<form action="" method="get">
							<div class="form-inline float-left">
								<label for="">Page Size:</label> <select class="form-control"
									name="" id="">
									<option>5</option>
									<option>15</option>
									<option>30</option>
								</select>
							</div>
						</form>
						<nav aria-label="Page navigation">
							<ul class="pagination justify-content-center">
								<li class="page-item "><a class="page-link"
									href="search?p=${page.number-1}" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
								</a></li>
								<li class="page-item active"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link"
									href="search?p=${page.number+1}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>

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