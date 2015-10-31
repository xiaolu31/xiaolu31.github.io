<?php
header("Content-type:text/html;charset=utf-8");
$login = array('xiaowei' => '小伟','xiaoshi'=> '小师','xiaohao'=>'小郝','xiaolu'=>'小路',
				'xiaodan'=>'小丹','xiaofang'=>'小方','xiaoguo'=>'小郭');
session_start();
$content = $_POST['content'];
date_default_timezone_set('Asia/Shanghai');
$content = date('Y-m-d H:i:s',time()) . "---" . $login[$_SESSION['username']] . ":" . $content;

echo writeMessage($content);


function writeMessage($msg) {
	if($msg != "") {
		$file_handle = fopen("data.txt","a+") or die("Unable to open file");
		$txt = $msg . "\r\n";
		fwrite($file_handle,$txt);
		fclose($file_handle);
		return true;
	}else{
		return false;
	}
}


?>