package org.SuperMarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Search_Page_one_Dao {
	
	public String l="0";

	public String a="0",b="0",c="0",d="0",f="0";   
	public String g="0",h="0",i="0",j="0";
	
	public void Search_Page_one_Dao(String goods_name) {
		
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
			
			if(rs.next()==true) {
				a=rs.getString("goods_type");
				b=rs.getString("goods_name");
				c=rs.getString("price");
				d=rs.getString("price_unit");
				f=rs.getString("stock");
				g=rs.getString("SKU");
				h=rs.getString("production_date");
				i=rs.getString("expiration_date");
				j=rs.getString("producer");
				l="1";
			}else if(rs.next()==false){
				l="0";
			}

			con.close();
			rs.close();
			stmt.close();	
		}catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}

	}
}
