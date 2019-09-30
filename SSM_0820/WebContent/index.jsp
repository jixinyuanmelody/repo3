<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>SUCCESS</h1>
<form action="first.action" method="post">
<input type="text" name="sid"/>
<input type="submit" value="查询">
</form>
<form action="chuan.action" method="post" enctype="multipart/form-data">
头像<input type="file" name="touxiang"/>
用户名<input type="text" name="username"/>
ID<input type="text" name="id"/>
<input type="submit" value="上传" >
</form>
</body>
</html>