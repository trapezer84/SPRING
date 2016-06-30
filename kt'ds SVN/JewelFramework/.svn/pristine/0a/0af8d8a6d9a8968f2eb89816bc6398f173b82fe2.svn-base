<?php   
	
	namespace framework\orm\my_sql;
	
	use framework\orm\util\XMLPath;
	
	class QueryTemplete {
		
		private $cache = null;
		
		//Param XMLPath();
		public function __construct() {
			$this->cache = phpFastCache();
		}
		
		public function queryForSelect($queryString) {
			DBConnection::open();
			
			$result = mysqli_query(DBConnection::$con, $queryString);
			$result = self::copyArrayFromFetchArray($result, null);
			DBConnection::close();
			return $result;
		}
		
		public function queryForOther($queryString) {
			DBConnection::open();
			mysqli_query(DBConnection::$con, $queryString);
			DBConnection::close();
		}
		
		public function select($sqlID, $parameter) {
			DBConnection::open();
			$xmlResult = self::getPathAndTarget($sqlID);
			
			if($xmlResult->queryMode != "select") {
				throw new \Exception("Can not excute ".$xmlResult->queryMode." query.", 500);
			}
			
			// echo "Query : ".$xmlResult->xml."<br/>";
			// echo "Query Mode : ".$xmlResult->queryMode."<br/>";
			// echo "Return Type : ".$xmlResult->returnType."<br/>";
			// echo "Return Map : ".$xmlResult->returnMap."<br/>";
			
			$queryString = self::preparedStateQuery($xmlResult->xml, $parameter);
			$result = mysqli_query(DBConnection::$con, $queryString);
			$result = self::copyArrayFromFetchArray($result, $xmlResult);
			DBConnection::close();
			return $result;
		}
		
		public function insert($sqlID, $parameter) {
			DBConnection::open();
			$xmlResult = self::getPathAndTarget($sqlID);
			$queryString = self::preparedStateQuery($xmlResult->xml, $parameter);
			mysqli_query(DBConnection::$con, $queryString);
			DBConnection::close();
		}
		
		public function delete($sqlID, $parameter) {
			self::insert($sqlID, $parameter);
		}
		
		public function update($sqlID, $parameter) {
			self::insert($sqlID, $parameter);
		}
		
		private function preparedStateQuery($query, $parameter) {

			if($parameter != null && $parameter->size() > 0) {
				$keys = $parameter->getKeys();
				$size = count($keys);
				$key = "";
				
				$value = "";
				
				for($i = 0; $i < $size; $i++) {
					$key = $keys[$i];
					
					if(is_numeric($parameter->get($key))) {
						$value = $parameter->get($key);
					}
					else {
						$value = "'".$parameter->get($key)."'";
					}
					$query = str_replace("#".$key."#", $value, $query);
					$query = str_replace("$".$key."$", $parameter->get($key), $query);
					
				}
			}

			return $query;
		}
		
		private function copyArrayFromFetchArray($selectResult, $xmlResult) {
			
			$result = array();
			
			if($selectResult != null) {
				while($row = mysqli_fetch_array($selectResult, MYSQL_ASSOC)) {
					array_push($result, $row);
				}
			}
			
			if(count($result) == 1) {
				return $result[0];
			}
			else {
				return $result;
			}
			
			
		}
		
		private function getPathAndTarget($sqlID) {
			$param = explode(".", $sqlID);
			return XMLPath::getQuery($this->cache->get($param[0].".xml"), $param[1]);
		}
		
	}
?>