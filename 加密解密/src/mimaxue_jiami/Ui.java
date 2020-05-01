package mimaxue_jiami;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
import org.w3c.dom.css.RGBColor;

import mimaxue_jiami.Ui;//
import mimaxue_jiami.jiemi_inputKey;
import mimaxue_jiami.jiami_inputKey;


/**
* @ClassName: Ui
* @Description: TODO
* @author rong
* @date 2019年10月6日
*
*/
public class Ui {
	private static String inputText;//输入框输入值（密码）
	private static String inputvalue;//输入框输入值（数据）
	private static String fileRoute;//文件选择器路径	
	
	public static String getFileRoute() {
		return fileRoute;
	}
	public static void setFileRoute(String fileRoute) {
		Ui.fileRoute = fileRoute;
	}
	public static String getInputvalue() {
		return inputvalue;
	}
	public static void setInputvalue(String inputvalue) {
		Ui.inputvalue = inputvalue;
	}

	public static String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame("加密解密");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置可以关闭当前窗口
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//设置可以关闭当前窗口
		
		//获取屏幕尺寸
		HashMap Size = getScreenSize(); 
		int height = (int) Size.get("height");
		int width = (int) Size.get("width");
		jf.setBounds((width-500)/2,(height-500)/2,  500, 500);
		jf.setVisible(true);
		//添加容器
		Container container = jf.getContentPane();
		container.setLayout(null);
	
		//加密
		JButton buttonE = new JButton("加密");
		buttonE.setBounds(140,100,200, 80);
		buttonE.setBackground(Color.red);	//设置按钮颜色为红色
		buttonE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new jiami_inputKey().action();	//“跳转”至加密
				jf.setVisible(false);
			}
			
		});
		//解密
		JButton buttonD = new JButton("解密");	
		buttonD.setBounds(140,250,200, 80);
		buttonD.setBackground(Color.green);	//设置按钮颜色为绿色
		buttonD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				new jiemi_inputKey().action();	//“跳转”至解密
				jf.setVisible(false);	//关闭当前窗口
			}
		});
		container.add(buttonE);
		container.add(buttonD);
	}
	public static HashMap getScreenSize() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int width = dim.width;
		int height = dim.height;
		HashMap hm = new HashMap();
		hm.put("width", width);
		hm.put("height", height);
		return hm;
		
	}
	
}
