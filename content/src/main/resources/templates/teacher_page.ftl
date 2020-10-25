<#import "parts/common.ftl" as c>

<@c.page "FITLab | " + teacher.getName() + " " + teacher.getSurname()>
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
    </div>

</@c.page>