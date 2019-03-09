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

                    <div class="form-group">
                        <label for="inputName" class="col-sm-2 control-label">需求名称</label>
                        <div class="col-sm-6">
                            <input class="form-control" id="inputName" name="name" required="required" value="${requirement.name}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputType" class="col-sm-2 control-label">需求类型</label>
                        <div class="col-sm-3">
                            <select class="form-control" id="inputType" name="type" required="required" value="${requirement.type}">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="inputPriority" class="col-sm-2 control-label">需求优先级</label>
                        <div class="col-sm-3">
                            <select class="form-control" id="inputPriority" name="priority" required="required" value="${requirement.priority}">
                                <option>高</option>
                                <option>中</option>
                                <option>低</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputdescription" class="col-sm-2 control-label">详细描述</label>
                        <div class="col-sm-6">
                            <textarea class="form-control" rows="10" id="inputDescription" name="description" required="required">${requirement.description}</textarea>
                        </div>
                    </div>
            <#else>
            <#--创建-->
                <form class="form-horizontal col-sm-offset-3" id="requirementInfoForm" onsubmit="return createRequirement()">

                    <div class="form-group">
                        <label for="inputName" class="col-sm-2 control-label">需求名称</label>
                        <div class="col-sm-6">
                            <input class="form-control" id="inputName" name="name" required="required">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputType" class="col-sm-2 control-label">需求类型</label>
                        <div class="col-sm-3">
                            <select class="form-control" id="inputType" name="type" required="required">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputPriority" class="col-sm-2 control-label">需求优先级</label>
                        <div class="col-sm-3">
                            <select class="form-control" id="inputPriority" name="priority" required="required">
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
                            <textarea class="form-control" rows="10" id="inputDescription" name="description" required="required"></textarea>
                        </div>
                    </div>

            </#if>

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