<#import "parts/common.ftl" as c>

<@c.page "| Admin Dashboard">

    <div class="container" id="cardSection">
        <div style="padding-top: 100px"></div>
        <div class="row">
            <!-- Requests -->
            <div class="col-3 card mx-auto align-items-center shadow p-1 bg-white rounded">

                <div class="card-body">
                    <h4 class="card-title">
                        Requests
                    </h4>
                    <p> @misirayd wants to add new homework</p>
                    <p> @yarovhli wants to add new homework</p>
                    <p> @akopikar wants to add new homework</p>
                </div>

            </div>

            <!-- Dashboard and statistics -->
            <div class="col-9 pl-5">
                <!-- Dashboard -->
                <div class="row">
                    <div class="card shadow w-100 p-1 bg-white rounded">

                        <div class="card-body">
                            <h4 class="card-title">
                                Dashboard
                            </h4>
                            <div class="card-deck">
                                <div class="card shadow-sm p-1 bg-white rounded">
                                    <a href="/subjects">
                                    <div class="card-body">
                                        <h6 class="card-title">
                                            Subjects
                                        </h6>
                                    </div>
                                    </a>
                                </div>
                                <div class="card shadow-sm p-1 bg-white rounded">
                                    <a href="/teachers">
                                    <div class="card-body">
                                        <h6 class="card-title">
                                            Teachers
                                        </h6>
                                    </div>
                                    </a
                                        >
                                </div>
                                <div class="card shadow-sm p-1 bg-white rounded">
                                    <a href="/users">
                                    <div class="card-body">
                                        <h6 class="card-title">
                                            Users
                                        </h6>
                                    </div>
                                    </a>
                                </div>
                                <div class="card shadow-sm p-1 bg-white rounded">
                                    <a href="/email">
                                    <div class="card-body">
                                        <h6 class="card-title">
                                            Email
                                        </h6>
                                    </div>
                                    </a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                <!-- Statistics -->
                <div class="row mt-5">
                    <div class="card shadow w-100 p-1 bg-white rounded">

                        <div class="card-body">
                            <h4 class="card-title">
                                Statistics
                            </h4>
                            <br/>
                            <h5>Usage</h5>
                            <label>Wednesday, October 28</label>
                            <div class="progress mb-2">
                                <div class="progress-bar" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">50%</div>
                            </div>
                            <label>Thursday, October 29</label>
                            <div class="progress mb-2">
                                <div class="progress-bar bg-warning" role="progressbar" style="width: 40%;" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100">40%</div>
                            </div>
                            <label>Friday, October 30</label>
                            <div class="progress">
                                <div class="progress-bar bg-success" role="progressbar" style="width: 77%;" aria-valuenow="77" aria-valuemin="0" aria-valuemax="100">77%</div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>

</@c.page>

