package org.SuperMarket.swing;
	

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import org.SuperMarket.Dao.*;
import org.SuperMarket.swing.*;
	public class LoginA {
		
        /*----------此处是程序主函数-------------*/
	    public static void main(String[] args) {
	        // 实例化对象
	        LoginA LA = new LoginA();
	        LA.showUI();
	    }

		void showUI() {
			// TODO 自动生成的方法存根
			JFrame jf = new JFrame(); 
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			jf.setTitle("超市信息管理系统");
			jf.setSize(520,520);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			FlowLayout fl = new FlowLayout();            //设置流水布局
			jf.setLayout(fl);
			jf.setLocationRelativeTo(null);              //设置居中显示
			jf.setResizable(false);                      //不能改变大小
			
			ImageIcon imagicon = new ImageIcon("picture/img/1.jpg");
			
			Image img = imagicon.getImage();
			img = img.getScaledInstance(520, 250,Image.SCALE_DEFAULT);
			imagicon.setImage(img);
			
			JLabel jlb = new JLabel(imagicon);      //图片标签
			
			
			// 账号密码标签
			JLabel name = new JLabel("账号 : ");
			JLabel password = new JLabel("密码 : ");
			JLabel find = new JLabel("找回密码");
			
			//设置几个Panel
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			
			//尺寸
			Dimension mansion = new Dimension(330,30);
			Dimension dimension = new Dimension(200,40);
			// 输入框,输入账号用
			JTextField jt = new JTextField();
			// 输入框，输入密码用
			JPasswordField jpassword = new JPasswordField();
			//按钮“登录” 和“注册”
			JButton btn1 = new JButton("登录");
			JButton btn2 = new JButton("注册");
			
			//第三步：设置组件
			jt.setPreferredSize(mansion);  //组件账号输入框
			jpassword.setPreferredSize(mansion); //组件密码输入框
			
			btn1.setBackground(new Color(0,255,255));
			btn1.setPreferredSize(dimension);  //组件登录按钮
			
			btn2.setBackground(new Color(199,97,20));
			btn2.setPreferredSize(dimension);  //组件注册按钮
			
			//第四步：添加组件到窗体容器中
			p1.add(name);      p1.add(jt);
			p2.add(password);  p2.add(jpassword);      
			p3.add(btn1);
			p4.add(btn2);
			
			jf.add(jlb);
			jf.add(p1);
			jf.add(p2);
			jf.add(p3);
			jf.add(p4);
			jf.setVisible(true);
			
			
			//第五步，设置监听事件
			btn1.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					Login_Dao LD = new Login_Dao();
					LD.Search(jt.getText().toString(),jpassword.getText().toString());
					if(LD.a==true) {
						jf.setVisible(false);
						Main_Page MP = new Main_Page();
						MP.Main_Page();
					}else if(LD.a==false) {
						jf.setVisible(true);
					}

				}
			});
			
			btn2.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					jf.setVisible(false);
					RegisterA RA = new RegisterA();
					RA.showUI();
				}
			});
		}
	
	}