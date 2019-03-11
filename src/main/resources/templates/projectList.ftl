<#import "basicLayout.ftl" as basicLayout>
<#--header从controller传送-->

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h1>${header!"项目列表"}</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10">
            <h5>共 ${pageNumber} 页，每页10条。当前第 ${currentPage} 页。</h5>
        </div>
    </div>

    <#--项目列表-->
    <#if projectList?? && (projectList?size > 0)>
        <#list projectList as project>
            <div class="row">
                <div class="col-sm-offset-1 col-sm-10">
                    <div class="project-container">
                        <div class="row">
                            <div class="col-xs-8">
                                <div class="row">
                                    <label class="col-sm-2" for="post-project-name">项目名称：</label>
                                    <div class="col-xs-10" id="post-project-name">${project.name}</div>
                                </div>
                                <br/>
                                <div class="row">
                                    <label class="col-sm-2" for="post-project-description">项目描述：</label>
                                    <div class="col-xs-10" id="post-project-description">${project.description}</div>
                                </div>
                            </div>
                            <div class="col-xs-3">
                                <div>
                                    <span id="createdTime"><b>创建时间：</b>${project.createdTime?string("yyyy-MM-dd HH:mm:ss")}</span>
                                </div>
                                <br/>
                                <div id="state"><b>项目状态：</b><#if project.state == 1>征集中<#else>已截止</#if>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 project-bottom">
                                <div class="col-xs-2" id="publisher"><b>发布者：</b>${project.publisher}</div>
                                <div class="col-xs-2 col-xs-offset-1" id="language"><b>项目语言：</b>${project.language}</div>
                                <div class="col-xs-2 col-xs-offset-1" id="field"><b>项目领域：</b>${project.field}</div>

                                <button class="btn btn-default col-xs-offset-1 col-xs-2" onclick="goToPost(${project.pid})">查看详情</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
        <#--页码-->
        <div class="row">
            <div class="col-sm-offset-1 col-sm-10" id="page-nav">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <#if currentPage == 1>
                            <li class="disabled"><span>&laquo;</span></li>
                        <#else>
                            <li>
                                <#if header == "项目列表">
                                    <a href="/post/projectList?page=${currentPage-1}">
                                <#elseif header == "我的项目">
                                    <a href="/post/myProjects?page=${currentPage-1}">
                                <#elseif header == "搜索结果">
                                    <a href="/post/searchResult?page=${currentPage-1}${condition}">
                                </#if>
                                    <span>&laquo;</span>
                                </a>
                            </li>
                        </#if>
                        <#list 1..pageNumber as page>
                            <#if currentPage == page><li class="active"><#else><li></#if>
                                    <#if header == "项目列表">
                                        <a href="/post/projectList?page=${page}">${page}</a>
                                    <#elseif header == "我的项目">
                                        <a href="/post/myProjects?page=${page}">${page}</a>
                                    <#elseif header == "搜索结果">
                                        <a href="/post/searchResult?page=${page}${condition}">${page}</a>
                                    </#if>
                            </li>
                        </#list>
                        <#if currentPage == pageNumber>
                            <li class="disabled"><span>&raquo;</span></li>
                        <#else>
                            <li>
                                <#if header == "项目列表">
                                    <a href="/post/projectList?page=${currentPage+1}">
                                <#elseif header == "我的项目">
                                    <a href="/post/myProjects?page=${currentPage+1}">
                                <#elseif header == "搜索结果">
                                    <a href="/post/searchResult?page=${currentPage+1}${condition}">
                                </#if>
                                    <span>&raquo;</span>
                                </a>
                            </li>
                        </#if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <#else>
        <div class="col-sm-offset-1 col-sm-2"><h4>暂无数据</h4></div>
    </#if>

</@basicLayout.layout>