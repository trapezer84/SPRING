<?php

	namespace framework\mvc\view;
	
	use framework\util\Map;
	use framework\util\JS;
	
	class View {
		
		private $view;
		private $object;
		private $js;
		
		public function __construct() {
			$this->object = new Map();
			$this->js = new JS();
		}
		
		public function setView($viewName) {
			$this->view = $GLOBALS['__VIEW_PATH'].$viewName;
		}
		
		public function setObject($key, $value) {
			$this->object->put($key, $value);
		}
		
		public function show() {
			include_once($this->view);
		}
		
		public function contextPath() {
			echo $GLOBALS['__CONTEXT_PATH'];
		}
		
		public function get($key) {
			echo $this->object->get($key);
		}
		
		public function getJS($destVar, $phpVar) {
			echo $this->js->convertToJSON($destVar, $this->get($phpVar));
		}
	}

?>