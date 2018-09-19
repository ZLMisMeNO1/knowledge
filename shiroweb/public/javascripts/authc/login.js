
$(function(){
    $('#tologin').click(function(){
        toLogin();
    });
});

function toLogin() {
    assertNotNull();
    var username = $('#username').val();
    var password = $('#username').val();
    var remerberme = $('#username').val();
    $.ajax({
        url : '/s/authc/toLogin',
        method : 'POST',
        data : {
            'username':username,
            'password':password,
            'rememberMe':true
        },
        success : function(data){
            console.log(data);
        }
    });
}
function assertNotNull() {
    var username = $('#username').val();
    var password = $('#username').val();
    var remerberme = $('#username').val();

    if($.isEmptyObject(username)) {
        return;
    }
}