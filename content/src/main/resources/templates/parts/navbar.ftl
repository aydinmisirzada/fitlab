<#include "security.ftl">
<#macro navbar>
    <!-- Navigation -->
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg fixed-top shadow">
            <img src="/images/FITLabLogo.svg" style="max-height: 30px">
            <a class="navbar-brand mr-0" href="/">FITLab</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
                    aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/subjects">Subjects</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/teachers">Teachers</a>
                    </li>
                    <#if !logged>
                        <li class="nav-item active">
                            <a class="nav-link" href="/login"><span>Log In</span></a>
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
        </nav>
    </div>

</#macro>