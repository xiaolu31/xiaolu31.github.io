<?php
header("Content-type:text/html;charset=utf-8");

$num = 30;//读取多少条
// function getMessage($num) {
	$line = count(file("data.txt"));
	$file_handle = fopen("data.txt","r") or die("Unable to open");
	// $content = "";
	if ($line > $num) {
		$row = $line -$num;
		for ($i=0;$i<$row;$i++) {
		 	fgets($file_handle);
		}
		for($i=0;$i<$line;$i++) {
		 	echo  fgets($file_handle) . "<br>";
		}
		fclose($file_handle);
		// echo $content;
	}else {
		while(!feof($file_handle)) {
			// $content += fgets($file_handle) . "<br>";
			echo fgets($file_handle) . "<br>";
		}
		fclose($file_handle);
		// echo $content;
	}
// }

 // getMessage($num);


?>