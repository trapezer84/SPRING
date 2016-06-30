<?php
	namespace framework\util;
	
	use framework\exceptions\ListIndexOutOfBoundException;
	
	class ArrayList {
		private $listData = null;
		
		public function __construct() {
			$this->listData = array();
		}
		
		// Add Object
		public function add($object) {
			array_push($this->listData, $object);
			return $this;
		}
		
		// Add All Another ArrayList
		public function addAll($anotherList) {
			array_merge($this->listData, $anotherList);		
			return $this;
		}
		
		// Get Object by index
		public function get($index) {
			
			$this->isValidIndex($index);
			
			return $this->listData[$index];
		}
		
		// Remove by index
		public function remove($index) {
			
			$this->isValidIndex($index);
			
			unset($this->listData[$index]);
			
			return $this;
		}
		
		// Remove All Object
		public function removeAll() {
			unset($this->listData);
			$this->listData = array();
			
			return $this;
		}
		
		public function compareValue($value) {
			$result = array_search($value, $this->listData);
			
			return !is_null($result);
		}
		
		public function size() {
			return count($this->listData);
		}
		
		private function isValidIndex($index) {
			if($this->size() <= $index) {
				throw new ListIndexOutOfBoundException('size:'.$this->size().', index:'.$index);
			}
		}
	}
?>