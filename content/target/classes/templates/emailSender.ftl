<#import "parts/common.ftl" as c>

<@c.page " | New Email">
    <div style="height:7%"></div>
    <div class="container" id="cardSection">
        <div class="card w-50 mx-auto">
            <div class="card-body">
                <div class="text-center"><h4 class="card-title">New Email</h4></div>
                <form action="/email/send" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="form-group">
                        <label for="selectTo">Send...</label>
                        <select id="selectTo" class="form-control form-control-sm" name="emailTo">
                            <option value="email">By email</option>
                            <option value="username">By username</option>
                            <option value="admin">To all admins</option>
                            <option selected value="all">To all users</option>
                        </select>
                        <div class="input-group mt-2 d-none" id="inputUsername">
                            <div class="input-group-prepend">
                                <div class="input-group-text">@</div>
                            </div>
                            <input type="text" class="form-control" name="username"
                                   placeholder="Username">
                        </div>
                        <input type="email" class="form-control mt-2 d-none" id="inputEmail" name="email" placeholder="Email">
                        <label for="Subject" class="mt-2">Mail Subject</label>
                        <input type="text" class="form-control" id="Subject" name="subject" placeholder="Subject">
                        <label for="exampleFormControlTextarea1">Enter your message</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="10"
                                  name="message"></textarea>
                    </div>
                    <button type="submit" class="btn btn-secondary" id="btnSubmit">Send email</button>
                </form>
            </div>
        </div>
    </div>
<script type="text/javascript">
    $('#selectTo').on('change', function() {
        if ($("#selectTo").val() == "email") {
            $("#inputEmail").removeClass("d-none");
            $("#inputUsername").addClass("d-none");
        } else if ($("#selectTo").val() == "username") {
            $("#inputUsername").removeClass("d-none");
            $("#inputEmail").addClass("d-none");
        } else {
            $("#inputUsername").addClass("d-none");
            $("#inputEmail").addClass("d-none");
        }
    });
</script>

</@c.page>