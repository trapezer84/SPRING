<?php  

	namespace framework\orm\util;
	
	class XMLPath {
		
		public static function getQuery($path, $targetNode) {
			
			$explorer = new XMLExplorer();
			$explorer->getNodeText($path, $targetNode);

			return $explorer;
		}
	}

?>