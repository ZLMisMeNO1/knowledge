layui.use(['layer', 'form', 'element'], function(){
    var layer = layui.layer
    ,form = layui.form
    ,element = layui.element

    form.on('switch()',function(data){
        remerberme = this.checked;
    });
  });
$(function(){

    exec('/s/user/getPersonDetail',{},false,'POST');
});