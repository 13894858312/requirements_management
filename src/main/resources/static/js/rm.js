/**
 * 小屏幕下的navbar
 */
$(window).scroll(function () {
    //小屏幕下的导航条折叠
    if ($(window).width() < 768) {
        //点击导航链接之后，把导航选项折叠起来
        $("#navbar a").click(function () {
            $("#navbar").collapse('hide');
        });
        //滚动屏幕时，把导航选项折叠起来
        $(window).scroll(function () {
            $("#navbar").collapse('hide');
        });
    }
});

/**
 * 高亮当前地址对应的导航栏
 */
$(function () {
    var relativePath = getUrlRelativePath();

    $("#menu li").each(function () {
        var a = $(this).find('a');
        var href = a.attr('href');

        if ( href!= null && href.indexOf(relativePath) > -1) {
            $(this).addClass('active');
        } else {
            $(this).removeClass('active');
        }
    });
    
});

/**
 * 获取url中的字符串
 * @param name
 * @returns {*}
 */
function getQueryString(name) {
    var result = window.location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
    if (result == null || result.length < 1) {
        return "";
    }
    return result[1];
}

/**
 * 获取URL相对路径
 * @returns {string}
 * @constructor
 */
function getUrlRelativePath()
{
    var url = document.location.toString();
    var arrUrl = url.split("//");

    var start = arrUrl[1].indexOf("/");
    var relUrl = arrUrl[1].substring(start);//stop省略，截取从start开始到结尾的所有字符

    if(relUrl.indexOf("?") != -1){
        relUrl = relUrl.split("?")[0];
    }
    return relUrl;
}

/**
 * 注销
 */
function logout() {
    $.ajax({
        url: '/logout',
        type: 'POST',
        success: function(msg){
            alert("注销成功");
            window.location.reload();
        },
        error: function (exc) {
            alert("something wrong, please try again");
            console.log(exc);
        }
    });
}

/**
 * 创建uml并跳转到编辑页面
 */
function createUml(pid) {
    var title = $("#inputUmlTitle").val();
    var data = {pid: pid, title: title};

    $.ajax({
        url: '/uml/create',
        data: data,
        type: 'POST',
        success: function(umlid){
            window.location.href="/uml/edit?pid=" + pid + "&umlid=" + umlid;
        },
        error: function (exc) {
            alert("something wrong, please try again");
            console.log(exc);
        }
    });
    return false;
}

/**
 * 导航栏搜索
 * @returns {boolean}
 */
function simpleSearch() {
    var input = $("#nav-search").val();
    if(input != null){
        window.location.href = '/post/searchResult?input=' + input +'&page=1';
    }
    return false;
}

/**
 * 导航栏添加监听
 */
$('#nav-search').bind('keypress', function (event) {
    if (event.keyCode == "13") {
        simpleSearch();
    }
    return false;
});