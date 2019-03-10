<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
<div class="row">
    <div class="col-sm-offset-1 col-sm-10 page-header">
        <h1>项目列表</h1>
    </div>
<#--项目列表-->
    <#if projectList??>
        <#list projectList as project>
            <div class="row">
                <div class="col-sm-offset-1 col-sm-10">
                    <div class="project-container">
                        <div class="row">
                            <div class="col-sm-8">
                                <div class="row">
                                    <label class="col-sm-2" for="post-project-name">项目名称：</label>
                                    <div class="col-sm-10" id="post-project-name">${project.name}</div>
                                </div>
                                <br/>
                                <div class="row">
                                    <label class="col-sm-2" for="post-project-description">项目描述：</label>
                                    <div class="col-sm-10" id="post-project-description">${project.description}</div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div>
                                    <span id="createdTime"><b>创建时间：</b>${project.createdTime?string("yyyy-MM-dd HH:mm:ss")}</span>
                                </div>
                                <br/>
                                <div id="state"><b>项目状态：</b><#if project.state == 1>征集中<#else>已截止</#if>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 project-bottom">
                                <div class="col-sm-2" id="publisher"><b>发布者：</b>${project.publisher}</div>
                                <div class="col-sm-2 col-sm-offset-1" id="language"><b>项目语言：</b>${project.language}</div>
                                <div class="col-sm-2 col-sm-offset-1" id="field"><b>项目领域：</b>${project.field}</div>

                                <button class="btn btn-default col-sm-offset-1 col-sm-2" onclick="goToPost(${project.pid})">查看详情</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    <#else>
        <div>暂无数据</div>
    </#if>
</div>
</@basicLayout.layout>