<#import "parts/common.ftl" as c>

<@c.page "| Admin Dashboard">

    <div class="container" id="profileSection">
        <div style="padding-top: 100px"></div>
        <div class="row">
            <div class="col-4">
                <div class="card mx-auto align-items-center shadow p-3 mb-5 bg-white rounded">
                    <div class="card-body">
                        <h5 class="card-title">Users</h5>
                        <div class="list-group">
                            <a href="#" class="list-group-item list-group-item-action active">
                                Aydin
                            </a>
                            <a href="#" class="list-group-item list-group-item-action">Gleb</a>
                            <a href="#" class="list-group-item list-group-item-action">Karen</a>
                            <a href="#" class="list-group-item list-group-item-action">Zdenek</a>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-8">
                <div class="card mx-auto align-items-center shadow p-3 mb-5 bg-white rounded">
                    <div class="card-body">
                        <h5 class="card-title">Subjects</h5>
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
                                        <h5 class="card-title">BIE-AG1</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-4">

            </div>
            <div class="col-8">
                <div class="card mx-auto align-items-center shadow p-3 mb-5 bg-white rounded">
                    <div class="card-body">
                        <h5 class="card-title">Teachers</h5>
                        <div class="row">
                            <div class="col">
                                <div class="card shadow-sm p-1 mb-2 bg-white rounded">
                                    <div class="card-body">
                                        <h5 class="card-title">Zdenek Rybola</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card shadow-sm p-1 mb-2 bg-white rounded">
                                    <div class="card-body">
                                        <h5 class="card-title">Jan Travnicek</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

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