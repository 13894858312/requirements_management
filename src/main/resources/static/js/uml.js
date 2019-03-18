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
var editor = "https://www.draw.io/?embed=1&ui=min&spin=1&proto=json&configure=1&lang=zh";
// 初始图内容， 来源待修改
var initial = null;
// 图名称， 来源待修改
var name = null;

//目前↑这些玩意的来源之一（另一个是localstorage），待修改
var diagram = $("#diagram");

// 页面初始化
$(function () {
   start();
   edit(diagram[0]);
});

function edit(element)
{
    var iframe = document.createElement('iframe');

    var close = function()
    {
        // 注销下面var=receive中的监听事件，待修改
        // window.removeEventListener('message', receive);
        // 父节点由document改为umlEditor
        // $("#umlEditor").remove(iFrame);
    };

    // 加载localStage中的draft
    var draft = localStorage.getItem('.draft-' + name);
    if (draft != null)
    {
        draft = JSON.parse(draft);

        if (!confirm("发现" + new Date(draft.lastModified) + "保存的文件，是否继续编辑？"))
        {
            draft = null;
        }
    }

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
                if (draft != null)
                {
                    iframe.contentWindow.postMessage(JSON.stringify({action: 'load', autosave: 1, xml: draft.xml}), '*');
                    iframe.contentWindow.postMessage(JSON.stringify({action: 'status', modified: true}), '*');
                }
                else
                {
                    // Avoids unescaped < and > from innerHTML for valid XML
                    var svg = new XMLSerializer().serializeToString(element.firstChild);
                    iframe.contentWindow.postMessage(JSON.stringify({action: 'load', autosave: 1, xml: svg}), '*');
                }
            }
            else if (msg.event == 'export')
            {
                // Extracts SVG DOM from data URI to enable links
                // 从data URI中提取SVG DOM以启用连接（？
                var svg = atob(msg.data.substring(msg.data.indexOf(',') + 1));
                element.innerHTML = svg;
                localStorage.setItem(name, JSON.stringify({lastModified: new Date(), data: svg}));
                localStorage.removeItem('.draft-' + name);
                draft = null;
                close();
            }
            else if (msg.event == 'autosave')
            {
                localStorage.setItem('.draft-' + name, JSON.stringify({lastModified: new Date(), xml: msg.xml}));
            }
            else if (msg.event == 'save')
            {
                // 点击保存
                iframe.contentWindow.postMessage(JSON.stringify({action: 'export', format: 'xmlsvg', xml: msg.xml, spin: 'Updating page'}), '*');
                localStorage.setItem('.draft-' + name, JSON.stringify({lastModified: new Date(), xml: msg.xml}));
            }
            else if (msg.event == 'exit')
            {
                // 点击退出
                localStorage.removeItem('.draft-' + name);
                draft = null;
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
//
// function load()
// {
//     initial = document.getElementById('diagram').innerHTML;
//     start();
// }

function start()
{
    // 初始化，diagram的获取改成了jquery
    // initial = document.getElementById('diagram').innerHTML;
    name = (window.location.hash.length > 1) ? window.location.hash.substring(1) : 'default';
    initial = diagram.innerHTML;

    //
    var current = localStorage.getItem(name);

    if (current != null)
    {
        var entry = JSON.parse(current);
       diagram.html(entry.data);
    }
    else
    {
        //设置当前图
        diagram.html(initial);
    }

}

window.addEventListener('hashchange', start);


/**
 * 创建uml并跳转到编辑页面
 */
function createUml() {
    //todo创建 并跳转到编辑
}

/**
 * 保存uml
 */
function save() {
    
}