<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1 page-header">
            <div class="row">
                <div class="col-sm-4">
                    <h1>个人资料</h1>
                </div>
                <a class="pull-right col-sm-2 col-md-1 btn btn-default" href="/userInfo/changePassword">修改密码</a>
            </div>
        </div>
    </div>
    <div>
        <#if account??>
            <form class="form-horizontal col-sm-offset-3" id="userInfoForm" onsubmit="return modifyUserInfo()">

                <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-3">
                        <input class="form-control" name="name" value="${account.name}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputOccupation" class="col-sm-2 control-label">职业</label>
                    <div class="col-sm-3">
                        <input class="form-control" name="occupation" value="${account.occupation}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputTelephone" class="col-sm-2 control-label">联系电话</label>
                    <div class="col-sm-3">
                        <input class="form-control" name="telephone" value="${account.telephone}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputEmail" class="col-sm-2 control-label">电子邮箱</label>
                    <div class="col-sm-3">
                        <input type="email" class="form-control" name="email" value="${account.email}">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputIntroduction" class="col-sm-2 control-label">个人简介</label>
                    <div class="col-sm-6">
                        <textarea class="form-control" rows="10" name="introduction">${account.introduction}</textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div>
                        <button class="btn btn-default col-sm-3 sign-button" onClick="javascript: window.history.back()">取消</button>
                        <button type="submit" class="btn btn-default col-sm-offset-2 col-sm-3 sign-button">确认</button>
                    </div>
                </div>
            </form>
        <#else>
            <div>请先登录</div>
        </#if>
    </div>
</@basicLayout.layout>