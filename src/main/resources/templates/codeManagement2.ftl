<#import "basicLayout.ftl" as basicLayout>
<#assign header = "上传代码管理">

<@basicLayout.layout>
<div class="row" xmlns="http://www.w3.org/1999/html">
    <div class="col-sm-offset-1 col-sm-10 page-header">
    <ul class="breadcrumb col">
        <li><a href="/post/myProjects?page=1">我的项目</a></li>
        <li><a href="/post/project?pid=${project.pid}&page=1">项目详情</a></li>
        <li><a href="/projectManagement?pid=${project.pid}">项目管理</a></li>
        <li class="active">${header}</li>
    </ul>
    <h1>${header}</h1>
    <br/>
    <#--<h2>${project.name}<h2>-->
    </div>
</div>
<div class="row">
    <div class="col-sm-10 col-sm-offset-1">
        <div class="container">
            <div class="btn-group">
                <button type="button" class="btn btn-default">项目1</button>
                <button type="button" class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
                    代码文件列表
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                    <#if codeList??&&(codeList?size>0)>
                        <#list codeList as code>
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="#">${code.name}</a>
                            </li>
                            <button type='button' class='btn btn-default' onclick="goToCodeRelation(${project.pid},${code.id})">编辑关联</button>
                        </#list>
                    </#if>
                </ul>
                <button type="button" class="btn btn-default" data-toggle='modal' data-target='#codeTitleModal'>上传代码文件</button>
                <button type="button" class="btn btn-default" data-toggle='modal' data-target='#fileTitleModal'>新建文件夹</button>
            </div>
            <br/>
            <div class="btn-group" style="margin-left: 30px">
                <button type="button" class="btn btn-default">文件夹1</button>
                <button type="button" class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
                    代码文件列表
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                    <#if codeList??&&(codeList?size>0)>
                        <#list codeList as code>
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="#">${code.name}</a>
                            </li>
                            <button type='button' class='btn btn-default' onclick="goToCodeRelation(${project.pid},${code.id})">编辑关联</button>
                        </#list>
                    </#if>
                </ul>
                <button type="button" class="btn btn-default" data-toggle='modal' data-target='#codeTitleModal'>上传代码文件</button>
                <button type="button" class="btn btn-default" data-toggle='modal' data-target='#fileTitleModal1'>新建文件夹</button>
            </div>
            <br/>
            <div class="btn-group" style="margin-left: 30px">
                <button type="button" class="btn btn-default">文件夹2</button>
                <button type="button" class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
                    代码文件列表
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                    <#if codeList??&&(codeList?size>0)>
                        <#list codeList as code>
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="#">${code.name}</a>
                            </li>
                            <button type='button' class='btn btn-default' onclick="goToCodeRelation(${project.pid},${code.id})">编辑关联</button>
                        </#list>
                    </#if>
                </ul>
                <button type="button" class="btn btn-default" data-toggle='modal' data-target='#codeTitleModal'>上传代码文件</button>
                <button type="button" class="btn btn-default" data-toggle='modal' data-target='#fileTitleModal'>新建文件夹</button>
            </div>
        </div>


    </div>
</div>
<br/>

<#--模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="fileTitleModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <h4 class="modal-title">请输入文件夹名称</h4>
            </div>
            <div class="modal-body" style="height: 100px">
                <div class="form-group">
                    <label for="inputUmlTitle control-label" class="col-xs-2 col-xs-offset-2 control-label">文件夹名称</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="inputUmlTitle" name="umlTitle" required="required" placeholder="无标题" oninput="changeFileName(value)">
                    </div>
                </div>
                <button type="submit" class="btn btn-success col-xs-2" onclick="codeManagement3(${project.pid})">确认</button>
            </div>
        </div>
    </div>
</div>

<#--模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="fileTitleModal1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <h4 class="modal-title">请输入文件夹名称</h4>
            </div>
            <div class="modal-body" style="height: 100px">
                <div class="form-group">
                    <label for="inputUmlTitle control-label" class="col-xs-2 col-xs-offset-2 control-label">文件夹名称</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" id="inputUmlTitle" name="umlTitle" required="required" placeholder="无标题" oninput="changeFileName(value)">
                    </div>
                </div>
                <button type="submit" class="btn btn-success col-xs-2" onclick="codeManagement1_1(${project.pid})">确认</button>
            </div>
        </div>
    </div>
</div>

<#--模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="codeTitleModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <h4 class="modal-title">上传代码文件</h4>
            </div>
            <div class="modal-body" style="height: 150px">
                <form class="form-horizontal col-sm-offset-3" id="uploadForm" onsubmit="return uploadCodeFile()" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="upload_file">代码文件输入</label>
                        <div class="col-sm-6">
                            <input type="file" class="form-control" id="upload_file" name="upload_file">
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <button class="btn btn-default col-xs-3" onClick="javascript: window.history.back()">取消</button>
                            <button type="submit" class="btn btn-success col-xs-offset-2 col-xs-3" >提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</@basicLayout.layout>