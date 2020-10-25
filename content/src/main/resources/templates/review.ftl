<#import "parts/common.ftl" as c>

<@c.page "FITLab | " + teacher.getName() + " " + teacher.getSurname()>

<div>
    <#assign x = teacher.averageRating()>
    <#if x != 0>
    <#list 1..x as i>
    <span>&#9733;</span>
    </#list>
    </#if>
    <#list x..4 as i>
    <span>&#9734;</span>
    </#list>
</div>

<div>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="radio" name="rating" value="1" >
        <input type="radio" name="rating" value="2" >
        <input type="radio" name="rating" value="3" >
        <input type="radio" name="rating" value="4" >
        <input type="radio" name="rating" value="5" >

        <input type="text" name="text" placeholder="Text">
        <button type="submit">Submit</button>
    </form>
</div>
<#--<span th:text="${error}">text</span>-->

<h1>Your review: </h1>
<div  class="container1" style="margin-top: 20px;">
    <ul>
        <#list reviews as review>

            <#if review.getUser().getUsername() == user>

                    <td  text="${review.getUser().getName()} + ' ' + ${review.getUser().getSurname()} + ' : ' ">
                        Name
                    </td>

                    <td>
                        ${review.getText()}
                    </td>

            </#if>
            </#list>

        </tr>
    </ul>
</div>


<div id="features" class="container1" style="margin-top: 20px;">
    <ul id="myUL">
        <#list reviews as review>

            <#if review.getUser().getUsername() != user>
                <a>
                    <td  text="${review.getUser().getName()} + ' ' + ${review.getUser().getSurname()} + ' : ' ">
                        Name           </td>
                    <h4>
                    </h4>
                    <td>
                        ${review.getText()}
                    </td>
                </a>
            </#if>
            <p>

            </p>
        </#list>
    </ul>
</div>

</@c.page>
