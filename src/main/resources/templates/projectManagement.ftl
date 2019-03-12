<#import "basicLayout.ftl" as basicLayout>
<#assign header = "项目管理">

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <button class="btn btn-default col-lg-1" onClick="javascript: window.history.back()">返回</button>
            <button type="button" class="btn btn-default col-lg-1 pull-right" data-toggle="modal" data-target="#closedTimeModal">开始征集</button>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h1>${header}</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <div class="management-container">
                <#if project??>
                    <div class="row">
                        <label class="col-md-1" for="name">项目名称</label>
                        <div class="col-md-11" id="name">${(project.name)!}</div>
                    </div>
                    <br/>
                    <div class="row">
                        <label class="col-md-1" for="description">项目描述</label>
                        <div class="col-md-11" id="description">${(project.description)!}</div>
                    </div>
                    <br/>
                    <div class="row">
                        <label class="col-md-1" for="language">项目语言</label>
                        <div class="col-md-5" id="language">${(project.language)!}</div>
                        <label class="col-md-1" for="field">项目领域</label>
                        <div class="col-md-5" id="field">${(project.field)!}</div>
                    </div>
                <#else>
                    <div>未找到当前项目</div>
                </#if>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-11 col-sm-offset-1">
            <a class="btn btn-default col-lg-1" href="#">需求管理</a>
            <a class="btn btn-default col-lg-1 col-lg-offset-1" href="editUML.ftl">绘制UML图</a>
            <a class="btn btn-default col-lg-1 col-lg-offset-1" href="editProjectDocument.ftl">编辑文档</a>
            <a class="btn btn-default col-lg-1 col-lg-offset-1" href="#">提交代码</a>
            <a class="btn btn-default col-lg-1 col-lg-offset-1" href="#">产物列表</a>
            <a class="btn btn-default col-lg-1 col-lg-offset-1" href="#">关联管理</a>
        </div>
    </div>

<#--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="closedTimeModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">请输入新的截止日期</h4>
                </div>
                <div class="modal-body" style="height: 100px">
                    <form id="closedTimeForm" onsubmit="return startCollection()">
                        <div class="form-group">
                            <label for="inputClosedTime" class="col-sm-2 col-sm-offset-2 control-label">截止日期</label>
                            <div class="col-sm-4">
                                <input type="date" class="form-control" id="inputClosedTime" name="newClosedTime" required="required" min="${.now?string('yyyy-MM-dd')}">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary col-sm-2">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@basicLayout.layout>