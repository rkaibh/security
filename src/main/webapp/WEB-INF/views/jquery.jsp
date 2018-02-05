<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("button").on("click", function(){
			$.post("jData").done(function(data){
				console.log(data);
			});
		});
	});
</script>
</head>
<body>
	<button type="button">로그인 확인</button>
</body>
</html>