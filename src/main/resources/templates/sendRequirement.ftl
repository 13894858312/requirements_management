<#import "basicLayout.ftl" as basicLayout>

<@basicLayout.layout>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-10 page-header">
            <h1>提交需求</h1>
        </div>
    </div>
    <div>
        <form class="form-horizontal col-sm-offset-3">
            <div class="form-group">
                <label for="inputName" class="col-sm-2 control-label">需求名称</label>
                <div class="col-sm-6">
                    <input class="form-control required" id="inputName">
                </div>
            </div>

            <div class="form-group">
                <label for="inputType" class="col-sm-2 control-label">需求类型</label>
                <div class="col-sm-3">
                    <select class="form-control" id="inputType">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                    </select>
                </div>
            </div>


            <div class="form-group">
                <label for="inputPriority" class="col-sm-2 control-label">需求优先级</label>
                <div class="col-sm-3">
                    <select class="form-control required" id="inputPriority">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="inputdescription" class="col-sm-2 control-label">详细描述</label>
                <div class="col-sm-6">
                    <textarea class="form-control required" rows="10" id="inputDescription"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div>
                    <button class="btn btn-default col-sm-3" onClick="javascript: window.history.back()">取消</button>
                    <button type="submit" class="btn btn-default col-sm-offset-2 col-sm-3">提交</button>
                </div>
            </div>
        </form>
    </div>
</@basicLayout.layout>