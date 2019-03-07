<#import "basicLayout.ftl" as basicLayout>
<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h1>注册</h1>
        </div>
    </div>
    <div>
        <form class="form-horizontal col-sm-offset-3">
            <div class="form-group">
                <label for="inputUid" class="col-sm-2 control-label">登录名</label>
                <div class="col-sm-6">
                    <input class="form-control" id="inputUid" placeholder="请输入登录名">
                </div>
                <span id="helpUid" class="help-block"></span>
            </div>

            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-6">
                    <input type="password" class="form-control" id="inputPassword" placeholder="请输入密码">
                </div>
                <span id="helpPassword" class="help-block"></span>
            </div>

            <div class="form-group">
                <label for="inputRePassword" class="col-sm-2 control-label">确认密码</label>
                <div class="col-sm-6">
                    <input type="password" class="form-control" id="inputRePassword" placeholder="请确认密码">
                </div>
                <span id="helpRePassword" class="help-block"></span>
            </div>


            <div class="form-group">
                <label for="inputName" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-6">
                    <input class="form-control" id="inputName" placeholder="姓名">
                </div>
                <span id="helpName" class="help-block"></span>
            </div>

            <div class="form-group">
                <label for="inputTelephone" class="col-sm-2 control-label">联系电话</label>
                <div class="col-sm-6">
                    <input class="form-control" id="inputTelephone" placeholder="联系电话">
                </div>
                <span id="helpTelephone" class="help-block"></span>
            </div>

            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">电子邮箱</label>
                <div class="col-sm-6">
                    <input type="email" class="form-control" id="inputEmail" placeholder="电子邮箱">
                </div>
                <span id="helpEmail" class="help-block"></span>
            </div>

            <div class="form-group">
                <label for="inputOccupation" class="col-sm-2 control-label">职业</label>
                <div class="col-sm-6">
                    <input class="form-control" id="inputOccupation" placeholder="职业">
                </div>
                <span id="helpOccupation" class="help-block"></span>
            </div>

            <div class="form-group">
                <label for="inputIntroduction" class="col-sm-2 control-label">个人简介</label>
                <div class="col-sm-6">
                    <textarea class="form-control" rows="5" id="inputIntroduction" placeholder="个人简介"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div>
                    <button type="submit" class="btn btn-default col-sm-8 sign-button" id="registerSubmit">注册</button>
                </div>
            </div>
        </form>
    </div>
</@basicLayout.layout>