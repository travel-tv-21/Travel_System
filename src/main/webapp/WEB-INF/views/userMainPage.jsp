<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<meta charset='UTF-8'>
	<head>
		<title>Travel agency</title>

		<link rel="stylesheet" type="text/css" href="styles/bootstrap.css">
		<%--<link rel="stylesheet" type="text/css" href="styles/styles.css">--%>
		<link rel="stylesheet" type="text/css" href="styles/media-queries.css">
	</head>
	<body>
		<div class="container">
			<div class="upper-info row">
				<div class='col-xs-12 upper-link'>You logged in as ${login}  <a href="logout.html">Logout</a></div>

			</div>
			<div class="center-header row">	
					<div class ="logo col-xs-3 col-md-2">
						<a href="index.html">TravelAgency</a>
					</div>
					<div class="col-xs-5 col-md-6 phone-search">
						<form class="search-form" method="post" action="/search.html">
							<input type="text" name="query"><input type="submit" value="SEARCH">
						</form>
					</div>
					<div class="col-xs-4 col-md-4 shopping-cart">
						<div class="shopping-cart-name col-xs-6">
							<a href='shoppingCart.html'>
								<img src="image/shopping-cart.png" width="44" height="32" alt="Корзина">
								<span class="cart-name">Shopping cart</span>
							</a>
						</div>
					</div>
			</div>

            <form class='col-xs-12 col-sm-3' method="POST" action="filter.html">
                <h2>Filter</h2>
                Minimal price:
                <input name="minPrice" type="number" value="${minPrice}"/><br/>
                Maximal price:
                <input name="maxPrice" type="number" value="${maxPrice}"/>
                <br/>
                Start date: from
                <input name="startDateFrom" type="date" value="${startDateFrom}"/> <br/>to
                <input name="startDateTo" type="date" value="${startDateTo}"/>
                <br/>
                Min days count: <input name="minDaysCount" type="number" value="${minDaysCount}">
                Max days count: <input name="maxDaysCount" type="number" value="${maxDaysCount}">
                <input type="submit" value="FILTER"/>
            </form>

            <div>
				<h1 class='head1'>Tours</h1>
                        <c:forEach var="tour" items="${toursForList}">
                        <div class="col-xs-4 good">
                            <img src="${tour.imgPath}"/><br/>
                            Name: ${tour.name}<br/>
                            Price: ${tour.price}<br/>
                            Description: ${tour.description}<br/>
                            Start date: ${tour.startDate}<br/>
                            Count of days: ${tour.countOfDays}<br/>
                            Price: ${tour.price}<br/>
                            Hot: <c:if test="${tour.hot}">Yes</c:if>
                                     <c:if test="${tour.hot == false}">No</c:if><br/>
                            <form name="addToCart" action="addToCart.html" method="POST">
                                <input name="tourId" type="text" value="${tour.id}" style="display: none;" >
                                <input type="submit" value="Add into cart">
                            </form>
                        </div>
                    </c:forEach>
			</div>
			
			

		
		
		</div>
	</body>
</html>