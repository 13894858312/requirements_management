<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1 page-header">
            <div class="row">
                <div class="col-sm-4">
                    <h1>个人资料</h1>
                </div>
                <div class="pull-right col-sm-2 col-md-1">
                    <button class="btn btn-default">修改密码</button>
                </div>
            </div>
        </div>
    </div>
    <div>
        <form class="form-horizontal col-sm-offset-3">
            <div class="form-group">
                <label for="inputName" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-3">
                    <input class="form-control" id="inputName">
                </div>
            </div>

            <div class="form-group">
                <label for="inputOccupation" class="col-sm-2 control-label">职业</label>
                <div class="col-sm-3">
                    <input class="form-control" id="inputOccupation">
                </div>
            </div>

            <div class="form-group">
                <label for="inputTelephone" class="col-sm-2 control-label">联系电话</label>
                <div class="col-sm-3">
                    <input class="form-control" id="inputTelephone">
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">电子邮箱</label>
                <div class="col-sm-3">
                    <input type="email" class="form-control" id="inputEmail">
                </div>
            </div>

            <div class="form-group">
                <label for="inputIntroduction" class="col-sm-2 control-label">个人简介</label>
                <div class="col-sm-6">
                    <textarea class="form-control" rows="10" id="inputIntroduction"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div>
                    <button class="btn btn-default col-sm-3 sign-button" onClick="javascript: window.history.back()">取消</button>
                    <button type="submit" class="btn btn-default col-sm-offset-2 col-sm-3 sign-button">确认</button>
                </div>
            </div>
        </form>
    </div>
</@basicLayout.layout>