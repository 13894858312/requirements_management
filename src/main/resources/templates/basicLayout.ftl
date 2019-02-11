<!DOCTYPE html>
<#assign ctx = request.contextPath>
<#macro layout>

    <html lang="en">
        <head>
            <meta charset="utf-8" />
            <meta name="description" content="众包需求管理系统" />
            <meta name="keywords" content="众包,需求管理,软件需求">
            <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

            <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
            <link rel="stylesheet" type="text/css" href="/css/rm.css">

            <title>众包需求管理系统</title>
        </head>

        <body class="cm-no-transition cm-1-navbar">
            <#--header-->
            <#include "header.ftl">

            <div id="global">
                <#nested>
            </div id="global">

            <script type="text/javascript" src="/js/jquery-2.1.3.min.js"></script>
            <script type="text/javascript" src="/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="/js/rm.js"></script>
        </body>
    </html>

</#macro>