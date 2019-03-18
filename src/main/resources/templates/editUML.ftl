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
        <title>编辑UML图</title>
    </head>

    <body class="cm-no-transition full-height">
        <div class="global full-height">
            <div class="row full-height">
                <div class="col-sm-3" id="uml-left">
                    <div class="row">
                        <button class="btn btn-default col-lg-3 col-lg-offset-1" id="uml-back" onclick="javascript:window.history.back()"><i class="icon-angle-left"></i>&nbsp;返回</button>
                    </div>
                    <table id="wrapper">
                        <tr>
                            <td id="diagram"></td>
                        </tr>
                    </table>
                    <div class="row">
                        <div id="uml-requirement-table"></div>
                    </div>
                    <div class="row">
                        <div id="uml-relationships"></div>
                    </div>
                </div>
                <div class="col-sm-9 full-height">
                    <div id="umlEditor" class="full-height"></div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="/js/jquery-2.1.3.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/js/rm.js"></script>
        <script type="text/javascript" src="/js/uml.js"></script>

    </body>
</html>
