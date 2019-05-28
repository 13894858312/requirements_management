<#import "basicLayout.ftl" as basicLayout>

<#assign header = "筛选结果">

<@basicLayout.layout>
<div class="row">
    <div class="col-sm-offset-1 col-sm-10">
        <ul class="breadcrumb col">
            <li><a href="/post/myProjects?page=1">我的项目</a></li>
            <li><a href="/post/project?pid=${project.pid}&page=1">项目详情</a></li>
            <li><a href="/projectManagement?pid=${project.pid}">项目管理</a></li>
            <li><a href="/rm?pid=${project.pid}">需求总览</a></li>
            <li><a href="/filtrateRequires?pid=${project.pid}">筛选需求</a></li>
            <li class="active">${header}</li>
        </ul>
        <div class="col-sm-4">
            <h1>${header}</h1>
        </div>
        <div>
            <a class="btn btn-default col-sm-1 col-sm-offset-1 pull-right" href="/projectManagement?pid=${project.pid}">完成管理</a>
        </div>
    </div>
</div>
<br/>
<div class="row">
    <div class="col-sm-10 col-sm-offset-1">
                <div class="panel-group" id="shoufengqing">
                    <div class="panel panel-default">
                        <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div1" class="panel-heading">
                            <h3 class="panel-title" style="text-align: center;">Security(SE)</h3>
                        </div>
                        <div id="div1" class="collapse">
                            <div class="panel-body">
                                <#if r1?? && (r1?size > 0)>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>编辑</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list r1 as requirement1>
                                        <tr>
                                            <td>${requirement1.name}</td>
                                            <td>${requirement1.description}</td>
                                            <td>
                                                <a class="btn btn-default col-sm-1" data-toggle="modal" data-target="#update">修改分类</a>
                                                <a class="btn btn-default col-sm-1 pull-right" data-toggle="modal" data-target="#deleteRequire">删除</a>
                                            </td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                <#else>
                                    <div class="col-sm-offset-1 col-sm-2">
                                         <h4>暂无数据</h4>
                                    </div>
                                </#if>

                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div2" class="panel-heading">
                            <h3 class="panel-title" style="text-align: center;">Reliability (RE)</h3>
                        </div>
                        <div id="div2" class="collapse">
                            <div class="panel-body">
                                <#if r2?? && (r2?size > 0)>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>编辑</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list r2 as requirement2>
                                        <tr>
                                            <td>${requirement2.name}</td>
                                            <td>${requirement2.description}</td>
                                            <td><a>修改分类</a><a>删除该需求</a></td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                <#else>
                                    <div class="col-sm-offset-1 col-sm-2">
                                        <h4>暂无数据</h4>
                                    </div>
                                </#if>

                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div3" class="panel-heading">
                            <h3 class="panel-title" style="text-align: center;">Performance (PE)</h3>
                        </div>
                        <div id="div3" class="collapse">
                            <div class="panel-body">
                                <#if r3?? && (r3?size > 0)>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>编辑</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list r3 as requirement3>
                                        <tr>
                                            <td>${requirement3.name}</td>
                                            <td>${requirement3.description}</td>
                                            <td><a>修改分类</a><a>删除该需求</a></td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                <#else>
                                    <div class="col-sm-offset-1 col-sm-2">
                                        <h4>暂无数据</h4>
                                    </div>
                                </#if>

                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div4" class="panel-heading">
                            <h3 class="panel-title" style="text-align: center;">Lifecycle (LI)</h3>
                        </div>
                        <div id="div4" class="collapse">
                            <div class="panel-body">
                                <#if r4?? && (r4?size > 0)>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>编辑</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list r4 as requirement4>
                                        <tr>
                                            <td>${requirement4.name}</td>
                                            <td>${requirement4.description}</td>
                                            <td><a>修改分类</a><a>删除该需求</a></td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                <#else>
                                    <div class="col-sm-offset-1 col-sm-2">
                                        <h4>暂无数据</h4>
                                    </div>
                                </#if>

                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div5" class="panel-heading">
                            <h3 class="panel-title" style="text-align: center;">Usability(US)</h3>
                        </div>
                        <div id="div5" class="collapse">
                            <div class="panel-body">
                                <#if r5?? && (r5?size > 0)>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>编辑</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list r5 as requirement5>
                                        <tr>
                                            <td>${requirement5.name}</td>
                                            <td>${requirement5.description}</td>
                                            <td><a>修改分类</a><a>删除该需求</a></td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                <#else>
                                    <div class="col-sm-offset-1 col-sm-2">
                                        <h4>暂无数据</h4>
                                    </div>
                                </#if>

                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div6" class="panel-heading">
                            <h3 class="panel-title" style="text-align: center;">Capability(CA)</h3>
                        </div>
                        <div id="div6" class="collapse">
                            <div class="panel-body">
                                <#if r6?? && (r6?size > 0)>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>编辑</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list r6 as requirement6>
                                        <tr>
                                            <td>${requirement6.name}</td>
                                            <td>${requirement6.description}</td>
                                            <td><a>修改分类</a><a>删除该需求</a></td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                <#else>
                                    <div class="col-sm-offset-1 col-sm-2">
                                        <h4>暂无数据</h4>
                                    </div>
                                </#if>

                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div7" class="panel-heading">
                            <h3 class="panel-title" style="text-align: center;">System Interface(SI)</h3>
                        </div>
                        <div id="div7" class="collapse">
                            <div class="panel-body">
                                <#if r7?? && (r7?size > 0)>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>编辑</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list r7 as requirement7>
                                        <tr>
                                            <td>${requirement7.name}</td>
                                            <td>${requirement7.description}</td>
                                            <td><a>修改分类</a><a>删除该需求</a></td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                <#else>
                                    <div class="col-sm-offset-1 col-sm-2">
                                        <h4>暂无数据</h4>
                                    </div>
                                </#if>

                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div8" class="panel-heading">
                            <h3 class="panel-title" style="text-align: center;">others</h3>
                        </div>
                        <div id="div8" class="collapse">
                            <div class="panel-body">
                                <#if r8?? && (r8?size > 0)>
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>编辑</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list r8 as requirement8>
                                        <tr>
                                            <td>${requirement8.name}</td>
                                            <td>${requirement8.description}</td>
                                            <td>
                                                <a class="btn btn-default" data-toggle="modal" data-target="#editType">修改需求</a>
                                                <a class="btn btn-default pull-right" data-toggle="modal" data-target="#changeTag">删除需求</a>
                                            </td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                <#else>
                                    <div class="col-sm-offset-1 col-sm-2">
                                        <h4>暂无数据</h4>
                                    </div>
                                </#if>
                            </div>
                        </div>
                    </div>
        </div>
        <#--<ul id="myTab" class="nav nav-tabs">-->
            <#--<li class="active"><a href="#se" data-toggle="tab">Security(SE)</a></li>-->
            <#--<li><a href="#se" data-toggle="tab">Reliability(RE)</a></li>-->
            <#--<li><a href="#se" data-toggle="tab">Performance(PE)</a></li>-->
            <#--<li><a href="#se" data-toggle="tab">Lifecycle(LI)</a></li>-->
            <#--<li><a href="#se" data-toggle="tab">Usability(US)</a></li>-->
            <#--<li><a href="#se" data-toggle="tab">Capability(CA)</a></li>-->
            <#--<li><a href="#se" data-toggle="tab">System Interface(SI)</a></li>-->
            <#--<li><a href="#se" data-toggle="tab">others</a></li>-->
        <#--</ul>-->
        <#--<div id="myTabContent" class="tab-content">-->
            <#--<div class="tab-pane fade in active" id="se">-->
                <#--<table class="table table-striped">-->
                    <#--<thead>-->
                    <#--<tr>-->
                        <#--<th>需求名称</th>-->
                        <#--<th>需求描述</th>-->
                        <#--<th>优先级</th>-->
                        <#--<th>提供者</th>-->
                        <#--<th>发布时间</th>-->
                        <#--<th>编辑</th>-->
                    <#--</tr>-->
                    <#--</thead>-->
                    <#--<tbody>-->
                    <#--<tr>-->
                        <#--<td>test</td>-->
                        <#--<td>t</td>-->
                        <#--<td>1</td>-->
                        <#--<td>te</td>-->
                        <#--<td>0000</td>-->
                        <#--<td>修改分类，删除该需求</td>-->
                    <#--</tr>-->
                    <#--<tr>-->
                        <#--<td>test2</td>-->
                        <#--<td>t2</td>-->
                        <#--<td>12</td>-->
                        <#--<td>te2</td>-->
                        <#--<td>00002</td>-->
                        <#--<td>修改分类，删除该需求</td>-->
                    <#--</tr>-->
                    <#--<tr>-->
                        <#--<td>test3</td>-->
                        <#--<td>t3</td>-->
                        <#--<td>13</td>-->
                        <#--<td>te3</td>-->
                        <#--<td>00003</td>-->
                        <#--<td>修改分类，删除该需求</td>-->
                    <#--</tr>-->
                    <#--</tbody>-->
                <#--</table>-->
            <#--</div>-->
        <#--</div>-->
    </div>
</div>
<#--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="editType">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">请选择新的需求分类</h4>
                </div>
                <div class="modal-body" style="height: 100px">
                    <form id="editType">
                        <div class="form-group">
                            <label for="inputType" class="col-sm-2 col-sm-offset-2 control-label">需求分类</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="inputType" name="newType" required="required">
                                    <option>Security(SE)</option>
                                    <option>Reliability (RE)</option>
                                    <option>Performance (PE)</option>
                                    <option>Lifecycle (LI)</option>
                                    <option>Usability (US)</option>
                                    <option>Capability (CA)</option>
                                    <option>System Interface (SI)</option>
                                    <option>others</option>
                                </select>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success col-sm-2">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

<#--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="changeTag">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">确认消息</h4>
                </div>
                <div class="modal-body" style="height: 100px">
                    <form id="changeTag">
                        <div class="form-group">
                            <label class="col-sm-offset-4 control-label">确认删除该需求吗</label>
                        </div>
                        <button type="submit" class="btn btn-success col-sm-2 pull-right">确认</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@basicLayout.layout>