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

    <div>
        <ul>
            <#if error??>
                <li id="error">${error}</li>
            </#if>
        </ul>
    </div>
    <form action="${requestContext.contextPath}/users/register" method="post">
        <table>
            <tr>
                <td><label>User name:</label></td>
                <td><@spring.formInput "command.username"/></td>
            </tr>
            <tr>
                <td><label>Password:</label></td>
                <td><@spring.formInput "command.password"/></td>
            </tr>
            <tr>
                <td><label>Confirm:</label></td>
                <td><@spring.formInput "command.passwordConfirm"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input id="register" type="submit" name="register" value="Register"/></td>
            </tr>
        </table>
        <h4><@spring.showErrors "<br>"/></h4>
    </form>
</div>

</body>
</html>
