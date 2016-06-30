<?php

	namespace framework\core;
	
	//
	// Set and Get Session Object
	//
	class SessionHandler {
		
		// Set Obejct to Session
		public static function setSessionObject($sessionKey, $sessionObject) {
			session_start();
			$_SESSION[$sessionKey] = serialize($sessionObject);
		}
		
		// Get Obejct from Session
		public static function getSessionObject($sessionKey) {
			session_start();
			return unserialize($_SESSION[$sessionKey]);
		}
		
	}

?>