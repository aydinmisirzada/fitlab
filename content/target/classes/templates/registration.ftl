<#import "parts/common.ftl" as c>

<@c.page " | Registration">
    <div style="height:7%"></div>
    <div class="container" id="cardSection">

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
                    <p class="invisible passStrength mb-1" style="font-size:0.9em;">Password strength: <span id="strengthText"></span></p>
                    <div class="progress invisible passStrength">
                        <div class="progress-bar" role="progressbar" id="strengthMeter" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
    <script type="text/javascript">
        var password = $('#password');
        password.tooltip({'trigger':'focus','title': 'Min. 8 characters', 'placement': 'top'});

        $(function () {
            $("#btnSubmit").click(function () {
                var password = $("#password").val();
                var confirmPassword = $("#confirmPassword").val();
                if (password.length < 8) {
                    $( "#errorMessage" ).text( "Your password should consist of at least 8 characters" );
                    return false;
                }
                if (password != confirmPassword) {
                    $( "#errorMessage" ).text( "Passwords do not match" );
                    return false;
                }
                return true;
            });
        });

        var strengthText = {
            0: "Bad",
            1: "Weak",
            2: "Normal",
            3: "Good",
            4: "Strong"
        }

        var strengthMeter = {
            0: "20",
            1: "40",
            2: "60",
            3: "80",
            4: "100"
        }

        var strengthMeterColor = {
            0: "#ff1100",
            1: "#ff5b14",
            2: "#ffc619",
            3: "#00de90",
            4: "#27b500"
        }


        var meter = $('#strengthMeter');
        var text = $('#strengthText');

        password.on('input', function() {

            var val = password.val();
            var result = zxcvbn(val);

            if (val !== "") {
                $('.passStrength').removeClass('invisible');
                $('#strengthText').html(strengthText[result.score]);
                meter.attr('aria-valuenow',strengthMeter[result.score]);
                meter.css('width',strengthMeter[result.score]+"%");
                meter.css('background-color',strengthMeterColor[result.score]);
            } else {
                $('.passStrength').addClass('invisible');
                $('#strengthText').html("");
            }
        });


    </script>

</@c.page>
