package org.SuperMarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Down_Page_second_Dao {

	
	public void Down_Page_second_Dao(String goods_name) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}catch(ClassNotFoundException ce){
			System.out.println("SQLException:"+ce.getMessage());
		}
		
		
		//从这里开始对已有用户进行查询
		try{
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://superMarket//one.accdb");
			Statement stmt = con.createStatement();
		
			ResultSet rs = stmt.executeQuery("select * from goods where goods_name='"+goods_name+"'");
			if(rs.next()) {
				String sql="delete from goods where goods_name='"+goods_name+"'";
				stmt.executeUpdate(sql);
				JOptionPane.showConfirmDialog(null, "下架成功", "提示",JOptionPane.YES_NO_OPTION);
			}
			

			rs.close();
			stmt.close();
			con.close();
			System.out.println("成功");
		}catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}
	}
}
