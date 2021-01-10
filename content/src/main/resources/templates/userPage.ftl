<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page " | "+ user.getUsername()>
    <div style="height:10%"></div>
    <div class="container" id="cardSection">
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
                                <div class="col pt-2">
                                    <label class="my-auto" for="username"><span class="text-muted">Username</span></label>
                                </div>
                                <div class="col">
                                    <input type="text" id="username" class="form-control myform editable"
                                           name="username"
                                           value="${user.getUsername()}" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col pt-2">
                                    <label class="my-auto" for="email"><span class="text-muted">Email</span></label>
                                </div>
                                <div class="col">
                                    <input type="text" id="email" class="form-control myform" name="email"
                                           value="${user.getEmail()}" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col pt-2">
                                    <label class="my-auto" for="phone"><span class="text-muted">Phone</span></label>
                                </div>
                                <div class="col">
                                    <input type="text" id="phone" class="form-control myform" name="phone"
                                           value="${user.getPhone()}" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col pt-2">
                                    <label class="my-auto" for="path"><span class="text-muted">URL</span></label>
                                </div>
                                <div class="col">
                                    <input type="text" id="path" class="form-control myform editable" name="pathId"
                                           value="${user.getPathId()}" readonly>
                                </div>
                            </div>
                            <div class="form-row" id="isAdmin" style="display: none;" <#if !isAdmin> hidden </#if> >
                                <div class="col" style="text-align: center">
                                    <input type="checkbox" class="form-check-input"  id="userRole" name="userRole"
                                           <#if user.isAdmin()>checked </#if> disabled>
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
                                        <button type="submit" class="btn btn-primary" id="saveButton"
                                                style="visibility: hidden">Save
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <#if name==user.getUsername()>
                            <div class="text-center">
                                <small><a href="/users/password">Change Password</a></small>
                            </div>
                        </#if>
                    </div>

                </div>
            </div>
            <div class="col-8">
                <div class="card mx-auto align-items-center shadow p-3 mb-5 bg-white rounded">
                    <div class="card-body">
                        <h5 class="card-title">My Subjects</h5>
                        <div class="row">
                            <#list user.getSubjects() as subject>
                            <div class="col">
                                <div class="card shadow-sm p-1 mb-2 bg-white rounded">
                                    <div class="card-body">
                                        <h5 class="card-title">${subject.getName()}</h5>
                                    </div>
                                </div>
                            </div>
                                <div>
                                    <form action="/users/${user.getPathId()}" method="post">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <input type="hidden" name="id" value="${subject.getId()}">
                                        <button type="submit" class="btn btn-secondary">del</button>
                                    </form>
                                </div>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script>
        $("#editButton").on('click', function () {
            //enable editing mode
            if ($('.nameform').attr("readonly")) {
                $('#saveButton').css('visibility', 'visible');
                $('.editable').attr("readonly", false);
                $('input[name="userRole"]').attr("disabled", false);
                $('.editable').css({'border-bottom': '1px solid grey', 'border-radius': '0'});
                $('.nameform').css({'font-weight': 'normal', 'padding-left': '10px', 'margin-left': '10px'});
                $('input[name="name"]').css('text-align', 'left');
                $('#isAdmin').css('display', '');
                $('#editButton').addClass('editMode');
            } else {
                $('.editable').attr("readonly", true);
                $('input[name="userRole"]').attr("disabled", true);
                $('.editable').css('border', 'none transparent');
                $('.nameform').css({'font-weight': '600', 'padding-left': '0', 'margin-left': '0'});
                $('#saveButton').css('visibility', 'hidden');
                $('input[name="name"]').css('text-align', 'right');
                $('#isAdmin').css('display', 'none');
                $('#editButton').removeClass('editMode');
            }
        });


    </script>


</@c.page>
