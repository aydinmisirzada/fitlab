<#import "parts/common.ftl" as c>

<@c.page " | Users">

    <div style="height:10%"></div>
    <div class="container" id="cardSection">
        <#list users?chunk(3) as row>
            <div class="row">
                <#list row as u>
                    <#assign path>${u.getPathId()}</#assign>
                    <div class="col-sm-4">
                        <div class="card shadow p-1 mb-5 bg-white rounded" style="width: 18rem;">
                            <img src="images/user.svg" class='mx-auto mt-3' style="max-height: 65px; max-width: 65px;">
                            <div class="card-body">
                                <h5 class="card-title">${u.getName()} ${u.getSurname()}</h5>
                                <p class="w-100">${u.getEmail()}</p>
                                <p>${u.getUsername()}</p>
                                <a class="btn btn-secondary" href="users/${path}">View</a>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </#list>
    </div>




</@c.page>

