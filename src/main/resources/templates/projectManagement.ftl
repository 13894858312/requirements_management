<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <button class="btn btn-default col-sm-1" onClick="javascript: window.history.back()">返回</button>
            <button class="btn btn-default col-sm-1 pull-right" onclick="startCollection()">开始征集</button>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <div class="row">
                <label class="col-sm-2" for="name">项目名称</label>
                <div class="col-sm-10" id="name"></div>
            </div>
            <br>
            <div class="row">
                <label class="col-sm-2" for="description">项目描述</label>
                <div class="col-sm-10" id="description"></div>
            </div>
            <br>
            <div class="row">
                <label class="col-sm-3" for="language">项目语言：</label>
                <div class="col-sm-3" id="language"></div>
                <label class="col-sm-3" for="field">项目领域：</label>
                <div class="col-sm-3" id="field"></div>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-11 col-sm-offset-1">
            <a class="btn btn-default col-sm-1" href="#">需求管理</a>
            <a class="btn btn-default col-sm-1 col-sm-offset-1" href="#">绘制UML图</a>
            <a class="btn btn-default col-sm-1 col-sm-offset-1" href="#">编辑文档</a>
            <a class="btn btn-default col-sm-1 col-sm-offset-1" href="#">提交代码</a>
            <a class="btn btn-default col-sm-1 col-sm-offset-1" href="#">产物列表</a>
            <a class="btn btn-default col-sm-1 col-sm-offset-1" href="#">关联管理</a>
        </div>
    </div>
</@basicLayout.layout>