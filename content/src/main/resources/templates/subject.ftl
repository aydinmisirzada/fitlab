<#import "parts/common.ftl" as c>
<#import "parts/form.ftl" as form>
<#include "parts/security.ftl">

<@c.page " | " + subject.getCode()>

    <div class="container" id="cardSection">
        <div style="padding-top: 100px"></div>
        <div class="card mx-auto" style="width: 60%">
            <div class="card-body mx-auto">
                <h3 class="card-title text-center">${subject.getCode()}</h3>
                <h5 class="card-title text-center">${subject.getName()}</h5>
                <p class="text-center">${(subject.getDescription())!"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus orci mi, bibendum vel mattis at, pretium id neque. Aliquam suscipit rhoncus porttitor. Pellentesque dignissim, quam sit amet tempor facilisis, libero velit euismod risus, a mattis diam nibh vel magna. Nunc feugiat enim est, eu convallis nisi feugiat in. In mauris elit, interdum at mi placerat, dictum iaculis erat. Praesent non euismod nibh. Maecenas vulputate eleifend risus sit amet tristique. Donec malesuada libero a efficitur gravida. Curabitur sed rhoncus quam. Curabitur vitae finibus massa, sed maximus nibh. Mauris nec finibus tortor, vitae rutrum nisi. Aliquam in tempor tortor. Morbi luctus nulla ac euismod semper. In maximus nibh eu quam consectetur, id blandit diam tincidunt. Donec id aliquet nisl, ac tincidunt elit. Vivamus rhoncus lectus dolor, ac lobortis felis varius et."}</p>
                <#if isAdmin>
                <form action="/subjects/${subject.getCode()}" method="post">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <label for="description">Description</label>
                        <input type="text" id="description" class="form-control" name="description"
                               placeholder="Type here">
                    </div>
                    <p style="color:red"> ${error}</p>
                    <button type="submit" class="btn btn-secondary ">Edit description</button>

                </form>
                </#if>
                <a href= "${'subjects/' + subject.getCode() + '/reviews'}" class="col-md-4 nav-link text-dark" style="font-size:18px; font-weight:600;">Reviews</a>

                <#if assigned == false>
                <form action="/subjects/${subject.getCode()}/addAssignment" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-secondary">Assign for this subject</button>
                </form>
                </#if>
                <#if assigned == true>
                    <form action="/subjects/${subject.getCode()}/delAssignment" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-secondary">Unassign for this subject</button>
                    </form>
                </#if>
                <br/>
                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#homeworkSection"
                        aria-expanded="false" aria-controls="homeworkSection">Homeworks
                </button>
                <div class="collapse multi-collapse" id="homeworkSection">
                    <ul id="myUL">
                        <#list contents as content>
                            <#if content.type.toString() == 'HOMEWORK'>
                                <li><a href="${'/subjects/' + subject.getCode() + '/homework/' + content.getId()}">
                                        <td>
                                            ${content.getTitle()}
                                        </td>
                                        <@form.form_template path="/subjects/${subject.getCode()}" name = "id" value = "${content.getId()}" href=""/>
                                    </a>
                                </li>
                            </#if>
                        </#list>
                    </ul>
                    <form action="/subjects/${subject.getCode()}" method="post">
                        <div class="form-group">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <label for="hwTitle">Title</label>
                            <input type="text" name="title" id="hwTitle" placeholder="Title">
                            <label for="hwDescription" style="visibility: hidden">Description</label>
                            <input type="text" name="type" id="hwDescription" value="HOMEWORK" style="visibility: hidden">
                        </div>
                        <button type="submit" class="btn btn-secondary">Add homework</button>
                    </form>
                    <br/>

                </div>
                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#testSection"
                        aria-expanded="false" aria-controls="testSection">Tests
                </button>
                <div class="collapse multi-collapse" id="testSection">
                    <ul id="myUL">
                        <#list contents as content>
                            <#if content.type.toString() == 'TEST'>
                                <li><a href="${'/subjects/' + subject.getCode() + '/test/' + content.getId() }">
                                        <td>
                                            ${content.getTitle()}
                                        </td>
                                        <@form.form_template path="/subjects/${subject.getCode()}" name = "id" value = "${content.getId()}" href=""/>
                                    </a>
                                </li>
                            </#if>
                        </#list>
                    </ul>
                    <form action="/subjects/${subject.getCode()}" method="post">
                        <div class="form-group">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <label for="testTitle">Title</label>
                            <input type="text" name="title" id="testTitle" placeholder="Title">
                            <label for="testDescription" style="visibility: hidden">Description</label>
                            <input type="text" name="type" id="testDescription" value="TEST" style="visibility: hidden">
                        </div>
                        <button type="submit" class="btn btn-secondary">Add test</button>
                    </form>
                    <br/>

                </div>
                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#examSection"
                        aria-expanded="false" aria-controls="examSection">Exams
                </button>
                <div class="collapse multi-collapse" id="examSection">
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
                    <form action="/subjects/${subject.getCode()}" method="post">
                        <div class="form-group">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <label for="examTitle">Title</label>
                            <input type="text" name="title" id="examTitle" placeholder="Title">
                            <label for="examDescription" style="visibility: hidden">Description</label>
                            <input type="text" name="type" id="testDescription" value="EXAM" style="visibility: hidden">
                        </div>
                        <button type="submit" class="btn btn-secondary">Add exam</button>
                    </form>
                    <br/>

                </div>


            </div>

        </div>
    </div>

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