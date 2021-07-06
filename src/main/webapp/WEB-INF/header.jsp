<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Java Project</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="/img/favicon.png" rel="icon">
  <link href="/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/vendor/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
 

  <!-- Template Main CSS File -->
  <link href="/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: EstateAgency - v2.2.1
  * Template URL: https://bootstrapmade.com/real-estate-agency-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <script>
  fetch("https://restcountries.eu/rest/v2/all")
  .then(res => res.json())
  .then(data => initialize(data))
  .catch(err => console.log("Error:", err));

 	 function initialize(countriesData) {
    countries = countriesData;
    let options = "<option value ='all'>All States</option>";
     for(let i=0; i<countries.length; i++) {
      options += "<option value="+countries[i].name+">"+countries[i].name+"</option>";
     }
	  document.getElementById("city").innerHTML= options;
 	 }
	</script>
</head>

<body>

   <!-- ======= Property Search Section ======= -->
  <div class="click-closed"></div>
  <!--/ Form Search Star /-->
  <div class="box-collapse">
    <div class="title-box-d">
      <h3 class="title-d">Search Property</h3>
    </div>
    <span class="close-box-collapse right-boxed ion-ios-close"></span>
    <div class="box-collapse-wrap form">
      <form action="/filter" method= "POST" class="form-a">
        <div class="row">
          <div class="col-md-12 mb-2">
            <div class="form-group">
              <label for="Type">Keyword</label>
              <input type="text" class="form-control form-control-lg form-control-a" placeholder="Keyword">
            </div>
          </div>
     
          <div class="col-md-6 mb-2">
            <div class="form-group">
              <label for="city">State</label>
              <select name = "state" class="form-control form-control-lg form-control-a" id="city">
                
          
  
              </select>

            </div>
          </div>
          <div class="col-md-6 mb-2">
            <div class="form-group">
              <label for="bedrooms">Bedrooms</label>
              <select name ="bedrooms" class="form-control form-control-lg form-control-a" id="bedrooms">
                <option value = "0">Any</option>
                <option value = "1">01</option>
                <option value = "2">02</option>
                <option value = "3">03</option>
                <option value = "4">04</option>
                <option value = "5">05</option>
                
                
              </select>
            </div>
          </div>
          
          <div class="col-md-6 mb-2">
            <div class="form-group">
              <label for="bathrooms">Bathrooms</label>
              <select name = "bathrooms" class="form-control form-control-lg form-control-a" id="bathrooms">
                <option value ="0">Any</option>
                <option value ="1">01</option>
                <option value ="2">02</option>
                <option value ="3">03</option>
                <option value ="4">04</option>
              </select>
            </div>
          </div>
          <div class="col-md-6 mb-2">
            <div class="form-group">

              <label for="price">Max Price</label>
              <select name = "price" class="form-control form-control-lg form-control-a" id="price">
                <option value = "0">Unlimite</option>
                <option value ="50000">$50,000</option>
                <option value ="1000000">$100,000</option>
                <option value ="1500000">$150,000</option>
                <option value ="2000000">$200,000</option>
              </select>
            </div>
          </div>
          <div class="col-md-12">
            <button type="submit" class="btn btn-b">Search Property</button>
          </div>
        </div>
      </form>
    </div>
  </div><!-- End Property Search Section -->>

  <!-- ======= Header/Navbar ======= -->
  <nav class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
    <div class="container">
      <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarDefault" aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span></span>
        <span></span>
        <span></span>
      </button>
      <a class="navbar-brand text-brand" href="/">Home4 <span class="color-b">You</span></a>
      <button type="button" class="btn btn-link nav-search navbar-toggle-box-collapse d-md-none" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-expanded="false">
        <span class="fa fa-search" aria-hidden="true"></span>
      </button>
      <div class="navbar-collapse collapse justify-content-center" id="navbarDefault">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" href="/">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/prop">Property</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/agentsGrid">Agents</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="/contact">Contact</a>
           </li>
           <c:if test="${sessionScope.role eq 3}">
          <li class="nav-item">
            <a class="nav-link" href="/addapp">Add Property</a>
          </li>
          </c:if>
           <c:choose>
           <c:when test="${sessionScope.role eq null}">
          
           <li class="nav-item">
            <a class="nav-link" href="/login">Login</a>
          </li>
          </c:when>
          <c:otherwise>
          
           <li class="nav-item">
            <a class="nav-link" href="/logout">Logout</a>
          </li>
          </c:otherwise>
          </c:choose>
          
        </ul>
      </div>
      <button type="button" class="btn btn-b-n navbar-toggle-box-collapse d-none d-md-block" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-expanded="false">
        <span class="fa fa-search" aria-hidden="true"></span>
      </button>
    </div>
  </nav><!-- End Header/Navbar -->
