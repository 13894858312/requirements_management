<!DOCTYPE html>
<#macro layout>

    <html lang="en">
        <head>
            <meta charset="utf-8" />
            <meta name="description" content="众包需求管理与分析系统" />
            <meta name="keywords" content="众包,需求管理,软件需求,软件众包">
            <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
            <meta http-equiv="content-type" content="text/html; charset=utf-8" />

            <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
            <link rel="stylesheet" type="text/css" href="/css/rm.css">
            <title>众包需求管理与分析系统</title>
        </head>

        <body class="cm-no-transition cm-1-navbar">
            <#--header-->
            <#include "header.ftl">

                <#nested>

            <script type="text/javascript" src="/js/jquery-2.1.3.min.js"></script>
            <script type="text/javascript" src="/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="/js/rm.js"></script>
            <script type="text/javascript" src="/js/md5.js"></script>
            <script type="text/javascript" src="/js/account.js"></script>
            <script type="text/javascript" src="/js/post.js"></script>
            <script type="text/javascript" src="/js/projectManagement.js"></script>

        </body>
    </html>

</#macro>