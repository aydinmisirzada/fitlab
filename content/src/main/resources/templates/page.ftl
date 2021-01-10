<#import "parts/common.ftl" as c>

<@c.page " | " + subject.getCode() + ' - ' + subject.getName()>

<div id="features" class="mt-5" style="margin-top: 20px;">
    <div class="container pb-4">
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean erat metus, volutpat et cursus nec, luctus nec libero. Integer vulputate eleifend ligula, quis ullamcorper urna sagittis sit amet. Pellentesque sodales accumsan odio non pellentesque. Vestibulum sed magna sodales, maximus metus sit amet, elementum sem. Donec ac urna a lacus aliquam ullamcorper in ut neque. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sollicitudin felis leo, a varius metus consequat et.</p>
        <button data-toggle="modal" data-target="#editDescription" type="button"
                class="btn btn-secondary">Edit Description
        </button>
    </div>
    <div class="container" >

<#--    show if description is null -->
        <form method="post" class="mb-5">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>


                    <label for="description">Description</label><br>
                    <textarea type="text" role="textbox"name="description" placeholder="Description"> </textarea><br>
                    <button type="submit" class="btn btn-primary">Add description</button>


        </form>
    </div>
</div>
<#--    end-->

    <div class="modal fade" id="editDescription" tabindex="-1" aria-labelledby="editDescription"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Edit Description</h5>
                    <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close">
                        <b>x</b></button>
                </div>
                <div class="modal-body">
                    <div class="mb-2"><label>Current Description</label>
                        <div class="p-2" style="border: 1px solid #2e2e2e; border-radius: 10px"><p
                                    class="mb-2">${"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus orci mi, bibendum vel mattis at, pretium id neque. Aliquam suscipit rhoncus porttitor. Pellentesque dignissim, quam sit amet tempor facilisis, libero velit euismod risus, a mattis diam nibh vel magna. Nunc feugiat enim est, eu convallis nisi feugiat in. In mauris elit, interdum at mi placerat, dictum iaculis erat. Praesent non euismod nibh. Maecenas vulputate eleifend risus sit amet tristique. Donec malesuada libero a efficitur gravida. Curabitur sed rhoncus quam. Curabitur vitae finibus massa, sed maximus nibh. Mauris nec finibus tortor, vitae rutrum nisi. Aliquam in tempor tortor. Morbi luctus nulla ac euismod semper. In maximus nibh eu quam consectetur, id blandit diam tincidunt. Donec id aliquet nisl, ac tincidunt elit. Vivamus rhoncus lectus dolor, ac lobortis felis varius et."}</p>
                        </div>
                    </div>
                    <form method="post">
                        <div class="form-group">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <label for="description">Enter new description</label>
                            <textarea type="text" role="textbox" id="description" class="form-control" name="description"
                                      placeholder="Description"> </textarea>
                        </div>
<#--                        <p style="color:#ff0000"> ${error}</p>-->
                        <div class="mt-2">
                            <button type="submit" class="btn btn-primary">Save description</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                            </button>

                        </div>

                    </form>
                </div>
                <#--                        <div class="modal-footer">-->
                <#--                            <button type="button" class="btn btn-primary">Save changes</button>-->
                <#--                        </div>-->
            </div>
        </div>
    </div>




    <#--    content.getDescription()-->
    <div class="container">
        <ul id="myUL" class="mb-3">
            <#list messages as message>
                <li>
                    <a>
                        <td> ${message.getdate()} &nbsp; &nbsp; <b>${message.getAuthor()}</b> </td>
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

<div class="container mt-3 card p-3 col-md-4 mb-5">
    <div  class="adder">
        <form method="post">
            <label>Enter your name</label><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="text" name="author" placeholder="Author" /><br>
            <lable for="" role="text">Enter your message</lable><br>

            <textarea type="text" name="text" placeholder="Text" > </textarea><br>

            <button type="submit" class="btn btn-primary mt-2">Add a message</button>
        </form>
    </div>
</div>

</@c.page>
