<?php
$login = array('xiaowei' => 123456,'xiaoshi'=> 123456,'xiaohao'=>123456,'xiaolu'=>123456,
				'xiaodan'=>123456,'xiaofang'=>123456,'xiaoguo'=>123456);
$name = $_GET["name"];
$pass = $_GET["pass"];
//验证用户名和密码是否正确
// $name='xiaowei';
// $pass = 123456;

	if(array_key_exists($name,$login) && $login[$name] == $pass) {
			echo 1;
			$through = true;
		}else {
			echo 0;
			$through = false;
		}
	
	if ($through == true) {
		session_start();
		$_SESSION["username"] = $name;
	}

?>