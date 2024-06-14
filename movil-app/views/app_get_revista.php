<?php
Header('Access-Control-Allow-Origin: *');
/**
 * Insertar una nueva meta en la base de datos
 */

require_once('../models/Revistas.php');

			
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	
	$body = json_decode(file_get_contents("php://input"), true);
	$id = $body["revistaId"];
	print Revistas::findByPk($id);
}
?>
