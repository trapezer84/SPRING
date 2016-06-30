<?php

namespace framework\util;

class Map {
	
	private $map = null;
	
	public function __construct() {
		$this->map = array();
	}
	
	public function put($key, $value) {
		$this->map[$key] = $value;
	}
	
	public function getKeys() {
		return array_keys($this->map);
	}
	
	public function get($key) {
		if(array_key_exists($key, $this->map) > 0) {
			return $this->map[$key];
		}
		else {
			return "";
		}
	}
	
	public function remove($key) {
		$index = array_search($key, $this->map);
		unset($this->map[$index]);
	}
	
	public function clean() {
		unset($this->map);
		$this->map = array();
	}
	
	public function size() {
		return count($this->map);
	}
	
}

?>