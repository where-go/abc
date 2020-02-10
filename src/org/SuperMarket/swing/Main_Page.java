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
			JFrame jf = new JFrame();                         //新建一个面板
					
			//Java 6 Update 10后的新的Swing 跨平台界面外观
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
			jf.setResizable(false);  
			
		
			JSplitPane vS = new JSplitPane(JSplitPane.VERTICAL_SPLIT);  	//横向分割线
			vS.setLeftComponent(new JLabel(" 2"));
			vS.setRightComponent(new JLabel(" 3"));
			vS.setDividerLocation(100);
			vS.setDividerSize(2);
			vS.setOneTouchExpandable(false);
			vS.setContinuousLayout(true);
			vS.setEnabled(false);
			jf.getContentPane().add(vS,BorderLayout.CENTER);
			
			
			//纵向分割线1
			JSplitPane hS1 = new JSplitPane();
			hS1.setDividerLocation(150);                     //纵向分割线1的位置
			hS1.setLeftComponent(new JLabel(" 1"));
			hS1.setEnabled(false);
			hS1.setDividerSize(2);
			vS.setRightComponent(hS1);
			
			//纵向分割线2
			JSplitPane hS2 = new JSplitPane();
			hS2.setDividerLocation(450);                     //纵向分割线2的位置
			hS2.setRightComponent(new JLabel(" 2"));
			hS2.setLeftComponent(new JLabel(" 5"));
			hS2.setEnabled(false);
			hS2.setDividerSize(2);
			hS1.setRightComponent(hS2);
			
			//设置顶端图片
			ImageIcon ic = new ImageIcon("picture/img/1.jpg");         
			Image img = ic.getImage();
			img = img.getScaledInstance(800, 130,Image.SCALE_DEFAULT);
			ic.setImage(img);
			JLabel jl_top = new JLabel(ic);
			vS.setLeftComponent(jl_top);                      //覆盖上述用来顶格的JLabel
			
			//设置纵向分割线1左边的控件内容
			JPanel jp1 = new JPanel(new FlowLayout());    jp1.setBackground(new java.awt.Color(255,160,122));
			JButton up = new JButton("上架商品");          
			JButton down = new JButton("下架商品");
			JButton search = new JButton("查询商品");
			JButton update = new JButton("更改商品信息");
			jp1.add(up);         jp1.add(down);
			jp1.add(search);     jp1.add(update);
			hS1.setLeftComponent(jp1);                       //覆盖上述用来顶格的JLabel
			
			//设置纵向分割线2左边的控件内容
			JLabel JL_center = new JLabel("欢迎来到超市信息管理系统");
			JLabel JL_center2 = new JLabel("请点击左侧菜单栏进行功能的选择");
			JL_center.setFont(new Font(null, Font.PLAIN, 20));
			JL_center2.setFont(new Font(null, Font.PLAIN, 20));
			JPanel jp_center = new JPanel();
			jp_center.add(JL_center);
			jp_center.add(JL_center2);
			hS2.setLeftComponent(jp_center);                  //覆盖上述用来定格的JLabel
			
			
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
			
			
/*----------------------设置按钮监听事件---------------------*/
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
					Down_Page_one DP = new Down_Page_one();
					DP.Down_Page_one();                       //跳到Down_Page_one
				}
			});
			
			search.addMouseListener(new MouseAdapter() {	
				public void mouseClicked(MouseEvent e) {
					jf.setVisible(false);
					Search_Page_one SP = new Search_Page_one();
					SP.Search_Page_one();                    //跳到Search_Page_one
				}
			});
			
			update.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					jf.setVisible(false);
					Change_Page_one CP = new Change_Page_one();
					CP.Change_Page_one();                   //跳到Change_Page_one
				}
			});
/*---------------------------------------------------------------------------------*/
			
			jf.setVisible(true);
	}
}
