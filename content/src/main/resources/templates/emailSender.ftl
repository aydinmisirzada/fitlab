<#import "parts/common.ftl" as c>

<@c.page " | Dashboard">
    </br>
    </br>
    </br>
    <form action="/email/send" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="container">
<#--            <h5>${result}</h5>-->
            <select class="form-control form-control-sm" name="emailTo">
                <option value="email">By email</option>
                <option value="username">By username</option>
                <option value="admin">All ADMIN</option>
                <option selected value="all">All USERS</option>
            </select>
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-text">@</div>
                </div>
                <input type="text" class="form-control" id="inlineFormInputGroupUsername" name="username"placeholder="Username">
            </div>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail" name="email" placeholder="Email">
            </div>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="Subject" name="subject" placeholder="Subject">
            </div>
            <div class="form-group">
                <label for="exampleFormControlTextarea1" >Example textarea</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="15" name="message"></textarea>
            </div>
            <button type="submit" class="btn btn-secondary" id="btnSubmit">Send email</button>
        </div>
    </form>

</@c.page>