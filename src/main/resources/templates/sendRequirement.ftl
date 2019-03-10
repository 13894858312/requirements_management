<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <#if requirement??>
                <h1>编辑需求</h1>
            <#else>
                <h1>添加需求</h1>
            </#if>
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
                    <#if requirement??>
                        <input class="form-control" id="inputName" name="name" required="required" value="${requirement.name}">
                    <#else>
                        <input class="form-control" id="inputName" name="name" required="required">
                    </#if>
                </div>
            </div>

            <div class="form-group">
                <label for="inputType" class="col-sm-2 control-label">需求类型</label>
                <div class="col-sm-3">
                    <#if requirement??>
                        <select class="form-control" id="inputType" name="type" required="required" value="${requirement.type}">
                    <#else>
                        <select class="form-control" id="inputType" name="type" required="required">
                    </#if>
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
                    <#if requirement??>
                        <select class="form-control" id="inputPriority" name="priority" required="required" value="${requirement.priority}">
                    <#else>
                        <select class="form-control" id="inputPriority" name="priority" required="required">
                    </#if>
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
                    <textarea class="form-control" rows="10" id="inputDescription" name="description" required="required"><#if requirement??>${requirement.description}</#if></textarea>
                </div>
            </div>

            <div class="form-group">
                <div>
                    <button class="btn btn-default col-sm-3" onClick="javascript: window.history.back()">取消</button>
                    <button type="submit" class="btn btn-default col-sm-offset-2 col-sm-3">提交</button>
                </div>
            </div>

        </form>

        <#else>
            <div>请先登录</div>
        </#if>

    </div>
</@basicLayout.layout>