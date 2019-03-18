<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <button class="btn btn-default col-lg-1" onClick="javascript: window.history.back()"><i class="icon-angle-left"></i>&nbsp;返回</button>
            <button type="button" class="btn btn-default col-lg-2 pull-right" data-toggle="modal" data-target="#umlTitleModal">新建</button>
        </div>
    </div>
<br/>
    <#if umlList?? && (umlList?size > 0)>
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="row">
                    <#list umlList as uml>
                        <div class="col-sm-3 uml-container" id="uml-${uml.umlid}">
                            <table class="uml-thumbnail" id="wrapper">
                                <tr>
                                    <td id="thumbnail-${uml.umlid}">${(uml.content)!}</>
                                </tr>
                            </table>
                            <div class="uml-title" title="${(uml.title)!"未命名"}">${(uml.title)!"未命名"}</div>
                            <a class="btn btn-default uml-btn" href="/uml/edit?umlid=${uml.umlid}">编&nbsp;&nbsp;&nbsp;辑</a>
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
        <h4>暂无数据</h4>
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
                    <form id="closedTimeForm" onsubmit="return createUml()">
                        <div class="form-group">
                            <label for="inputUmlTitle" class="col-sm-2 col-sm-offset-2 control-label">标题</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="inputUmlTitle" name="umlTitle" required="required" value="无标题">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary col-sm-2">确认</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@basicLayout.layout>