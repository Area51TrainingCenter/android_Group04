<?php
	
	require_once 'conex.php';


	$json = array('respuesta' => 'OK',
					'mensaje' => 'Lista de usuarios');

	$sql = "SELECT id, usuario, clave , estado, votacion 
			FROM usuario
			ORDER BY id DESC";

	$query = mysql_query($sql);

	while ( $datasql = mysql_fetch_assoc($query)  ) {
		$json['datos'][] = $datasql;
	}

	echo json_encode($json);


?>