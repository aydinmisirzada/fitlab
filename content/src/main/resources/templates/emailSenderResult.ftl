<#import "parts/common.ftl" as c>

<@c.page " | Email">
    <div style="height:7%"></div>
    <div class="container" id="cardSection">
        <div class="card mx-auto align-items-center" style="width: 22rem;">
            <div class="card-body text-center">
                <#if result=="false">
                    <i class="fa fa-times-circle" style="font-size: 2.5em"></i>
                    <p class="mt-3">Your email has not been sent</p>
                <#else>
                    <i class="fa fa-check-circle" style="font-size: 2.5em"></i>
                    <p class="mt-3">Your email has been sent</p>
                </#if>
            </div>
        </div>
    </div>
</@c.page>