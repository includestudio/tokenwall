<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h3>Register!</h3>
<div>
    <ul>
        <#if error??>
        <li id="error">${error}</li>
        </#if>
    </ul>
</div>
<form action="/tokenwall/register" method="post">
    <table>
        <tr>
            <td><label>User name:</label></td>
            <td><input id="username" type="text" name="username" /></td>
        </tr>
        <tr>
            <td><label>Password:</label></td>
            <td><input id="password" type="text" name="password" /></td>
        </tr>
        <tr>
            <td><label>Confirm:</label></td>
            <td><input id="confirm" type="text" name="confirm" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input id="register" type="submit" name="register" value="Register" /></td>
        </tr>
    </table>
</form>
</body>
</html>