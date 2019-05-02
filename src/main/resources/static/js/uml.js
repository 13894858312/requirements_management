// 使用draw.io绘制UML图；github：https://github.com/jgraph/drawio
// ***************************************这玩意简直要人命****************************************//
// 参考网址 https://support.draw.io/display/DO/2015/09/21/Simple+draw.io+embedding+walk-through
// 以及 https://desk.draw.io/support/solutions/articles/16000042542
// draw.io-html5 的一些demo： https://github.com/jgraph/drawio-html5
// 搭建自己的draw.io http://elkpi.com/topics/establish_draw-io.html
// *****************************看到这个文件的你根本不知道我都经历了什么*****************************//

// 嵌入式draw.io所使用的url，?后面的参数对编辑界面有影响
// url参数参考 https://desk.draw.io/support/solutions/articles/16000042546-what-url-parameters-are-supported-
// 以及 https://desk.draw.io/support/solutions/articles/16000042544-how-does-embed-mode-work-
// 如果有人需要对源代码进行二次开发，配置文件中的参数配置可参考 https://desk.draw.io/support/solutions/articles/16000058316
var editor = "https://www.draw.io/?embed=1&ui=min&spin=1&proto=json&configure=1&libs=general;uml;flowchart;er;dfd";

var uml = null;
var content = null;
var title = null;

// 编辑页面初始化
$(function () {
   start();
   edit();
});

function edit()
{
    var iframe = document.createElement('iframe');

    var close = function()
    {
        self.location=document.referrer;
    };

    // 开始监听信息
    // 用到了跨域通信，
    // 详见https://www.cnblogs.com/flora-dn/p/9019252.html (js)
    // http://www.aijquery.cn/Html/jqueryshili/1.html
    // http://www.aijquery.cn/Html/jqueryshili/43.html (jquery)
    var receive = function(event)
    {
        if (event.data.length > 0)
        {
            var msg = JSON.parse(event.data);

            // 如果使用configure = 1 URL参数，则客户端会在创建主应用程序之前发送{event：'configure'} 并等待{action：'configure'，config：obj}
            // 详见https://desk.draw.io/support/solutions/articles/16000058316
            if (msg.event == 'configure')
            {
                // Configuration example
                iframe.contentWindow.postMessage(JSON.stringify({action: 'configure',
                    config: {defaultFonts: ["Humor Sans", "Helvetica", "Times New Roman"]}}), '*');
            }
            else if (msg.event == 'init')
            {
                iframe.contentWindow.postMessage(JSON.stringify({action: 'load', xmlpng: content }), '*');
                // 暂不设置自动保存
                // iframe.contentWindow.postMessage(JSON.stringify({action: 'load', autosave: 1, xmlpng: content }), '*');
            }
            else if (msg.event == 'autosave')
            {
                //暂不设置自动保存
                // var data = msg.data;
                // saveUml(data);
            }
            else if (msg.event == 'save')
            {
                //转换为export事件以设置xml+png格式
                iframe.contentWindow.postMessage(JSON.stringify({action: 'export', format: 'xmlpng'}), '*');}
            else if (msg.event == 'export'){
                var data = msg.data;
                saveUml(data);
            }
            else if (msg.event == 'exit')
            {
                close();
            }
        }
    };

    window.addEventListener('message', receive);
    iframe.setAttribute('src', editor);
    // document.body.appendChild(iFrame);
    //从父节点改为umlEditor
    $("#umlEditor").append(iframe);
}

//从后端获取uml
function getUml() {
    $.ajax({
        type: "GET",
        url: "/uml/getUml?umlid=" + getQueryString("umlid"),
        contentType: "application/json; charset=utf-8",
        async: false,
        success:function(rst){
            uml = JSON.parse(rst);
        },
        error:function(exc){
            alert("something wrong, please try again");
            console.log(exc);
        }
    });
}

//初始化参数
function start()
{
    getUml();
    title = uml.title;
    content = uml.content;
}

function saveUml(content){
    var umlid = uml.umlid;
    var data = {umlid: umlid, name: title, content: content};
    $.ajax({
        url: '/uml/save',
        data: data,
        type: 'POST',
        success: function(){
            self.location=document.referrer;
        },
        error: function (exc) {
            alert("something wrong, please try again");
            console.log(exc);
        }
    });
    return false;
}

window.addEventListener('hashchange', start);

/**
 * 给需求表格增加按钮
 * @returns {string}
 */
function addRequirementButton(value, row, index) {
    return [
        '<button class="btn btn-default" id="details" data-toggle="modal" data-target="#detailsModal">详情</button>&nbsp;&nbsp;' +
        '<button class="btn btn-info" id="associate">关联</button>'
    ].join("");
}

/**
 * 给关联表格增加按钮
 * @returns {string}
 */
function addRelationshipButton(value, row, index) {
    return [
        '<button class="btn btn-default" id="details" data-toggle="modal" data-target="#detailsModal">详情</button>&nbsp;&nbsp;' +
        '<button class="btn btn-danger" id="cancel-associate">取消关联</button>'
    ].join("");
}

/**
 * 注册表格按钮事件
 * @type {{}}
 */
window.operationEvents = {
    "click #details": function (e, value, row, index) {
        var uid = row.uid;
        var postTime = row.postTime;
        var name = row.name;
        var type = row.type;
        var priority = row.priority;
        var description  = row.description;
        $("#uid").html(uid);
        $("#postTime").html(new Date(parseInt(postTime)).toLocaleString().replace(/:\d{1,2}$/,' '));
        $("#name").html(name);
        $("#type").html(type);
        $("#priority").html(priority);
        $("#description").html(description);
    },
    "click #associate": function (e, value, row) {
        var umlid = uml.umlid;
        var rid = row.rid;
        var data = {pid: getQueryString("pid"), umlid: umlid, rid: rid};
        $.ajax({
            url: '/uml/addRelation',
            data: data,
            type: 'GET',
            success: function(){
                refreshTable();
            },
            error: function (exc) {
                alert("something wrong, please try again");
                console.log(exc);
            }
        });
        return false;
    },
    "click #cancel-associate": function (e, value, row, index) {
        var umlid = uml.umlid;
        var rid = row.rid;
        var data = {pid: getQueryString("pid"), umlid: umlid, rid: rid};
        $.ajax({
            url: '/uml/deleteRelation',
            data: data,
            type: 'GET',
            success: function(){
                refreshTable();
            },
            error: function (exc) {
                alert("something wrong, please try again");
                console.log(exc);
            }
        });
        return false;
    }
};

/**
 * timestamp转化方法
 * @param value
 * @param row
 * @param index
 */
function timestampFormatter(value, row, index) {
    if(value != null){
        return new Date(parseInt(value)).toLocaleString().replace(/:\d{1,2}$/,' ');
    }
}
/**
 * 刷新bootstrap-table
 */
function refreshTable() {
    $("#uml-requirement-table").bootstrapTable('refresh');
    $("#uml-relationship-table").bootstrapTable('refresh');
}