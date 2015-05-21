
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shopping cart</title>

    <link rel="stylesheet" type="text/css" href="styles/bootstrap.css">
    <%--<link rel="stylesheet" type="text/css" href="styles/styles.css">--%>
    <link rel="stylesheet" type="text/css" href="styles/media-queries.css">
</head>
<body>
    <container>
        <h1 class='head1'>ShoppingCart</h1>
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
                <form name="removeFromCart" action="removeFromCart.html" method="POST">
                    <input name="tourId" type="text" value="${tour.id}" style="display: none;" >
                    <input type="submit" value="Remove">
                </form>
            </div>
        </c:forEach>
        <form name="Confirm order" action="confirmOrder.html" method="POST">
            <input type="submit" value="Confirm order">
        </form>
        <a href="index.html">Home</a>
    </container>
</body>
</html>
