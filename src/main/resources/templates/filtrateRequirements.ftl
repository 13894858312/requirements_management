<#import "basicLayout.ftl" as basicLayout>

<#assign header = "筛选需求">

<@basicLayout.layout>
<div class="row">
    <div class="col-sm-offset-1 col-sm-10">
        <ul class="breadcrumb col">
            <li><a href="/post/myProjects?page=1">我的项目</a></li>
            <li><a href="/post/project?pid=${project.pid}&page=1">项目详情</a></li>
            <li><a href="/projectManagement?pid=${project.pid}">项目管理</a></li>
            <li><a href="/rm?pid=${project.pid}">需求管理</a></li>
            <li class="active">${header}</li>
        </ul>
    </div>
</div>
<form class="form-horizontal">
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h3>一般需求</h3>
            <a class="col-sm-1 col-sm-offset-1 pull-right" data-toggle="collapse" data-parent="#accordion" href="#collapse1">展开</a>
        </div>
        <div id="collapse1" class="panel-collapse collapse col-sm-offset-2 col-sm-9">
            <div class="panel-body row pre-scrollable">
                <#if requirementList?? && (requirementList?size > 0)>
                    <#list requirementList as requirement>
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <td><input type="checkbox" style="zoom:150%;" name="" value=${requirement.rid} /></td>
                                <td>${requirement.name}</td>
                                <td>${requirement.priority}</td>
                                <td>${requirement.description}</td>
                            </tr>
                            </tbody>
                        </table>
                    </#list>
                <#else>
                    <div class="col-sm-offset-1 col-sm-2">
                         <h4>暂无数据</h4>
                    </div>
                </#if>

            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h3>重复需求</h3>
            <a class="col-sm-1 col-sm-offset-1 pull-right" data-toggle="collapse" data-parent="#accordion" href="#collapse2">展开</a>
        </div>
        <div id="collapse2" class="panel-collapse collapse col-sm-offset-1 col-sm-10">
            <div class="panel-body">
                        <div class="panel-group" id="shoufengqing">
                            <div class="panel panel-default">
                                <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div1" class="panel-heading">
                                    <h3 class="panel-title" style="text-align: center;">首发需求名称</h3>
                                </div>
                                <div id="div1" class="collapse">
                                    <div class="panel-body col-sm-offset-1">
                                        <table class="table table-bordered ">
                                            <tbody>
                                            <tr>
                                                <td><input type="checkbox" style="zoom:150%;" name="" value="" /></td>
                                                <td>需求名称</td>
                                                <td>需求优先级</td>
                                                <td>需求描述</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div2" class="panel-heading">
                                    <h3 class="panel-title" style="text-align: center;">首发需求名称</h3>
                                </div>
                                <div id="div2" class="collapse">
                                    <div class="panel-body col-sm-offset-1">
                                        <table class="table table-bordered ">
                                            <tbody>
                                            <tr>
                                                <td><input type="checkbox" style="zoom:150%;" name="" value="" /></td>
                                                <td>需求名称</td>
                                                <td>需求优先级</td>
                                                <td>需求描述</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h3>冲突需求</h3>
            <a class="col-sm-1 col-sm-offset-1 pull-right" data-toggle="collapse" data-parent="#accordion" href="#collapse3">展开</a>
        </div>
        <div id="collapse3" class="panel-collapse collapse col-sm-offset-1 col-sm-10">
            <div class="panel-body">
                        <div class="panel-group" id="shoufengqing">
                            <#--<#if cvoList?? && (cvoList?size > 0)>-->
                                <#--<#list cvoList as conflictVO>-->
                                    <div class="panel panel-default">
                                        <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div" class="panel-heading">
                                            <h3 class="panel-title" style="text-align: center;">首发需求名称</h3>
                                            <#--<h3 class="panel-title" style="text-align: center;">${conflictVO.frequirementName}</h3>-->
                                        </div>
                                        <div id="div" class="collapse">
                                            <div class="panel-body col-sm-offset-1">
                                                <#--<#list conflictVO.crequirementList as requirement>-->
                                                <table class="table table-bordered ">
                                                    <tbody>
                                                    <tr>
                                                        <td><input type="checkbox" style="zoom:150%;" name="" value="" /></td>
                                                        <#--<td>${requirement.name}</td>-->
                                                        <#--<td>${requirement.priority}</td>-->
                                                        <#--<td>${requirement.description}</td>-->
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <#--</#list>-->
                                            </div>
                                        </div>
                                    </div>
                                <#--</#list>-->
                            <#--<#else>-->
                                <#--<div class="col-sm-offset-1 col-sm-2">-->
                                    <#--<h4>暂无数据</h4>-->
                                <#--</div>-->
                            <#--</#if>-->
                        </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10">
            <a class="btn btn-default pull-right" href="/filtrateResult?pid=${project.pid}">保存</a>
        </div>
    </div>

</form>

</@basicLayout.layout>