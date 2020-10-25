<#import "parts/common.ftl" as c>
<#import "parts/form.ftl" as form>


<@c.page "FITLab | Subjects">

    <div class="container" id="cardSection">

        <div style="padding-top: 100px"></div>

        <#list subject?chunk(3) as row>
            <div class="row">
                <#list row as s>
                    <#assign path>${s.getCode()}</#assign>
                    <div class="col-sm-4">
                        <div class="card shadow p-3 mb-5 bg-white rounded" style="width: 18rem;">
                            <div class="card-body">
                                <h5 class="card-title">${s.getCode()}</h5>
                                <p class="card-text">${s.getName()}</p>
                                <p class="card-text">Semester: ${s.getSemester()}</p>
                                <@form.form_template path="/subjects" name = "id" value = "${s.getId()}" href ="subjects/${path}" />

                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </#list>


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
                            <label class="col-sm-2 col-form-label">Select Semester:</label>
                            <div class="col-sm-10">
                                <select name="semester" class="custom-select">
                                    <option value="SUMMER">Summer</option>
                                    <option value="WINTER">Winter</option>
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
    </div>
    <!-- /.container -->
</@c.page>