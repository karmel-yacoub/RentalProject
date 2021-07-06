<%@ taglib prefix=  "c" uri=  "http://java.sun.com/jsp/jstl/core"  %>

<jsp:include page="header.jsp"></jsp:include>
<img src="img/slide-3.jpg">

<main id="main">
	<!-- ======= Services Section ======= -->
	<section class="section-services section-t8">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="title-wrap d-flex justify-content-between">
						<div class="title-box">
							<h2 class="title-a">Our Services</h2>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="card-box-c foo">
						<div class="card-header-c d-flex">
							<div class="card-box-ico">
								<span class="fa fa-gamepad"></span>
							</div>
							<div class="card-title-c align-self-center">
								<h2 class="title-c">Lifestyle</h2>
							</div>
						</div>
						<div class="card-body-c">
							<p class="content-c">Sed porttitor lectus nibh. Cras
								ultricies ligula sed magna dictum porta. Praesent sapien massa,
								convallis a pellentesque nec, egestas non nisi.</p>
						</div>
						<div class="card-footer-c">
							<a href="#" class="link-c link-icon">Read more <span
								class="ion-ios-arrow-forward"></span>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card-box-c foo">
						<div class="card-header-c d-flex">
							<div class="card-box-ico">
								<span class="fa fa-usd"></span>
							</div>
							<div class="card-title-c align-self-center">
								<h2 class="title-c">Loans</h2>
							</div>
						</div>
						<div class="card-body-c">
							<p class="content-c">Nulla porttitor accumsan tincidunt.
								Curabitur aliquet quam id dui posuere blandit. Mauris blandit
								aliquet elit, eget tincidunt nibh pulvinar a.</p>
						</div>
						<div class="card-footer-c">
							<a href="#" class="link-c link-icon">Read more <span
								class="ion-ios-arrow-forward"></span>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card-box-c foo">
						<div class="card-header-c d-flex">
							<div class="card-box-ico">
								<span class="fa fa-home"></span>
							</div>
							<div class="card-title-c align-self-center">
								<h2 class="title-c">Sell</h2>
							</div>
						</div>
						<div class="card-body-c">
							<p class="content-c">Sed porttitor lectus nibh. Cras
								ultricies ligula sed magna dictum porta. Praesent sapien massa,
								convallis a pellentesque nec, egestas non nisi.</p>
						</div>
						<div class="card-footer-c">
							<a href="#" class="link-c link-icon">Read more <span
								class="ion-ios-arrow-forward"></span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Services Section -->



	<!-- ======= Agents Section ======= -->
	<section class="section-agents section-t8">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="title-wrap d-flex justify-content-between">
						<div class="title-box">
							<h2 class="title-a">Best Agents</h2>
						</div>
						<div class="title-link">
							<a href="/agentsGrid">All Agents <span
								class="ion-ios-arrow-forward"></span>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="agent" items="${Agents}">
					<div class="col-md-4">
						<div class="card-box-d">
							<div class="card-img-d">
								<img src="img/agent-4.jpg" alt="" class="img-d img-fluid">
							</div>
							<div class="card-overlay card-overlay-hover">
								<div class="card-header-d">
									<div class="card-title-d align-self-center">
										<h3 class="title-d">
											<a href="/agentsGridone/${agent.id}" class="link-two">
												${agent.username} </a>
										</h3>
									</div>
								</div>
								<div class="card-body-d">
									<p class="content-d color-text-a">Sed porttitor lectus
										nibh, Cras ultricies ligula sed magna dictum porta two.</p>
									<div class="info-agents color-a">
										<p>
											<strong>Phone: </strong>${agent.phonenumber}
										</p>
										<p>
											<strong>Email: </strong> ${agent.email}
										</p>
									</div>
								</div>
								<div class="card-footer-d">
									<div class="socials-footer d-flex justify-content-center">
										<ul class="list-inline">
											<li class="list-inline-item"><a href="#"
												class="link-one"> <i class="fa fa-facebook"
													aria-hidden="true"></i>
											</a></li>
											<li class="list-inline-item"><a href="#"
												class="link-one"> <i class="fa fa-twitter"
													aria-hidden="true"></i>
											</a></li>
											<li class="list-inline-item"><a href="#"
												class="link-one"> <i class="fa fa-instagram"
													aria-hidden="true"></i>
											</a></li>
											<li class="list-inline-item"><a href="#"
												class="link-one"> <i class="fa fa-pinterest-p"
													aria-hidden="true"></i>
											</a></li>
											<li class="list-inline-item"><a href="#"
												class="link-one"> <i class="fa fa-dribbble"
													aria-hidden="true"></i>
											</a></li>
										</ul>
									</div>
								</div>
							</div>

						</div>

					</div>
				</c:forEach>
				

				<!--  
            <div class="col-md-4">
            <div class="card-box-d">
              <div class="card-img-d">
                <img src="img/agent-1.jpg" alt="" class="img-d img-fluid">
              </div>
              <div class="card-overlay card-overlay-hover">
                <div class="card-header-d">
                  <div class="card-title-d align-self-center">
                    <h3 class="title-d">
                      <a href="agent-single.html" class="link-two">Stiven Spilver
                        <br> Darw</a>
                    </h3>
                  </div>
                </div>-->
				<!--  <div class="card-body-d">
                  <p class="content-d color-text-a">
                    Sed porttitor lectus nibh, Cras ultricies ligula sed magna dictum porta two.
                  </p>
                  <div class="info-agents color-a">
                    <p>
                      <strong>Phone: </strong> +54 356 945234
                    </p>
                    <p>
                      <strong>Email: </strong> agents@example.com
                    </p>
                  </div>
                </div>
                <div class="card-footer-d">
                  <div class="socials-footer d-flex justify-content-center">
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
          <div class="col-md-4">
            <div class="card-box-d">
              <div class="card-img-d">
                <img src="img/agent-5.jpg" alt="" class="img-d img-fluid">
              </div>
              <div class="card-overlay card-overlay-hover">
                <div class="card-header-d">
                  <div class="card-title-d align-self-center">
                    <h3 class="title-d">
                      <a href="agent-single.html" class="link-two">Emma Toledo
                        <br> Cascada</a>
                    </h3>
                  </div>
                </div>
                -->
				<!--  <div class="card-body-d">
                  <p class="content-d color-text-a">
                    Sed porttitor lectus nibh, Cras ultricies ligula sed magna dictum porta two.
                  </p>
                  <div class="info-agents color-a">
                    <p>
                      <strong>Phone: </strong> +54 356 945234
                    </p>
                    <p>
                      <strong>Email: </strong> agents@example.com
                    </p>
                  </div>
                </div>
                <div class="card-footer-d">
                  <div class="socials-footer d-flex justify-content-center">
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
                -->
			</div>
		</div>

		</div>

		</div>
		</div>
	</section>
	<!-- End Agents Section -->
</main>
<!-- End #main -->
<jsp:include page="footer.jsp"></jsp:include>