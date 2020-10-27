<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page " | "+ user.getUsername()>
    <div class="container" id="cardSection">
        <div style="padding-top: 100px"></div>
        <div class="row">

            <div class="col-4">
                <div class="card mx-auto align-items-center shadow mb-5 bg-white rounded" id="formCard">
                    <button class="btn btn-secondary ml-auto m-2" id="editButton">Edit</button>
                    <br/>
                    <img src="images/user.svg" style="max-height: 80px; max-width: 80px;">
                    <div class="card-body w-100">

                        <form action="/users/userEdit" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <input type="hidden" name="id" value="${user.getId()}"/>

                            <div class="form-row mb-1">
                                <div class="col">

                                    <input type="text" name="name" class="form-control myform nameform editable"
                                           value="${user.getName()}"
                                           spellcheck="false" style="text-align: right;" readonly/>
                                </div>
                                <div class="col">
                                    <input type="text" name="surname" class="form-control myform nameform editable"
                                           value="${user.getSurname()}" spellcheck="false" readonly/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <input type="text" id="username" class="form-control myform editable" name="username"
                                           value="${user.getUsername()}" style="text-align: center" readonly>
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
                                    <input type="text" id="path" class="form-control myform editable" name="pathId"
                                           value="${user.getPathId()}" style="text-align: center" readonly>
                                </div>
                            </div>
                            <div class="form-row" <#if !isAdmin> hidden </#if> >
                                <div class="col" style="text-align: center">
                                    <input type="checkbox" class="form-check-input" id="userRole" name="userRole"
                                           <#if user.isAdmin()>checked </#if> >
                                    <label class="form-check-label" for="userRole">Admin</label>
                                </div>
                            </div>

                            <br/>

                            <#if error = 1>
                                <p class="text-center" style="color: #ff0000;">This URL is already in use!</p>
                            <#elseif error = 2>
                                <p class="text-center" style="color: #ff0000;">This username is already in use!</p>
                            </#if>
                            <div class="form-row">
                                <div class="col">
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary" id="saveButton" style="visibility: hidden">Save</button>
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

            $("#editButton").on('click',function(){
                //enable editing mode
                if ($('.nameform').attr("readonly")) {
                    $('#saveButton').css('visibility','visible');
                    $('.editable').attr("readonly",false);
                    $('.editable').css('border','1px solid grey');
                    $('.nameform').css({'font-weight':'normal','padding-left':'10px','margin-left':'10px'});
                    $('input[name="name"]').css('text-align','left');
                    $('#editButton').addClass('editMode');
                } else {
                    $('.editable').attr("readonly",true);
                    $('.editable').css('border','none transparent');
                    $('.nameform').css({'font-weight':'600','padding-left':'0','margin-left':'0'});
                    $('#saveButton').css('visibility','hidden');
                    $('input[name="name"]').css('text-align','right');
                    $('#editButton').removeClass('editMode');
                }
            });



        $('#username').tooltip({'trigger': 'manual', 'title': 'Username', 'placement': 'left'}).tooltip('show');
        $('#email').tooltip({'trigger': 'manual', 'title': 'Email', 'placement': 'left'}).tooltip('show');
        ;
        $('#phone').tooltip({'trigger': 'manual', 'title': 'Phone', 'placement': 'left'}).tooltip('show');
        ;
        $('#path').tooltip({trigger: 'manual', title: 'URL', placement: 'left'}).tooltip('show');
        ;
    </script>


</@c.page>
