package com.foxhis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foxhis.dao.UserDao;
import com.foxhis.dao.impl.UserDaoImpl;
import com.foxhis.entity.User;
import com.foxhis.service.UserService;

/**
 * Servlet implementation class LoginServlet
 * controller数据控制层，用于请求post,get的业务处理以及跳转
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String verifycode =request.getParameter("verifycode");
		
		if(username==null||username.trim().isEmpty()){  
            request.setAttribute("msg", "帐号不能为空");   
            request.getRequestDispatcher("/index.jsp").forward(request, response);  
            return;  
        }  
		
		String session = (String)request.getSession().getAttribute("sessionverify");
		if(session==null ||(session!=null && !session.equalsIgnoreCase(verifycode)))
		{
			request.setAttribute("username", username); 
			request.setAttribute("msg", "验证码输入不正确"); 
			request.getRequestDispatcher("/index.jsp").forward(request, response); 
			return ;
		}
		
		//定义实体
		User user = new User();
		user.setUsername(username);
		user.setPass(pass);
		//定义服务，用于干什么，该请求主要是登录
		UserService userservice = new UserService();
		
		//定义DAO层，用于与数据库操作
		UserDao userdao = new UserDaoImpl();
		//初始化服务
		userservice.setUserdao(userdao);
		//最终通过服务调用登录方法
		boolean isLogin = userservice.getLogin(user);
		
		String forword = "";
		if(isLogin)
		{
			forword = "success.jsp";
		}
		else
		{
			request.setAttribute("username", username); 
			request.setAttribute("msg", "用户名或者密码错误"); 
			request.getRequestDispatcher("/index.jsp").forward(request, response); 
			return ;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(forword);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
