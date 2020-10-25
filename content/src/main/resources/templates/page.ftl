<#import "parts/common.ftl" as c>

<@c.page "FITLab | " + subject.getCode() + ' - ' + subject.getName()>

<div id="features" class="container1" style="margin-top: 20px;">
    <ul id="myUL">
        <#list messages as message>
            <li>
                <a>
                    <td  text="${message.getdate()} + ' ' + ${message.getAuthor()} + ':' "> Name</td>
                    <h4>
                    </h4>
                    <td>
                        ${message.getText()}
                    </td>
                </a>
            </li>
            <p>

            </p>
        </#list>
    </ul>
</div>

<div  class="adder">
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <table width="100%">
            <tr>
                <td width="10%">Enter your name:</td>
                <td>
        <input type="text" name="author" placeholder="Author">
                </td>
            </tr>
            <tr>
                <td width="10%">Enter text</td>
                <td>
        <input type="text" name="text" placeholder="Text">
                </td>
            </tr>
        </table>
        <button type="submit">Add a message</button>
    </form>
</div>

</@c.page>
