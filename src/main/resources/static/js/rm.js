/**
 * 注销
 */
function logout() {
    $.ajax({
        url: '/logout',
        type: 'POST',
        success: function(msg){
            alert("注销成功");
            window.location.href="/home";
        },
        error: function (exc) {
            alert("something wrong, please try again");
            console.log(exc);
        }
    });
}

/**
 * 获取url中的id
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