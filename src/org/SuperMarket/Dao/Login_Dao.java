package org.SuperMarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Login_Dao {
	
	public boolean a ;
	
	public void Search(String username,String password) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}catch(ClassNotFoundException ce){
			System.out.println("SQLException:"+ce.getMessage());
		}
		
		
		//�����￪ʼ�������û����в�ѯ
		try{
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://E://superMarket//one.accdb");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from User where username='"+username+"'");
			

			String sql1 ="select * from User where username='"+username+"' and password='"+password+"'";
			ResultSet rs1 = stmt.executeQuery(sql1);
			
			if(rs.next()) {
				if(rs1.next()) {
					a = true;
				}else {
					JOptionPane.showConfirmDialog(null, "�˺�����������ٴ�����", "��ʾ",JOptionPane.YES_NO_OPTION);
					a = false;
				}
				
			}else {
				JOptionPane.showConfirmDialog(null, "�����ڴ��˺ţ������������˺�", "��ʾ",JOptionPane.YES_NO_OPTION);
			}

			con.close();
			rs.close();
			stmt.close();	
		}catch(SQLException e) {
			System.out.println("SQLException:"+e.getMessage());
		}

	}

}
