<html>
	<head>
		<script type="text/javascript" charset="utf-8" src="/JewelFramework/resources/js/test.js"></script>
	</head>
	<body>
		<form method="POST" action="<?php $this->contextPath()?>/Welcome/receive">
			<input type="text" name="name" id="name" />
			<input type="submit" value="ok" />
		</form>
		
		<?php $this->get("name")?>
	</body>
	
	
</html>