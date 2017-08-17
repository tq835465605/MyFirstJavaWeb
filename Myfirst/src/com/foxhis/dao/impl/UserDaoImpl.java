package com.foxhis.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.foxhis.dao.UserDao;
import com.foxhis.entity.User;


/***
 * Dao层一般是作为与数据库打交道的层，在MVC里是模型层model
 * @author tq
 *
 */
public class UserDaoImpl implements UserDao{
	
	private String DB_Driver = "com.mysql.jdbc.Driver";
	private String DB_Url = "jdbc:mysql://localhost:3306/xmsitf";
	private String DB_User = "root";
	private String DB_Pwd = "foxhis"; 
	
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
		
		 DB_Driver = "com.mysql.jdbc.Driver";
		 DB_Url = "jdbc:mysql://localhost:3306/xmsitf";
		 DB_User = "root";
		 DB_Pwd = "foxhis"; 
	}
	

	public Connection getConn() throws SQLException, ClassNotFoundException
	{
		Class.forName(DB_Driver);
		Connection conn = DriverManager.getConnection(DB_Url, DB_User, DB_Pwd);
		return conn;
	}
	
	
	public boolean registerUserByNameAndPass(User user)
	{
		Connection conn=null;
		PreparedStatement ps = null;
		int rs = 0;
		boolean reb = false;

		try
		{
			conn=getConn();
			if(conn!=null)
			{
				ps=conn.prepareStatement("insert into username (username,password) values (?,?)");
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPass());
				rs = ps.executeUpdate();
				if(rs>=1)
				{
					reb =true;
				}
				else
				{
					reb = false;
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return reb;
	}
	
	
	public boolean findUserByNameAndPass(User user)
	{
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean reb = false;

		try
		{
			conn=getConn();
			if(conn!=null)
			{
				ps=conn.prepareStatement("select * from username where username=? and password=?");
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPass());
				rs = ps.executeQuery();
				if(rs.next())
				{
					reb=true;
				}
				else
				{
					reb = false;
				}  

			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally{
			try
			{

				if(conn!=null)
					conn.close();
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		return reb;
	}
}



