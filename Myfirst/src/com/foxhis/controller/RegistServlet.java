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

@WebServlet("/register")
public class RegistServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 /**
     * @return 
	 * @see HttpServlet#HttpServlet()
     */
    public  RegistServlet() {
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
		String repass = request.getParameter("repassword");
		
		
		if(username==null||username.trim().isEmpty()){  
            request.setAttribute("usernamemsg", "帐号不能为空");   
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return;  
        }  
		if(pass==null||pass.trim().isEmpty()){  
            request.setAttribute("passwordmsg", "密码不能为空"); 
            request.setAttribute("username", username);  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return;  
        }  
		if(repass==null||repass.trim().isEmpty()){  
			request.setAttribute("username", username);  
			request.setAttribute("password", pass); 
            request.setAttribute("repasswordmsg", "确认不能为空");  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return;  
        } 
		if(!repass.equals(pass)){  
			request.setAttribute("username", username);  
			request.setAttribute("password", pass);  
			request.setAttribute("repassword", repass);  
            request.setAttribute("repasswordmsg", "确认密码与密码不一致，请重新输入");  
           
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return;  
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
		boolean hasUser = userservice.getLogin(user);
		if(hasUser)
		{
			request.setAttribute("usernamemsg", "帐号已经被注册");  
			request.getRequestDispatcher("/register.jsp").forward(request, response);  
			return;  
		}
		
		//最终通过服务调用登录方法
		boolean isLogin = userservice.RegisterUser(user);
		
		String forword = "";
		if(isLogin)
		{
			forword = "regsuccess.jsp";
		}
		else
		{
			forword = "fails.jsp";
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
