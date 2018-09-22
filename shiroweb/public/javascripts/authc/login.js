
$(function(){
    layui.use(['layer', 'form', 'element'], function(){
        var layer = layui.layer
        ,form = layui.form
        ,element = layui.element

        form.on('switch()',function(data){
            remerberme = this.checked;
        });
      });
    $('#tologin').click(function(){
        toLogin();
    });
});
var remerberme =false;
function toLogin() {
    if(!assertNotNull()) {
        layer.msg('用户名或密码不能为空！',{icon:2,time:2000});
        return;
    }
    var username = $('#username').val();
    var password = $('#password').val();
    
    $.ajax({
        url : '/s/authc/toLogin',
        data : {
            'username':username,
            'password':password,
            'rememberMe':remerberme 
        },
        method : 'POST',
        async : false,
        success : function(data){
            // console.log(data);
            data = JSON.parse(data);
            if(data.code == 200) {
                var mylay = parent.layer.getFrameIndex(window.name);
                // console.log(mylay);
                parent.layer.close(mylay);
            } else {
                layer.msg(data.message);
            }
        }
    });
}
function assertNotNull() {
    var username = $('#username').val();
    var password = $('#password').val();

    
    return !$.isEmptyObject(username) && !$.isEmptyObject(password)
}