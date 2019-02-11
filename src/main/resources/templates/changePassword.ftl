<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h1>修改密码</h1>
        </div>
    </div>
    <div>
        <form class="form-horizontal col-sm-offset-4">
            <div class="form-group">
                <label for="inputUid" class="col-sm-2 control-label">登录名</label>
                <div class="col-sm-4">
                    <input class="form-control required" id="inputUid" placeholder="请输入登录名">
                </div>
                <span id="helpUid" class="help-block"></span>
            </div>

            <div class="form-group">
                <label for="inputOldPassword" class="col-sm-2 control-label">原密码</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control required" id="inputOldPassword" placeholder="请输入原密码">
                </div>
                <span id="helpOldPassword" class="help-block"></span>
            </div>


            <div class="form-group">
                <label for="inputNewPassword" class="col-sm-2 control-label">新密码</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control required" id="inputNewPassword" placeholder="请输入新密码">
                </div>
                <span id="helpNewPassword" class="help-block"></span>
            </div>

            <div class="form-group">
                <label for="inputRePassword" class="col-sm-2 control-label">确认新密码</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control required" id="inputRePassword" placeholder="请再次输入新密码">
                </div>
                <span id="helpRePassword" class="help-block"></span>
            </div>

            <div class="form-group">
                <div>
                    <button class="btn btn-default col-sm-2" onClick="javascript: window.history.back()">取消</button>
                    <button type="submit" class="btn btn-default col-sm-offset-2 col-sm-2">确认</button>
                </div>
            </div>
        </form>
    </div>
</@basicLayout.layout>