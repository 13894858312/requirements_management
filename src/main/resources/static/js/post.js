/**
 * 创建项目
 * @returns {boolean}
 */
function createProject() {
    $.ajax({
        url: '/post/createProject',
        data: $("#projectInfoForm").serialize(),
        type: 'POST',
        dataType: 'text',
        success: function(msg){
            if(msg == "fail"){
                alert("创建失败，请重试");
                return false;
            }else if(msg="success") {
                alert("创建成功");
                window.location.href="/post/myProjects";
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
 * 编辑项目
 * @returns {boolean}
 */
function editProject() {
    var pid = getQueryString("pid");

    $.ajax({
        url: '/post/editProject?pid=' + pid,
        data: $("#projectInfoForm").serialize(),
        type: 'POST',
        dataType: 'text',
        success: function(msg){
            if(msg="wrong_user"){
                alert("该用户无操作权限");
                return false;
            }else if(msg == "fail"){
                alert("编辑失败，请重试");
                return false;
            }else if(msg="success") {
                alert("编辑成功");
                window.location.href="/post/myProjects";
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
 * 添加需求
 * @returns {boolean}
 */
function createRequirement() {
    var pid = getQueryString("pid");

    $.ajax({
        url: '/post/createRequirement?pid=' + pid,
        data: $("#requirementInfoForm").serialize(),
        type: 'POST',
        dataType: 'text',
        success: function(msg){
            if(msg == "fail"){
                alert("添加失败，请重试");
                return false;
            }else if(msg="success") {
                alert("添加成功");
                window.location.href="/post/project?pid=" + pid;
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
 * 编辑需求
 * @returns {boolean}
 */
function editRequirement() {
    var pid = getQueryString("pid");
    var rid = getQueryString("rid");

    $.ajax({
        url: '/post/editRequirement?pid=' + pid + '&rid=' + rid,
        data: $("#requirementInfoForm").serialize(),
        type: 'POST',
        dataType: 'text',
        success: function(msg){
            if(msg="wrong_user"){
                alert("该用户无操作权限");
                return false;
            }else if(msg == "fail"){
                alert("编辑失败，请重试");
                return false;
            }else if(msg="success") {
                alert("编辑成功");
                window.location.href="/post/project?pid=" + pid;
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
 * 进入项目帖子
 * @param pid
 */
function goToPost(pid) {
    window.location.href = '/post/project?pid=' + pid;
}

/**
 * 进入提交需求
 * @param pid
 */
function goToCreateRequirement(pid) {
    window.location.href = '/post/sendRequirement?pid=' + pid;
}

/**
 * 进入编辑需求
 * @param pid
 * @param rid
 */
function goToEditRequirement(pid, rid) {
    window.location.href = '/post/sendRequirement?pid=' + pid + '&rid=' + rid;
}

/**
 * 进入编辑项目
 * @param pid
 */
function goToEditProject(pid) {
    window.location.href = '/post/sendProject?pid=' + pid;
}
