<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Login</h3>
<hr/>
<form name="loginForm" action="doLogin.html" method="POST" modelAttribute="user" method="post">
    <input type="hidden" name="command" value ="login"/>
    Login:<br/>
    <input type="text" name="login" value =""> <br/>
    Password:<br/>
    <input type="password" name ="password" value="">
    <br/>
    <input type ="submit" value="Sign In"/>
</form>
<a href="signup.html"><button>Sign Up</button></a>
<hr/>
</body>
</html>