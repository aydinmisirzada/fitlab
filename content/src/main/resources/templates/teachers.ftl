<#import "parts/common.ftl" as c>



<@c.page "FITLab | Teachers">

    <div class="container" id="subjectsSection">

        <div style="padding-top: 100px"></div>

        <#list teacher?chunk(3) as row>
            <div class="row">
                <#list row as t>
                    <#assign path>${t.getId()}</#assign>
                    <div class="col-sm-4">
                        <div class="card shadow p-3 mb-5 bg-white rounded" style="width: 18rem;">
                            <div class="card-body">
                                <h5 class="card-title">${t.getName()} ${t.getSurname()}</h5>
                                <form method="post" style="height:0;">
                                    <a href="teachers/${path}" class="btn btn-secondary">Learn More</a>
                                    <button type="submit" class="btn btn-danger" style="float: right;">Delete</button>
                                    <input type="text" name="id" value="${t.getId()}"
                                           style="visibility: hidden;height: 0">
                                </form>
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
    </div>
    <!-- /.container -->
</@c.page>