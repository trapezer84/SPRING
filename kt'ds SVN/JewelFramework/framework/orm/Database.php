<?php

	namespace framework\orm;
	
	use framework\orm\my_sql\DBConnection;
	
	class Database {
		
		public function getMySqlConnection() {
			return DBConnection::getInstance('rooya.vps.phps.kr', 'rooya', 'wkdalsckd1!', 'rooya');
		}
		
	}

?>