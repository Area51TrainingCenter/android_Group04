<?php

	//Variables de conexión
    $localhost 	= "localhost";
    $usuario 	= "root";
    $clave 		= "clave";
    $basedatos 	= "area51";

    mysql_pconnect($localhost, $usuario, $clave) or die("Arañitas del mal xD :" . mysql_error());
    mysql_select_db($basedatos) or die("why?? : " . mysql_error());
    mysql_query("SET NAMES utf8");
    mysql_query("SET time_zone = 'America/Lima'");

    //echo $cadena = "Mi clave es: " . $clave;


?>