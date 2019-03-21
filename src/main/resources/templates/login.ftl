<#import "basicLayout.ftl" as basicLayout>
<#assign header = "登录">

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h1>${header}</h1>
        </div>
    </div>

    <div>
        <form class="form-horizontal col-sm-offset-4" name="loginForm" onsubmit="return login()">
            <div class="form-group">
                <label for="inputUid" class="col-sm-2 control-label">登录名</label>
                <div class="col-sm-4">
                    <input class="form-control" id="inputUid" name="uid" placeholder="请输入登录名" required="required">
                </div>
                <span id="helpUid" class="help-block"></span>
            </div>

            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="inputPassword" name="password" placeholder="请输入密码" required="required" autocomplete="off">
                </div>
                <span id="helpPassword" class="help-block"></span>
            </div>

            <div class="form-group">
                <div>
                    <button type="submit" class="btn btn-info col-xs-6 sign-button">登录</button>
                </div>
            </div>
        </form>
    </div>
</@basicLayout.layout>