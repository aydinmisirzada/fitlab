<#import "parts/common.ftl" as c>

<@c.page " | Change Password">
    <div style="height:7%"></div>
    <div class="container" id="cardSection">

        <div class="card mx-auto align-items-center" style="width: 25rem;">

            <div class="card-body">
                <form action="/registration" method="post">
                    <div class="form-group">
                        <input type="password" name="oldpassword" class="form-control" placeholder="Old Password" id="oldpassword" required>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password" id="password" required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Confirm Password" id="confirmPassword" required/>
                    </div>
                    <button type="submit" class="btn btn-secondary" id="btnSubmit">Change</button>
                </form>
            </div>
        </div>

    </div>


</@c.page>
