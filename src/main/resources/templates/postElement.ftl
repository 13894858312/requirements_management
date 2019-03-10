<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10">
            <div class="row post-container">
                <div class="col-sm-2 post-left">
                    <div>
                        <label for="publisher">项目发布者</label>
                        <div id="publisher"></div>
                    </div>
                    <br/>
                    <div>
                        <label for="language">项目语言</label>
                        <div id="language"></div>
                    </div>
                    <br/>
                    <div>
                        <label for="field">项目领域</label>
                        <div id="field"></div>
                    </div>
                </div>
                <div class="col-sm-9 post-right">
                    <div class="row">
                        <div class="col-sm-2" id="state">项目状态</div>
                        <div class="col-sm-8" id="name">项目名称</div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-sm-10" id="description">项目名称</div>
                    </div>
                </div>
                <div class="col-sm-12 post-bottom">
                    <label class="col-sm-1" for="createdTime">发布时间</label>
                    <div class="col-sm-1" id="createdTime"></div>
                    <label class="col-sm-1" for="closedTime">截止时间</label>
                    <div class="col-sm-1" id="closedTime"></div>
                    <label class="col-sm-2" for="number">已征集到的需求数</label>
                    <div class="col-sm-1" id="number"></div>

                    <button class="btn btn-default col-sm-2 pull-right">提交需求</button>
                </div>
            </div>

        </div>
    </div>

</@basicLayout.layout>