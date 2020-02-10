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
		jf.setResizable(false);                      //不能改变大小
		
	
		JSplitPane vS = new JSplitPane(JSplitPane.VERTICAL_SPLIT);  	//横向分割线
		vS.setLeftComponent(new JLabel(" 2"));
		vS.setRightComponent(new JLabel(" 3"));
		vS.setDividerLocation(100);
		vS.setDividerSize(1);
		vS.setOneTouchExpandable(false);
		vS.setContinuousLayout(true);
		vS.setEnabled(false);
		jf.getContentPane().add(vS,BorderLayout.CENTER);
		
		
		//纵向分割线1
		JSplitPane hS1 = new JSplitPane();
		hS1.setDividerLocation(150);                     //纵向分割线1的位置
		hS1.setLeftComponent(new JLabel(" 1"));
		hS1.setEnabled(false);
		hS1.setDividerSize(1);
		vS.setRightComponent(hS1);
		
		//纵向分割线2
		JSplitPane hS2 = new JSplitPane();
		hS2.setDividerLocation(450);                     //纵向分割线2的位置
		hS2.setRightComponent(new JLabel(" 2"));
		hS2.setLeftComponent(new JLabel(" 5"));
		hS2.setEnabled(false);
		hS2.setDividerSize(1);
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
		
		//下面会创建要给垂直盒子把这些都装起来
		
		//商品种类以及输入框
		JLabel JL_goods_type = new JLabel("商品种类 ：");          
		JTextField jt1 = new JTextField(8);            jt1.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_goods_name_tips = new JLabel("(例：“果蔬类” / “海鲜类”)");
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp3.add(JL_goods_type);                         JL_goods_name_tips.setFont(new Font(null, Font.PLAIN, 12));
		jp3.add(jt1);
		jp3.add(JL_goods_name_tips);
		
		//商品名称以及输入框
		JLabel JL_goods_name = new JLabel("商品名称 ：");          
		JTextField jt2 = new JTextField(8);             jt2.setFont(new Font(null, Font.PLAIN, 18));
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp4.add(JL_goods_name);
		jp4.add(jt2);
		
		//商品单价以及输入框
		JLabel JL_price = new JLabel("商品单价 ：");              
		JTextField jt3 = new JTextField(8);                jt3.setFont(new Font(null, Font.PLAIN, 18));
		JTextField jt4 = new JTextField(8);                jt4.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_price_unit = new JLabel("（价格单位）");     JL_price_unit.setFont(new Font(null, Font.PLAIN, 12));
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp5.add(JL_price);
		jp5.add(jt3);
		jp5.add(jt4);
		jp5.add(JL_price_unit);
		
		
		//商品库存以及输入框
		JLabel JL_stock = new JLabel("商品库存 ：");              
		JTextField jt5 = new JTextField(8);                jt5.setFont(new Font(null, Font.PLAIN, 18));
		JTextField jt6 = new JTextField(8);                jt6.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_SKU = new JLabel("（数量单位）");            JL_SKU.setFont(new Font(null, Font.PLAIN, 12));
		JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp6.add(JL_stock);
		jp6.add(jt5);
		jp6.add(jt6);
		jp6.add(JL_SKU);
		
		//商品生产日期以及输入框
		JLabel JL_production_date = new JLabel("商品生产日期 ：");   
		JTextField jt7 = new JTextField(11);               jt7.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_date_Tips = new JLabel("（例：2019年12月19日）");   JL_date_Tips.setFont(new Font(null, Font.PLAIN, 12));
		JPanel jp7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp7.add(JL_production_date);
		jp7.add(jt7);
		jp7.add(JL_date_Tips);
		
		//商品保质期以及输入框
		JLabel JL_expiration_date = new JLabel("商品保质期限 ：");         
		JTextField jt8 = new JTextField(11);               jt8.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_expiration_date_tips = new JLabel("（例：7天/1个月/12个月）");  JL_expiration_date_tips.setFont(new Font(null, Font.PLAIN, 12));
		JPanel jp8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp8.add(JL_expiration_date);
		jp8.add(jt8);
		jp8.add(JL_expiration_date_tips);
		
		//商品生产地以及输入框
		JLabel JL_producer_place = new JLabel("商品生产地点 ：");        
		JTextField jt9 = new JTextField(11);                        jt9.setFont(new Font(null, Font.PLAIN, 18));
		JLabel JL_place_tips = new JLabel("（例：中国/广东/深圳/***）");
		JPanel jp9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp9.add(JL_producer_place);
		jp9.add(jt9);
		jp9.add(JL_place_tips);
		
		
		//设置一个“提交”的button
		JButton btn1 = new JButton("上架");
		//设置btn1的尺寸
		Dimension dimension = new Dimension(200,40);
		btn1.setPreferredSize(dimension);
		//设置btn1的背景颜色
		btn1.setBackground(new Color(199,97,20));
		//设置btn1的位置：居中显示
		JPanel jp10 = new JPanel();
		jp10.add(btn1);
		
		
		// 创建一个垂直盒子容器, 把上面 3 个 JPanel 串起来作为内容面板添加到窗口
        Box vBox = Box.createVerticalBox();
        vBox.add(jp3);   vBox.add(jp4);   vBox.add(jp5);              //用jp2把所有的JPanel装载起来
        vBox.add(jp6);   vBox.add(jp7);   vBox.add(jp8);
        vBox.add(jp9);   vBox.add(jp10);
		
		hS2.setLeftComponent(vBox);                        //替换掉上面用来顶格的label
		
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
		
/*--------------------------------设置监听事件-----------------------------------------*/		
				
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
				JOptionPane.showConfirmDialog(null, "上架成功", "提示",JOptionPane.YES_NO_OPTION);
			}
		});
		
		
/*---------------------------------------------------------------------------------*/
		
/*---------------------------------------------------------------------------------*/		
		jf.setVisible(true);
	}
	
	
	
}
