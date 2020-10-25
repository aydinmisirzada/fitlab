<#macro form_template path name value href>
    <form action=${path}  method="post">

        <#if href?has_content>
            <a href="${href}" class="btn btn-secondary">Learn More</a>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button onclick="return confirm('Are you sure?')"  class="btn btn-danger" style="float: right;">Delete</button>
        <input id="tmp" type="text"  name="${name}" value="${value}" style="visibility: hidden;height: 0" >
    </form>
</#macro>

