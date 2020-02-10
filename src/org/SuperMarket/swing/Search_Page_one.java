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
		JFrame jf = new JFrame();                         //新建一个面板
		
/*-------------------------Java 6 Update 10后的新的Swing 跨平台界面外观-------------------------*/
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		jf.setTitle("超市信息管理系统");
		jf.setSize(800,600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null); 
		jf.setResizable(false);                      //不能改变大小
		
/*------------------------------------横向分割线--------------------------------------------*/
		JSplitPane vS = new JSplitPane(JSplitPane.VERTICAL_SPLIT);  	//横向分割线
		vS.setLeftComponent(new JLabel(" 2"));
		vS.setRightComponent(new JLabel(" 3"));
		vS.setDividerLocation(100);
		vS.setDividerSize(1);
		vS.setOneTouchExpandable(false);
		vS.setContinuousLayout(true);
		vS.setEnabled(false);
		jf.getContentPane().add(vS,BorderLayout.CENTER);
		
		
/*------------------------------------纵向分割线1-------------------------------------------*/
		JSplitPane hS1 = new JSplitPane();
		hS1.setDividerLocation(150);                     //纵向分割线1的位置
		hS1.setLeftComponent(new JLabel(" 1"));
		hS1.setEnabled(false);
		hS1.setDividerSize(1);
		vS.setRightComponent(hS1);
		
/*------------------------------------纵向分割线2-------------------------------------------*/
		JSplitPane hS2 = new JSplitPane();
		hS2.setDividerLocation(450);                     //纵向分割线2的位置
		hS2.setRightComponent(new JLabel(" 2"));
		hS2.setLeftComponent(new JLabel(" 5"));
		hS2.setEnabled(false);
		hS2.setDividerSize(1);
		hS1.setRightComponent(hS2);
		
/*------------------------------------设置顶端图片-------------------------------------------*/
		ImageIcon ic = new ImageIcon("picture/img/1.jpg");         
		Image img = ic.getImage();
		img = img.getScaledInstance(800, 130,Image.SCALE_DEFAULT);
		ic.setImage(img);
		JLabel jl_top = new JLabel(ic);
		vS.setLeftComponent(jl_top);                      //覆盖上述用来顶格的JLabel
		
/*-----------------------------设置纵向分割线1左边的控件内容-------------------------------------*/
		JPanel jp1 = new JPanel(new FlowLayout());    jp1.setBackground(new java.awt.Color(255,160,122));
		JButton up = new JButton("上架商品");          
		JButton down = new JButton("下架商品");         down.setFocusPainted(true);
		JButton search = new JButton("查询商品");
		JButton update = new JButton("更改商品信息");
		jp1.add(up);         jp1.add(down);
		jp1.add(search);     jp1.add(update);
		hS1.setLeftComponent(jp1);                       //覆盖上述用来顶格的JLabel
		
/*-----------------------------设置中间面板的内容---------------------------------------------*/		
		
		/*---设置一个jp2面板来囊括所有中间面板的控件----*/
		JPanel jp2 = new JPanel();
		
		/*------设置一个JLabel，并设置它的样式-------*/
		JLabel JL_down_name = new JLabel("请输入需查询商品的名称 ：");
		//设置JL_down_name的字体样式
		JL_down_name.setFont(new Font(null, Font.PLAIN, 18));   
		JTextField JT_down_name = new JTextField(10);      JT_down_name.setFont(new Font(null, Font.PLAIN, 18));
		JPanel jp3 = new JPanel();
		jp3.add(JL_down_name);
		jp3.add(JT_down_name);
		
        
		
		/*---设置一个“查询”的button---*/
		JButton btn1 = new JButton("查询");
		//设置btn1的尺寸
		Dimension dimension = new Dimension(200,40);
		btn1.setPreferredSize(dimension);
		//设置btn1的背景颜色
		btn1.setBackground(new Color(199,97,20));
		//设置btn1的位置：居中显示
		JPanel jp4 = new JPanel();
		jp4.add(btn1);
		
		jp2.add(jp3);
		jp2.add(jp4);
		
		hS2.setLeftComponent(jp2);
		
		//设置纵向分割线2右边的控件内容
		JLabel JL_right = new JLabel("纯原创：");
		JLabel JL_right2 = new JLabel("17计本7,2019.12.22");
		JL_right.setFont(new Font(null, Font.PLAIN, 18));
		JL_right2.setFont(new Font(null, Font.PLAIN, 18));
		JPanel JP_rigth = new JPanel(new FlowLayout());
		JP_rigth.setBackground(new java.awt.Color(255,160,122));
		JP_rigth.add(JL_right);
		JP_rigth.add(JL_right2);
		hS2.setRightComponent(JP_rigth);
/*--------------------------------------------------------------------------------*/
		
/*------------------------------设置按钮监听事件--------------------------------------*/
		up.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);
				UP_Page UP  = new UP_Page();
				UP.UP_Page();                             //跳到UP_Page
			}
		});
		
		down.addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);
				Down_Page_one DPO = new Down_Page_one();
				DPO.Down_Page_one();                       //跳到Down_Page_one
			}
		});
			
		update.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jf.setVisible(false);
				Change_Page_one CPO = new Change_Page_one();
				CPO.Change_Page_one();                   //跳到Change_Page_one
			}
		});
		
		btn1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Search_Page_one_Dao SPoD = new Search_Page_one_Dao();
				SPoD.Search_Page_one_Dao(JT_down_name.getText().toString());
				if(SPoD.l=="1") {                             //判断是否找到了这条数据，找到则跳转到Search_Page_second
			
					jf.setVisible(false);
					Search_Page_second SPe = new Search_Page_second();
					SPe.Search_Page_second();
					
					//把	Search_Page_one_Dao中查询到的数据放到second页面中
					SPe.jt1.setText(SPoD.a);  SPe.jt2.setText(SPoD.b);
					SPe.jt3.setText(SPoD.c);  SPe.jt4.setText(SPoD.d);
					SPe.jt5.setText(SPoD.f);  SPe.jt6.setText(SPoD.g);
					SPe.jt7.setText(SPoD.h);  SPe.jt8.setText(SPoD.i);
					SPe.jt9.setText(SPoD.j);
					
				}
				else if(SPoD.l=="0") {
					JOptionPane.showConfirmDialog(null, "不存在此商品，请重新输入", "提示",JOptionPane.YES_NO_OPTION);
				}
			}
		});
/*---------------------------------------------------------------------------------*/
		
		jf.setVisible(true);
		

		
	}

}
