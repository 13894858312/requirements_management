<#import "basicLayout.ftl" as basicLayout>
<#assign header = "修改密码">

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h1>${header}</h1>
        </div>
    </div>

    <div>
        <form class="form-horizontal col-sm-offset-4" onsubmit="return changePassword()">
            <div class="form-group">
                <label for="inputOldPassword" class="col-sm-2 control-label">原密码</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="inputOldPassword" name="oldPassword" placeholder="请输入原密码" required="required" autocomplete="off">
                </div>
                <span id="helpOldPassword" class="help-block"></span>
            </div>


            <div class="form-group">
                <label for="inputNewPassword" class="col-sm-2 control-label">新密码</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="inputNewPassword" name="newPassword" placeholder="请输入新密码" required="required" autocomplete="off">
                </div>
                <span id="helpNewPassword" class="help-block"></span>
            </div>

            <div class="form-group">
                <label for="inputRePassword" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="inputRePassword" name="newPassword" placeholder="请再次输入新密码" required="required" autocomplete="off">
                </div>
                <span id="helpRePassword" class="help-block"></span>
            </div>

            <div class="form-group">
                <div>
                    <button class="btn btn-default col-xs-2 sign-button" onClick="javascript: window.history.back()">取消</button>
                    <button type="submit" class="btn btn-success col-xs-offset-2 col-xs-2 sign-button">确认</button>
                </div>
            </div>
        </form>
    </div>
</@basicLayout.layout>