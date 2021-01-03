<#import "parts/common.ftl" as c>
<#import "parts/form.ftl" as form>
<#include "parts/security.ftl">
<@c.page " | Subjects">

    <div class="container" id="cardSection">

        <div style="padding-top: 100px"></div>

        <#list subject?chunk(3) as row>
            <div class="row">
                <#list row as s>
                    <#assign path>${s.getCode()}</#assign>
                    <div class="col-sm-4">
                        <div class="card shadow mb-5 bg-white rounded" style="width: 18rem;">
                            <#if isAdmin>
                                <div class="col-1 offset-11 pt-2">
                                    <button class="btn btn-secondary btn-sm" id="editButton" style="float: right">Edit
                                    </button>
                                </div>
                            </#if>
                            <div class="card-body">
                                <form action="/subjects" method="post">

                                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                    <input type="hidden" name="id" value="${s.getId()}"/>
                                    <div class="form-row mb-1">
                                        <input type="text" name="code" class="form-control myform editable pl-1"
                                               value="${s.getCode()}"
                                               spellcheck="false" style="font-size: 1.25rem; font-weight: 500;" readonly/>
                                    </div>
                                    <div class="form-row">
                                        <input type="text" name="name" class="form-control myform editable pl-1"
                                               value="${s.getName()}"
                                               spellcheck="false" readonly/>
                                    </div>
                                    <div class="form-row">
                                        <p class="card-text pl-1">Semester: ${s.getSemester()}</p>
                                        <#assign sem>${s.getSemester()}</#assign>
                                        <#if sem == "SUMMER">
                                            <input type="hidden" name="semester" class="form-control myform"
                                                   value="0"
                                                   spellcheck="false" readonly/>
                                        <#elseif sem == "WINTER">
                                            <input type="hidden" name="semester" class="form-control myform"
                                                   value="1"
                                                   spellcheck="false" readonly/>
                                        <#elseif sem == "WINTER_SUMMER">
                                            <input type="hidden" name="semester" class="form-control myform"
                                                   value="2"
                                                   spellcheck="false" readonly/>
                                        </#if>
                                    </div>

                                    <div class="form-row p-0" style="display: none" id="saveButton">
                                        <div class="col-4 offset-8 mb-2 p-0">
                                            <button class="btn btn-primary"  style="float: right;" > Save </button>
                                        </div>
                                    </div>

                                </form>

                                <@form.form_template path="/subjects" name = "id" value = "${s.getId()}" href ="subjects/${path}" />

                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </#list>

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
                                aria-controls="multiCollapseExample2">Add Subject
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <#list subject as s>
                                <#assign path>${s.getCode()}</#assign>
                                <a class="dropdown-item" href="subjects/${path}">${s.getCode()} ${s.getName()}</a>
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
                                <label for="subjectCode" class="col-sm-2 col-form-label">Enter Subject Code:</label>
                                <div class="col-sm-10">
                                    <input type="text" name="code" class="form-control" id="subjectCode">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="subjectName" class="col-sm-2 col-form-label">Enter Subject Name:</label>
                                <div class="col-sm-10">
                                    <input type="text" name="name" class="form-control" id="subjectName">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="subjectName" class="col-sm-2 col-form-label">Description:</label>
                                <div class="col-sm-10">
                                    <input type="text" name="description" class="form-control" id="description">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Select Semester:</label>
                                <div class="col-sm-10">
                                    <select name="semester" class="custom-select">
                                        <option value="SUMMER">Summer</option>
                                        <option value="WINTER">Winter</option>
                                        <option value="WINTER_SUMMER">ALL</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-primary">Add subject</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </#if>
    </div>
    <!-- /.container -->

    <script type="text/javascript">
        $("#editButton").on('click', function () {
            //enable editing mode
            if ($('.editable').attr("readonly")) {
                $('#saveButton').show();
                $('.editable').attr("readonly", false);
                $('.editable').css({'border-bottom':'1px solid grey','border-radius':'0'});
                $('#editButton').addClass('editMode');
            } else {
                $('.editable').attr("readonly", true);
                $('.editable').css('border', 'none transparent');
                $('#saveButton').hide();
                $('#editButton').removeClass('editMode');
            }
        });
    </script>
</@c.page>