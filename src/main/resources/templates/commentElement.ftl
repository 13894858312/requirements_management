<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-xs-offset-3 col-xs-7">
            <div class="row comment-container">
                <div class="col-xs-2 comment-left">
                    <label for="uid">评论者</label>
                    <div id="uid">评论者</div>
                    <br/>
                    <label for="commentTime">评论时间</label>
                    <div id="commentTime">评论时间</div>
                </div>
                <div class="col-xs-8 comment-right">
                    <div id="content">评论内容</div>
                </div>
            </div>
        </div>
    </div>


</@basicLayout.layout>