<#import "basicLayout.ftl" as basicLayout>
<#assign header = "UML图列表">

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1 page-header">
            <ul class="breadcrumb col">
                <li><a href="/post/myProjects?page=1">我的项目</a></li>
                <li><a href="/post/project?pid=${RequestParameters['pid']}&page=1">项目详情</a></li>
                <li><a href="/projectManagement?pid=${RequestParameters['pid']}">项目管理</a></li>
                <li class="active">UML图列表</li>
            </ul>
            <div class="row">
                <div class="col-sm-4">
                    <h1>${header}</h1>
                </div>
                <button type="button" class="btn btn-success col-lg-1 pull-right" data-toggle="modal" data-target="#umlTitleModal">新建</button>
            </div>
            <#--<button class="btn btn-default col-lg-1" onClick="javascript: window.history.back()"><i class="icon-angle-left"></i>&nbsp;返回</button>-->
        </div>
    </div>

    <#if umlList?? && (umlList?size > 0)>
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="row">
                    <#list umlList as uml>
                        <div class="col-xs-3 uml-container" id="uml-${uml.umlid}">
                            <div class="uml-thumbnail" id="wrapper">
                                <img id="thumbnail-${uml.umlid}" style="height:100%;width:100%" src="${(uml.content)!}"/>
                            </div>
                            <div class="uml-title" title="${(uml.title)!"未命名"}">${(uml.title)!"未命名"}</div>
                            <div class="row">
                                <div class="col-xs-6">
                                    <a class="btn btn-info uml-btn" href="/uml/edit?pid=${RequestParameters['pid']}&umlid=${uml.umlid}">编&nbsp;&nbsp;辑</a>
                                </div>
                                <div class="col-xs-6">
                                    <button class="btn btn-danger col-sm-3 uml-btn" onclick="deleteUML(${uml.umlid})">删&nbsp;&nbsp;除</button>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>

        <#--页码-->
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div id="page-nav">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <#assign preffix = "/uml/list?pid=${RequestParameters['pid']}">
                            <#if currentPage == 1>
                                <li class="disabled"><span>&laquo;</span></li>
                            <#else>
                                <li>
                                    <a href="${preffix}&page=${currentPage-1}"><span>&laquo;</span></a>
                                </li>
                            </#if>
                            <#list 1..pageNumber as page>
                                <#if currentPage == page>
                                    <li class="active">
                                        <span>${page}</span>
                                    </li>
                                <#else>
                                    <li>
                                        <a href="${preffix}&page=${page}">${page}</a>
                                    </li>
                                </#if>
                            </#list>

                            <#if currentPage == pageNumber>
                                <li class="disabled"><span>&raquo;</span></li>
                            <#else>
                                <li>
                                    <a href="${preffix}&page=${currentPage+1}"><span>&raquo;</span></a>
                                </li>
                            </#if>
                        </ul>
                    </nav>
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


<#--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="umlTitleModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">请输入UML图标题</h4>
                </div>
                <div class="modal-body" style="height: 100px">
                    <form id="umlTitleForm" onsubmit="return createUml(${RequestParameters['pid']})">
                        <div class="form-group">
                            <label for="inputUmlTitle control-label" class="col-xs-2 col-xs-offset-2 control-label">标题</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputUmlTitle" name="umlTitle" required="required" placeholder="无标题">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success col-xs-2">确认</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@basicLayout.layout>