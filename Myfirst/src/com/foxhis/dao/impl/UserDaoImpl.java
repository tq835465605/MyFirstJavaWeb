package com.foxhis.dao.impl;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.foxhis.dao.UserDao;
import com.foxhis.entity.User;


/***
 * Dao层一般是作为与数据库打交道的层，在MVC里是模型层model
 * @author tq
 *
 */
public class UserDaoImpl implements UserDao{
	
	/*private String DB_Driver = "com.mysql.jdbc.Driver";
	private String DB_Url = "jdbc:mysql://localhost:3306/xmsitf";
	private String DB_User = "root";
	private String DB_Pwd = "foxhis"; */
	
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
		
		/* DB_Driver = "com.mysql.jdbc.Driver";
		 DB_Url = "jdbc:mysql://localhost:3306/xmsitf";
		 DB_User = "root";
		 DB_Pwd = "foxhis"; */
	}
	
/*
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
	}*/
	
	public boolean registerUserByNameAndPass(User user)
	{
		 //定位配置文件
        String resource= "MyBatis_Conf.xml";
        //获取配置文件流
        InputStream inputStream =this.getClass().getClassLoader().getResourceAsStream(resource);      
        //通过SqlSessionFactoryBuilder class create a instance and use the fun build to create ssf
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(inputStream);
       //open the SqlSessionFactory
        SqlSession sqlSess= ssf.openSession();
        //
        String paramString = "com.foxhis.mapping.UserMapper.addUser";
        int i=sqlSess.insert(paramString, user);
        System.out.println("加载用户名："+i);
        sqlSess.close();
        if(i>=1)
        	return true;
        else {
		    return false;
		}
	}
	public <T>T getMybatisConn(Map<String, Object> input)
	{
        //定位配置文件
        String resource= "MyBatis_Conf.xml";
        //获取配置文件流
        InputStream inputStream =this.getClass().getClassLoader().getResourceAsStream(resource);
        
        //通过sqlsessionfactorybuilder class creat a instance and use the fun build to create ssf
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(inputStream);
       //open the sqlsessionfactory
        SqlSession sqlSess= ssf.openSession();
        //
        String paramString = "com.foxhis.mapping.UserMapper.getUser";
        return sqlSess.selectOne(paramString, input);
        
        
	}
	
	public static void main(String[] args) {
		Map<String, Object> input = new HashMap<String,Object>();
		input.put("username", "1001");
		input.put("password", "1234");
		new UserDaoImpl().getMybatisConn(input);
	}
	
	public boolean findUserByNameAndPass(User user)
	{
		boolean reb=false;
		Map<String, Object> input = new HashMap<String,Object>();
		input.put("username", user.getUsername());
		input.put("password", user.getPass());
		User user2=getMybatisConn(input);
		if(user2!=null)
		{
			reb=true;
		}
		else {
			reb =false;
		}
		return reb;
	}
	
	/*
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
	*/
}



