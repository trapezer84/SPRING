<?php

	namespace framework\core\collector;
	
	class SQLCollector {
		
		public $cache = null;
		
		public function __construct() {
			$this->cache = phpFastCache();
			$this->collectSql($GLOBALS['__APPLICATION_PATH']);
		}
		
		//
		// Search Controller Path in controller class
		//
		private function collectSql($dir) {
			
			if($dirOrFiles = opendir($dir)) {
				
				$inFiles = array();
				
				while($list = readdir($dirOrFiles)) {

					if($list[0] != ".") {
						if(is_dir($dir."/".$list)) {
							$inFiles = $this->collectSql($dir."/".$list);
						}
						else {
							$exists = strrpos($list, ".xml");

							if($exists) {
								$xmlFile = str_replace($GLOBALS['__FRAMEWORK_PATH'], "", $dir."/".$list);
								$this->cache->set($list, $xmlFile);
							}
						}
					}
				}
				
				closedir($dirOrFiles);
				
			}
			
		}
		
	}

?>
