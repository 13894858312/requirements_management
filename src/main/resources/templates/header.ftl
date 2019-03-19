<header id="cm-header">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container" id="navbar">
            <div class="navbar-header" id="navbar-title">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <span><a class="navbar-brand" href="/post/projectList?page=1">众包需求管理系统</a></span>
            </div>
            <div id="menu" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-left" id="navbar-left">
                    <li><a href="/home">首页</a></li>
                    <li><a href="/post/projectList?page=1">项目列表</a></li>
                    <li><a href="/post/myProjects?page=1">我的项目</a></li>
                    <li><a href="/post/sendProject">发布项目</a></li>
                    <li><a href="/post/searchProject">查找项目</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right" id="navbar-right">
                    <#if Session.uid?exists>
                        <li><a href="/userInfo">${Session.uid}</a></li>
                        <li><a href="javascript:void(0);" onclick="logout()">注销</a></li>
                    <#else>
                        <li><a href="/login">登录</a></li>
                        <li><a href="/register">注册</a></li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>
</header>