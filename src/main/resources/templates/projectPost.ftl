<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
<#--项目信息-->
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10">
            <div class="row post-container">
                <div class="col-sm-2 post-left">
                    <div>
                        <label for="publisher">项目发布者</label>
                        <div id="publisher">${project.publisher}</div>
                    </div>
                    <br/>
                    <div>
                        <label for="language">项目语言</label>
                        <div id="language">${project.language}</div>
                    </div>
                    <br/>
                    <div>
                        <label for="field">项目领域</label>
                        <div id="field">${project.field}</div>
                    </div>
                </div>
                <div class="col-sm-9 post-right">
                    <div class="row">
                        <div class="col-sm-12" id="name"><b>${project.name}</b>&nbsp;（<#if project.state == 1>征集中<#else>已结束</#if>）</div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-sm-12" id="description">${project.description}</div>
                    </div>
                </div>
                <div class="col-sm-12 post-bottom">
                    <label class="col-sm-1" for="createdTime"><b>创建时间</b></label>
                    <div class="col-sm-2" id="createdTime">${project.createdTime?string("yyyy-MM-dd HH:mm:ss")}</div>
                    <label class="col-sm-1" for="closedTime"><b>截止日期</b></label>
                    <div class="col-sm-2" id="closedTime">${project.closedTime?string("yyyy-MM-dd")}</div>
                    <label class="col-sm-2" for="number"><b>已征集到的需求数</b></label>
                    <div class="col-sm-1" id="number">${numberOfRequirements}</div>

                    <#if Session.uid?? && project.publisher == Session.uid>
                    <#--若登陆人为发布者，则编辑项目-->
                        <button class="btn btn-default col-sm-2 col-sm-offset-1" onclick="goToEditProject(${project.pid})">编辑项目</button>
                    <#else>
                    <#--若不是发布者，则提交需求-->
                        <button class="btn btn-default col-sm-2 col-sm-offset-1" onclick="goToCreateRequirement(${project.pid})">提交需求</button>
                    </#if>
                </div>
            </div>
        </div>
    </div>
    <#--需求列表-->
    <#if requirementList??>
        <div class="col-sm-offset-1 col-sm-10">
            <h3>需求列表</h3>
        </div>
        <#list requirementList as requirement>
            <div class="row">
                <div class="col-sm-offset-1 col-sm-10">
                    <div class="row reply-container">
                        <div class="col-sm-2 reply-left">
                            <div>
                                <label for="uid">需求提供者</label>
                                <div id="uid">${requirement.uid}</div>
                            </div>
                            <div>
                                <label for="priority">优先级</label>
                                <div id="priority">${requirement.priority}</div>
                            </div>
                            <div>
                                <label for="type">需求类型</label>
                                <div id="type">${requirement.type}</div>
                            </div>
                            <div>
                                <label for="postTime">提供时间</label>
                                <div id="postTime">${requirement.postTime?string("yyyy-MM-dd HH:mm:ss")}</div>
                            </div>
                        </div>
                        <div class="col-sm-9 reply-right">
                            <div class="row">
                                <label class="col-sm-2" for="name">需求名称</label>
                                <div class="col-sm-9" id="name"><b>${requirement.name}</b></div>

                                <#if requirement.uid == Session.uid>
                                    <a class="pull-right" onclick="goToEditRequirement(${project.pid}, ${requirement.rid})">编辑</a>
                                <#else>
                                    <a class="pull-right">点赞</a>
                                </#if>
                            </div>
                            <div class="row">
                                <label class="col-sm-2" for="description">详细描述</label>
                                <div class="col-sm-9" id="description">${requirement.description}</div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </#list>
    </#if>
</@basicLayout.layout>