/**
 * 用户注册
 */
layui.use(['form','layer','jquery'],function (){
    var form =layui.form;
    var $ = layui.jquery;
    var layer=layui.layer;
    form.render();
    form.verify({
        account: function(value){
            if(value.length ==0){
                return '用户名不能为空';
            }
            if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                return '用户名不能有特殊字符';
            }
            if(/(^\_)|(\__)|(\_+$)/.test(value)){
                return '用户名首尾不能出现下划线\'_\'';
            }
            if(/^\d+\d+\d$/.test(value)){
                return '用户名不能全为数字';
            }
        }
        ,password: [
            /^[\S]{6,12}$/
            ,'密码必须6到12位，且不能出现空格'
        ]
        ,password_twice:function (value){
            var newpwd=$("#password").val();
            if(value.length==0){
                return '密码必须6到12位，且不能出现空格'
            }
            if(newpwd!=value){
                return '密码必须保持一致'
            }
        }
        , mobile: [
            /^[1][0-9]{10}$/
            , '手机号格式不正确'
        ]
    });

    form.on('submit(register)', function(data){
        $.ajax({
            url:'/user/userAdd',
            data:data.field,
            type:'GET',//返回数据格式,
            dataType: "json",
            success:function(data){
                if(data.code==200){
                    //location.reload();
                    layer.msg("修改成功", {icon: 6,time: 1000},function () {
                        layer.close(layer.index);
                        window.parent.location.reload();
                    });

                }
            },
            error: function (data) {
                layer.msg("失败", {icon: 2, anim: 6});
            }
        });
        return false;
    });

})