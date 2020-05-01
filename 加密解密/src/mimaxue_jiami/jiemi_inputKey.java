package mimaxue_jiami;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.*;

import mimaxue_jiami.jiemi;
import mimaxue_jiami.Ui;


public class jiemi_inputKey {
	public static String text = null;
	public static void action() { 
		JFrame jf = new JFrame("加密解密");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//设置可以关闭当前窗口
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置可以关闭当前窗口
		//获取屏幕尺寸
		HashMap Size = gitScreenSize(); 
		int height = (int) Size.get("height");
		int width = (int) Size.get("width");
		jf.setBounds((width-500)/2,(height-500)/2,  500, 500);
		
		//添加容器
		Container container = jf.getContentPane();
		container.setLayout(null);	//设置容器布局
		
		 JTextField txtfield=new JTextField();   
		 txtfield.setBounds(140,150,200, 40);
		 
		 JLabel jl = new JLabel("请输入解密密码");
		 JLabel errorLaber = new JLabel("请输入解密密码");
		 errorLaber.setBounds(190, 90, 300, 30);
		 jl.setBounds(190, 190, 300, 30);
		 
		 JButton button = new JButton("提交"), buttonBack = new JButton("返回") , buttonTile = new JButton("解密");
		 
		 button.setBounds(350, 156, 60, 30);
		 buttonBack.setBounds(210, 410, 60, 40);
		 buttonTile.setBounds(0, 0, 482, 40);
		 Font f=new Font("宋体",Font.BOLD,16);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
		 buttonTile.setFont(f);
		 buttonTile.setBackground(Color.gray);
		 buttonTile.setEnabled(false);
		 
		 //button提交
		 button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 text = txtfield.getText();	//获取手动输入的值
				 if(text.equals("")) {
					 jl.setText("密码不能为空！！！");
				 }else {
					 new Ui().setInputText(text);	//设置首页的值
					 txtfield.setText("");		//重置tetfield中的值
					 
					 jf.setVisible(false);		//关闭当前窗体
					 new jiemi().action();
				 }
				 
			}
		});
		 //button返回
		 buttonBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Ui().main(null); 	//跳转至首页
				jf.setVisible(false); 	//关闭当前窗体
			}
		});
		 
		 container.add(txtfield);
		 container.add(jl);
		 container.add(button);
		 container.add(buttonBack);
		 container.add(buttonTile);
		 
		 jf.setVisible(true);
		 
		
	}
//获取屏幕大小
	public static HashMap gitScreenSize() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int width = dim.width;
		int height = dim.height;
		HashMap hm = new HashMap();
		hm.put("width", width);
		hm.put("height", height);
		return hm;
		
	}
}

