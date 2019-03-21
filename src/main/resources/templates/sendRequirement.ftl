<#import "basicLayout.ftl" as basicLayout>
<#if requirement??>
    <#assign header = "编辑需求">
<#else>
    <#assign header = "添加需求">
</#if>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <ul class="breadcrumb col">
                <li><a href="/post/projectList?page=1">项目列表</a></li>
                <li><a href="/post/project?pid=${RequestParameters['pid']}&page=1">项目详情</a></li>
                <li class="active">${header}</li>
            </ul>
            <h1>${header}</h1>
        </div>
    </div>

    <div>
        <#if Session.uid??>
            <#if requirement??>
            <#--编辑-->
                <form class="form-horizontal col-sm-offset-3" id="requirementInfoForm" onsubmit="return editRequirement()">
            <#else>
            <#--创建-->
                <form class="form-horizontal col-sm-offset-3" id="requirementInfoForm" onsubmit="return createRequirement()">
            </#if>

            <div class="form-group">
                <label for="inputName" class="col-sm-2 control-label">需求名称</label>
                <div class="col-sm-6">
                    <input class="form-control" id="inputName" name="name" required="required" value="${(requirement.name)!}">
                </div>
            </div>

            <div class="form-group">
                <label for="inputType" class="col-sm-2 control-label">需求类型</label>
                <div class="col-sm-3">
                    <select class="form-control" id="inputType" name="type" required="required" value="${(requirement.type)!}">
                        <option>Security(SE)</option>
                        <option>Reliability (RE)</option>
                        <option>Performance (PE)</option>
                        <option>Lifecycle (LI)</option>
                        <option>Usability (US)</option>
                        <option>Capability (CA)</option>
                        <option>System Interface (SI)</option>
                        <option selected="selected">others</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="inputPriority" class="col-sm-2 control-label">需求优先级（5为最高）</label>
                <div class="col-sm-3">
                    <select class="form-control" id="inputPriority" name="priority" required="required" value="${(requirement.priority)!}">

                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="inputDescription" class="col-sm-2 control-label">详细描述</label>
                <div class="col-sm-6">
                    <textarea class="form-control" rows="10" id="inputDescription" name="description" required="required">${(requirement.description)!}</textarea>
                </div>
            </div>

            <div class="form-group">
                <div>
                    <button class="btn btn-default col-xs-3" onClick="javascript: window.history.back()">取消</button>
                    <button type="submit" class="btn btn-success col-sm-offset-2 col-sm-3">提交</button>
                </div>
            </div>
        </form>

        <#else>
            <div>请先登录</div>
        </#if>

    </div>
</@basicLayout.layout>