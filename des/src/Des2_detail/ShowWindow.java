package Des2_detail;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShowWindow {
	JFrame window;
	JTextField originM;//输入原文
	JTextField outputM;//输出明文
	JTextField outputC;//输出密文
	//mingwen
	public JTextField getOriginM() {
		return originM;
	}
	public void setOriginM(JTextField originM) {
		this.originM = originM;
	}
	//加密后的密文
	public JTextField getOutputC() {
		return outputC;
	}
	public void setOutputC(JTextField outputC) {
		this.outputC = outputC;
	}
	//解密后的明文
	public JTextField getOutputM() {
		return outputM;
	}
	public void setOutputM(JTextField outputM) {
		this.outputM = outputM;
	}
	
	//加密解密按钮
		JButton encDecryption;
		JButton decryption;
		public JButton getEncDecryption() {
			return encDecryption;
		}
		public void setEncDecryption(JButton encDecryption) {
			this.encDecryption = encDecryption;
		}
		public JButton getDecryption() {
			return decryption;
		}
		public void setDecryption(JButton decryption) {
			this.decryption = decryption;
		}
		public void OpertInterface(){
			window=new JFrame("des加解密数据系统");
			window.setLayout(null);
			window.setSize(700, 700);//设置大小
			window.setLocationRelativeTo(null);//设置居中
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置可关闭
			window.setLayout(null);//设置绝对布局（窗口里面的内容不会随着窗口的改变而改变）
			window.setResizable(false);//设置窗口不可拉伸改变大小
			//设置明文标签
			JLabel sourceFile_label =new JLabel("明文:");
			sourceFile_label.setBounds(100,100,100,50);
			window.add(sourceFile_label);
			//设置文件文本框
			originM =new JTextField();
			originM.setBounds(150, 100, 300, 50);
//			fileName.setText(sourceFile);
			window.add(originM);
		
			//设置秘文输出文本框
			outputC = new JTextField();
			outputC.setBounds(150, 300, 300, 50);
			window.add(outputC);
			//设置明文输出文本框
			outputM = new JTextField();
			outputM.setBounds(150, 400, 300, 50);
			window.add(outputM);
			//设置加密按钮
			encDecryption = new JButton("加密");
			encDecryption.setBounds(150, 500, 100, 50);
			window.add(encDecryption);
			//设置解密按钮
			decryption = new JButton("解密");
			decryption.setBounds(350, 500, 100, 50);
			window.add(decryption);
			
			window.setVisible(true);//设置面板可见
		}
}
