<#include "security.ftl">
<#macro navbar>
<!-- Navigation -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
           <img src="images/fitlab_logo.svg" style="max-height: 60px; max-width: 60px;">
           <a class="navbar-brand" href="/" style="margin-left: 20px;">FITLab</a>

        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/subjects">Subjects</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/teachers">Teachers</a>
                </li>
                <#if !logged>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Log In</a>
                    </li>
                <#else>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Log Out, ${name}</a>
                    </li>
                </#if>
            </ul>
        </div>
    </div>
</nav>
</#macro>