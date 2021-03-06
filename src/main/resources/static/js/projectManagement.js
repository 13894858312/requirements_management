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

/**
 * 截止征集
 * @returns {boolean}
 */
function stopCollection(pid) {
    $.ajax({
        url: '/projectManagement/stopCollection?pid=' + pid ,
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
                window.location.href = "/projectManagement?pid=" + pid ;
            }
        },
        error: function (exc) {
            alert("发生错误，请重试");
            console.log(exc);
        }
    });

    return false;
}


/**
 * 进入需求管理
 * @param pid
 */
function goToRequirementManagement(pid) {
    window.location.href = '/rm?pid=' + pid;
}
