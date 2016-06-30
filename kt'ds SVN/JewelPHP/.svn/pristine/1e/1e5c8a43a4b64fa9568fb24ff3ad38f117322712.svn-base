<?php

	namespace framework\core;
	
	class Params {
		
		public static $POST = "POST";
		public static $GET = "GET";
		
		// Get POST Parameter Array
		public static function RequestParams($array, $requestType) {
			if($requestType == $POST) {
				return $array[1];
			}
			else if($requestType == $GET) {
				return $array[0];
			}
		}
		
		// Get PATH Parameter Array
		public static function PathParams($array) {
			return $array[2];
		}
		
	}

?>