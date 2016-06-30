<?php
	
	// When called new keyword 
	// Search Called Class Path. And Import Class
	function autoload($classId) {
		
		// Split Target Class Path
		$classIdParts	= explode("\\", $classId);
		
		// Get Target Class Path Array count
		$classIdLength	= count($classIdParts);
		
		// Get Class Name
		$className		= $classIdParts[$classIdLength - 1];
		
		// Get Namespace of Class
		$namespace		= $classIdParts[0];
		
		// Merge Namespace of Class
		for($i = 1; $i < ($classIdLength-1); $i++) {
			$namespace .= "/".$classIdParts[$i];
		}
		
		// Merge Namespace and Class
		$fileName = $GLOBALS['__FRAMEWORK_PATH']."/".$namespace."/".$className.".php";
		
		// Include Class File
		if(file_exists($fileName)) {
// 			echo $fileName."<br/>";
			require_once $fileName;
		}
	}
	
	// Added Listener
	spl_autoload_register("autoload");

?>