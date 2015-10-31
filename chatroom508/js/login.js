/**
 * Created by dell on 15-7-9.
 */
$(function(){
    //发送ajax请求前显示：正在验证......
    $("#state").ajaxStart(function(){
        $(this).show().html("正在验证......");
    });
    //发送ajax请求后显示
    $("#state").ajaxStop(function(){
        $(this).html("验证完毕！").hide();
    });
    //button点击事件
    $("#btntrue").click(function(){
        var $name = $("#username");//用户名
        var $pass = $("#userpass");//用户密码
        if ($name.val() != "" && $pass.val() !="") {
            UserLogin($name.val(),$pass.val());
            console.log($name.val());
        }else {
            if ($name.val() =="") {
                alert("用户名不能为空");
                $name.focus();
                return false;
            }else {
                alert("密码不能为空！");
                $pass.focus();
                return false;
            }
        }
    });
    $("#btncancel").click(
        function() {
            $("#username").val("");
            $("#userpass").val("");
        }
    );

    function UserLogin(name,pass) {
        $.ajax({
            type:"GET",
            url:"index.php",
            //   data:"&action=" + new Date() + "&name=" + name + "&pass=" + pass,
            data:{name:name,pass:pass,action:new Date()},
            success:function(data) {
                console.log(data);
                if (data == "1") {
                    window.location = "chatMain.html";
                }else {
                    alert("用户名或密码错误！");
                    return false;
                }
            },
            error:function(XMLResponse) {
                alert(XMLResponse.responseText);
            }

        });
    }
});