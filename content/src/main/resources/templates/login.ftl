<#import "parts/common.ftl" as c>

<@c.page "FitLab login">
    <br>    <br>
    <br>
    <br>
    <br>

    <form action="/login" method="post">
    <div><label> User Name : <input type="text" name="username" value="user" /> </label></div>
    <div><label> Password: <input type="password" name="password" value="u"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
<a href="/registration">Register new user</a><br>
<form action="/logout" method="post">
    <div><input type="submit" value="Sign out"/></div>
</form>
</@c.page>