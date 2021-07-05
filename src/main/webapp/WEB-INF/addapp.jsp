<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>body {

    padding: 0;
    font-family: sans-serif;
    background: linear-gradient(to right, #2eca6a, #ffffff)
}



.box {
    width: 500px;
    padding: 40px;
    position: absolute;
    top: 50%;
    left: 50%;
    background: #191919;
    ;
    text-align: center;
    transition: 0.25s;
    margin-top: 100px
}
input {
    border: 0;
    background: none;
    display: block;
    margin: 20px auto !important;
    text-align: center;
    border: 2px solid #3498db;
    padding: 10px 10px;
    width: 250px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s
}

.box h1 {
    color: white;
    text-transform: uppercase;
    font-weight: 500
}

input:focus {
    width: 300px;
    border-color: #2ecc71
}

.submit {
    border: 0;
    background: none;
    display: block;
    margin: 20px auto;
    text-align: center;
    border: 2px solid #2ecc71;
    padding: 14px 40px;
    outline: none;
    color: white;
    border-radius: 24px;
    transition: 0.25s;
    cursor: pointer
}

.submit:hover {
    background: #2ecc71
}

.forgot {
    text-decoration: underline
}

ul.social-network {
    list-style: none;
    display: inline;
    margin-left: 0 !important;
    padding: 0
}

ul.social-network li {
    display: inline;
    margin: 0 5px
}

.social-network a.icoFacebook:hover {
    background-color: #3B5998
}

.social-network a.icoTwitter:hover {
    background-color: #33ccff
}

.social-network a.icoGoogle:hover {
    background-color: #BD3518
}

.social-network a.icoFacebook:hover i,
.social-network a.icoTwitter:hover i,
.social-network a.icoGoogle:hover i {
    color: #fff
}

a.socialIcon:hover,
.socialHoverClass {
    color: #44BCDD
}

.social-circle li a {
    display: inline-block;
    position: relative;
    margin: 0 auto 0 auto;
    border-radius: 50%;
    text-align: center;
    width: 50px;
    height: 50px;
    font-size: 20px
}

.social-circle li i {
    margin: 0;
    line-height: 50px;
    text-align: center
}

.social-circle li a:hover i,
.triggeredHover {
    transform: rotate(360deg);
    transition: all 0.2s
}

.social-circle i {
    color: #fff;
    transition: all 0.8s;
    transition: all 0.8s
}</style>
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
 <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" rel="stylesheet">
 <link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet">
 <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel="stylesheet">
 
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            
                <p><form:errors path="user.*"/></p>
                <form:form method="POST" action="/addapp" modelAttribute="Apartment" class="box" enctype="multipart/form-data">
                    <h1>Register</h1>
                	 <form:input type="hidden" path="host" value="${user.getId() }"/>
                     <form:input type="text" path="buildingName" placeholder="Building Name" />
                     <form:input type="text" path="address" placeholder="Address" />
                      <form:input type="text" path="price" placeholder="Price" /> 
                      <form:input type="number" path="bedroomnum" placeholder="Number of bedrooms" /> 
                      <form:input type="number" path="bathroomnum" placeholder="Number of bathrooms" />
                      
                      
                     <form:input type="text" path="buildingName" placeholder="buildingName" />
                     <form:input type="text" path="address" placeholder="address" />
                      <form:input type="text" path="price" placeholder="price" /> 
                      <label style="color:white;" for="bedroomnum">Bedroom Number</label>
                      <form:input type="number" path="bedroomnum" placeholder="bedroomnum" /> 
                      <label style="color:white;" for="bedroomnum">Bathroom Number</label>
                      <form:input type="number" path="bathroomnum" placeholder="bathroomnum" />
                       <input type="file" name="Image" placeholder="image" >
                  		<form:label path="state">State</form:label>
				        <form:errors path="state"/>
				        <form:select path="state">
				        <c:forEach var="state" items="${States}">
							<form:option value="${state.id}" label="${state.id}"/>
        				</c:forEach>
				        
				       </form:select>
                      
                       <input class="submit"type="submit" value="Add Property"/>
                    <div class="col-md-12">
                       
                    </div>
                </form:form>
            </div>
        </div>
    </div>

</body>
</html>