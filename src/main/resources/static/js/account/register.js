/**
 * 注册表单提交
 */
$("#registerSubmit").click(function(e){
    e.preventDefault();
    register();
});

/**
 * 注册
 */
function register() {
    var submit = $("#registerSubmit");

    var inputUid = $("#inputUid");
    var inputPassword = $("#inputPassword");
    var inputRePassword = $("#inputRePassword");
    var inputName = $("#inputName");
    var inputTelephone = $("#inputTelephone");
    var inputEmail = $("#inputEmail");
    var inputOccupation = $("#inputOccupation");
    var inputIntroduction = $("#inputIntroduction");

    var uid = inputUid.val();
    var password = hex_md5(inputPassword.val());
    var rePassword = hex_md5(inputRePassword.val());
    var name = inputName.val();
    var telephone = inputTelephone.val();
    var email = inputEmail.val();
    var occupation = inputOccupation.val();
    var introduction = inputIntroduction.val();

    var data = {uid:uid, password: password, rePassword:rePassword, name:name,
            telephone:telephone, email:email, occupation:occupation, introduction:introduction};

    $.ajax({
        url: '/register/doRegister',
        data: data,
        type: 'POST',
        dataType: 'text',
        beforeSend: function () {
            submit.attr('disabled', 'disabled');
            submit.text('注册中...');
        },
        success: function(msg){
            if(msg == "uid_existed"){
                alert("用户名已存在，登录失败");
                window.location.reload();
                return false;
            }else if(msg == "wrong_uid_pattern"){
                alert("用户名格式错误");
                window.location.reload();
                return false;
            }else if(msg == "wrong_password_length"){
                alert("密码未经加密");
                window.location.reload();
                return false;
            }else if(msg == "different_password"){
                alert("两次输入的密码不同");
                window.location.reload();
                return false;
            }else if(msg == "wrong"){
                alert("注册错误，请重试");
                window.location.reload();
                return false;
            }else if(msg == "fail"){
                alert("注册失败，请重试");
                window.location.reload();
                return false;
            }else if(msg == "success") {
                alert("注册成功！");
                window.location.href = "/home";
            }
        },
        error: function (exc) {
            alert("Something wrong, please try again.");
            window.location.reload();
            console.log(exc)
        },
        complete: function () {
            //让登陆按钮重新有效
            submit.removeAttr('disabled');
            submit.text('注册');
        }
    });
}
