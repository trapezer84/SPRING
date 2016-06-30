<?php

	namespace framework\mvc\controller;
	
	require_once("./framework/phpfastcache/phpfastcache.php");
	
	abstract class Controller {
		
		public function __construct($controller, $controllerName) {
			$cache = phpFastCache();
			$cachedController = $cache->get($controllerName);
			
			if($cachedController == null) {
				$cache->set($controllerName, $controller, 99999999999);
			}
		}
		
	}

?>