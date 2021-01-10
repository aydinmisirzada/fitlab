<#import "parts/common.ftl" as c>

<@c.page " | " + teacher.getName() + " " + teacher.getSurname()>
    <div style="height:7%"></div>
    <div id="cardSection" class="container">
        <div class="card shadow mx-auto w-50">
            <div class="card-body">
                <h5 class="mt-4"><b>Teacher Info</b></h5>

                <div class="row p-2 mt-4 border-top">
                    <h5 class="col-md-4">Name</h5>
                    <div class="col-md-8 badge-right">
                        <span class="badge shadow-sm p-2 m-2" style="background-color: #367CF6; color:white;">${teacher.getName() + ' ' + teacher.getSurname()}</span>
                    </div>
                </div>

                <div class="row p-2 border-top">
                    <h5 class="col-md-4">Username</h5>
                    <div class="col-md-8 badge-right">
                        <span class="badge shadow-sm p-2 m-2" style="background-color: #367CF6; color:white;">${teacher.getUsername()}</span>
                    </div>

                    </h5>
                </div>
                <div class="row p-2 mb-4 border-top-bottom">
                    <a href="${'teachers/' + teacher.getId() + '/reviews'}" class="col-md-4 nav-link text-dark"
                       style="font-size:18px; font-weight:600;">Reviews</a>
                    <div class="col-md-8 badge-right">
                        <span class="badge shadow-sm p-2 m-2" style="background-color: #367CF6; color:white;">

                <#if teacher.getReviewList()?size gt 0>
                <#assign x = teacher.averageRating()>
                            <#if x != 0>
                                <#list 1..x as i>
                                    &#9733;
                                </#list>
                            </#if>
                            <#if x < 5>
                                <#list x..4 as i>
                                    &#9734;
                                </#list>
                            </#if>
                        </span>
                        <#else>
                            Not rated yet
                        </#if>
                    </div>

                    </h5>
                </div>
            </div>
        </div>
    </div>
</@c.page>