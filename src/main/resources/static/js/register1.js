/**
 * 添加role
 */
layui.use(['form','layer','jquery'],function (){
    var form =layui.form;
    var $ = layui.jquery;
    var layer=layui.layer;
    form.render();
    form.verify({
        name: function(value){
            if(value.length ==0){
                return '角色名不能为空';
            }
        }
    });

    form.on('submit(register1)', function(data){
        $.ajax({
            url:'/user/roleAdd',
            data:data.field,
            type:'GET',
            //返回数据格式,
            contentType: 'application/json',
            success:function(data){
                if(data.code==200){
                    //location.reload();
                    layer.msg("增加成功", {icon: 6,time: 1000},function () {
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