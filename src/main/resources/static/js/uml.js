var editor = 'https://www.draw.io/?embed=1&ui=min&spin=1&proto=json&configure=1';
var initial = null;
var name = null;

function edit(elt)
{
    var iframe = document.createElement('iframe');
    iframe.setAttribute('frameborder', '0');

    var close = function()
    {
        window.removeEventListener('message', receive);
        $("#umlEditor").remove(iframe);
    };

    var draft = localStorage.getItem('.draft-' + name);

    if (draft != null)
    {
        draft = JSON.parse(draft);

        if (!confirm("A version of this page from " + new Date(draft.lastModified) + " is available. Would you like to continue editing?"))
        {
            draft = null;
        }
    }

    var receive = function(evt)
    {
        if (evt.data.length > 0)
        {
            var msg = JSON.parse(evt.data);

            // If configure=1 URL parameter is used the application
            // waits for this message. For configuration options see
            // https://desk.draw.io/support/solutions/articles/16000058316
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
                    iframe.contentWindow.postMessage(JSON.stringify({action: 'load',
                        autosave: 1, xml: draft.xml}), '*');
                    iframe.contentWindow.postMessage(JSON.stringify({action: 'status',
                        modified: true}), '*');
                }
                else
                {
                    // Avoids unescaped < and > from innerHTML for valid XML
                    var svg = new XMLSerializer().serializeToString(elt.firstChild);
                    iframe.contentWindow.postMessage(JSON.stringify({action: 'load',
                        autosave: 1, xml: svg}), '*');
                }
            }
            else if (msg.event == 'export')
            {
                // Extracts SVG DOM from data URI to enable links
                var svg = atob(msg.data.substring(msg.data.indexOf(',') + 1));
                elt.innerHTML = svg;
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
                iframe.contentWindow.postMessage(JSON.stringify({action: 'export',
                    format: 'xmlsvg', xml: msg.xml, spin: 'Updating page'}), '*');
                localStorage.setItem('.draft-' + name, JSON.stringify({lastModified: new Date(), xml: msg.xml}));
            }
            else if (msg.event == 'exit')
            {
                localStorage.removeItem('.draft-' + name);
                draft = null;
                close();
            }
        }
    };

    window.addEventListener('message', receive);
    iframe.setAttribute('src', editor);
    $("#umlEditor").append(iframe);
    // document.body.appendChild(iframe);
}

function load()
{
    initial = document.getElementById('diagram').innerHTML;
    start();
}

function start()
{
    name = (window.location.hash.length > 1) ? window.location.hash.substring(1) : 'default';
    var current = localStorage.getItem(name);

    if (current != null)
    {
        var entry = JSON.parse(current);
        document.getElementById('diagram').innerHTML = entry.data;
    }
    else
    {
        document.getElementById('diagram').innerHTML = initial;
    }
}

window.addEventListener('hashchange', start);