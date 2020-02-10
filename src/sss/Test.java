package sss;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test t1 = new Test();
		t1.show();
	}

	
	void show() {
		JFrame jf = new JFrame();
		jf.setTitle("Exercise20_02");
		jf.setSize(400,520);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);              //设置居中显示
		jf.setResizable(false);                      //不能改变大小
		jf.setVisible(true);
		
		//设置横向分割线
		JSplitPane vS = new JSplitPane(JSplitPane.VERTICAL_SPLIT);  	//横向分割线
		vS.setLeftComponent(new JLabel(" 2"));
		vS.setRightComponent(new JLabel(" 3"));
		vS.setDividerLocation(50);
		vS.setDividerSize(2);
		vS.setOneTouchExpandable(false);
		vS.setContinuousLayout(true);
		vS.setEnabled(false);
		jf.getContentPane().add(vS,BorderLayout.CENTER);
		
		//横线分割线左侧放置JPane
		JPanel jp1 = new JPanel(new FlowLayout());
		//设置JLabel和JTextFiled
		JLabel jL = new JLabel("Enter a number:");
		JTextField JT = new JTextField(8);
		jp1.add(jL);
		jp1.add(JT);
		vS.setLeftComponent(jp1);
		
		
		
	  
		
	}
}
