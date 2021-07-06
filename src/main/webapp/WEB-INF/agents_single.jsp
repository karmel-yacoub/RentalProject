 <%@ taglib prefix=  "c" uri=  "http://java.sun.com/jsp/jstl/core"  %>
<jsp:include page="header.jsp"></jsp:include>
 <main id="main">

    <!-- ======= Intro Single ======= -->
    <section class="intro-single">
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-lg-8">
            <div class="title-single-box">
              <h1 class="title-single"><c:out value="${Agent.username}"/> </h1>
              <span class="color-text-a">Agent Immobiliari</span>
            </div>
          </div>
          <div class="col-md-12 col-lg-4">
            <nav aria-label="breadcrumb" class="breadcrumb-box d-flex justify-content-lg-end">
              <ol class="breadcrumb">
                <li class="breadcrumb-item">
                  <a href="/">Home</a>
                </li>
                <li class="breadcrumb-item">
                  <a href="/agentsGrid">Agents</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                  <c:out value="${Agent.username}"/> 
                </li>
              </ol>
            </nav>
          </div>
        </div>
      </div>
    </section><!-- End Intro Single -->

    <!-- ======= Agent Single ======= -->
    <section class="agent-single">
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <div class="row">
              <div class="col-md-6">
                <div class="agent-avatar-box">
                  <img src="img/agent-7.jpg" alt="" class="agent-avatar img-fluid">
                </div>
              </div>
              <div class="col-md-5 section-md-t3">
                <div class="agent-info-box">
                  <div class="agent-title">
                    <div class="title-box-d">
                      <h3 class="title-d"><c:out value="${Agent.username}"/> 
                        <br> 
                      </h3>
                    </div>
                  </div>
                  <div class="agent-content mb-3">
                    <p class="content-d color-text-a">
                      Sed porttitor lectus nibh. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi.
                      Vivamus suscipit tortor
                      eget felis porttitor volutpat. Vivamus suscipit tortor eget felis porttitor volutpat.
                    </p>
                    <div class="info-agents color-a">
                      <p>
                        <strong>Phone: </strong>
                        <span class="color-text-a"> <c:out value="${Agent.phonenumber}"/> </span>
                      </p>
                      <p>
                        <strong>Mobile: </strong>
                        <span class="color-text-a"> <c:out value="${Agent.phonenumber}"/></span>
                      </p>
                      <p>
                        <strong>Email: </strong>
                        <span class="color-text-a"> <c:out value="${Agent.email}"/></span>
                      </p>
               
                  
                    </div>
                  </div>
                  <div class="socials-footer">
                    <ul class="list-inline">
                      <li class="list-inline-item">
                        <a href="#" class="link-one">
                          <i class="fa fa-facebook" aria-hidden="true"></i>
                        </a>
                      </li>
                      <li class="list-inline-item">
                        <a href="#" class="link-one">
                          <i class="fa fa-twitter" aria-hidden="true"></i>
                        </a>
                      </li>
                      <li class="list-inline-item">
                        <a href="#" class="link-one">
                          <i class="fa fa-instagram" aria-hidden="true"></i>
                        </a>
                      </li>
                      <li class="list-inline-item">
                        <a href="#" class="link-one">
                          <i class="fa fa-pinterest-p" aria-hidden="true"></i>
                        </a>
                      </li>
                      <li class="list-inline-item">
                        <a href="#" class="link-one">
                          <i class="fa fa-dribbble" aria-hidden="true"></i>
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-12 section-t8">
            <div class="title-box-d">
              <h3 class="title-d">My Properties (6)</h3>
            </div>
          </div>
          <div class="row property-grid grid">
            <c:if test="${Agent.getHostedapartments() != null }">
            <c:forEach var="option" items="${Agent.getHostedapartments()}">
				<div class="col-md-4">
            <div class="card-box-a card-shadow">
              <div class="img-box-a">
                <img src="img/property-1.jpg" alt="" class="img-a img-fluid">
              </div>
              <div class="card-overlay">
                <div class="card-overlay-a-content">
                  <div class="card-header-a">
                    <h2 class="card-title-a">
                      <a href="#">${option.address}
                        <br /> ${option.name}</a>
                    </h2>
                  </div>
                  <div class="card-body-a">
                    <div class="price-box d-flex">
                      <span class="price-a">rent | $ ${option.price} </span>
                    </div>
                    <a href="property-single.html" class="link-a">Click here to view
                      <span class="ion-ios-arrow-forward"></span>
                    </a>
                  </div>
                  <div class="card-footer-a">
                    <ul class="card-info d-flex justify-content-around">
                      <li>
                        <h4 class="card-info-title">Area</h4>
                        <span>${option.area}m
                          <sup>2</sup>
                        </span>
                      </li>
                      <li>
                        <h4 class="card-info-title">Bedrooms</h4>
                        <span>${option.bedroomnum}</span>
                      </li>
                      <li>
                        <h4 class="card-info-title">Baths</h4>
                        <span>${option.bathroomnum}</span>
                      </li>
                      <li>
                        <h4 class="card-info-title">Garages</h4>
                        <span>1</span>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        	</c:forEach>
        	</c:if>
           
                  </div>
                </div>
              </div>

    </section><!-- End Agent Single -->

  </main><!-- End #main -->
  <jsp:include page="footer.jsp"></jsp:include>