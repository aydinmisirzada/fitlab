<#import "parts/common.ftl" as c>

<@c.page "FITLab | Registraion">

    <div class="container" id="registrationSection">
        <div style="padding-top: 100px"></div>

        <div class="card mx-auto align-items-center" style="width: 18rem;">

            <div class="card-body">
                <h4 class="card-title text-center">Registration</h4>
                <h6 class="card-title text-center">It's quick and easy!</h6>
                <br/>
                <form action="/registration" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" name="name" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="surname" placeholder="Last Name">
                    </div>

                    <div class="form-group">
                        <input type="email" class="form-control" name="email" placeholder="Email">
                    </div>

                    <div class="form-group">
                        <input type="text" class="form-control" name="phone" placeholder="Phone">
                    </div>

                    <br/>

                    <div class="form-group">
                        <input type="text" class="form-control" name="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password"/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Confirm Password"/>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-secondary">Sign Up</button>
                        <br/>
                        <br/>
                        <small><a href="/login">Registered user? Log in.</a></small>
                    </div>

                </form>
            </div>
        </div>

    </div>



</@c.page>

<!---
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
--->