<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page " | Change Password">
    <div style="height:7%"></div>
    <div class="container" id="cardSection">

        <div class="card mx-auto align-items-center text-center" style="width: 25rem;">
            <div class="card-body">
                <h4 class="card-title">Change Password</h4>
                <form action="/users/password/change" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <input type="hidden" name="username" value="${name}"/>

                    <div class="form-group mt-5">
                        <input type="password" name="oldPassword" class="form-control" placeholder="Old Password"
                               id="oldpassword" required>
                    </div>
                    <div class="form-group">
                        <input type="password" name="newPassword" class="form-control" placeholder="Password"
                               id="password"
                               required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Confirm Password" id="confirmPassword"
                               required/>
                    </div>
                    <p class="invisible passStrength mb-1" style="font-size:0.9em;">Password strength: <span
                                id="strengthText"></span></p>
                    <div class="progress invisible passStrength">
                        <div class="progress-bar" role="progressbar" id="strengthMeter" aria-valuenow="0"
                             aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <p id="errorMessage" style="color:red"></p>
                    <button type="submit" class="btn btn-secondary" id="btnSubmit">Change</button>
                </form>
                <#if result=="false">
                    <p>An error occured. Please try again</p>
                </#if>

            </div>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
    <script type="text/javascript"> var password = $('#password');
        password.tooltip({'trigger': 'focus', 'title': 'Min. 8 characters', 'placement': 'top'});

        $(function () {
            $("#btnSubmit").click(function () {
                var password = $("#password").val();
                var confirmPassword = $("#confirmPassword").val();
                if (password.length < 8) {
                    $("#errorMessage").text("Your password should consist of at least 8 characters");
                    return false;
                }
                if (password != confirmPassword) {
                    $("#errorMessage").text("Passwords do not match");
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

        password.on('input', function () {

            var val = password.val();
            var result = zxcvbn(val);

            if (val !== "") {
                $('.passStrength').removeClass('invisible');
                $('#strengthText').html(strengthText[result.score]);
                meter.attr('aria-valuenow', strengthMeter[result.score]);
                meter.css('width', strengthMeter[result.score] + "%");
                meter.css('background-color', strengthMeterColor[result.score]);
            } else {
                $('.passStrength').addClass('invisible');
                $('#strengthText').html("");
            }
        });
        </script>


</@c.page>
