package org.SuperMarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Change_Page_second_Dao {

	 public void Change_Page_second_Dao(String a,String b,String c,String d,
				String f,String g,String h,String i,
				String j) {
		 try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			}catch(ClassNotFoundException ce){
				System.out.println("SQLException:"+ce.getMessage());
			}
			
			
			//�����￪ʼ�������û����в�ѯ
			try{
				Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://superMarket//one.accdb");
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from goods where goods_name='"+b+"'");
		

				
				if(rs.next()) {
					
					String x= rs.getString("goods_ID");
					
					//���µ�sql
					String sql ="update goods set goods_type=?,goods_name=?,price=?,price_unit=?,stock=?,SKU=?,production_date=?,expiration_date=?,producer=? where goods_name=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, a);
					ps.setString(2, b);
					ps.setString(3, c);
					ps.setString(4, d);
					ps.setString(5, f);
					ps.setString(6, g);
					ps.setString(7, h);
					ps.setString(8, i);
					ps.setString(9, j);
					ps.setString(10,b);
					ps.executeUpdate();
					JOptionPane.showConfirmDialog(null, "���ĳɹ�", "��ʾ",JOptionPane.YES_NO_OPTION);
					
				}
				
				con.close();
				rs.close();
				stmt.close();	
			}catch(SQLException e) {
				System.out.println("SQLException:"+e.getMessage());
			}

	 }
}
