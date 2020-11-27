<#include "security.ftl">
<#macro navbar>
    <!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <img src="images/fitlab_logo.svg" style="max-height: 60px; max-width: 60px;">
            <a class="navbar-brand" href="/" style="margin-left: 20px;">FITLab</a>

            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                    data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                    aria-label="Toggle navigation">
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
                        <#if isAdmin>
                            <li class="nav-item">
                                <a class="nav-link" href="/users">Users</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/admin">Dashboard</a>
                            </li>
                        </#if>
                        <li class="nav-item dropdown pb-1">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${name}
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="/users/${pathId}">View profile</a>
                                <form action="/logout" method="post">
                                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                    <button class="dropdown-item">Log Out</button>
                                </form>
                            </div>
                        </li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>
</#macro>