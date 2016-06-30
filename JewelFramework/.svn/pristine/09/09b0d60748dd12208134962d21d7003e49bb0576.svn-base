<?php 
	  
	namespace framework\orm\my_sql;
	
	class DBConnection {
		
		private static $host; 
		private static $userId;
		private static $password;
		private static $database;
		
		private function __construct($host, $userId, $password, $database) {
			self::$host = $host;
			self::$userId = $userId;
			self::$password = $password;
			self::$database = $database;
			
			$this->getConnection();
		}
		
		public static function getInstance($host, $userId, $password, $database) {
			return new DBConnection($host, $userId, $password, $database);
		}
		
		public static $con = null;
		
		public function getConnection() {
			if(is_null(self::$con)) {
				self::$con = "";
			}			
			return self::$con;
		}
		
		public static function open() {
			self::$con = mysqli_connect(self::$host, self::$userId, self::$password, self::$database);
			
			if (!self::$con) {
				echo "Failed to connect to MySQL: " . mysqli_connect_error();
			}
			
			mysqli_query(self::$con, "SET NAMES 'utf8'");
		}
		
		public static function close() {
			mysqli_close(self::$con);
		}
		
		private $queryTemplete = null;
		
		// @param XMLPath();
		public function getQueryTemplete() {
			
			if(is_null(self::$con)) {
				throw new \Exception("Connection Fail", 500);
			}
			if($this->queryTemplete == null) {
				
				$this->queryTemplete = new QueryTemplete();
			}
			
			return $this->queryTemplete;
		}
		
	}

?>