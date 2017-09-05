<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%-- <%@page import="com.mysql.jdbc.*" %>--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录结果</title>
</head>
<body>


<jsp:useBean id="user" class="com.foxhis.service.UserService"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<c:if test="${user.login}">
<jsp:forward page="success.jsp"></jsp:forward>>
</c:if>

<c:if test="${not user.login}">
<jsp:forward page="fails.jsp"></jsp:forward>
</c:if>







<%--
<%!
   public static final String DB_Driver = "com.mysql.jdbc.Driver";
   public static final String DB_Url = "jdbc:mysql://localhost:3306/xmsitf";
   public static final String DB_User = "root";
   public static final String DB_Pwd = "foxhis";   
%>
   
<%
 Connection conn=null;
 PreparedStatement ps = null;
 ResultSet rs = null;
 boolean reb = false;
%>

<%
try{
%>

<%
   Class.forName(DB_Driver);
   conn = DriverManager.getConnection(DB_Url, DB_User, DB_Pwd);
   ps=conn.prepareStatement("select * from username where username=? and password=?");
   ps.setString(1, request.getParameter("username"));
   ps.setString(2, request.getParameter("pass"));
   rs = ps.executeQuery();
   if(rs.next())
   {
	   reb=true;
   }
   else
   {
	   reb = false;
   }  
%>

<%
} catch(Exception e)
{
	e.printStackTrace();
}
finally{
	if(conn!=null)
		conn.close();
	if(rs!=null)
		rs.close();
	if(ps!=null)
		ps.close();
}
%>

<%
 if(reb){
%>
<jsp:forward page="success.jsp"></jsp:forward>
<%
} else{
%>
<jsp:forward page="fails.jsp"></jsp:forward>
<%
}
%>
 --%> 

   
   
<%--
 <c:if test="${param.username==\"1001\" && param.pass==\"1234\"}">
 <h2>登录成功</h2></c:if> 
 <c:if test="${param.username!=\"1001\" || param.pass!=\"1234\"}">
 <h2>登录失败，请<a href="index1.jsp">重新登录</a></h2></c:if> 
 --%> 
 
</body>
</html>