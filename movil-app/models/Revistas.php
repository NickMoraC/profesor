<?php

/**
 * Representa el la estructura de la tabla personas
 * almacenadas en la base de datos
 */
 
require_once('../config/Database.php');

class Revistas
{
	
    public static function findAll(){
        $string = "SELECT * FROM revistas;";
        try {
			$comando = Database::getInstance()->getDb()->prepare($string);
			$comando->execute();
			$registros = $comando->fetchAll(PDO::FETCH_ASSOC);
			if ($registros){			
				$msj = json_encode(array('status' => 'success','message' => 'Se encontraron registros', 'data'=>$registros));
			}else{
				$msj = json_encode(array('status' => 'error','message' => 'No hay registros'));
			}
		}catch (PDOException $e){
			//$errorMsj = Revistas::getError($e->getCode());
			$msj = json_encode(array('status' => 'error','message' => $e->getCode(). ' '. $e->getMessage()));
			//$msj = json_encode(array('status' => 'error','message' =>$errorMsj));
		}
		return $msj;
    }
	
	
	public static function findByPk($id) {
		$string = "SELECT * FROM revistas  WHERE id = :id";
		try {
			$comando = Database::getInstance()->getDb()->prepare($string);
			$comando->bindParam(':id', $id);
			$comando->execute();
			$registros = $comando->fetch(PDO::FETCH_ASSOC);
			if ($registros){			
				$msj = json_encode(array('status' => 'success','message' => 'Se encontro un registro', 'data'=>$registros));
			}else{
				$msj = json_encode(array('status' => 'error','message' => 'No hay registros'));
			}
		}catch (PDOException $e){
			//$errorMsj = Revistas::getError($e->getCode());
			$msj = json_encode(array('status' => 'error','message' => $e->getCode(). ' '. $e->getMessage()));
			//$msj = json_encode(array('status' => 'error','message' =>$errorMsj));
		}
		return $msj;
		
    }
	
	public static function save($titulo,$issn,$numero,$anio){        
		$string = "INSERT INTO revistas (titulo, issn, numero, anio) VALUES (:titulo, :issn, :numero, :anio)";	
		try {
			$comando = Database::getInstance()->getDb()->prepare($string);
			$comando->bindParam(':titulo', $titulo);						
			$comando->bindParam(':issn', $issn);						
			$comando->bindParam(':numero', $numero);						
			$comando->bindParam(':anio', $anio);						
			if($comando->execute())
				$msj = json_encode(array('status' => 'success','message' => 'Registro agregado correctamente...',));			
			else
				$msj = json_encode(array('status' => 'error','message' => 'Ocurrio un error.',));			
				
		}catch (PDOException $e){
			$msj = json_encode(array('status' => 'error','message' => $e->getMessage()));
		}
		return $msj;
	}
	
	public static function update() {        
        
}

    public static function delete($id){ 
		$string = "DELETE FROM revistas  WHERE id = :id";	
		try {
			$comando = Database::getInstance()->getDb()->prepare($string);
			$comando->bindParam(':id', $id);						
			$comando->execute();
			$msj = json_encode(array('status' => 'success','message' => 'Registro eliminado satisfatoriamente...',));			
		}catch (PDOException $e){
			$msj = json_encode(array('status' => 'error','message' => $e->getMessage()));
		}
		return $msj;
    }
	
	public static function getError($code){
		if($code=='42S02')
			$error = 'Tabla no encontrada...';
		elseif($code=='1045')
			$error = 'Error de conexión a la base de datos.';
		else
			$error = 'Ocurrio un error en la base de datos';
			
		return $error;
    }
}

?>
