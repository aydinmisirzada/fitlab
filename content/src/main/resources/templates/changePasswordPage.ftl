<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page " | Change Password">
    <div style="height:7%"></div>
    <div class="container" id="cardSection">

        <div class="card mx-auto align-items-center" style="width: 25rem;">
            <div class="card-body">
                <form action="/users/password/change" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <input type="hidden" name="username" value="${name}"/>

                    <div class="form-group">
                        <input type="password" name="oldPassword" class="form-control" placeholder="Old Password"
                               id="oldpassword" required>
                    </div>
                    <div class="form-group">
                        <input type="password" name="newPassword" class="form-control" placeholder="Password" id="password"
                               required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Confirm Password" id="confirmPassword"
                               required/>
                    </div>
                    <button type="submit" class="btn btn-secondary" id="btnSubmit">Change</button>
                </form>
                <h3>${result}</h3>
            </div>
        </div>
    </div>


</@c.page>
