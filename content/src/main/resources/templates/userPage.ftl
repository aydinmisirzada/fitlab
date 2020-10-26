<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page " | "+ user.getUsername()>
    <div class="container" id="cardSection">
        <div style="padding-top: 100px"></div>
        <div class="row">

            <div class="col-4">
                <div class="card mx-auto align-items-center shadow p-3 mb-5 bg-white rounded" id="formCard">
                    <br/>
                    <img src="images/user.svg" style="max-height: 80px; max-width: 80px;">
                    <div class="card-body w-100">

                        <form action="/users/userEdit" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <input type="hidden" name="id" value="${user.getId()}"/>
                            <div class="form-row">
                                <div class="col">

                                    <input type="text" name="name" class="form-control myform nameform"
                                           value="${user.getName()}"
                                           spellcheck="false" style="text-align: right;"/>
                                </div>
                                <div class="col">
                                    <input type="text" name="surname" class="form-control myform nameform"
                                           value="${user.getSurname()}" spellcheck="false"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <input type="text" id="username" class="form-control myform" name="username"
                                           value="${user.getUsername()}" style="text-align: center">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <input type="text" id="email" class="form-control myform" name="email"
                                           value="${user.getEmail()}" style="text-align: center" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <input type="text" id="phone" class="form-control myform" name="phone"
                                           value="${user.getPhone()}" style="text-align: center" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <input type="text" id="path" class="form-control myform" name="pathId"
                                           value="${user.getPathId()}" style="text-align: center">
                                </div>
                            </div>
<#--                            <#if isAdmin>-->
                            <div class="form-row" <#if !isAdmin> hidden </#if> >
                                <div class="col" style="text-align: center">
                                    <input type="checkbox" class="form-check-input" id="userRole" name="userRole" <#if user.isAdmin()>checked</#if>>
                                    <label class="form-check-label" for="userRole">Admin</label>
                                </div>
                            </div>
<#--                            </#if>-->
                            <br/>
                            <small class="form-text text-muted text-center pb-1">Click on field to edit it</small>
                            <#if error = 1>
                                <p class="text-center" style="color: #ff0000;">This URL is already in use!</p>
                            <#elseif error = 2>
                                <p class="text-center" style="color: #ff0000;">This username is already in use!</p>
                            </#if>
                            <div class="form-row">
                                <div class="col">
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-secondary">Save</button>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>

                </div>
            </div>
            <div class="col-8">
                <div class="card mx-auto align-items-center shadow p-3 mb-5 bg-white rounded">
                    <div class="card-body">
                        <h5 class="card-title">My Subjects</h5>
                        <div class="row">
                            <div class="col">
                                <div class="card shadow-sm p-1 mb-2 bg-white rounded">
                                    <div class="card-body">
                                        <h5 class="card-title">BIE-SI1</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm p-1 mb-2 bg-white rounded">
                                    <div class="card-body">
                                        <h5 class="card-title">BIE-SP1</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm p-1 mb-2 bg-white rounded">
                                    <div class="card-body">
                                        <h5 class="card-title">BIE-SP2</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm p-1 mb-2 bg-white rounded">
                                    <div class="card-body">
                                        <h5 class="card-title">BIE-PA1</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm p-1 mb-2 bg-white rounded">
                                    <div class="card-body">
                                        <h5 class="card-title">BIE-OSY</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script>
        $('#username').tooltip({'trigger': 'manual', 'title': 'Username', 'placement': 'left'}).tooltip('show');
        $('#email').tooltip({'trigger': 'manual', 'title': 'Email', 'placement': 'left'}).tooltip('show');
        ;
        $('#phone').tooltip({'trigger': 'manual', 'title': 'Phone', 'placement': 'left'}).tooltip('show');
        ;
        $('#path').tooltip({trigger: 'manual', title: 'URL', placement: 'left'}).tooltip('show');
        ;
    </script>


</@c.page>


<!--

no error 0
url exist 1
username exist 2

reguitration: 0 no error 3 username exist 4 email exist
    <p >${error}</p>
    <form action="/users/userEdit" method="post">
        <div><label> User Name : <input type="text" name="username" value="${user.getUsername()}"/> </label></div>

        <div><label> Name : <input type="text" name="name" value="${user.getName()}"/> </label></div>
        <div><label> Sur Name : <input type="text" name="surname" value="${user.getSurname()}"/> </label></div>
        <div><label> Personal URL : <input type="text" name="pathId" value="${user.getPathId()}"/> </label></div>
        <div><label> Email: <input type="text"  name="email" value="${user.getEmail()}" readonly/> </label></div>
        <div><label> Phone: <input type="text" name="phone" value="${user.getPhone()}" readonly/> </label></div>
        <div><input type="submit" value="Save"/></div>
    </form>

-->