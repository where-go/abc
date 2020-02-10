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
		
        /*----------�˴��ǳ���������-------------*/
	    public static void main(String[] args) {
	        // ʵ��������
	        LoginA LA = new LoginA();
	        LA.showUI();
	    }

		void showUI() {
			// TODO �Զ����ɵķ������
			JFrame jf = new JFrame(); 
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			jf.setTitle("������Ϣ����ϵͳ");
			jf.setSize(520,520);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			FlowLayout fl = new FlowLayout();            //������ˮ����
			jf.setLayout(fl);
			jf.setLocationRelativeTo(null);              //���þ�����ʾ
			jf.setResizable(false);                      //���ܸı��С
			
			ImageIcon imagicon = new ImageIcon("picture/img/1.jpg");
			
			Image img = imagicon.getImage();
			img = img.getScaledInstance(520, 250,Image.SCALE_DEFAULT);
			imagicon.setImage(img);
			
			JLabel jlb = new JLabel(imagicon);      //ͼƬ��ǩ
			
			
			// �˺������ǩ
			JLabel name = new JLabel("�˺� : ");
			JLabel password = new JLabel("���� : ");
			JLabel find = new JLabel("�һ�����");
			
			//���ü���Panel
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			
			//�ߴ�
			Dimension mansion = new Dimension(330,30);
			Dimension dimension = new Dimension(200,40);
			// �����,�����˺���
			JTextField jt = new JTextField();
			// ���������������
			JPasswordField jpassword = new JPasswordField();
			//��ť����¼�� �͡�ע�ᡱ
			JButton btn1 = new JButton("��¼");
			JButton btn2 = new JButton("ע��");
			
			//���������������
			jt.setPreferredSize(mansion);  //����˺������
			jpassword.setPreferredSize(mansion); //������������
			
			btn1.setBackground(new Color(0,255,255));
			btn1.setPreferredSize(dimension);  //�����¼��ť
			
			btn2.setBackground(new Color(199,97,20));
			btn2.setPreferredSize(dimension);  //���ע�ᰴť
			
			//���Ĳ���������������������
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
			
			
			//���岽�����ü����¼�
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