<#import "parts/common.ftl" as c>

<@c.page "FITLab | All users">
    <#list users as u>
        <#assign path>${u.getPathId()}</#assign>
        <a class="dropdown-item" href="users/${path}">${u.getUsername()} ${u.getEmail()}</a>
    </#list>
</@c.page>