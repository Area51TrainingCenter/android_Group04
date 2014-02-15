<?php
	
	require_once 'conex.php';

	//Esta variable será para imprimir el formato json desde el api
	$json = array('respuesta' => 'ERROR');

	$logueo = new ArrayObject( array() , 2 );
	$logueo->usuario = "";
	$logueo->clave = "";

	//Recibimos por el método $_GET
	if( isset($_GET['usuario']) && $_GET['usuario'] != ''  ){
		$logueo->usuario = htmlentities(strip_tags($_GET['usuario']));
	}

	if( isset($_GET['clave']) && $_GET['clave'] != ''  ){
		$logueo->clave = htmlentities(strip_tags($_GET['clave']));
	}

	//print_r($logueo);


	//$_POST['valor'];
	//$_FILE['valor'];

	if ( $logueo->usuario != '' && $logueo->clave != '' ) {

		$sql = "SELECT * FROM usuario 
				WHERE usuario = '$logueo->usuario'
				AND clave = '$logueo->clave'
				LIMIT 1";
				
		$query = mysql_query($sql);
		$total = mysql_fetch_assoc($query);

		if ( count($total) > 1 ) {
			//echo 'Ingreso valido';
			$json['respuesta'] = 'OK';
			$json['mensaje'] = 'INGRESO CORRECTO';
			$json['datos'][] = $total;
			//array_push(array, var);
		}else{
			$json['mensaje'] = 'Revise los datos ingresos';
		}


	}else{
		//echo 'Error de datos';
	}

	echo json_encode($json);

?>