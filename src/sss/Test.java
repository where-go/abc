package sss;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class Test {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test t1 = new Test();
		t1.show();
	}

	
	void show() {
		JFrame jf = new JFrame();
		jf.setTitle("Exercise20_02");
		jf.setSize(400,520);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);              //���þ�����ʾ
		jf.setResizable(false);                      //���ܸı��С
		jf.setVisible(true);
		
		//���ú���ָ���
		JSplitPane vS = new JSplitPane(JSplitPane.VERTICAL_SPLIT);  	//����ָ���
		vS.setLeftComponent(new JLabel(" 2"));
		vS.setRightComponent(new JLabel(" 3"));
		vS.setDividerLocation(50);
		vS.setDividerSize(2);
		vS.setOneTouchExpandable(false);
		vS.setContinuousLayout(true);
		vS.setEnabled(false);
		jf.getContentPane().add(vS,BorderLayout.CENTER);
		
		//���߷ָ���������JPane
		JPanel jp1 = new JPanel(new FlowLayout());
		//����JLabel��JTextFiled
		JLabel jL = new JLabel("Enter a number:");
		JTextField JT = new JTextField(8);
		jp1.add(jL);
		jp1.add(JT);
		vS.setLeftComponent(jp1);
		
		
		
	  
		
	}
}
