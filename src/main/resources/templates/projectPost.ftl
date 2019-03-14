<#import "basicLayout.ftl" as basicLayout>
<#assign header = "项目详情">

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h1>${header}</h1>
        </div>
    </div>

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
                        <div class="col-sm-12" id="name">（<#if project.state == 1>征集中<#else>已结束</#if>）&nbsp;<b>${project.name}</b></div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-sm-12" id="description">${project.description}</div>
                    </div>
                </div>
                <div class="col-xs-12 post-bottom">
                    <label class="col-sm-1" for="createdTime"><b>创建时间</b></label>
                    <div class="col-sm-2" id="createdTime">${project.createdTime?string("yyyy-MM-dd HH:mm:ss")}</div>
                    <label class="col-sm-1" for="closedTime"><b>截止日期</b></label>
                    <div class="col-sm-2" id="closedTime">${project.closedTime?string("yyyy-MM-dd")}</div>
                    <label class="col-sm-2" for="number"><b>已征集到的需求数</b></label>
                    <div class="col-sm-1" id="number">${numberOfRequirements}</div>

                    <#if Session.uid??>
                        <#if project.publisher == Session.uid>
                        <#--若登陆人为发布者-->
                            <#if project.state == 1>
                            <#--项目未截止，则编辑项目-->
                                <button class="btn btn-default col-sm-1 col-sm-offset-1" onclick="goToEditProject(${project.pid})">编辑项目</button>
                                <button class="btn btn-default col-sm-1" onclick="stopCollection(${project.pid})">截止征集</button>
                            <#else>
                            <#--项目截止，则管理项目-->
                                <a class="btn btn-default col-sm-2 col-sm-offset-1" href="/projectManagement?pid=${project.pid}">管理项目</a>
                            </#if>
                        <#else>
                        <#--若不是发布者，则提交需求-->
                            <button class="btn btn-default col-sm-2 col-sm-offset-1" onclick="goToCreateRequirement(${project.pid})">提交需求</button>
                        </#if>
                    <#else>
                        <a class="btn btn-default col-md-2 col-md-offset-1" href="/login">请先登录</a>
                    </#if>
                </div>
            </div>
        </div>
    </div>
    <#--需求列表-->
    <#if requirementList?? && (numberOfRequirements > 0)>
        <div class="col-sm-offset-1 col-sm-10">
            <h3>需求列表</h3>
            <div>
                <span>共 ${pageNumber} 页，当前第 ${currentPage} 页。</span>
            </div>
        </div>

        <#list requirementList as requirementVO>
            <#assign requirement = requirementVO.requirement>
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
                                <#if Session.uid??>
                                    <a class="pull-right"onclick="like(${requirementVO.like?c}, ${requirement.rid}, ${project.pid})">
                                        <#if requirementVO.like>
                                        <#--已点赞-->
                                            <i id="likeIcon" class="icon-heart-empty"></i>
                                        <#else >
                                        <#--未点赞-->
                                            <i id="likeIcon" class="icon-heart"></i>
                                        </#if>
                                    </a>
                                </#if>
                            </div>
                            <div class="row">
                                <label class="col-sm-2" for="description">详细描述</label>
                                <div class="col-sm-9" id="description">${requirement.description}</div>
                            </div>
                        </div>
                        <#--按钮-->
                        <#if Session.uid??>
                            <#if requirement.uid == Session.uid>
                                <a class="btn btn-default col-sm-2 pull-right" onclick="goToEditRequirement(${project.pid}, ${requirement.rid})">编辑</a>
                            <#else>
                                <button class="btn btn-default col-sm-2 pull-right" data-toggle="modal" data-target="#commentModal" data-rid="${requirement.rid}">评论</button>
                            </#if>
                        </#if>

                        <#--评论列表-->
                        <#if requirementVO.commentList??>
                            <#list requirementVO.commentList as comment>
                                <div class="row">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <div class="row comment-container">
                                            <div class="col-sm-2 comment-left">
                                                <label for="uid">评论者</label>
                                                <div id="uid">${comment.uid}</div>
                                                <br/>
                                                <label for="commentTime">评论时间</label>
                                                <div id="commentTime">${comment.commentTime}</div>
                                            </div>
                                            <div class="col-sm-8 comment-right">
                                                <div id="content">${comment.content}</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </#list>
                        </#if>

                    </div>
                </div>
            </div>
        </#list>

        <#--页码-->
        <div class="row">
            <div class="col-sm-offset-1 col-sm-10" id="page-nav">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <#assign preffix = "/post/project?pid=${RequestParameters['pid']}">
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
    <#else>
        <div class="col-sm-offset-1 col-sm-10">
            <h4>暂无数据</h4>
        </div>
    </#if>


    <#--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="commentModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">添加评论</h4>
                </div>
                <form id="commentForm" onsubmit="return comment()">
                    <#--记录js传来的rid-->
                    <input type="hidden" id="rid" name="rid">

                    <div class="modal-body" style="height: 200px">
                        <div class="form-group">
                            <label for="inputContent" class="col-sm-2 col-sm-offset-2 control-label">添加评论</label>
                            <div class="col-sm-6">
                                <textarea class="form-control" rows="5" id="inputContent" name="content" required="required"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary col-sm-2 pull-right">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@basicLayout.layout>