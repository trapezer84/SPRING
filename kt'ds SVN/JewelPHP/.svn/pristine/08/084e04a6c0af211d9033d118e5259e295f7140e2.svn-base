<?php

	namespace framework\core;
	
	//
	// RequestHandler is Request URI Analysor.
	// @Target POST Data
	// @Target GET Data
	// @Target PATH Param Data
	// @CalledBy index.php
	//
	class RequestHandler {
		
		// Controller Param(Include path)
		public static $controller;
		
		// Method Param
		public static $method;
		
		// Path Param 
		public static $args;
		
		// Destination Controller Class Name (Include namespace)
		public static $destinationControllerName;
		
// 		public function __construct() {}
		
		public static function requestAnalysor($requestURI) {

			// remove file identity
			$requestUri = explode(".php/", $requestURI);
			
			if($requestUri[1] == "") {
				$requestUri = array();
				
				if($GLOBALS['__CONTEXT_NAME'] == "/") {	
					array_push($requestUri, "/");
					array_push($requestUri, substr($requestURI, 1));
				}
				else {
					$requestUri = explode($GLOBALS['__CONTEXT_NAME'], $requestURI);
				}
			}
			
			// remove GET Data
			$requestUri = explode("?", $requestUri[1]);

			// get request Class, Method and Argument Indentity
			$controllerPath = $requestUri[0];
			
			// Split controller name
			$controllerParts = explode("/", $controllerPath);
			
			// get Controller Name
			self::$controller =  $controllerParts[0];
			self::$destinationControllerName = self::$controller;
			// get Method Name
			self::$method = $controllerParts[1];
			
			// Initiate Path Arguments.
			self::$args = array();
			
			// Get and Merge Path Param.
			if(($size = count($controllerParts)) > 2) {
				for($i = 2; $i < $size; $i++) {
					array_push(self::$args, $controllerParts[$i]);
				}
			}
			
		}
		
	}

?>