<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h1>Sign Up</h1>

<form:form method="post" commandName="signupForm">
    <table>
        <tr>
            <td>Login:</td>
            <td><form:input path="login" /></td>
            <td><span class="error"><form:errors path="login" /></span></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><form:password path="password" /></td>
            <td><span class="error"><form:errors path="password" /></span></td>
        </tr>

        <tr>
            <td>Confirm Password:</td>
            <td><form:password path="confirmPassword" /></td>
            <td><span class="error"><form:errors
                    path="confirmPassword" /></span></td>
        </tr>

        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
            <td><span class="error"><form:errors path="name" /></span></td>
        </tr>

        <tr>
            <td>Email:</td>
            <td><form:input path="email" /></td>
            <td><span class="error"><form:errors path="email" /></span></td>
        </tr>

        <tr>
            <td>Phone:</td>
            <td><form:input path="phone" /></td>
            <td><span class="error"><form:errors path="phone" /></span></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>

<a href="index.html" title="Home">Home</a>
</body>
</html>