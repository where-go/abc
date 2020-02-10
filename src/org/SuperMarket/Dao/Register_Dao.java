package org.SuperMarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.SuperMarket.swing.LoginA;

public class Register_Dao {
		
		public Boolean a ;
			
		public void Search(String username,String password) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			}catch(ClassNotFoundException ce){
				System.out.println("SQLException:"+ce.getMessage());
			}
			
			try{
				Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://superMarket//one.accdb");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from User where username='"+username+"'");
				
				
				if(rs.next()) {
					JOptionPane.showConfirmDialog(null, "账号已存在，请重新填写用户名", "提示",JOptionPane.YES_NO_OPTION);
					a = false;           //账号已经存在
				}else{					
					String sql = "insert into User values(?,?,?)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1,0);         //数据库会自动编号
					ps.setString(2,username);
					ps.setString(3,password);
					ps.executeUpdate();
					a = true;           //注册成功
					JOptionPane.showConfirmDialog(null, "注册成功", "提示",JOptionPane.YES_NO_OPTION);
				}
				
				con.close();
				rs.close();
				stmt.close();	
				
			}catch(SQLException e) {
				System.out.println("SQLException:"+e.getMessage());
			}

		
	}
}
	
	