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
        <button type="button" class="btn btn-default col-sm-1 pull-right" onclick="goToCreateRequirement(${project.pid})">添加新关联</button>
        <a class="btn btn-default col-sm-1 col-sm-offset-1 pull-right" href="/filtrateRequires?pid=${project.pid}">编辑关联</a>
    </div>
</div>
<br/>
<div class="row">
    <div class="col-sm-10 col-sm-offset-1">


        <div class="btn-group btn-group-lg" role="group" aria-label="...">
            <div class="btn-group btn-group-lg" role="group">
                    <div>
                    <script type="application/javascript">

                        var fileTree = JSON.parse(localStorage.getItem('fileTree'))
                        doSomething(fileTree)
                        function doSomething(node){
                            if(node !== null) {
                                document.write("<button type='button' class='btn btn-default dropdown-toggle' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>")
                                document.write("<span>"+node.name+"</span>")
                                document.write("<span class='caret'></span>")
                                document.write("<button type='button' class='btn btn-default pull-right' data-toggle='modal' data-target='#fileTitleModal' onclick='changeFatherName("+"`"+node.name+"`"+")'>新建文件夹</button>")
                                document.write("<button type='button' class='btn btn-default pull-right' data-toggle='modal' data-target='#codeTitleModal'>上传代码文件</button>")
                                document.write("</button>")
                                if(node.sonFile.length){
                                    for(let i=0;i<node.sonFile.length;i++){
                                        doSomething(node.sonFile[i])
                                    }
                                }
                            }
                        }
                    </script>
                    </div>

                <div>
                    <script type="application/javascript">
                        if(name){
                            document.write("<button type='button' class='btn btn-default'>"+name+"</button>")
                            document.write("<button type='button' class='btn btn-default' onclick='goToCodeRelation(${project.pid})'>编辑关联</button>")
                        }
                    </script>
                </div>
            </div>
        </div>

        <br/>


        <br/><br/>

        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="se">
                <#if relationList??&&(relationList?size>0)>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>关联关系ID</th>
                        <th>项目ID</th>
                        <th>A产物类型</th>
                        <th>A产物ID</th>
                        <th>B产物类型</th>
                        <th>B产物ID</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list relationList as relation1>
                       <tr>
                           <td>${relation1.id}</td>
                           <td>${relation1.pid}</td>
                           <td>${relation1.atype}</td>
                           <td>${relation1.aid}</td>
                           <td>${relation1.btype}</td>
                           <td>${relation1.bid}</td>
                       </tr>
                    </#list>
                    </tbody>
                </table>
                <#else>
                    <div class="col-sm-offset-1 col-sm-2">
                        <h4>暂无数据</h4>
                    </div>
                </#if>


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
                    <button type="submit" class="btn btn-success col-xs-2" onclick="newFile()">确认</button>
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