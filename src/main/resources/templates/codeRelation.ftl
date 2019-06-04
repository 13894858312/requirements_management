<#import "basicLayout.ftl" as basicLayout>
<#assign header = "编辑代码关联">

<@basicLayout.layout>
<div class="row" xmlns="http://www.w3.org/1999/html">
    <div class="col-sm-offset-1 col-sm-10 page-header">
        <ul class="breadcrumb col">
            <li><a href="/post/myProjects?page=1">我的项目</a></li>
            <li><a href="/post/project?pid=${project.pid}&page=1">项目详情</a></li>
            <li><a href="/projectManagement?pid=${project.pid}">项目管理</a></li>
            <li><a onclick="codeManagement1_1(${project.pid})">上传代码管理</a></li>
            <li class="active">${header}</li>
        </ul>
        <h1>${header}</h1>
        <button type="button" class="btn btn-default">${(code.name)!}</button>
    </div>
</div>
<div class="row">
    <div class="col-sm-10 col-sm-offset-1">
        <h1>需求列表</h1>
        <div id="myTabContent" class="tab-content">
            <#if requirementList??&&(requirementList?size>0)>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>需求名称</th>
                        <th>需求描述</th>
                        <th>优先级</th>
                        <th>提供者</th>
                        <th>发布时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list requirementList as requirementVO>
                            <#assign requirement = requirementVO.requirement>
                        <tr>
                            <td>${requirement.name}</td>
                            <td>${requirement.description}</td>
                            <td>${requirement.priority}</td>
                            <td>${requirement.uid}</td>
                            <td>${requirement.postTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                            <td>
                                <#if requirementVO.state>
                                <#--已关联-->
                                    <button type='button' class='btn btn-primary' onclick="goToEditRelation(${project.pid},${code.id},${requirement.rid},${requirementVO.state?c})">取消关联</button>
                                <#else>
                                <#--未关联-->
                                    <button type='button' class='btn btn-default' onclick="goToEditRelation(${project.pid},${code.id},${requirement.rid},${requirementVO.state?c})">添加关联</button>
                                </#if>
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
    <br/>

    <#if umlList?? && (umlList?size > 0)>
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <h1>UML图列表</h1>
                <div class="row">
                    <#list umlList as umlVO>
                        <#assign uml = umlVO.uml>
                        <div class="col-xs-3 uml-container" id="uml-${uml.umlid}">
                            <div class="uml-thumbnail" id="wrapper">
                                <img id="thumbnail-${uml.umlid}" style="height:100%;width:100%" src="${(uml.content)!}"/>
                            </div>
                            <div class="uml-title" title="${(uml.title)!"未命名"}">${(uml.title)!"未命名"}</div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <a class="btn btn-default" href="/uml/edit?pid=${RequestParameters['pid']}&umlid=${uml.umlid}">编&nbsp;&nbsp;辑</a>
                                </div>
                                <div class="col-xs-6">
                                    <#if umlVO.ustate>
                                    <#--已关联-->
                                        <button type='button' class='btn btn-primary' onclick="editUMLRelation(${project.pid},${code.id},${uml.umlid},${umlVO.ustate?c})">取消关联</button>
                                    <#else>
                                    <#--未关联-->
                                        <button type='button' class='btn btn-default' onclick="editUMLRelation(${project.pid},${code.id},${uml.umlid},${umlVO.ustate?c})">添加关联</button>
                                    </#if>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>

    <#else>
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <h4>暂无数据</h4>
            </div>
        </div>
    </#if>
</div>
</@basicLayout.layout>