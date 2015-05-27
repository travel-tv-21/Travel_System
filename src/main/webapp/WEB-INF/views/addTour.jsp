<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 20.05.2015
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/resources/styles/semantic.css">
</head>
<body>

<form:form class="ui form segment" modelAttribute="tour" enctype="multipart/form-data"  method="post" action="addTour.html">
    <div class="ui message">
        <div class="header">Add Tour</div>
    </div>
    <div class="two fields">
        <div class="field">

            <label >Name</label>
            <form:input path="name" name="Name" placeholder="Name" type="text"/>
            <%--<form:errors cssClass="error" path="firstName"/>--%>
        </div>
        <div class="field">
            <label>Price</label>
            <form:input path="price" name="price" placeholder="price" type="number"/>
            <%--<form:errors  cssClass="error" path="lastName"/>--%>
        </div>
    </div>

    <%--<div class="two fields">--%>

        <div class="field">
            <label>File</label>
            <input name="file" type="file"/>
            <%--<form:errors cssClass="error" path="salary"/>--%>
        </div>
        <%--<div class="field">--%>
            <%--<label>Start Date</label>--%>
            <%--<input type="text" name="startDate" placeholder="example 01-10-2012" path="birthDay"/>--%>
            <%--&lt;%&ndash;<form:errors cssClass="error" path="birthDay"/>&ndash;%&gt;--%>
        <%--</div>--%>
    <%--</div>--%>

    <div class="field">
        <label>Description</label>
        <form:input path="description" type="text" name="description" />
    </div>

    <div class="two fields">
        <div class="field">
            <label>number of day</label>
            <form:input path="numday" name="numOfDay" placeholder="numOfDay" type="number"/>
            <%--<form:errors cssClass="error" path="salary"/>--%>
        </div>

        <div class="field">
            <label>Start Date</label>
            <form:input type="number" path="numPeopleId" placeholder="number Of people" />
            <%--<form:errors cssClass="error" path="birthDay"/>--%>
        </div>
    </div>
    <div class="inline field">
        <form:checkbox path="insurance"  /> active
    </div>
    <div class="inline field">
    <form:checkbox  path="hot" /> hot
    </div>
    <br/>


    <%--<div class="field">--%>
        <%--<label>department</label>--%>
        <%--<select path="department" items = "" itemValue="idDepartment" itemLabel="name" />--%>
    <%--</div>--%>

    <input type="submit" value="Додати" class="ui positive submit button"/>
    <input type="reset" value="Очистити" class="ui red button"/>
    <a href="index.html"><input type="button" value="Повернутись назад" class="ui red button"/></a>
</form:form>
</body>
</html>
