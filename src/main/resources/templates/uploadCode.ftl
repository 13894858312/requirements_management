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


    </div>
</div>
<br/>

</@basicLayout.layout>