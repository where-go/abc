package org.SuperMarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UP_Page_Dao {

	
	public void UP_Page_Dao(String a,String b,String c,String d,String f,String g,String h,String i,String j) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}catch(ClassNotFoundException ce){
			System.out.println("SQLException:"+ce.getMessage());
		}
		
		
		//从这里开始对已有用户进行查询
		try{
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://superMarket//one.accdb");
			Statement stmt = con.createStatement();
			
			String sqlstr="insert into goods values('1','"+a+"','"+b+"','"+c+"','"+d+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"')";
			stmt.executeUpdate(sqlstr);
			con.close();
			stmt.close();	
		}catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}

	}
}
