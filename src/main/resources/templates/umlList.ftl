<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <button class="btn btn-default col-lg-1" onClick="javascript: window.history.back()">返回</button>
            <button type="button" class="btn btn-default col-lg-1 pull-right" data-toggle="modal" data-target="#umlTitleModal">新建</button>
        </div>
    </div>

<div class="row">
    <div class="col-sm-10 col-sm-offset-1">
        <#if umlList?? && (umlList?size > 0)>
            <#list umlList as uml>
                <div class="uml-container" id="uml-${uml.umlid}">
                    <div class="uml-thumbnail"></div>
                    <div class="uml-title">${(uml.title)!"无标题"}</div>
                </div>
            </#list>
        <#else>
            <h4>暂无数据</h4>
        </#if>
    </div>
</div>


<#--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="umlTitleModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                    <h4 class="modal-title">请输入UML图标题</h4>
                </div>
                <div class="modal-body" style="height: 100px">
                    <form id="closedTimeForm" onsubmit="return createUml()">
                        <div class="form-group">
                            <label for="inputUmlTitle" class="col-sm-2 col-sm-offset-2 control-label">标题</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="inputUmlTitle" name="umlTitle" required="required" value="无标题">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary col-sm-2">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@basicLayout.layout>