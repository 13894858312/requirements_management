<#import "basicLayout.ftl" as basicLayout>
<#if project??>
    <#assign header = "编辑项目">
<#else>
    <#assign header = "创建项目">
</#if>

<@basicLayout.layout>
    <#if Session.uid??>
        <div class="row">
            <div class="col-sm-offset-1 col-sm-10 page-header">
                <h1>${header}</h1>
            </div>
        </div>

        <#if project??>
        <#--编辑-->
            <form class="form-horizontal col-sm-offset-3" id="projectInfoForm" onsubmit="return editProject()">
        <#else>
        <#--创建-->
            <form class="form-horizontal col-sm-offset-3" id="projectInfoForm" onsubmit="return createProject()">
        </#if>

            <div class="form-group">
                <label for="inputName" class="col-sm-2 control-label">项目名称</label>
                <div class="col-sm-6">
                    <input class="form-control" id="inputName" name="name" required="required" value="${(project.name)!}">
                </div>
            </div>

            <div class="form-group">
                <label for="inputLanguage" class="col-sm-2 control-label">项目语言</label>
                <div class="col-sm-4">
                    <input class="form-control" id="inputLanguage" name="language" required="required" value="${(project.language)!}">
                </div>
            </div>

            <div class="form-group">
                <label for="inputField" class="col-sm-2 control-label">项目领域</label>
                <div class="col-sm-4">
                    <input class="form-control" id="inputField" name="field" required="required" value="${(project.field)!}">
                </div>
            </div>

            <div class="form-group">
                <label for="inputClosedTime" class="col-sm-2 control-label">截止日期</label>
                <div class="col-sm-4">
                    <#if project??>
                        <input type="date" class="form-control" id="inputClosedTime" name="closedTime" required="required" min="${.now?string('yyyy-MM-dd')}" value="${project.closedTime?string("yyyy-MM-dd")}">
                    <#else>
                        <input type="date" class="form-control" id="inputClosedTime" name="closedTime" required="required" min="${.now?string('yyyy-MM-dd')}">
                    </#if>
                </div>
            </div>

            <div class="form-group">
                <label for="inputDescription" class="col-sm-2 control-label">项目描述</label>
                <div class="col-sm-6">
                    <textarea class="form-control" rows="10" id="inputDescription" name="description" required="required">${(project.description)!}</textarea></div>
            </div>
            <div class="form-group">
                <div>
                    <button class="btn btn-default col-xs-3" onClick="javascript: window.history.back()">取消</button>
                    <button type="submit" class="btn btn-default col-xs-offset-2 col-xs-3">提交</button>
                </div>
            </div>
        </form>

    <#else>
        <div>请先登录</div>
    </#if>
</@basicLayout.layout>