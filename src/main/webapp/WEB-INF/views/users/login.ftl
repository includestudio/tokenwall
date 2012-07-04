<!DOCTYPE html>
<#import "/spring.ftl" as spring />
<html lang="en">
<head>
    <title>Register</title>
    <#include  "/common/head.ftl"/>
</head>
<body>
<#include  "/common/topNavbar.ftl"/>

<div class="container">
    <h3>Login with Username and Password, or <a href="${requestContext.contextPath}/users/register">register</a> one!</h3>

    <form name='f' action='${requestContext.contextPath}/j_spring_security_check' method='POST'>
        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='j_username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='j_password'/></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>