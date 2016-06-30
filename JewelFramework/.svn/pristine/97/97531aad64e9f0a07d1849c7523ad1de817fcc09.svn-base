<?php  
	
	namespace framework\orm\util;
	
	class XMLExplorer {
		
		public $xml = "";
		public $returnType = "";
		public $returnMap = "";
		public $queryMode = "";
		
		public function getNodeText($path, $target) {
			$xmlReader = new \XMLReader();

			$xmlReader->open($GLOBALS['__FRAMEWORK_PATH'].$path);
			
			$id = "";
			while($xmlReader->read()) {
				switch($xmlReader->nodeType) {
				case \XMLReader::ELEMENT :
										
					$xmlReader->moveToAttribute("id");
					$id = $xmlReader->value;
					
					if($xmlReader->value == $target) {
						$xmlReader->moveToAttribute("returnType");
						$this->returnType = $xmlReader->value;
						
						if($id === $this->returnType) $this->returnType = "";

						$xmlReader->moveToAttribute("returnMap");
						$this->returnMap = $xmlReader->value;
						
						if($id === $this->returnMap) $this->returnMap = "";
						
						if($this->returnType === $this->returnMap) {
							$this->returnMap = "";
						}
						
						$xmlReader->moveToElement();
						$this->queryMode = $xmlReader->name;
						
						if($this->queryMode == "select") {
							if($this->returnMap == "" && $this->returnType == "") {
								throw new \Exception("Select must define returnType or returnMap", 500);
							}
						}
						
						$xmlReader->read();
						$this->xml = $xmlReader->value;
					}
					
					break;
				}

			}
			
		}
		
	}

?>