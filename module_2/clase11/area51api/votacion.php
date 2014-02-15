<?php

	require_once 'conex.php';

	//Esta variable será para imprimir el formato json desde el api
	$json = array('respuesta' => 'ERROR');

	$logueo = new ArrayObject( array() , 2 );
	$logueo->usuario = "";
	$logueo->votacion = "";


	//Recibimos por el método $_GET
	if( isset($_GET['usuario']) && $_GET['usuario'] != ''  ){
		$logueo->usuario = htmlentities(strip_tags($_GET['usuario']));
	}

	//Recibimos por el método $_GET
	if( isset($_GET['votacion']) && $_GET['votacion'] != ''  ){
		$logueo->votacion = htmlentities(strip_tags($_GET['votacion']));
	}

	if ( $logueo->usuario != '' && $logueo->votacion != '' ) {
		
		$sql = "UPDATE usuario SET votacion = '1'
				WHERE usuario = '$logueo->usuario' ";

		$query = mysql_query( $sql );

		$json['respuesta'] = "OK";
		$json['mensaje'] = "Voto ingresado correctamente";

		/*
		//Hacer el update en la tabla usuario_votacion y guardar el voto
		//de la variable $logueo->votacion

		$sql = "UPDATE usuario_votacion 
				SET votacion = '$logueo->votacion' , registro = '$dia_hora'
				WHERE usuario = '$logueo->usuario' ";
		$query = mysql_query( $sql );
		*/
	}//fin del if

	echo json_encode($json);

?>