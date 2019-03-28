<!DOCTYPE html>

<html lang="en" class="full-height">
    <head>
        <meta charset="utf-8" />
        <meta name="description" content="众包需求管理与分析系统" />
        <meta name="keywords" content="众包,需求管理,软件需求,软件众包">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />

        <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="/css/rm.css">
        <link rel="stylesheet" type="text/css" href="/static/bootstrap-table/bootstrap-table.css">
        <title>编辑UML图</title>
    </head>

    <body class="cm-no-transition full-height">
        <div class="uml-global full-height">
            <div class="row full-height">
                <div class="col-sm-3" id="uml-left">
                    <div class="row">
                        <button class="btn btn-default col-lg-3" id="uml-back" onclick="javascript:window.history.back()"><i class="icon-angle-left"></i>&nbsp;返回</button>
                    </div>
                    <br/>

                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active">
                            <a href="#requirementList" data-toggle="tab">需求列表</a>
                        </li>
                        <li><a href="#relationships" data-toggle="tab">关联需求</a></li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade in active" id="requirementList">
                            <#--需求列表 -->
                            <div class="row">
                                <div class="tab-pane" id="requirementTab">
                                    <table id="uml-requirement-table"
                                           data-toggle="table"
                                           data-url="/uml/getRequirementList.do?pid=${RequestParameters['pid']}"
                                           data-show-refresh='true'
                                           data-show-toggle='true'
                                           data-show-columns='true'
                                           data-search='true'
                                           data-search-align='left'
                                           data-height='500'
                                           data-show-footer='false'
                                           data-striped='true'
                                           data-sort-stable='true'
                                           data-pagination='true'
                                           data-pagesize="10"
                                           data-sort-name="rid"
                                           data-sort-order="desc"
                                    >
                                        <thead>
                                        <tr>
                                            <th data-field="uid" data-visible="false">提供者</th>
                                            <th data-field="postTime" data-formatter="timestampFormatter" data-visible="false">提交时间</th>
                                            <th data-field="name">需求名称</th>
                                            <th data-field="type" data-visible="false">类别</th>
                                            <th data-field="priority" data-visible="false">优先级</th>
                                            <th data-field="Button" data-events="operationEvents" data-formatter="addRequirementButton" data-width="134px">操作</th>
                                        </tr>
                                        </thead>
                                    </table>
                                </div><!--tab-pane-->
                            </div>
                        </div>
                        <div class="tab-pane fade" id="relationships">
                            <#--关联需求列表-->
                            <div class="row">
                                <div class="tab-pane" id="relationshipTab">
                                    <table id="uml-relationship-table"
                                           data-toggle="table"
                                           data-url="/uml/getRelationshipList.do?umlid=${RequestParameters['umlid']}"
                                           data-show-refresh='true'
                                           data-show-toggle='true'
                                           data-show-columns='true'
                                           data-search='true'
                                           data-search-align='left'
                                           data-height='500'
                                           data-show-footer='false'
                                           data-striped='true'
                                           data-sort-stable='true'
                                           data-pagination='true'
                                           data-pagesize="10"
                                           data-sort-name="rid"
                                           data-sort-order="desc"
                                    >
                                        <thead>
                                        <tr>
                                            <th data-field="uid" data-visible="false">提供者</th>
                                            <th data-field="postTime" data-formatter="timestampFormatter" data-visible="false">提交时间</th>
                                            <th data-field="name">需求名称</th>
                                            <th data-field="type" data-visible="false">类别</th>
                                            <th data-field="priority" data-visible="false">优先级</th>
                                            <th data-field="Button" data-events="operationEvents" data-formatter="addRelationshipButton">操作</th>
                                        </tr>
                                        </thead>
                                    </table>
                                </div><!--tab-pane-->
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-9 full-height">
                    <div id="umlEditor" class="full-height"></div>
                </div>
            </div>
        </div>


        <#--模态框-->
        <div class="modal fade" tabindex="-1" role="dialog" id="detailsModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                        <h4 class="modal-title">需求详情</h4>
                    </div>
                    <div class="modal-body col-sm-offset-2" style="min-height: 400px">
                        <div class="row">
                            <label class="col-sm-3 control-label" for="name">需求名称</label>
                            <div class="col-sm-5" id="name"></div>
                        </div>
                        <br/>
                        <div class="row">
                            <label class="col-sm-3 control-label" for="postTime">提交时间</label>
                            <div class="col-sm-5" id="postTime"></div>
                        </div>
                        <br/>
                        <div class="row">
                            <label class="col-sm-3 control-label" for="uid">提供者</label>
                            <div class="col-sm-5" id="uid"></div>
                        </div>
                        <br/>
                        <div class="row">
                            <label class="col-sm-3 control-label" for="type">类型</label>
                            <div class="col-sm-5" id="type"></div>
                        </div>
                        <br/>
                        <div class="row">
                            <label class="col-sm-3 control-label" for="priority">优先级</label>
                            <div class="col-sm-5" id="priority"></div>
                        </div>
                        <br/>
                        <div class="row">
                            <label class="col-sm-3 control-label" for="description">详细描述</label>
                            <div class="col-sm-5" id="description"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="/js/jquery-2.1.3.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/js/rm.js"></script>
        <script type="text/javascript" src="/js/uml.js"></script>
        <script type="text/javascript" src="/static/bootstrap-table/bootstrap-table.js"></script>
        <script type="text/javascript" src="/static/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>

    </body>
</html>
