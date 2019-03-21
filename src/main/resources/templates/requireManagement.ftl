<#import "basicLayout.ftl" as basicLayout>
<#assign header = "需求管理">

<@basicLayout.layout>
<br/>
<div class="row">
    <div class="col-sm-offset-1 col-sm-10 page-header">
        <ul class="breadcrumb col">
            <li><a href="/post/myProjects?page=1">我的项目</a></li>
            <li><a href="/post/project?pid=${project.pid}&page=1">项目详情</a></li>
            <li><a href="/projectManagement?pid=${project.pid}">项目管理</a></li>
            <li class="active">${header}</li>
        </ul>
        <h1>${header}</h1>
        <br/>
        <button type="button" class="btn btn-default col-sm-1 pull-right" onclick="goToCreateRequirement(${project.pid})">添加新需求</button>
        <a class="btn btn-default col-sm-1 col-sm-offset-1 pull-right" href="/filtrateRequires?pid=${project.pid}">筛选需求</a>
    </div>
</div>
<br/>
<div class="row">
    <div class="col-sm-10 col-sm-offset-1">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#se" data-toggle="tab">Security(SE)</a></li>
            <li><a href="#re" data-toggle="tab">Reliability(RE)</a></li>
            <li><a href="#se" data-toggle="tab">Performance(PE)</a></li>
            <li><a href="#se" data-toggle="tab">Lifecycle(LI)</a></li>
            <li><a href="#se" data-toggle="tab">Usability(US)</a></li>
            <li><a href="#se" data-toggle="tab">Capability(CA)</a></li>
            <li><a href="#se" data-toggle="tab">System Interface(SI)</a></li>
            <li><a href="#se" data-toggle="tab">others</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="se">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>需求名称</th>
                        <th>需求描述</th>
                        <th>优先级</th>
                        <th>提供者</th>
                        <th>发布时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>test</td>
                        <td>t</td>
                        <td>1</td>
                        <td>te</td>
                        <td>0000</td>

                    </tr>
                    <tr>
                        <td>test2</td>
                        <td>t2</td>
                        <td>12</td>
                        <td>te2</td>
                        <td>00002</td>

                    </tr>
                    <tr>
                        <td>test3</td>
                        <td>t3</td>
                        <td>13</td>
                        <td>te3</td>
                        <td>00003</td>

                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane fade" id="re">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>需求名称</th>
                        <th>需求描述</th>
                        <th>优先级</th>
                        <th>提供者</th>
                        <th>发布时间</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>test</td>
                        <td>t</td>
                        <td>1</td>
                        <td>te</td>
                        <td>0000</td>

                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


</@basicLayout.layout>