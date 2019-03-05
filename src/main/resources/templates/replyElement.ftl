<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-9">
            <div class="row reply-container">
                <div class="col-sm-2 reply-left">
                    <div>
                        <label for="uid">需求提供者</label>
                        <div id="uid"></div>
                    </div>
                    <br>
                    <div>
                        <label for="postTime">提供时间</label>
                        <div id="postTime"></div>
                    </div>
                    <br>
                    <div>
                        <label for="priority">优先级</label>
                        <div id="priority"></div>
                    </div>
                </div>
                <div class="col-sm-9 reply-right">
                    <div class="row">
                        <div class="col-sm-2" id="type">需求类型</div>
                        <div class="col-sm-8" id="name">需求名称</div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-10" id="description">hello</div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</@basicLayout.layout>