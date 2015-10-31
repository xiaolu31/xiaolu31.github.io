<?php
session_start();
$login = array('xiaowei' => '小伟','xiaoshi'=> '小师','xiaohao'=>'小郝','xiaolu'=>'小路',
				'xiaodan'=>'小丹','xiaofang'=>'小方','xiaoguo'=>'小郭');
echo $login[$_SESSION['username']] . "<br>";


?>