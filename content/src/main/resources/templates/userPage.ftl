<#import "parts/common.ftl" as c>

<@c.page>
    <br>    <br>
    <br>
    <br>
    <br>

    <form action="/userEdit" method="post">
        <div><label> User Name : <input type="text" name="username" value="${user.getUsername()}"/> </label></div>

        <div><label> Name : <input type="text" name="name" value="${user.getName()}"/> </label></div>
        <div><label> Sur Name : <input type="text" name="surname" value="${user.getSurname()}"/> </label></div>
        <div><label> Email: ${user.getEmail()} </label></div>
        <div><label> Phone: ${user.getPhone()} </label></div>
        <div><input type="submit" value="Save"/></div>
    </form>
</@c.page>