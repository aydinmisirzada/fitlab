<#import "parts/common.ftl" as c>

<@c.page " | Registraion">

    <div class="container" id="cardSection">
        <div style="padding-top: 100px"></div>

        <div class="card mx-auto align-items-center" style="width: 25rem;">

            <div class="card-body">
                <h4 class="card-title text-center">Registration</h4>
                <h6 class="card-title text-center">It's quick and easy!</h6>
                <br/>
                <form action="/registration" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="form-group">
                        <input type="text" class="form-control" name="name" placeholder="Name" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="surname" placeholder="Last Name" required>
                    </div>

                    <div class="form-group">
                        <input type="email" class="form-control" name="email" placeholder="Email" required>
                    </div>

                    <div class="form-group">
                        <input type="text" class="form-control" name="phone" placeholder="Phone" required>
                    </div>

                    <br/>

                    <div class="form-group">
                        <input type="text" class="form-control" name="username" placeholder="Username" required>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password" id="password" required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Confirm Password" id="confirmPassword" required/>
                    </div>
                    <div class="text-center">
                        <p id="errorMessage" style="color:red"></p>
                        <#if error = 3>
                            <p class="text-center" style="color: #ff0000;">This username is already in use!</p>
                        <#elseif error = 4>
                            <p class="text-center" style="color: #ff0000;">This email is already in use!</p>
                        </#if>
                        <button type="submit" class="btn btn-secondary" id="btnSubmit">Sign Up</button>
                        <br/>
                        <br/>
                        <small><a href="/login">Registered user? Log in.</a></small>
                    </div>

                </form>
            </div>
        </div>

    </div>

    <script type="text/javascript">
        $(function () {
            $("#btnSubmit").click(function () {
                var password = $("#password").val();
                var confirmPassword = $("#confirmPassword").val();
                if (password != confirmPassword) {
                    $( "#errorMessage" ).text( "Passwords do not match" );
                    return false;
                }
                return true;
            });
        });
    </script>

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