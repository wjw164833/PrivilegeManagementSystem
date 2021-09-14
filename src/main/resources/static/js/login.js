/**
 * 系统登录
 */

/*注册*/
function register() {
    layer.open({
        title: '账号注册',
        type: 2,//层类型：2（iframe层）
        shade:0.2,//遮罩
        maxmin:true,//最大最小化。
        shadeClose: true,//是否点击遮罩关闭
        area: ['35%', '80%'],//宽高
        content: '/register',
    });
}

layui.use(['layer', 'form',], function (data) {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;

    // 登录事件
    form.on('submit(login)', function () {
        $.ajax({
            type: "POST",
            url: 'user/tologin',
            data: {
                account:$('#account').val(),
                password:$('#password').val()
            },
            success: function (res) {
                if (res.flag==="true") {
                    // 提示语
                    layer.msg('登录成功', {
                        icon: 1,
                        time: 1500
                    });

                    // 延迟3秒
                    setTimeout(function () {
                        // 跳转后台首页
                        window.location.href = "/adminIndex";
                    }, 2000);

                    return false;
                } else if(res.flag==="false"){
                    // 错误信息
                    layer.msg(res.errMesage, {icon: 2, anim: 6});
                }else if(res.flag==="disable"){
                    layer.msg(res.errMesage, {icon: 2, anim: 6});
                }
            },
            error: function () {
                layer.msg("AJAX请求异常");
            }
        });
        return false;
    });

});