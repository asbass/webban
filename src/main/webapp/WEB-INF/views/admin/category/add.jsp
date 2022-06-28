<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  
  <body>
    <main class="container">
        <section class="row">
            <div class="col-6 offset-3 mt-4">
                <form action="/admin/categories/add" method="post">
                    <div class="card">
                        <div class="card-header">
                            <h2>Add New Category</h2>
                        </div>
                        <div class="card-body">
                         <div class="form-group">
                           <label for="id">Category ID:</label>
                           <input  type="text" class="form-control" name="id" value="${item.id }"  aria-describedby="IdHid" placeholder=""/>
                           <small id="IdHid" class="form-text text-muted">Category id is required</small>
                         </div>
                         <div class="form-group">
                            <label for="name">Name ID:</label>
                            <input type="text" class="form-control" name="name" id="name" value="${item.name }" aria-describedby="nameHid" placeholder=""/>
                            <small id="nameHid" class="form-text text-muted">Name id is required</small>
                          </div>
                        </div>
                        <div class="card-footer text-muted">
                            <button type="reset" class="btn btn-secondary">reset</button>
                            <button class="btn btn-primary"><i class="fas fa-save"></i> save</button>
                            <button class="btn btn-primary float-right" formaction="/admin/categories/update"> update</button>
                            
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <footer></footer>
    </main>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>