<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>

</head>
<body>
<center>
 <div>
  <h1>注册</h1>
  <form action="register" method="post">
   请输入帐号:<input type ="text" name="username" value="${username}"><font size="2" color="red">${usernamemsg}</font><br>
   请输入密码:<input type ="password" name ="password" value="${password}"><font size="2" color="red">${passwordmsg}</font><br>
   请确认密码:<input type = "password" name ="repassword" value="${repassword}"><font size="2" color="red">${repasswordmsg}</font><br>
  <input type="submit" value="注册">
  <a href="../index.jsp" ><font size="4">取消</font></a>
  </form>

 </div>
</center>


</body>
</html>