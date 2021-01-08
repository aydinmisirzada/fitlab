<#import "parts/common.ftl" as c>

<@c.page " | " + subject.getCode()>

    <div style="height:7%"></div>
    <div class="container" id="cardSection">
        <div class="row">
            <div class="card shadow mx-auto" style="width: 50rem;">
                <div class="row">
                    <div class="col-8">
                        <div class="card-body">
                            <h5 class="card-title"><a href="${'/subjects/' + subject.getCode()}">${subject.getCode()}</a></h5>
                            <h6 class="card-subtitle mb-2 text-muted"><a href="${'/subjects/' + subject.getCode()}">${subject.getName()}</a></h6>
                        </div>
                    </div>
                    <div class="col-md-1 my-auto">
                        <div class="card-body">
                            ${subject.averageRating()}
                        </div>
                    </div>
                    <div class="col-md-3 my-auto">

                        <span <#assign x = subject.averageRating()>
                        <#if x != 0>
                            <#list 1..x as i>
                                <span class="fa fa-star checked"></span>
                            </#list>
                        </#if>
                        <#list x..4 as i>
                            <span class="fa fa-star"></span>
                        </#list>
                        </span>
                    </div>
                </div>
            </div>
        </div>


        <div class="row mt-5">
            <div class="card-sm-4 shadow mx-auto text-center " style="width: 50rem;">
                <div class="card-body">
<#--                    <h5 class="card-title">Review: ${teacher.getName()}</h5>-->
                    <form method="post">

                        <div class="star-rating">
                            <div class="star-rating__wrap">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <input class="star-rating__input" id="star-rating-5" type="radio" name="rating"
                                       value="5">
                                <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-5"
                                       title="5 out of 5 stars"></label>
                                <input class="star-rating__input" id="star-rating-4" type="radio" name="rating"
                                       value="4">
                                <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-4"
                                       title="4 out of 5 stars"></label>
                                <input class="star-rating__input" id="star-rating-3" type="radio" name="rating"
                                       value="3">
                                <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-3"
                                       title="3 out of 5 stars"></label>
                                <input class="star-rating__input" id="star-rating-2" type="radio" name="rating"
                                       value="2">
                                <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-2"
                                       title="2 out of 5 stars"></label>
                                <input class="star-rating__input" id="star-rating-1" type="radio" name="rating"
                                       value="1">
                                <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-1"
                                       title="1 out of 5 stars"></label>
                            </div>
                        </div>
                        <p class="card-text">
                            <textarea name="text" placeholder="Text" rows="5" cols="50"></textarea>
                        </p>
                        <button class="btn btn-primary" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="row mt-5">
            <div class="card shadow mx-auto" style="width: 50rem;">

                <div class="card-body">
                    <h5 class="card-title">Your review: </h5>
                    <div class="card-body">
                        <#list reviews as review>
                            <#if review.getUser().getUsername() == user>
                                <div class="row">
                                    <div class="col-md-auto">
                                        <h5 class="card-title">${review.getUser().getName()} ${review.getUser().getSurname()}
                                            : </h5>
                                    </div>
                                    <div class="col">
                                        <p class="card-text">${review.getText()}<p>
                                    </div>
                                </div>
                            </#if>
                        </#list>
                    </div>

                </div>

                <div class="card-body">
                    <h5 class="card-title">Other reviews: </h5>
                    <div class="card-body">
                        <#list reviews as review>
                            <#if review.getUser().getUsername() != user>
                                <div class="row">
                                    <div class="col-md-auto">
                                        <h5 class="card-title">${review.getUser().getName()} ${review.getUser().getSurname()}
                                            : </h5>
                                    </div>
                                    <div class="col">
                                        <p class="card-text">${review.getText()}<p>
                                    </div>
                                </div>
                            </#if>
                        </#list>
                    </div>
                </div>


            </div>

        </div>
    </div>

    <style>
        .checked {
            color: orange;
        }
    </style>

</@c.page>