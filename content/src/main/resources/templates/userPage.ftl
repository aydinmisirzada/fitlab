<#import "parts/common.ftl" as c>

<@c.page>
    <br>    <br>
    <br>
    <br>
    <br>

    <p >${error}</p>
    <form action="/users/userEdit" method="post">
        <div><label> User Name : <input type="text" name="username" value="${user.getUsername()}"/> </label></div>

        <div><label> Name : <input type="text" name="name" value="${user.getName()}"/> </label></div>
        <div><label> Sur Name : <input type="text" name="surname" value="${user.getSurname()}"/> </label></div>
        <div><label> Personal URL : <input type="text" name="pathId" value="${user.getPathId()}"/> </label></div>
        <div><label> Email: <input type="text"  name="email" value="${user.getEmail()}" readonly/> </label></div>
        <div><label> Phone: <input type="text" name="phone" value="${user.getPhone()}" readonly/> </label></div>
        <div><input type="submit" value="Save"/></div>
    </form>
</@c.page>