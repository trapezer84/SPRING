<?php

	namespace application\dao;
	
	use framework\orm\Database;
	
	class WelcomeDAO extends Database {
		
		private $sqlTemplete = null;
		
		public function __construct() {
			$database = parent::getMySqlConnection();
			$this->sqlTemplete = $database->getQueryTemplete();
		}
		
		public function getQueryTest() {
			$result = $this->sqlTemplete->select("Welcome.testQuery", null);
			return $result;
		}
		
	}

?>