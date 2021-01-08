<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    usertmp = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = usertmp.getUsername()
    pathId = usertmp.getPathId()
    isAdmin = usertmp.isAdmin()
    logged = true
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    logged = false
    pathId = "unknown"
    >
</#if>
