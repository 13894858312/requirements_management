<header id="cm-header">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid" id="navbar">
            <div class="navbar-header" id="navbar-title">
                <a class="navbar-brand" href="#">众包需求管理系统</a>
            </div>
            <div>
                <ul class="nav navbar-nav navbar-left" id="navbar-left">
                    <li class="active"><a href="/home">首页</a></li>
                    <li><a href="/post/projectList">项目列表</a></li>
                    <li><a href="/post/myProjects">我的项目</a></li>
                    <li><a href="/post/sendProject">发布项目</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right" id="navbar-right">
                    <#if Session.account?exists>
                        <li><a href="/userInfo">我的信息</a></li>
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