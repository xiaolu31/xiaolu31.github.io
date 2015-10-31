/**
 * Created by dell on 15-7-10.
 */
$(function() {


    $("#send").click(function() {
        var $content = $("#message");//发送的内容
        if ($content.val() != "") {
            SendContent($content.val());
        }else {
            $("#void").html("说点啥啊，不能什么都不写啊！");
            $content.focus();
            return false;
        }
    });

    function SendContent(content) {
        $.ajax({
            type:"POST",
            url:"main.php",
            data:"action=SendContent&d=" + new Date() + "&content=" + content,
            success:function(data) {
                console.log(data);
                if (data == "1") {
                    GetMessageList();
                    $("#message").val("");
                    $("#void").html("");
                }else {
                    alert("发送失败！");
                    return false;
                }
            }
        });
    }

    function GetMessageList() {
        $.ajax({
            type:"POST",
            url:"showmsg.php",
            data:"action=ChatList&d=" + new Date(),
            success:function(data) {
                console.log(data);
                $("#talkFrame").html(data);
            }
        });
        AutoUpdate();
    }

    function GetOnlinList() {
        $.ajax({
            type:"POST",
            url:"online.php",
            data:"action=OnlineList&d=" + new Date(),
            success:function(data) {
                $("#onlineUsers").html(data);
            }
        });
    }

    function AutoUpdate() {
        setTimeout(GetMessageList,5000);
        setTimeout(GetOnlinList,5000);
    }
});