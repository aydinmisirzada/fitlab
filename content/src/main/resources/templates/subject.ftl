<#import "parts/common.ftl" as c>
<#import "parts/form.ftl" as form>

<@c.page subject.getCode() + " - " + subject.getName()>
<div id="features" class="features-section">
    <div class="container text-center">
        <a style="font-size: 35px;">${subject.getName()}</a>

    </div>
</div>



<div  class="adder">

    <h3>${(subject.getDescription())!"There is no description yet."}</h3>
    <form action="/subjects/${subject.getCode()}" method="post">
        <table width="100%">
            <tr>
                <td width="10%">
                    Edit a description:
                </td>
                <td>
                    <input type="text" name="description" placeholder="Type here">
                </td>
            </tr>
        </table>
        <button type="submit">Edit a description</button>

    </form>
    <p>${(error)}</p>
</div>


<!-- Add a Homework -->
<div class="container1" style="margin-left:10%;margin-right: 10%;margin-bottom: 20px;">
    <h3 style="text-align: center;">Homework</h3>

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

    <h4 style="text-align: center; margin: 10px;">Add a homework</h4>
    <div  class="adder">
        <form action="/subjects/${subject.getCode()}" method="post">
            <table width="100%">
                <tr>
                    <td width="10%">
                        Add a homework:</td>
                    <td>
                        <input type="text" name="title" placeholder="Title">
                    </td>
                </tr>
            </table>
            <input type="text"  name="type" value="HOMEWORK" style="visibility: hidden">
            <button type="submit">Add a page</button>
        </form>
    </div>
</div>
<!-- END a Homework -->

<!-- Add a Test -->
<div class="container1" style="margin-left:10%;margin-right: 10%;margin-bottom: 20px;">
    <h3 style="text-align: center;">Tests</h3>

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

    <h4 style="text-align: center; margin: 10px;">Add a Test</h4>
    <div  class="adder">
        <form action="/subjects/${subject.getCode()}" method="post">
            <table width="100%">
                <tr>
                    <td width="10%">
                        Add a test:</td>
                    <td>

                        <input type="text" name="title" placeholder="Title">
                    </td>

                </tr>
            </table>
            <input type="text"  name="type" value="TEST" style="visibility: hidden">
            <button type="submit">Add a page</button>
        </form>
    </div>
</div>
<!-- END Test -->

<!-- Add a Exam -->
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

<!-- END a Exam -->


</@c.page>
