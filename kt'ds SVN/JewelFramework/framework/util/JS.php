<?php

	namespace framework\util;
	
	class JS {
		
		public function __construct() {}
		
		public function convertToJSON($destVar, $phpVariable) {
			$result = "var ".$destVar." = ".json_encode($phpVariable);
			echo $result;
		}
		
	}
	

?>