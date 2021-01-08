<#import "parts/common.ftl" as c>

<@c.page " | " >
    <div class="form-container" id="cardSection">
        <div class="card shadow m-8 col-md-4">
            <#if teacher??>
            <div class="col-md-8 badge-right">
                <span                     <#assign x = teacher.averageRating()>
                <#if x != 0>
                    <#list 1..x as i>
                        <span>&#9733;</span>
                    </#list>
                </#if>
                <#list x..4 as i>
                <span>&#9734;</span>
                </#list></span>
            </div>
            </#if>
            <h5 class="mt-4"><b>Your reviews</b></h5>

            <div class="row p-2 mt-4 border-top">
                <ul>
                    <#list reviews as review>
                        <#if review.getUser().getUsername() == user>
                                <td >${review.getUser().getName()} ${review.getUser().getSurname()} :</td>
                            <td>${review.getText()}</td>
                        </#if>
                    </#list>
                    </tr>
                </ul>
            </div>
            <h5 class="mt-4"><b>Other reviews: </b></h5>
            <div class="row p-2 mt-4 border-top">

                <ul>
                    <#list reviews as review>
                        <#if review.getUser().getUsername() != user>
                            <td  text="${review.getUser().getName()} + ' ' + ${review.getUser().getSurname()} + ' : ' ">Name</td>
                            <td>${review.getText()}</td>
                        </#if>
                    </#list>
                    </tr>
                </ul>



            </div>


            <div class="row p-2 mb-4 border-top">
                <h5>Review:</h5>
                <p style="color:red"> ${error!""}</p>
                <div class="col-md-8 badge-right">
                    <span>
                        <div class="col-md-8 badge-right">
                            <form method="post">
                                   <div class="rating">
                                       <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                       <input type="radio" name="rating" value="5" id="5">
                                       <label for="5">☆</label>
                                       <input type="radio" name="rating" value="4" id="4">
                                       <label for="4">☆</label>
                                       <input type="radio" name="rating" value="3" id="3">
                                       <label for="3">☆</label>
                                       <input type="radio" name="rating" value="2" id="2">
                                       <label for="2">☆</label>
                                       <input type="radio" name="rating" value="1" id="1">
                                       <label for="1">☆</label>
                                    </div>
<div class="row p-2 mb-4 border-top-bottom">
                <input type="text" name="text" placeholder="Text">
                <div class="col-md-6 badge-right">                  <span class="badge p-2 m-2">
<button type="submit">Submit</button>

          </span>
                </div>

            </div>

                            </form>
                        </div>
                    </span>
                </div>
            </div>



        </div>


    </div>
    </div>

</@c.page>
