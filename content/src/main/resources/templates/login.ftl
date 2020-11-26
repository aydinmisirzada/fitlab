<#import "parts/common.ftl" as c>

<@c.page " | Log In">

    <div class="container" id="cardSection">

        <div class="card mx-auto align-items-center" style="width: 22rem;">

            <div class="card-body">
                <h4 class="card-title text-center">Welcome to FITLab!</h4>
                <br/>
                <form action="/login" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="form-group">
                        <input type="text" class="form-control" name="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password"/>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-secondary">Log In</button>
                        <br/>
                        <br/>
                        <small><a href="/registration">New to FITLab? Register.</a></small>
                    </div>
                </form>
            </div>
        </div>

    </div>

</@c.page>

<!--

    <br>    <br>
    <br>
    <br>
    <br>
<#--    <p >${error}</p>-->
    <form action="/login" method="post">
    <div><label> User Name : <input type="text" name="username" value="user" /> </label></div>
    <div><label> Password: <input type="password" name="password" value="u"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
<a href="/registration">Register new user</a><br>
<form action="/logout" method="post">
    <div><input type="submit" value="Sign out"/></div>
</form>


-->