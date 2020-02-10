package org.SuperMarket.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main_Page {

	
	void Main_Page() {
			JFrame jf = new JFrame();                         //�½�һ�����
					
			//Java 6 Update 10����µ�Swing ��ƽ̨�������
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
			jf.setResizable(false);  
			
		
			JSplitPane vS = new JSplitPane(JSplitPane.VERTICAL_SPLIT);  	//����ָ���
			vS.setLeftComponent(new JLabel(" 2"));
			vS.setRightComponent(new JLabel(" 3"));
			vS.setDividerLocation(100);
			vS.setDividerSize(2);
			vS.setOneTouchExpandable(false);
			vS.setContinuousLayout(true);
			vS.setEnabled(false);
			jf.getContentPane().add(vS,BorderLayout.CENTER);
			
			
			//����ָ���1
			JSplitPane hS1 = new JSplitPane();
			hS1.setDividerLocation(150);                     //����ָ���1��λ��
			hS1.setLeftComponent(new JLabel(" 1"));
			hS1.setEnabled(false);
			hS1.setDividerSize(2);
			vS.setRightComponent(hS1);
			
			//����ָ���2
			JSplitPane hS2 = new JSplitPane();
			hS2.setDividerLocation(450);                     //����ָ���2��λ��
			hS2.setRightComponent(new JLabel(" 2"));
			hS2.setLeftComponent(new JLabel(" 5"));
			hS2.setEnabled(false);
			hS2.setDividerSize(2);
			hS1.setRightComponent(hS2);
			
			//���ö���ͼƬ
			ImageIcon ic = new ImageIcon("picture/img/1.jpg");         
			Image img = ic.getImage();
			img = img.getScaledInstance(800, 130,Image.SCALE_DEFAULT);
			ic.setImage(img);
			JLabel jl_top = new JLabel(ic);
			vS.setLeftComponent(jl_top);                      //�����������������JLabel
			
			//��������ָ���1��ߵĿؼ�����
			JPanel jp1 = new JPanel(new FlowLayout());    jp1.setBackground(new java.awt.Color(255,160,122));
			JButton up = new JButton("�ϼ���Ʒ");          
			JButton down = new JButton("�¼���Ʒ");
			JButton search = new JButton("��ѯ��Ʒ");
			JButton update = new JButton("������Ʒ��Ϣ");
			jp1.add(up);         jp1.add(down);
			jp1.add(search);     jp1.add(update);
			hS1.setLeftComponent(jp1);                       //�����������������JLabel
			
			//��������ָ���2��ߵĿؼ�����
			JLabel JL_center = new JLabel("��ӭ����������Ϣ����ϵͳ");
			JLabel JL_center2 = new JLabel("�������˵������й��ܵ�ѡ��");
			JL_center.setFont(new Font(null, Font.PLAIN, 20));
			JL_center2.setFont(new Font(null, Font.PLAIN, 20));
			JPanel jp_center = new JPanel();
			jp_center.add(JL_center);
			jp_center.add(JL_center2);
			hS2.setLeftComponent(jp_center);                  //�����������������JLabel
			
			
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
			
			
/*----------------------���ð�ť�����¼�---------------------*/
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
					Down_Page_one DP = new Down_Page_one();
					DP.Down_Page_one();                       //����Down_Page_one
				}
			});
			
			search.addMouseListener(new MouseAdapter() {	
				public void mouseClicked(MouseEvent e) {
					jf.setVisible(false);
					Search_Page_one SP = new Search_Page_one();
					SP.Search_Page_one();                    //����Search_Page_one
				}
			});
			
			update.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					jf.setVisible(false);
					Change_Page_one CP = new Change_Page_one();
					CP.Change_Page_one();                   //����Change_Page_one
				}
			});
/*---------------------------------------------------------------------------------*/
			
			jf.setVisible(true);
	}
}
