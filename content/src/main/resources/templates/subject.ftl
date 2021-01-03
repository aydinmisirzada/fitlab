<#import "parts/common.ftl" as c>
<#import "parts/form.ftl" as form>
<#include "parts/security.ftl">

<@c.page " | " + subject.getCode()>
    <div style="height:7%"></div>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8"><div class="container pb-4" id="cardSection">

                <div class="card col-md-12">
                    <div class="card-body">
                        <div class="row col-md-12">
                            <div class="col-md-4">
                                <h4>Subject Code </h4>
                            </div>
                            <div class="col-md-3" >
                                <h4><span class="badge bg-dark p-2">${subject.getCode()}</span></h4>
                            </div>
                            <div class="col" style="text-align: right">
                                <#if assigned == false>
                                    <form action="/subjects/${subject.getCode()}/addAssignment" method="post">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <div>
                                            <button type="submit" class="btn btn-primary">Add to My Subjects</button>
                                        </div>
                                    </form>
                                </#if>
                                <#if assigned == true>
                                    <form action="/subjects/${subject.getCode()}/delAssignment" method="post" class="mb-2">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <div class="mt-2 ml-4"><button type="submit" class="btn btn-secondary">Remove from My Subjects</button>
                                        </div>
                                    </form>
                                </#if>
                            </div>
                        </div>
                        <div class="row col-md-12 mt-2">
                            <div class="col-md-4">
                                <h4>Subject Name: </h4>
                            </div>
                            <div class="col-md-3">
                                <h4><span class="badge bg-dark p-2">${subject.getName()}</span></h4>
                            </div>
                        </div>


                        <div class="row">
                            <div class="col"><h4 class="mt-2 mb-2 ml-3">Description</h4></div>
                            <#if isAdmin>
                                <div class="col pr-3" style="text-align: right"><button  data-toggle="modal" data-target="#editDescription"  type="button" class="btn btn-primary mr-5">Edit description</button></div></#if>

                        </div>
                        <div class="p-2 ml-3" style="border: 1px solid #2e2e2e; border-radius: 10px">                    <p class="mb-2">${(subject.getDescription())!"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus orci mi, bibendum vel mattis at, pretium id neque. Aliquam suscipit rhoncus porttitor. Pellentesque dignissim, quam sit amet tempor facilisis, libero velit euismod risus, a mattis diam nibh vel magna. Nunc feugiat enim est, eu convallis nisi feugiat in. In mauris elit, interdum at mi placerat, dictum iaculis erat. Praesent non euismod nibh. Maecenas vulputate eleifend risus sit amet tristique. Donec malesuada libero a efficitur gravida. Curabitur sed rhoncus quam. Curabitur vitae finibus massa, sed maximus nibh. Mauris nec finibus tortor, vitae rutrum nisi. Aliquam in tempor tortor. Morbi luctus nulla ac euismod semper. In maximus nibh eu quam consectetur, id blandit diam tincidunt. Donec id aliquet nisl, ac tincidunt elit. Vivamus rhoncus lectus dolor, ac lobortis felis varius et."}</p>
                        </div>

                    </div>

                    <div class="modal fade" id="editDescription" tabindex="-1" aria-labelledby="editDescription" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Edit Description</h5>
                                    <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"><b>x</b></button>
                                </div>
                                <div class="modal-body">
                                    <div class="mb-2"><label>Current Description</label>
                                        <div class="p-2" style="border: 1px solid #2e2e2e; border-radius: 10px">                    <p class="mb-2">${(subject.getDescription())!"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus orci mi, bibendum vel mattis at, pretium id neque. Aliquam suscipit rhoncus porttitor. Pellentesque dignissim, quam sit amet tempor facilisis, libero velit euismod risus, a mattis diam nibh vel magna. Nunc feugiat enim est, eu convallis nisi feugiat in. In mauris elit, interdum at mi placerat, dictum iaculis erat. Praesent non euismod nibh. Maecenas vulputate eleifend risus sit amet tristique. Donec malesuada libero a efficitur gravida. Curabitur sed rhoncus quam. Curabitur vitae finibus massa, sed maximus nibh. Mauris nec finibus tortor, vitae rutrum nisi. Aliquam in tempor tortor. Morbi luctus nulla ac euismod semper. In maximus nibh eu quam consectetur, id blandit diam tincidunt. Donec id aliquet nisl, ac tincidunt elit. Vivamus rhoncus lectus dolor, ac lobortis felis varius et."}</p>
                                        </div></div>
                                    <form action="/subjects/${subject.getCode()}" method="post">
                                        <div class="form-group">
                                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                            <label for="description">Enter new description</label>
                                            <input type="text" id="description" class="form-control" name="description"
                                                   placeholder="Description">
                                        </div>
                                        <p style="color:red"> ${error}</p>
                                        <div class="mt-2">
                                            <button type="submit" class="btn btn-primary">Save description</button>
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                                        </div>

                                    </form>
                                </div>
                                <#--                        <div class="modal-footer">-->
                                <#--                            <button type="button" class="btn btn-primary">Save changes</button>-->
                                <#--                        </div>-->
                            </div>
                        </div>
                    </div>

                    <h4 class="ml-3 pl-3 mt-2 mb-2 pb-3">Study material for the subject</h4>
                    <div class="center">
                        <div class="btn-group text-center " role="group" aria-label="Basic outlined example">
                            <button class="btn btn-outline-primary"  type="button" data-toggle="collapse" data-target="#homeworkSection"
                                    aria-expanded="false" aria-controls="homeworkSection">Homeworks</button>
                            <button type="button" class="bt n btn-outline-primary" data-toggle="collapse" data-target="#testSection"
                                    aria-expanded="false" aria-controls="testSection">Tests</button>
                            <button type="button" class="btn btn-outline-primary" data-toggle="collapse" data-target="#examSection"
                                    aria-expanded="false" aria-controls="examSection">Exams</button>
                        </div>
                    </div>

                    <div class="collapse multi-collapse mb-2 mt-2" id="homeworkSection">
                        <div class="row mb-2">
                            <div class="col">
                                <label>List of homeworks</label>
                            </div>
                            <div class="col" style="text-align: right">
                                <button class="btn btn-outline-primary" type="button" data-toggle="modal" data-target="#addHomework" >Add Homework</button>
                            </div>
                        </div>
                        <div style="border: 1px solid #2e2e2e">

                            <ul class="list-group" id="myUL">
                                <#list contents as content>
                                    <#if content.type.toString() == 'HOMEWORK'>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <a href="${'/subjects/' + subject.getCode() + '/homework/' + content.getId()}"> ${content.getTitle()} </a>
                                            <@form.form_template path="/subjects/${subject.getCode()}" name = "id" value = "${content.getId()}" href=""/>

                                            <#--                                <span class="badge bg-primary rounded-pill">14</span>-->
                                        </li>
                                    </#if>
                                </#list>

                            </ul>

                        </div>

                        <div class="modal fade" id="addHomework" tabindex="-1" aria-labelledby="addHomework" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Add Homework</h5>
                                        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"><b>x</b></button>
                                    </div>
                                    <div class="modal-body">

                                        <form action="/subjects/${subject.getCode()}" method="post">
                                            <div class="form-group">
                                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                                <label for="hwTitle">Homework Title</label><br>
                                                <input type="text" name="title" id="hwTitle" placeholder="Title">
                                                <label for="hwDescription" style="visibility: hidden">Description</label>
                                                <input type="text" name="type" id="hwDescription" value="HOMEWORK" style="visibility: hidden">
                                            </div>
                                            <div class="mt-2">
                                                <button type="submit" class="btn btn-primary">Add Homework</button>
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/>
                    </div>


                    <div class="collapse multi-collapse" id="testSection">
                        <div class="row mb-2">
                            <div class="col">
                                <label>List of Tests</label>
                            </div>
                            <div class="col" style="text-align: right">
                                <button class="btn btn-outline-primary" type="button" data-toggle="modal" data-target="#addTest" >Add Test</button>
                            </div>
                        </div>
                        <div style="border: 1px solid #2e2e2e">


                            <ul class="list-group" id="myUL">
                                <#list contents as content>
                                    <#if content.type.toString() == 'TEST'>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <a href="${'/subjects/' + subject.getCode() + '/test/' + content.getId() }"> ${content.getTitle()} </a>
                                            <@form.form_template path="/subjects/${subject.getCode()}" name = "id" value = "${content.getId()}" href=""/>
                                        </li>
                                    </#if>
                                </#list>
                            </ul>
                        </div>

                        <div class="modal fade" id="addTest" tabindex="-1" aria-labelledby="addTest" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="addTestLabel">Add Test</h5>
                                        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"><b>x</b></button>
                                    </div>
                                    <div class="modal-body">

                                        <form action="/subjects/${subject.getCode()}" method="post">
                                            <div class="form-group">
                                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                                <label for="testTitle">Test Title</label>
                                                <input type="text" name="title" id="testTitle" placeholder="Title">
                                                <label for="testDescription" style="visibility: hidden">Description</label>
                                                <input type="text" name="type" id="testDescription" value="TEST" style="visibility: hidden">
                                            </div>
                                            <button type="submit" class="btn btn-secondary">Add test</button>
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <br/>

                    </div>

                    <div class="collapse multi-collapse" id="examSection">

                        <div class="row mb-2">
                            <div class="col">
                                <label>List of Exams</label>
                            </div>
                            <div class="col" style="text-align: right">
                                <button class="btn btn-outline-primary" type="button" data-toggle="modal" data-target="#addExam" >Add Exam</button>
                            </div>
                        </div>
                        <div style="border: 1px solid #2e2e2e">
                            <ul class="list-group" id="myUL">
                                <#list contents as content>
                                    <#if content.type.toString() == 'EXAM'>
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            <a href="${'/subjects/' +  subject.getCode() + '/exam/' + content.getId()}">${content.getTitle()} </a>
                                            <@form.form_template path="/subjects/${subject.getCode()}" name = "id" value = "${content.getId()}" href=""/>
                                        </li>
                                    </#if>
                                </#list>
                            </ul>
                        </div>

                        <div class="modal fade" id="addExam" tabindex="-1" aria-labelledby="addExam" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="addTestLabel">Add Exam</h5>
                                        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"><b>x</b></button>
                                    </div>
                                    <div class="modal-body">

                                        <form action="/subjects/${subject.getCode()}" method="post">
                                            <div class="form-group">
                                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                                <label for="examTitle">Title</label>
                                                <input type="text" name="title" id="examTitle" placeholder="Title">
                                                <label for="examDescription" style="visibility: hidden">Description</label>
                                                <input type="text" name="type" id="testDescription" value="EXAM" style="visibility: hidden">
                                            </div>
                                            <button type="submit" class="btn btn-secondary">Add exam</button>
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <br/>

                    </div>


                </div>

            </div></div>
        <div class="col-md-2"></div>
    </div>






</@c.page>

<!--



<div  class="adder">

 Add a Exam
<div class="container1" style="margin-left:10%;margin-right: 10%;margin-bottom: 20px;">
    <h3 style="text-align: center;">Exams</h3>

    <ul id="myUL">
        <#list contents as content>
            <#if content.type.toString() == 'EXAM'>
                <li><a href="${'/subjects/' +  subject.getCode() + '/exam/' + content.getId()}">
                        <td >
                            ${content.getTitle()}
                        </td>
                        <@form.form_template path="/subjects/${subject.getCode()}" name = "id" value = "${content.getId()}" href=""/>

                    </a>
                </li>
            </#if>
        </#list>
    </ul>



    <h4 style="text-align: center; margin: 10px;">Add an exam</h4>
    <div  class="adder">
        <form action="/subjects/${subject.getCode()}" method="post" >
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <table width="100%">
                <tr>
                    <td width="10%">
                        Add an exam:</td>
                    <td>
                        <input type="text"  name="title" placeholder="Title">
                    </td>
                </tr>
            </table>
            <input type="text"  name="type" value="EXAM" style="visibility: hidden">
            <button type="submit">Add a page</button>
        </form>
    </div>

-->