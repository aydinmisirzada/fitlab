<#include "security.ftl">
<#macro form_template path name value href>
    <form action=${path}  method="post">
        <div class="form-row p-0">
            <div class="col-8 p-0">
                <#if href?has_content>
                    <a href="${href}" class="btn btn-secondary">Learn More</a>
                </#if>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <#if isAdmin>
                <div class="col-4 p-0">
                    <button onclick="return confirm('Are you sure?')" class="btn btn-danger" style="float: right;">
                        Delete
                    </button>
                </div>
            </#if>
        </div>

        <input id="tmp" type="text" name="${name}" value="${value}" style="visibility: hidden;height: 0">
    </form>
</#macro>