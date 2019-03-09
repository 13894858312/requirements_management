<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <button class="btn btn-default col-sm-1" onClick="javascript: window.history.back()">返回</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#closedTimeModal">开始征集</button>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <#if project??>
                <div class="row">
                    <label class="col-sm-2" for="name">项目名称</label>
                    <div class="col-sm-10" id="name">${project.name}</div>
                </div>
                <br>
                <div class="row">
                    <label class="col-sm-2" for="description">项目描述</label>
                    <div class="col-sm-10" id="description">${project.description}</div>
                </div>
                <br>
                <div class="row">
                    <label class="col-sm-3" for="language">项目语言：</label>
                    <div class="col-sm-3" id="language">${project.language}</div>
                    <label class="col-sm-3" for="field">项目领域：</label>
                    <div class="col-sm-3" id="field">${project.field}</div>
                </div>
            <#else>
                <div>未找到当前项目</div>
            </#if>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-11 col-sm-offset-1">
            <a class="btn btn-default col-sm-1" href="#">需求管理</a>
            <a class="btn btn-default col-sm-1 col-sm-offset-1" href="#">绘制UML图</a>
            <a class="btn btn-default col-sm-1 col-sm-offset-1" href="#">编辑文档</a>
            <a class="btn btn-default col-sm-1 col-sm-offset-1" href="#">提交代码</a>
            <a class="btn btn-default col-sm-1 col-sm-offset-1" href="#">产物列表</a>
            <a class="btn btn-default col-sm-1 col-sm-offset-1" href="#">关联管理</a>
        </div>
    </div>

<#--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">开始征集</h4>
                </div>
                <div class="modal-body">
                    <form id="closedTimeForm" onsubmit="return startCollection()">
                        <div class="form-group">
                            <label for="inputclosedTime" class="col-sm-3 control-label">截止时间</label>
                            <div class="col-sm-4">
                                <input type="datetime" class="form-control" id="inputClosedTime" name="newClosedTime" required="required">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">确认</button>
                </div>
            </div>
        </div>
    </div>
</@basicLayout.layout>