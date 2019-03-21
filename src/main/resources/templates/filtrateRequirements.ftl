<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
<form class="form-horizontal">
    <br/>
    <br/>
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
                <div class="container">
                    <div class="row">
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
        </div>
    </div>

    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h3>冲突需求</h3>
            <a class="col-sm-1 col-sm-offset-1 pull-right" data-toggle="collapse" data-parent="#accordion" href="#collapse3">展开</a>
        </div>
        <div id="collapse3" class="panel-collapse collapse col-sm-offset-1 col-sm-10">
            <div class="panel-body">
                <div class="container">
                    <div class="row">
                        <div class="panel-group" id="shoufengqing">
                            <#--<#if fidList?? && (fidList?size > 0)>-->
                                <#--<#list fidList as conflictVO>-->
                                    <div class="panel panel-default">
                                        <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div" class="panel-heading">
                                            <h3 class="panel-title" style="text-align: center;">首发需求名称</h3>
                                        </div>
                                        <div id="div" class="collapse">
                                            <div class="panel-body col-sm-offset-1">
                                                <#--<#list conflictVO.crequirementList as crequirement>-->
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
        </div>
    </div>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10">
            <button type="" class="btn btn-default pull-right">取消</button>
            <a class="btn btn-default pull-right" href="/filtrateResult?pid=${project.pid}">保存</a>
        </div>
    </div>

</form>

</@basicLayout.layout>