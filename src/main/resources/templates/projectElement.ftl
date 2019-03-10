<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
<div class="row">
    <div class="col-sm-offset-1 col-sm-10">
        <div class="row project-container">
            <div class="col-sm-9">
                <div class="row">
                    <label class="col-sm-2" for="name">项目名称：</label>
                    <div class="col-sm-10" id="name">name</div>
                </div>
                <br/>
                <div class="row">
                    <label class="col-sm-2" for="description">项目描述：</label>
                    <div class="col-sm-10" id="description">description</div>
                </div>
            </div>
            <div class="col-sm-2">
                <div>
                    <span id="createdTime">createdTime</span>
                </div>
                <br/>
                <div id="state">状态
                </div>
            </div>
            <div class="col-sm-12 project-bottom">
                <div class="col-sm-2" id="publisher">发布者</div>
                <div class="col-sm-2 col-sm-offset-1" id="language">语言</div>
                <div class="col-sm-2 col-sm-offset-1" id="field">领域</div>

                <button class="btn btn-default col-sm-2 pull-right">查看详情</button>
            </div>
        </div>

    </div>
</div>
</div>
</@basicLayout.layout>