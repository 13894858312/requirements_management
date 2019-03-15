// 使用draw.io绘制UML图
// 将draw.io的存储方式修改为服务器存储
// ****这玩意简直要人命****
// 参考网址 https://support.draw.io/display/DO/2015/09/21/Simple+draw.io+embedding+walk-through
// draw.io-html5 github地址 https://github.com/jgraph/drawio-html5
// ****看到这个文件的你根本不知道我都经历了什么****

// 嵌入draw.io使用的网址，?后面的参数对编辑界面有影响
// 参数见https://github.com/jgraph/drawio/tree/master/src/main/webapp/js/diagramly/app.js，其余的自己领会
var editor = 'https://www.draw.io/?embed=1&ui=ElectronApp&spin=1&proto=json&configure=1';
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
    var iFrame = document.createElement('iFrame');
    // 去边框，此样式已加到css里了
    // iFrame.setAttribute('frameborder', '0');

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
    // 和http://www.aijquery.cn/Html/jqueryshili/43.html (jquery)
    var receive = function(event)
    {
        if (event.data.length > 0)
        {
            var msg = JSON.parse(event.data);

            // If configure=1 URL parameter is used the application
            // waits for this message. For configuration options see
            // https://desk.draw.io/support/solutions/articles/16000058316
            if (msg.event == 'configure')
            {
                // Configuration example
                iFrame.contentWindow.postMessage(JSON.stringify({action: 'configure',
                    config: {defaultFonts: ["Humor Sans", "Helvetica", "Times New Roman"]}}), '*');
            }
            else if (msg.event == 'init')
            {
                if (draft != null)
                {
                    iFrame.contentWindow.postMessage(JSON.stringify({action: 'load', autosave: 1, xml: draft.xml}), '*');
                    iFrame.contentWindow.postMessage(JSON.stringify({action: 'status', modified: true}), '*');
                }
                else
                {
                    // Avoids unescaped < and > from innerHTML for valid XML
                    var svg = new XMLSerializer().serializeToString(element.firstChild);
                    iFrame.contentWindow.postMessage(JSON.stringify({action: 'load', autosave: 1, xml: svg}), '*');
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
                iFrame.contentWindow.postMessage(JSON.stringify({action: 'export', format: 'xmlsvg', xml: msg.xml, spin: 'Updating page'}), '*');
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
    iFrame.setAttribute('src', editor);
    // document.body.appendChild(iFrame);
    //从父节点改为umlEditor
    $("#umlEditor").append(iFrame);
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