<#import "basicLayout.ftl" as basicLayout>
<#assign header = "关联关系管理">

<@basicLayout.layout>
<div class="row" xmlns="http://www.w3.org/1999/html">
    <div class="col-sm-offset-1 col-sm-10 page-header">
        <ul class="breadcrumb col">
            <li><a href="/post/myProjects?page=1">我的项目</a></li>
            <li><a href="/post/project?pid=${project.pid}&page=1">项目详情</a></li>
            <li><a href="/projectManagement?pid=${project.pid}">项目管理</a></li>
            <li><a onclick="codeManagement1_1(${project.pid})">上传代码管理</a></li>
            <li class="active">${header}</li>
        </ul>
        <h1>${header}</h1>
    </div>
</div>
<br/>
<div class="row">
    <div class="col-sm-10 col-sm-offset-1">

        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="se">
                <#if relationVOList??&&(relationVOList?size>0)>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>项目名称</th>
                        <th>A产物类型</th>
                        <th>A产物名称</th>
                        <th>A产物描述</th>
                        <th>B产物类型</th>
                        <th>B产物名称</th>
                        <th>B产物描述</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list relationVOList as relationVO>
                        <tr>
                            <td>${project.name}</td>
                            <td>${relationVO.atype}</td>
                            <td>${relationVO.aname}</td>
                            <td>${relationVO.adescription}</td>
                            <td>${relationVO.btype}</td>
                            <td>${relationVO.bname}</td>
                            <td>${relationVO.bdescription}</td>
                            <td>
                                <button type='button' class='btn btn-default' onclick="deleteRelation(${project.pid},${relationVO.id})">取消关联</button>
                            </td>
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


</@basicLayout.layout>