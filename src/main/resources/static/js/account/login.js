/**
 * 登录表单提交
 */
$("#loginSubmit").click(function(e){
    e.preventDefault();
    login();
});


/**
 * 登录
 */
function login() {
    var submit = $("#loginSubmit");

    var inputUid = $("#inputUid");
    var inputPassword = $("#inputPassword");
    var uid = inputUid.val();
    var password = hex_md5(inputPassword.val());

    var data = {uid: uid, password: password};

    $.ajax({
        url: '/login/doLogin',
        data: data,
        type: 'POST',
        dataType: 'text',
        beforeSend: function () {
            //让提交按钮失效，以实现防止按钮重复点击
            submit.attr('disabled', 'disabled');
            //给用户提供友好状态提示
            submit.text('登录中...');
        },
        success: function(msg){
            if(msg == "fail"){
                alert("用户名或密码错误，登录失败");
                window.location.reload();
                return false;
            }else if(msg="success") {
                window.location.href = "/home";
            }
        },
        error: function (exc) {
            alert("发生错误，请重试");
            window.location.reload();
            console.log(exc)
        },
        complete: function () {
            //让登陆按钮重新有效
            submit.removeAttr('disabled');
            submit.text('登录');
        }
    });
}
