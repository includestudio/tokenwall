<!DOCTYPE html>
<#import "/spring.ftl" as spring />
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Token Wall</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Jerry">

    <link href="${requestContext.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
    <style>
        body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="${requestContext.contextPath}/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${requestContext.contextPath}/assets/js/html5.js"></script>
    <![endif]-->

</head>

<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Token Wall</a>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="active"><a href="${requestContext.contextPath}/welcome">Wall</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

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
            <td><input id="register" type="submit" name="register" value="Register" /></td>
        </tr>
    </table>
    <h4><@spring.showErrors "<br>"/></h4>
</form>
</div>

<script src="${requestContext.contextPath}/assets/assets/js/jquery.js"></script>
<script src="${requestContext.contextPath}/assets/assets/js/bootstrap-transition.js"></script>
<script src="${requestContext.contextPath}/assets/assets/js/bootstrap-alert.js"></script>
<script src="${requestContext.contextPath}/assets/assets/js/bootstrap-modal.js"></script>
<script src="${requestContext.contextPath}/assets/assets/js/bootstrap-dropdown.js"></script>
<script src="${requestContext.contextPath}/assets/assets/js/bootstrap-scrollspy.js"></script>
<script src="${requestContext.contextPath}/assets/assets/js/bootstrap-tab.js"></script>
<script src="${requestContext.contextPath}/assets/js/bootstrap-tooltip.js"></script>
<script src="${requestContext.contextPath}/assets/js/bootstrap-popover.js"></script>
<script src="${requestContext.contextPath}/assets/js/bootstrap-button.js"></script>
<script src="${requestContext.contextPath}/assets/js/bootstrap-collapse.js"></script>
<script src="${requestContext.contextPath}/assets/js/bootstrap-carousel.js"></script>
<script src="${requestContext.contextPath}/assets/js/bootstrap-typeahead.js"></script>

</body>
</html>
