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