<#import "basicLayout.ftl" as basicLayout>
<#assign header = "需求总览">

<@basicLayout.layout>
<div class="row">
    <div class="col-sm-offset-1 col-sm-10">
        <ul class="breadcrumb col">
            <li><a href="/post/myProjects?page=1">我的项目</a></li>
            <li><a href="/post/project?pid=${project.pid}&page=1">项目详情</a></li>
            <li><a href="/projectManagement?pid=${project.pid}">项目管理</a></li>
            <li class="active">${header}</li>
        </ul>
        <div class="col-sm-4">
            <h1>${header}</h1>
        </div>
        <div class="col-sm-8">
            <button type="button" class="btn btn-default pull-right" onclick="goToCreateRequirement(${project.pid})">添加新需求</button>
            <a class="btn btn-default col-sm-offset-1 pull-right" href="/filtrateRequires?pid=${project.pid}">筛选需求</a>
        </div>
    </div>
</div>
<br/>
<div class="row">
    <div class="col-sm-offset-1 col-sm-10">
        <div class="panel-group" id="shoufengqing">
            <div class="panel panel-default">
                <div data-parent="#shoufengqing" data-toggle="collapse" data-target="#div1" class="panel-heading">
                    <h3 class="panel-title" style="text-align: center;">Security(SE)</h3>
                </div>
                <div id="div1" class="collapse">
                    <div class="panel-body">
                                <#if requirementList1?? && (requirementList1?size > 0)>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>优先级</th>
                                            <th>提供者</th>
                                            <th>发布时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list requirementList1 as requirement1>
                                        <tr>
                                            <td>${requirement1.name}</td>
                                            <td>${requirement1.description}</td>
                                            <td>${requirement1.priority}</td>
                                            <td>${requirement1.uid}</td>
                                            <td>${requirement1.postTime?string('yyyy/MM/dd HH:mm')}</td>
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
                                <#if requirementList2?? && (requirementList2?size > 0)>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>优先级</th>
                                            <th>提供者</th>
                                            <th>发布时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list requirementList2 as requirement2>
                                        <tr>
                                            <td>${requirement2.name}</td>
                                            <td>${requirement2.description}</td>
                                            <td>${requirement2.priority}</td>
                                            <td>${requirement2.uid}</td>
                                            <td>${requirement2.postTime?string('yyyy/MM/dd HH:mm')}</td>
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
                                <#if requirementList3?? && (requirementList3?size > 0)>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>优先级</th>
                                            <th>提供者</th>
                                            <th>发布时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list requirementList3 as requirement3>
                                        <tr>
                                            <td>${requirement3.name}</td>
                                            <td>${requirement3.description}</td>
                                            <td>${requirement3.priority}</td>
                                            <td>${requirement3.uid}</td>
                                            <td>${requirement3.postTime?string('yyyy/MM/dd HH:mm')}</td>
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
                                <#if requirementList4?? && (requirementList4?size > 0)>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>优先级</th>
                                            <th>提供者</th>
                                            <th>发布时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list requirementList4 as requirement4>
                                        <tr>
                                            <td>${requirement4.name}</td>
                                            <td>${requirement4.description}</td>
                                            <td>${requirement4.priority}</td>
                                            <td>${requirement4.uid}</td>
                                            <td>${requirement4.postTime?string('yyyy/MM/dd HH:mm')}</td>
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
                                <#if requirementList5?? && (requirementList5?size > 0)>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>优先级</th>
                                            <th>提供者</th>
                                            <th>发布时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list requirementList5 as requirement5>
                                        <tr>
                                            <td>${requirement5.name}</td>
                                            <td>${requirement5.description}</td>
                                            <td>${requirement5.priority}</td>
                                            <td>${requirement5.uid}</td>
                                            <td>${requirement5.postTime?string('yyyy/MM/dd HH:mm')}</td>
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
                                <#if requirementList6?? && (requirementList6?size > 0)>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>优先级</th>
                                            <th>提供者</th>
                                            <th>发布时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list requirementList6 as requirement6>
                                        <tr>
                                            <td>${requirement6.name}</td>
                                            <td>${requirement6.description}</td>
                                            <td>${requirement6.priority}</td>
                                            <td>${requirement6.uid}</td>
                                            <td>${requirement6.postTime?string('yyyy/MM/dd HH:mm')}</td>
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
                                <#if requirementList7?? && (requirementList7?size > 0)>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>优先级</th>
                                            <th>提供者</th>
                                            <th>发布时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list requirementList7 as requirement7>
                                        <tr>
                                            <td>${requirement7.name}</td>
                                            <td>${requirement7.description}</td>
                                            <td>${requirement7.priority}</td>
                                            <td>${requirement7.uid}</td>
                                            <td>${requirement7.postTime?string('yyyy/MM/dd HH:mm')}</td>
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
                                <#if requirementList8?? && (requirementList8?size > 0)>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>需求名称</th>
                                            <th>需求描述</th>
                                            <th>优先级</th>
                                            <th>提供者</th>
                                            <th>发布时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list requirementList8 as requirement8>
                                        <tr>
                                            <td>${requirement8.name}</td>
                                            <td>${requirement8.description}</td>
                                            <td>${requirement8.priority}</td>
                                            <td>${requirement8.uid}</td>
                                            <td>${requirement8.postTime?string('yyyy/MM/dd HH:mm')}</td>
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
    </div>
</div>
<#--<div class="row">
    <div class="col-sm-10 col-sm-offset-1">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#se" data-toggle="tab">Security(SE)</a></li>
            <li><a href="#re" data-toggle="tab">Reliability(RE)</a></li>
            <li><a href="#pe" data-toggle="tab">Performance(PE)</a></li>
            <li><a href="#li" data-toggle="tab">Lifecycle(LI)</a></li>
            <li><a href="#us" data-toggle="tab">Usability(US)</a></li>
            <li><a href="#ca" data-toggle="tab">Capability(CA)</a></li>
            <li><a href="#si" data-toggle="tab">System Interface(SI)</a></li>
            <li><a href="#ot" data-toggle="tab">others</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="se">
                <#if requirementList1??&&(requirementList1?size>0)>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>需求名称</th>
                        <th>需求描述</th>
                        <th>优先级</th>
                        <th>提供者</th>
                        <th>发布时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list requirementList1 as requirement1>
                       <tr>
                           <td>${requirement1.name}</td>
                           <td>${requirement1.description}</td>
                           <td>${requirement1.priority}</td>
                           <td>${requirement1.uid}</td>
                           <td>${requirement1.postTime?string("yyyy-MM-dd HH:mm:ss")}</td>

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
            <div class="tab-pane fade in active" id="re">
                <#if requirementList2??&&(requirementList2?size>0)>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>需求名称</th>
                            <th>需求描述</th>
                            <th>优先级</th>
                            <th>提供者</th>
                            <th>发布时间</th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list requirementList2 as requirement2>
                    <tr>
                        <td>${requirement2.name}</td>
                        <td>${requirement2.description}</td>
                        <td>${requirement2.priority}</td>
                        <td>${requirement2.uid}</td>
                        <td>${requirement2.postTime?string("yyyy-MM-dd HH:mm:ss")}</td>

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
            <div class="tab-pane fade in active" id="pe">
                <#if requirementList3??&&(requirementList3?size>0)>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>需求名称</th>
                            <th>需求描述</th>
                            <th>优先级</th>
                            <th>提供者</th>
                            <th>发布时间</th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list requirementList3 as requirement3>
                    <tr>
                        <td>${requirement3.name}</td>
                        <td>${requirement3.description}</td>
                        <td>${requirement3.priority}</td>
                        <td>${requirement3.uid}</td>
                        <td>${requirement3.postTime?string("yyyy-MM-dd HH:mm:ss")}</td>

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
            <div class="tab-pane fade in active" id="li">
                <#if requirementList4??&&(requirementList4?size>0)>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>需求名称</th>
                            <th>需求描述</th>
                            <th>优先级</th>
                            <th>提供者</th>
                            <th>发布时间</th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list requirementList4 as requirement4>
                    <tr>
                        <td>${requirement4.name}</td>
                        <td>${requirement4.description}</td>
                        <td>${requirement4.priority}</td>
                        <td>${requirement4.uid}</td>
                        <td>${requirement4.postTime?string("yyyy-MM-dd HH:mm:ss")}</td>

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
            <div class="tab-pane fade in active" id="us">
                <#if requirementList5??&&(requirementList5?size>0)>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>需求名称</th>
                            <th>需求描述</th>
                            <th>优先级</th>
                            <th>提供者</th>
                            <th>发布时间</th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list requirementList5 as requirement5>
                    <tr>
                        <td>${requirement5.name}</td>
                        <td>${requirement5.description}</td>
                        <td>${requirement5.priority}</td>
                        <td>${requirement5.uid}</td>
                        <td>${requirement5.postTime?string("yyyy-MM-dd HH:mm:ss")}</td>

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
            <div class="tab-pane fade in active" id="ca">
                <#if requirementList6??&&(requirementList6?size>0)>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>需求名称</th>
                            <th>需求描述</th>
                            <th>优先级</th>
                            <th>提供者</th>
                            <th>发布时间</th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list requirementList6 as requirement6>
                    <tr>
                        <td>${requirement6.name}</td>
                        <td>${requirement6.description}</td>
                        <td>${requirement6.priority}</td>
                        <td>${requirement6.uid}</td>
                        <td>${requirement6.postTime?string("yyyy-MM-dd HH:mm:ss")}</td>

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
            <div class="tab-pane fade in active" id="si">
                <#if requirementList7??&&(requirementList7?size>0)>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>需求名称</th>
                            <th>需求描述</th>
                            <th>优先级</th>
                            <th>提供者</th>
                            <th>发布时间</th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list requirementList7 as requirement7>
                    <tr>
                        <td>${requirement7.name}</td>
                        <td>${requirement7.description}</td>
                        <td>${requirement7.priority}</td>
                        <td>${requirement7.uid}</td>
                        <td>${requirement7.postTime?string("yyyy-MM-dd HH:mm:ss")}</td>

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
            <div class="tab-pane fade in active" id="ot">
                <#if requirementList8??&&(requirementList8?size>0)>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>需求名称</th>
                            <th>需求描述</th>
                            <th>优先级</th>
                            <th>提供者</th>
                            <th>发布时间</th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list requirementList8 as requirement8>
                    <tr>
                        <td>${requirement8.name}</td>
                        <td>${requirement8.description}</td>
                        <td>${requirement8.priority}</td>
                        <td>${requirement8.uid}</td>
                        <td>${requirement8.postTime?string("yyyy-MM-dd HH:mm:ss")}</td>

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
</div>-->


</@basicLayout.layout>