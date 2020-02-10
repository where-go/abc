package org.SuperMarket.swing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
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

import org.SuperMarket.Dao.UP_Page_Dao;


public class UP_Page {
	
	
	void UP_Page(){
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
		jf.setResizable(false);                      //���ܸı��С
		
	
		JSplitPane vS = new JSplitPane(JSplitPane.VERTICAL_SPLIT);  	//����ָ���
		vS.setLeftComponent(new JLabel(" 2"));
		vS.setRightComponent(new JLabel(" 3"));
		vS.setDividerLocation(100);
		vS.setDividerSize(1);
		vS.setOneTouchExpandable(false);
		vS.setContinuousLayout(true);
		vS.setEnabled(false);
		jf.getContentPane().add(vS,BorderLayout.CENTER);
		
		
		//����ָ���1
		JSplitPane hS1 = new JSplitPane();
		hS1.setDividerLocation(150);                     //����ָ���1��λ��
		hS1.setLeftComponent(new JLabel(" 1"));
		hS1.setEnabled(false);
		hS1.setDividerSize(1);
		vS.setRightComponent(hS1);
		
		//����ָ���2
		JSplitPane hS2 = new JSplitPane();
		hS2.setDividerLocation(450);                     //����ָ���2��λ��
		hS2.setRightComponent(new JLabel(" 2"));
		hS2.setLeftComponent(new JLabel(" 5"));
		hS2.setEnabled(false);
		hS2.setDividerSize(1);
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
		
		//����ᴴ��Ҫ����ֱ���Ӱ���Щ��װ����
		
		//��Ʒ�����Լ������
		JLabel JL_goods_type = new JLabel("��Ʒ���� ��");          
		JTextField jt1 = new JTextField(8);            jt1.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_goods_name_tips = new JLabel("(�����������ࡱ / �������ࡱ)");
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3.add(JL_goods_type);                         JL_goods_name_tips.setFont(new Font(null, Font.PLAIN, 12));
		jp3.add(jt1);
		jp3.add(JL_goods_name_tips);
		
		//��Ʒ�����Լ������
		JLabel JL_goods_name = new JLabel("��Ʒ���� ��");          
		JTextField jt2 = new JTextField(8);             jt2.setFont(new Font(null, Font.PLAIN, 18));
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp4.add(JL_goods_name);
		jp4.add(jt2);
		
		//��Ʒ�����Լ������
		JLabel JL_price = new JLabel("��Ʒ���� ��");              
		JTextField jt3 = new JTextField(8);                jt3.setFont(new Font(null, Font.PLAIN, 18));
		JTextField jt4 = new JTextField(8);                jt4.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_price_unit = new JLabel("���۸�λ��");     JL_price_unit.setFont(new Font(null, Font.PLAIN, 12));
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp5.add(JL_price);
		jp5.add(jt3);
		jp5.add(jt4);
		jp5.add(JL_price_unit);
		
		
		//��Ʒ����Լ������
		JLabel JL_stock = new JLabel("��Ʒ��� ��");              
		JTextField jt5 = new JTextField(8);                jt5.setFont(new Font(null, Font.PLAIN, 18));
		JTextField jt6 = new JTextField(8);                jt6.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_SKU = new JLabel("��������λ��");            JL_SKU.setFont(new Font(null, Font.PLAIN, 12));
		JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp6.add(JL_stock);
		jp6.add(jt5);
		jp6.add(jt6);
		jp6.add(JL_SKU);
		
		//��Ʒ���������Լ������
		JLabel JL_production_date = new JLabel("��Ʒ�������� ��");   
		JTextField jt7 = new JTextField(11);               jt7.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_date_Tips = new JLabel("������2019��12��19�գ�");   JL_date_Tips.setFont(new Font(null, Font.PLAIN, 12));
		JPanel jp7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp7.add(JL_production_date);
		jp7.add(jt7);
		jp7.add(JL_date_Tips);
		
		//��Ʒ�������Լ������
		JLabel JL_expiration_date = new JLabel("��Ʒ�������� ��");         
		JTextField jt8 = new JTextField(11);               jt8.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_expiration_date_tips = new JLabel("������7��/1����/12���£�");  JL_expiration_date_tips.setFont(new Font(null, Font.PLAIN, 12));
		JPanel jp8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp8.add(JL_expiration_date);
		jp8.add(jt8);
		jp8.add(JL_expiration_date_tips);
		
		//��Ʒ�������Լ������
		JLabel JL_producer_place = new JLabel("��Ʒ�����ص� ��");        
		JTextField jt9 = new JTextField(11);                        jt9.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_place_tips = new JLabel("�������й�/�㶫/����/***��");
		JPanel jp9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp9.add(JL_producer_place);
		jp9.add(jt9);
		jp9.add(JL_place_tips);
		
		
		//����һ�����ύ����button
		JButton btn1 = new JButton("�ϼ�");
		//����btn1�ĳߴ�
		Dimension dimension = new Dimension(200,40);
		btn1.setPreferredSize(dimension);
		//����btn1�ı�����ɫ
		btn1.setBackground(new Color(199,97,20));
		//����btn1��λ�ã�������ʾ
		JPanel jp10 = new JPanel();
		jp10.add(btn1);
		
		
		// ����һ����ֱ��������, ������ 3 �� JPanel ��������Ϊ���������ӵ�����
        Box vBox = Box.createVerticalBox();
        vBox.add(jp3);   vBox.add(jp4);   vBox.add(jp5);              //��jp2�����е�JPanelװ������
        vBox.add(jp6);   vBox.add(jp7);   vBox.add(jp8);
        vBox.add(jp9);   vBox.add(jp10);
		
		hS2.setLeftComponent(vBox);                        //�滻���������������label
		
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
		
/*--------------------------------���ü����¼�-----------------------------------------*/		
				
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
		
		btn1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				UP_Page_Dao UPD = new UP_Page_Dao();
				UPD.UP_Page_Dao(jt1.getText().toString(), 
								jt2.getText().toString(), 
								jt3.getText().toString(), 
								jt4.getText().toString(), 
								jt5.getText().toString(), 
								jt6.getText().toString(), 
								jt7.getText().toString(), 
								jt8.getText().toString(),
								jt9.getText().toString());
				JOptionPane.showConfirmDialog(null, "�ϼܳɹ�", "��ʾ",JOptionPane.YES_NO_OPTION);
			}
		});
		
		
/*---------------------------------------------------------------------------------*/
		
/*---------------------------------------------------------------------------------*/		
		jf.setVisible(true);
	}
	
	
	
}
