<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exUpload</title>
    <style>
         .wrap{max-width: 800px; margin: 100px auto; padding: 10px; border: 1px solid #ccc;}
        .wrap>form div{margin: 10px 0;}        
    </style>
</head>
<body>
    <div class="wrap">
        <form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
            <div><input type="file" name="files"></div>
            <div><input type="file" name="files"></div>
            <div><input type="file" name="files"></div>
            <div><input type="file" name="files"></div>
            <div><input type="file" name="files"></div>
            <div><input type="submit"></div>
        </form>
    </div>
</body>
</html>