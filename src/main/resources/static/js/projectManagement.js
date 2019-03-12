/**
 * 开始征集
 * @returns {boolean}
 */
function startCollection() {
    var pid = getQueryString("pid");
    $.ajax({
        url: '/projectManagement/startCollection?pid=' + pid ,
        data: $("#closedTimeForm").serialize(),
        type: 'GET',
        success: function(msg){
            if(msg == "wrong_user"){
                alert("该用户无操作权限");
                return false;
            }else if(msg == "fail"){
                alert("操作失败，请重试");
                return false;
            }else if(msg == "success") {
                alert("操作成功");
                window.location.href = "/post/project?pid=" + pid + "&page=1";
            }
        },
        error: function (exc) {
            alert("发生错误，请重试");
            console.log(exc);
        }
    });

    return false;
}
