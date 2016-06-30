<?php

	namespace application\controller;
	
	use framework\core\ArgumentsUtil;
	use framework\mvc\view\View;
	use framework\mvc\controller\Controller;
	
	use application\dao\WelcomeDAO;
	
	/**
	 * Class name must equals file name.
	 */
	class Welcome extends Controller{
		
		private $welcomeDAO = null;
		
		public function __construct() {
			parent::__construct("application\controller\Welcome", "Welcome");
			$this->welcomeDAO = new WelcomeDAO();
		}
		
		public function index() {
			
			$path 	= ArgumentsUtil::getPATHArgument(func_get_args());
			$post 	= ArgumentsUtil::getPOSTArgument(func_get_args());
			$get 	= ArgumentsUtil::getGETArgument(func_get_args());
			
			$queryTest = $this->welcomeDAO->getQueryTest();

			$view = new View();
			
			$view->setView("/Welcome.php");
			// $view->setObject("path1", $path[0]);
			// $view->setObject("name", $get["name"]);
			$view->show();
		}
		
		public function receive() {
			$post 	= ArgumentsUtil::getPOSTArgument(func_get_args());
			echo $post["name"];
		}
	}

?>