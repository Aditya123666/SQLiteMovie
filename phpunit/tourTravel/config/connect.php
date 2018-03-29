<?php
	$host = "localhost";
	$user = "root";
	$pass = "123456";
	
	$db   = "db_pkl2225";
	
	$pdo = new PDO("mysql:host=$host; dbname=$db", $user, $pass);
	//Hanya TES
	/*if($pdo){
		echo "Koneksi ke DB Berhasil";
	}else{
		echo "Koneksi GAGAL";
	}*/
?>