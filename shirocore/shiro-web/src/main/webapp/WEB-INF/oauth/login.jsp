<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<body>
<h2>Hello World!</h2>
<form action="/authorize" method="post">
    <input type="text" name="username"/>
    <input type="text" name="password"/>
    <input type="text" name="client_id" value ="${param.client_id}"/>
    <input type="text" name="response_type" value ="${param.response_type}"/>
    <input type="text" name="redirect_uri" value ="${param.redirect_uri}"/>
    <input type="submit" value="确认授权"/>

</form>
</body>
</html>
