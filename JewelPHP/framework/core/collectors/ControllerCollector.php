<?php
	
	namespace framework\core\collectors;
	
	class ControllerCollector {
		
		// Array Type Controllers name
		public $controller = null;
		
		public function __construct() {
			$this->controller = array();
			$this->collectController($GLOBALS['__APPLICATION_PATH']);
		}
		
		//
		// Search Controller Path in controller class
		//
		private function collectController($dir) {

			if($dirOrFiles = opendir($dir)) {
				
				$inFiles = array();
				
				while($list = readdir($dirOrFiles)) {
					
					if($list[0] != ".") {
						if(is_dir($dir."/".$list)) {
							$inFiles = $this->collectController($dir."/".$list);
						}
						else {
							$ctrlName = str_replace($GLOBALS['__FRAMEWORK_PATH'], "", $dir."/".$list);
							$ctrlName = str_replace(".php", "", $ctrlName);
							$ctrlName = str_replace("/", "\\", $ctrlName);
							new $ctrlName();
						}
					}
				}
				
				closedir($dirOrFiles);
				
			}
			
		}
		
	}

?>