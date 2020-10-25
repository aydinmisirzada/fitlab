<#import "parts/common.ftl" as c>

<@c.page "| My profile">

    <div class="container" id="cardSection">
        <div style="padding-top: 100px"></div>
        <div class="row">

            <div class="col-4">
                <div class="card mx-auto align-items-center shadow p-3 mb-5 bg-white rounded">
                    <br/>
                    <img src="images/user.svg" style="max-height: 80px; max-width: 80px;">
                    <div class="card-body">

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
                            <br/>
                            <small class="form-text text-muted text-center pb-1">Click on field to edit it</small>
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
        $('#username').tooltip({'trigger':'hover focus', 'title': 'Username','placement':'left'});
        $('#email').tooltip({'trigger':'hover focus', 'title': 'Email','placement':'left'});
        $('#phone').tooltip({'trigger':'hover focus', 'title': 'Phone','placement':'left'});
        $('#path').tooltip({'trigger':'hover focus', 'title': 'Path ID','placement':'left'});
    </script>


</@c.page>


<!--

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