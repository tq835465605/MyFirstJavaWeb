<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="descript"  content="西软，西软接口管理系统，系统"/>
<meta name="keywords" content="接口，接口管理系统">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>接口管理系统登录界面</title>

<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />

</head>

<!--  
 <script type="text/javascript">  
      function change(){  
          var img =document.getElementById("verify");  
          img.src="verifycodesevlet?a="+new Date().getTime();  
      }  
</script>
 -->
<body>


<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas">请更换浏览器</canvas>
					<div class="logo_box">
						<h3>接口管理系统欢迎你</h3>
						<form action="login" name="f" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2">
							<input class="text act-but"  style="color: #FFFFFF" type = "submit" value="登录" />
							</div>
							<div class="mb2">
							<font class ="font">${msg}</font>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
		<div style="text-align:center;">
<h4><a href="http://www.foxhis.com/" target="_blank">西软官网</a> @版权所有：2017 杭州西软信息技术有限公司</h4>
</div>



<!-- 
<form name="form1" method="post" action="login">
<table>  
    <tr>  
    <td width="66" align="right"><font size="3">帐号：</font></td><td colspan="2"><input type="text" name="username" value="${username}" style="width:200;height:25;"/></td>  
    </tr>  
    <tr>  
    <td align="right"><font size="3">密码：</font></td><td colspan="2"><input type="password" name="password"  style="width:200;height:25;"/></td>  
    </tr>  
    <tr>  
    <td align="right"><font size="3">验证码：</font></td>  
    <td width="108" valign="middle"><input type="text" name="verifycode" style="width:100;height:25;"/></td>  
    <td width="90" valign="middle"><a href="javascript:change()"><img src="verifycodesevlet" id="verify" border="0"></a></td>  
    </tr>  
    <tr><td colspan="3" align="center"><input type="submit" value="登录" style="width:130;height:30;"/></td></tr>  
   </table>  
</form> 
    <a href="jsp/register.jsp"><font size="2"><i>没有帐号？点击注册</i></font></a>   <br>
     <font color="red" size="2">${msg}</font>
-->



<%-- 
	<form name="form1" method="post" action="login" onsubmit="myfun()">
		用户名：<input type="text" name="username" id="username"><br /> 
		密码：<input type="password" name="pass" id="pass"><br /> 
		<input type="submit" value="确定" name="submit" /> 
		<input type="reset" value="重置" name="reset" />
	</form>
 --%>
</body>
</html>