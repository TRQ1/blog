<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page session="false" %>
<% 
    String ctx = request.getContextPath();    
    pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Saturn by @flamekaizar</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Saturn is free PSD &amp; HTML template by @flamekaizar">
    <meta name="author" content="Afnizar Nur Ghifari">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="css/kube.min.css" />
    <link rel="stylesheet" href="css/font-awesome.min.css" />
    <link rel="stylesheet" href="css/custom.min.css" />
    <link rel="shortcut icon" href="/img/favicon.png" />
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- Navigation -->
	<div class="main-nav">
		<div class="container">
			<header class="group top-nav">
				<nav class="navbar logo-w navbar-left" >
					<a class="logo" href="index.jsp">TRQ1</a>
				</nav>
				<div class="navigation-toggle" data-tools="navigation-toggle" data-target="#navbar-1">
				    <span class="logo">TRQ1</span>
				</div>
			    <nav id="navbar-1" class="navbar item-nav navbar-right">
				    <ul>
				        <li class="active"><a href="index.jsp">Home</a></li>
				        <li><a href="#">About</a></li>
				        <li><a href="#">Archive</a></li>
				        <li><a href="#">Contact</a></li>
				    </ul>
				</nav>
			</header>
		</div>
	</div>

	<!-- Introduction -->
	<div class="intro">
		<div class="container">
			<div class="units-row">
			    <div class="unit-10">
			    	<img class="img-intro" src="img/avatar.png" alt="">
			    </div>
			    <div class="unit-90">
			    	<p class="p-intro">Hello, Iâm Q1. Iâm proud to be a part of milky way.</p>
			    </div>
			</div>
		</div>
	</div>
	
	<!-- Content -->
	<div class="content">
		<div class="container">
			<!-- Post -->
			<div class="post">
				<!-- Heading -->
				<a href="#"><h1>Galaxy is on your hand</h1></a>
				<hr>
				<div class="in-content">
					<p>
						Q1 has a prominent ring system that consists of nine continuous main rings and three discontinuous arcs, composed mostly of ice particles with a smaller amount of rocky debris and dust. Sixty-two known moons orbit the planet, of which fifty-three are officially named. This does not include the hundreds of "moonlets" comprising the rings.
					</p>
					<a class="read-more" href="#">Read more</a>
				</div>
				<div class="foot-post">
					<div class="units-row">
					    <div class="unit-100">
					    	<strong>Tags:</strong>
					    	<a href="#">Galaxy</a>,
					    	<a href="#">Human</a>,
					    	<a href="#">World</a>,
					    </div>
					    <div class="unit-100">
					    	<strong>COMMENTS:</strong> 
					    	<a href="#">3</a>
					    </div>
					</div>
				</div>
			</div>
			<!-- /post -->

			<!-- Post -->
			<div class="post">
				<!-- Heading -->
				<a href="#"><h1>The moon will pass above or below Saturn in the sky</h1></a>
				<hr>
				<div class="in-content">
					<img class="right" src="img/post-img.jpg" alt="">
					<p>
						Saturn has a prominent ring system that consists of nine continuous main rings and three discontinuous arcs, composed mostly afn of ice particles with a smaller amount of rocky debris and dust.
					</p>
				</div>
				<div class="foot-post">
					<div class="units-row">
					    <div class="unit-100">
					    	<strong>Tags:</strong>
					    	<a href="#">Saturn</a>,
					    	<a href="#">Sky</a>,
					    	<a href="#">Moon</a>,
					    </div>
					    <div class="unit-100">
					    	<strong>COMMENTS:</strong> 
					    	<a href="#">3</a>
					    </div>
					</div>
				</div>
			</div>
			<!-- /post -->

			<!-- Post -->
			<div class="post">
				<!-- Heading -->
				<a href="#"><h1>Moonâs orbit around the Earth </h1></a>
				<hr>
				<div class="in-content">
					<p>
						Tilted to the orbit of the Earth around the Sun â and so most of the time, the moon will pass above or below Saturn in the sky, and no occultation will occur. It is only when Saturn lies near the point that the moonâs orbit crosses the âplane of the eclipticâ that occultations can happen.
					</p>
					<a class="read-more" href="#">Read more</a>
				</div>
				<div class="foot-post">
					<div class="units-row">
					    <div class="unit-100">
					    	<strong>Tags:</strong>
					    	<a href="#">Moon</a>,
					    	<a href="#">Orbit</a>,
					    	<a href="#">Earth</a>,
					    </div>
					    <div class="unit-100">
					    	<strong>COMMENTS:</strong> 
					    	<a href="#">221</a>
					    </div>
					</div>
				</div>
			</div>
			<!-- /post -->
		</div>
	</div>

	<footer>
		<div class="container">
			<div class="units-row">
			    <div class="unit-50">
			    	<button class="btn btn-black"><i class="fa fa-arrow-left"></i> PREVIOUS</button>
			    </div>
			    <div class="unit-50">
					<ul class="social list-flat right">
						<li><a href="mailto:afnizarhilmi@gmail.com"><i class="fa fa-send"></i></a></li>
						<li><a href="http://twitter.com/flamekaizar"><i class="fa fa-twitter"></i></a></li>
						<li><a href="http://dribbble.com/flamekaizar"><i class="fa fa-dribbble"></i></a></li>
						<li><a href="http://behance.com/flamekaizar"><i class="fa fa-behance"></i></a></li>
					</ul>
			    </div>
			</div>
			<p class="text-centered foot-cp">
	    		<a href="#">handcrafted by @flamekaizar</a>
	    	</p>
		</div>
	</footer>

	<!-- Javascript -->
	<script src="js/jquery.min.js"></script>
    <script src="js/kube.min.js"></script>
</body>
</html>