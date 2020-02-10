package org.SuperMarket.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.SuperMarket.Dao.*;
import org.SuperMarket.swing.*;
public class RegisterA {

	LoginA LA = new LoginA();
	
	void showUI() {
		// TODO �Զ����ɵķ������
		JFrame jf = new JFrame();
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
		JLabel back = new JLabel("����");
		
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
		//��ע�ᡱ �͡����ؼ���
		JButton btn1 = new JButton("ע��");
		JButton btn2 = new JButton("����");
		
		//���������������
		jt.setPreferredSize(mansion);  //����˺������
		jpassword.setPreferredSize(mansion); //������������
		
		
		btn1.setBackground(new Color(199,97,20));
		btn1.setPreferredSize(dimension);  //���ע�ᰴť
		
		btn2.setBackground(new Color(199,97,20));
		btn2.setPreferredSize(dimension);  //������ذ�ť
		
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
		
		/*---------��ע�ᡱ�¼�-----------*/
		btn1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Register_Dao RD = new Register_Dao();
				RD.Search(jt.getText().toString(), jpassword.getText().toString());
				
				if(RD.a==false) {
					jf.setVisible(true);
				}else if(RD.a==true) {
					jf.setVisible(false);
					LA.showUI();
				}
				
			}
		});
		
		/*---------�����ء��¼�-----------*/
		btn2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);
				LA.showUI();
			}
		});
		
	}


}
