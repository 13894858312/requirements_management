<#import "basicLayout.ftl" as basicLayout>
<#assign header = "查找项目">

<@basicLayout.layout>
<div class="row">
    <div class="col-sm-offset-1 col-sm-10 page-header">
        <ul class="breadcrumb col">
            <li class="active">${header}</li>
        </ul>
        <h1>${header}</h1>
    </div>
</div>

<div>
    <form class="form-horizontal col-sm-offset-4" id="searchProjectForm" onsubmit="return doSearch()">

        <div class="form-group">
            <label for="publisher" class="col-sm-2 control-label">项目发布者</label>
            <div class="col-sm-4">
                <input class="form-control" id="publisher" name="publisher">
            </div>
        </div>

        <div class="form-group">
            <label for="state" class="col-sm-2 control-label">项目状态</label>
            <div class="col-sm-4">
                <select class="form-control" id="state" name="state">
                    <option selected="selected">全部</option>
                    <option>征集中</option>
                    <option>已截止</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="field" class="col-sm-2 control-label">项目领域</label>
            <div class="col-sm-4">
                <input class="form-control" id="field" name="field">
            </div>
        </div>

        <div class="form-group">
            <label for="input" class="col-sm-2 control-label">搜索信息</label>
            <div class="col-sm-4">
                <input class="form-control" id="input" name="input"">
            </div>
        </div>

        <div class="form-group">
            <div>
                <button type="submit" class="btn btn-info col-xs-6">搜索</button>
            </div>
        </div>
    </form>
</div>
</@basicLayout.layout>