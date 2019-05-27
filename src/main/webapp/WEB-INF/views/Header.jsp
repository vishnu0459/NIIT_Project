<!DOCTYPE html>

<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  /* Make the image fully responsive */
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-blue">
  <!-- Brand -->
 


  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="navbar-brand" href="home">Home</a>
    </li>
 

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Category
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="category">Add Category</a>
         <a class="dropdown-item" href="show">Show Category</a>
    
      </div>
   
    </li>

     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Supplier
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="supp">Add Supplier </a>
         <a class="dropdown-item" href="showsupply">Show Supplier</a>
    
      </div>
    
    </li>
    
     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Product
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="product">Add Product </a>
         <a class="dropdown-item" href="showproduct">Show Product</a>
    
      </div>
    
    </li>
    <li class="nav-item">
      <a class="nav-link" href="about">About us</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="contact">Contact us</a>
    </li>
  </ul>
</nav>

</body>
</html>
