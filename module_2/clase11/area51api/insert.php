<?php

	require_once 'conex.php';

	$sql 	= "";
	$query 	= "";

	//require 'conex.php';

	//include_once 'conex.php';
	//include 'conex.php';



	//echo " $variable ";
	//echo ' valor: '.$variable;


	//$alumnos = array( "key" => "valor" );
	$alumnos = array( "correo@gmail.com",
					  "correo@gmail.com",
					  "correo@gmail.com",
					  "correo@gmail.com",
					  "correo@gmail.com",
					  "correo@gmail.com");

	//print_r($alumnos);  //imprimir arreglos

	foreach ($alumnos as $key => $value) {
		//echo $value.'<br>';
		$sql = "INSERT INTO usuario( usuario, clave, estado, votacion ) 
		VALUES( '$value', '1234' , '1', '0' )";
		$query = mysql_query($sql);
	}
	
	/*
	for ($i=0; $i < ; $i++) { 
		echo $alumnos[$i];
	}
	*/



?>
