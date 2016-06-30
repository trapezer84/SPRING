<?php
// Jewel Frame work path
// DO NOT EDIT
$__FRAMEWORK_PATH = dirname(__FILE__);

// Define GLOBALS Variable
include "./framework/core/config/Config.php";

// Load CAL(Class Auto Loader)
include "./framework/system/ClassAutoLoader.php";
require_once("./framework/phpfastcache/phpfastcache.php");

// import RequestHandler
use framework\core\RequestHandler;
use framework\core\collector\ControllerCollector;
use framework\core\collector\SQLCollector;

$cache = phpFastCache();

if($cache->get("exec") == null) {
	$controllerCollector = new ControllerCollector();
	$sqlCollector = new SQLCollector();
}

// Call Request URL Analysor
RequestHandler::requestAnalysor($_SERVER['REQUEST_URI']);

// Get Destination Controller Name
$destinationName = RequestHandler::$destinationControllerName;

// Define Request Controller
$controllerName = $cache->get($destinationName);

// Destination Controller Name validation check.
if($controllerName == "") {
	throw new Exception("Invalid Access... ".RequestHandler::$controller." Controller is not found", 404);
}

$destination = new $controllerName();

// Get Request Method
$method = RequestHandler::$method;

if($method != null && $method != "") {
	// Get Request Path Parameter
	$args = RequestHandler::$args;

	// Process Request Method of Request Controller
	$destination->$method($_GET, $_POST, $args);
}
?>