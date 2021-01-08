<#import "parts/common.ftl" as c>

<@c.page " | " + teacher.getName() + " " + teacher.getSurname()>
    <div style="height:10%"></div>
    <div class="form-container" id="cardSection">
        <div class="card shadow m-0 col-md-4">
            <h5 class="mt-4"><b>Teacher Info</b></h5>

            <div class="row p-2 mt-4 border-top">
                <h5 class="col-md-4" >Name</h5>
                <div class="col-md-8 badge-right">
                    <span class="badge badge-info shadow-sm p-2 m-2">${teacher.getName() + ' ' + teacher.getSurname()}</span>
                </div>
            </div>

            <div class="row p-2 border-top">
                <h5 class="col-md-4">Username</h5>
                <div class="col-md-8 badge-right">                  <span class="badge badge-info shadow-sm p-2 m-2">${teacher.getUsername()}</span>
                </div>

                </h5>
            </div>
            <div class="row p-2 mb-4 border-top-bottom">
                <a href= "${'teachers/' + teacher.getId() + '/reviews'}" class="col-md-4 nav-link text-dark" style="font-size:18px; font-weight:600;">Reviews</a>
                <div class="col-md-8 badge-right">                  <span class="badge badge-info shadow-sm p-2 m-2">
          
          
            <#assign x = teacher.averageRating()>
                        <#if x != 0>
                            <#list 1..x as i>
                                &#9733;
                            </#list>
                        </#if>
                        <#list x..4 as i>
                            &#9734;
                        </#list>
          </span>
                </div>

                </h5>
            </div>
        </div>
    </div>
<#--  
    <div id="features" class="features-section">
        <div class="container text-center">
            <a style="font-size: 35px;"><td>${teacher.getName() + ' ' + teacher.getSurname()}</td></a>
            <br>
            <a style="font-size: 35px;"><td>${teacher.getUsername()}</td></a>
        </div>
    </div>

    <div id="hero-section">
        <div class="container text-center" >
            <a style="font-size: 35px;" href="${'/teachers/' + teacher.getId() + '/reviews'}">Reviews</a>

            <#assign x = teacher.averageRating()>
            <#if x != 0>
            <#list 1..x as i>
                <span>&#9733;</span>
            </#list>
            </#if>
            <#list x..4 as i>
                <span>&#9734;</span>
            </#list>
        </div>
    </div>  -->

</@c.page>