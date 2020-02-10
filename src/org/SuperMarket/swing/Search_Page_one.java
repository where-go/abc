package org.SuperMarket.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.SuperMarket.Dao.Search_Page_one_Dao;

public class Search_Page_one {
	
	
	void Search_Page_one() {
		JFrame jf = new JFrame();                         //�½�һ�����
		
/*-------------------------Java 6 Update 10����µ�Swing ��ƽ̨�������-------------------------*/
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		jf.setTitle("������Ϣ����ϵͳ");
		jf.setSize(800,600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null); 
		jf.setResizable(false);                      //���ܸı��С
		
/*------------------------------------����ָ���--------------------------------------------*/
		JSplitPane vS = new JSplitPane(JSplitPane.VERTICAL_SPLIT);  	//����ָ���
		vS.setLeftComponent(new JLabel(" 2"));
		vS.setRightComponent(new JLabel(" 3"));
		vS.setDividerLocation(100);
		vS.setDividerSize(1);
		vS.setOneTouchExpandable(false);
		vS.setContinuousLayout(true);
		vS.setEnabled(false);
		jf.getContentPane().add(vS,BorderLayout.CENTER);
		
		
/*------------------------------------����ָ���1-------------------------------------------*/
		JSplitPane hS1 = new JSplitPane();
		hS1.setDividerLocation(150);                     //����ָ���1��λ��
		hS1.setLeftComponent(new JLabel(" 1"));
		hS1.setEnabled(false);
		hS1.setDividerSize(1);
		vS.setRightComponent(hS1);
		
/*------------------------------------����ָ���2-------------------------------------------*/
		JSplitPane hS2 = new JSplitPane();
		hS2.setDividerLocation(450);                     //����ָ���2��λ��
		hS2.setRightComponent(new JLabel(" 2"));
		hS2.setLeftComponent(new JLabel(" 5"));
		hS2.setEnabled(false);
		hS2.setDividerSize(1);
		hS1.setRightComponent(hS2);
		
/*------------------------------------���ö���ͼƬ-------------------------------------------*/
		ImageIcon ic = new ImageIcon("picture/img/1.jpg");         
		Image img = ic.getImage();
		img = img.getScaledInstance(800, 130,Image.SCALE_DEFAULT);
		ic.setImage(img);
		JLabel jl_top = new JLabel(ic);
		vS.setLeftComponent(jl_top);                      //�����������������JLabel
		
/*-----------------------------��������ָ���1��ߵĿؼ�����-------------------------------------*/
		JPanel jp1 = new JPanel(new FlowLayout());    jp1.setBackground(new java.awt.Color(255,160,122));
		JButton up = new JButton("�ϼ���Ʒ");          
		JButton down = new JButton("�¼���Ʒ");         down.setFocusPainted(true);
		JButton search = new JButton("��ѯ��Ʒ");
		JButton update = new JButton("������Ʒ��Ϣ");
		jp1.add(up);         jp1.add(down);
		jp1.add(search);     jp1.add(update);
		hS1.setLeftComponent(jp1);                       //�����������������JLabel
		
/*-----------------------------�����м���������---------------------------------------------*/		
		
		/*---����һ��jp2��������������м����Ŀؼ�----*/
		JPanel jp2 = new JPanel();
		
		/*------����һ��JLabel��������������ʽ-------*/
		JLabel JL_down_name = new JLabel("���������ѯ��Ʒ������ ��");
		//����JL_down_name��������ʽ
		JL_down_name.setFont(new Font(null, Font.PLAIN, 18));   
		JTextField JT_down_name = new JTextField(10);      JT_down_name.setFont(new Font(null, Font.PLAIN, 18));
		JPanel jp3 = new JPanel();
		jp3.add(JL_down_name);
		jp3.add(JT_down_name);
		
        
		
		/*---����һ������ѯ����button---*/
		JButton btn1 = new JButton("��ѯ");
		//����btn1�ĳߴ�
		Dimension dimension = new Dimension(200,40);
		btn1.setPreferredSize(dimension);
		//����btn1�ı�����ɫ
		btn1.setBackground(new Color(199,97,20));
		//����btn1��λ�ã�������ʾ
		JPanel jp4 = new JPanel();
		jp4.add(btn1);
		
		jp2.add(jp3);
		jp2.add(jp4);
		
		hS2.setLeftComponent(jp2);
		
		//��������ָ���2�ұߵĿؼ�����
		JLabel JL_right = new JLabel("��ԭ����");
		JLabel JL_right2 = new JLabel("17�Ʊ�7,2019.12.22");
		JL_right.setFont(new Font(null, Font.PLAIN, 18));
		JL_right2.setFont(new Font(null, Font.PLAIN, 18));
		JPanel JP_rigth = new JPanel(new FlowLayout());
		JP_rigth.setBackground(new java.awt.Color(255,160,122));
		JP_rigth.add(JL_right);
		JP_rigth.add(JL_right2);
		hS2.setRightComponent(JP_rigth);
/*--------------------------------------------------------------------------------*/
		
/*------------------------------���ð�ť�����¼�--------------------------------------*/
		up.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);
				UP_Page UP  = new UP_Page();
				UP.UP_Page();                             //����UP_Page
			}
		});
		
		down.addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);
				Down_Page_one DPO = new Down_Page_one();
				DPO.Down_Page_one();                       //����Down_Page_one
			}
		});
			
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);
				Change_Page_one CPO = new Change_Page_one();
				CPO.Change_Page_one();                   //����Change_Page_one
			}
		});
		
		btn1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Search_Page_one_Dao SPoD = new Search_Page_one_Dao();
				SPoD.Search_Page_one_Dao(JT_down_name.getText().toString());
				if(SPoD.l=="1") {                             //�ж��Ƿ��ҵ����������ݣ��ҵ�����ת��Search_Page_second
			
					jf.setVisible(false);
					Search_Page_second SPe = new Search_Page_second();
					SPe.Search_Page_second();
					
					//��	Search_Page_one_Dao�в�ѯ�������ݷŵ�secondҳ����
					SPe.jt1.setText(SPoD.a);  SPe.jt2.setText(SPoD.b);
					SPe.jt3.setText(SPoD.c);  SPe.jt4.setText(SPoD.d);
					SPe.jt5.setText(SPoD.f);  SPe.jt6.setText(SPoD.g);
					SPe.jt7.setText(SPoD.h);  SPe.jt8.setText(SPoD.i);
					SPe.jt9.setText(SPoD.j);
					
				}
				else if(SPoD.l=="0") {
					JOptionPane.showConfirmDialog(null, "�����ڴ���Ʒ������������", "��ʾ",JOptionPane.YES_NO_OPTION);
				}
			}
		});
/*---------------------------------------------------------------------------------*/
		
		jf.setVisible(true);
		

		
	}

}
