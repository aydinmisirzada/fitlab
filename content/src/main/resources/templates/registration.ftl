<#import "parts/common.ftl" as c>

<@c.page "FitLab registration">
    <br>    <br>
    <br>
    <br>
    <br>
    <form action="/registration" method="post">
        <h4>REGISTRATION</h4>
        <p >${error}</p>
        <div><label> Username : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>

        <div><label> Name : <input type="text" name="name" value="MUHA"/> </label></div>
        <div><label> Sur Name : <input type="text" name="surname" value="GAvrik"/> </label></div>
        <div><label> Email: <input type="email" name="email" value="a@a"/> </label></div>
        <div><label> Phone: <input type="text" name="phone" value="+3333333"/> </label></div>
        <div><input type="submit" value="Register"/></div>
    </form>
    <a href="/login">Log in</a>

</@c.page>