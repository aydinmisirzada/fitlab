<#import "parts/common.ftl" as c>
<#import "parts/form.ftl" as form>
<#include "parts/security.ftl">

<@c.page " | Teachers">
    <div style="height:7%"></div>
    <div class="container" id="cardSection">
        <div class="input-group mb-4">
            <input type="text" class="form-control" id="searchTeachers" placeholder="Search Teachers">
        </div>
        <#if isAdmin>
            <!-- list of all subjects -->
            <div class="row" style="padding: 0 0 30px 0">
                <div class="col">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            View All
                        </button>
                        <button class="btn btn-primary" type="button" data-toggle="collapse"
                                data-target="#multiCollapseExample2" aria-expanded="false"
                                aria-controls="multiCollapseExample2">Add Teacher
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <#list teacher as t>
                                <#assign path>${t.getId()}</#assign>
                                <a class="dropdown-item" href="teachers/${path}">${t.getName()} ${t.getSurname()}</a>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>


            <!-- form -->

            <div class="row">
                <div class="col">
                    <div class="collapse multi-collapse" id="multiCollapseExample2">
                        <form method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <div class="form-group row">
                                <label for="subjectCode" class="col-sm-2 col-form-label">Enter Name:</label>
                                <div class="col-sm-10">
                                    <input type="text" name="name" class="form-control" id="teacherName">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="subjectName" class="col-sm-2 col-form-label">Enter Surname:</label>
                                <div class="col-sm-10">
                                    <input type="text" name="surname" class="form-control" id="teacherSurname">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="subjectName" class="col-sm-2 col-form-label">Enter username:</label>
                                <div class="col-sm-10">
                                    <input type="text" name="username" class="form-control" id="teacherUsername">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-primary">Add teacher</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </#if>
        <h3>All Teachers</h3>
        <#list teacher?chunk(3) as row>
            <div class="row">
                <#list row as t>
                    <#assign path>${t.getId()}</#assign>
                    <div class="col-sm-4">
                        <div class="card shadow p-0 mb-5 bg-white rounded" style="width: 18rem;">
                            <#if isAdmin>
                                <div class="col-1 offset-11 pt-2">
                                    <button class="btn btn-secondary btn-sm editButton" style="float: right">Edit
                                    </button>
                                </div>
                            </#if>
                            <div class="card-body">
                                <#if isAdmin>
                                <form action="/teachers" method="post">
                                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                    <input type="hidden" name="id" value="${t.getId()}"/>

                                    <div class="form-row" style="display:flex; flex-direction: row; justify-content: center; align-items: center">
                                        <div class="col">
                                            <input type="text" name="name" class="form-control myform editable pl-1"
                                                   value="${t.getName()}"
                                                   spellcheck="false" style="font-size: 1.25rem; font-weight: 500;"
                                                   readonly/>
                                        </div>
                                        <div class="col">
                                            <input type="text" name="surname" class="form-control myform editable pl-1"
                                                   value="${t.getSurname()}"
                                                   spellcheck="false" style="font-size: 1.25rem; font-weight: 500;"
                                                   readonly/>
                                        </div>
                                    </div>

                                    <div class="form-row" style="display:flex; flex-direction: row; justify-content: center; align-items: center">
                                        <div class="col-md-4">
                                            <label class="card-text pl-1" >username: </label>
                                        </div>
                                        <div class="col-md-8">
                                            <input type="text" name="username" class="form-control myform editable pl-1"
                                                   value="${t.getUsername()}"
                                                   spellcheck="false"
                                                   readonly/>
                                        </div>
                                    </div>

                                    <div class="form-row" style="display:flex; flex-direction: row; justify-content: center; align-items: center">
                                        <div class="col-md-4">
                                            <label class="card-text pl-1" >rating: </label>
                                        </div>

                                        <#if t.getReviewList()?size gt 2>
                                        <div class="col-md-6">
                                            <span <#assign x = t.averageRating()>
                                            <#if x != 0>
                                                <#list 1..x as i>
                                                    <span class="fa fa-star checked"></span>
                                                </#list>
                                            </#if>
                                            <#if x < 5>
                                                <#list x..4 as i>
                                                    <span class="fa fa-star"></span>
                                                </#list>
                                            </#if>
                                            </span>
                                        </div>
                                        <div class="col-md-2">
                                            ${t.averageRating()}
                                        </div>
                                        <#else>
                                            <div class="col-md-8">Not rated yet</div>
                                        </#if>
                                    </div>

                                    <div style="padding-top: 20px"></div>

                                    <div class="form-row p-0 mt-3 saveButton" style="display: none">
                                        <div class="col-4 offset-8 mb-2 p-0">
                                            <button class="btn btn-primary" style="float: right;"> Save</button>
                                        </div>
                                    </div>
                                </form>
                                <#else>
                                <h5 class="card-title">${t.getName()} ${t.getSurname()}</h5>
                                </#if>
                                <@form.form_template path="/teachers" name = "id" value = "${t.getId()}" href ="teachers/${path}" />
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </#list>
    </div>
    <!-- /.container -->
    <script type="text/javascript">
        $(".editButton").on('click', function () {
            //enable editing mode
            if ($('.editable').attr("readonly")) {
                $('.saveButton').show();
                $('.editable').attr("readonly", false);
                $('.editable').css({'border-bottom':'1px solid grey','border-radius':'0'});
                $('.editButton').addClass('editMode');
            } else {
                $('.editable').attr("readonly", true);
                $('.editable').css('border', 'none transparent');
                $('.saveButton').hide();
                $('.editButton').removeClass('editMode');
            }
        });

        function search() {
            var input, filter, i, txtValue;
            input = $('#searchTeachers');
            filter = input.val().toUpperCase();
            cards = $(".card");
            for (i = 0; i < cards.length; i++) {
                var name = $(cards[i]).find("input[name='name']").val();
                var surname = $(cards[i]).find("input[name='surname']").val();
                txtValue = name + surname;

                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    $(cards[i]).parent().css('display',"");
                } else {
                    $(cards[i]).parent().css('display',"none");
                }
            }
        }
        $('#searchTeachers').on('keyup',search);
    </script>

    <style>
        .checked {
            color: orange;
        }
    </style>
</@c.page>