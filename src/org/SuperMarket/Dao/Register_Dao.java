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
					JOptionPane.showConfirmDialog(null, "�˺��Ѵ��ڣ���������д�û���", "��ʾ",JOptionPane.YES_NO_OPTION);
					a = false;           //�˺��Ѿ�����
				}else{					
					String sql = "insert into User values(?,?,?)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1,0);         //���ݿ���Զ����
					ps.setString(2,username);
					ps.setString(3,password);
					ps.executeUpdate();
					a = true;           //ע��ɹ�
					JOptionPane.showConfirmDialog(null, "ע��ɹ�", "��ʾ",JOptionPane.YES_NO_OPTION);
				}
				
				con.close();
				rs.close();
				stmt.close();	
				
			}catch(SQLException e) {
				System.out.println("SQLException:"+e.getMessage());
			}

		
	}
}
	
	