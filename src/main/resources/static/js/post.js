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

    $.ajax({
        url: '/post/editProject',
        data: $("#projectInfoForm").serialize(),
        type: 'POST',
        dataType: 'text',
        success: function(msg){
            if(msg == "fail"){
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

    $.ajax({
        url: '/post/createRequirement?pid=' + getQueryString("pid"),
        data: $("#requirementInfoForm").serialize(),
        type: 'POST',
        dataType: 'text',
        success: function(msg){
            if(msg == "fail"){
                alert("添加失败，请重试");
                return false;
            }else if(msg="success") {
                alert("添加成功");
                window.history.back();
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

    $.ajax({
        url: '/post/editRequirement?pid=' + getQueryString("pid"),
        data: $("#requirementInfoForm").serialize(),
        type: 'POST',
        dataType: 'text',
        success: function(msg){
            if(msg == "fail"){
                alert("编辑失败，请重试");
                return false;
            }else if(msg="success") {
                alert("编辑成功");
                window.history.back();
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
    alert(pid);
}