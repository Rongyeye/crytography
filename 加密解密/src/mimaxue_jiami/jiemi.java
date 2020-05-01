package mimaxue_jiami;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mimaxue_jiami.jiemi_inputKey;

import mimaxue_jiami.jiemi;

import mimaxue_jiami.Ui;


public class jiemi implements ActionListener{
	JButton bChoice = new JButton("选择本地文件解密"), buttonTile = new JButton("解密"),buttonBack = new JButton("返回"),
			summit1 = new JButton("解密"),summit2 = new JButton("解密"),clear1 = new JButton("清空"),clear2 = new JButton("清空");
	JTextField txtfield=new JTextField();  	//数据输入框
	JTextField textAdress=new JTextField();  //地址显示框
	JLabel jl = new JLabel("输入数据进行解密:");
	String text = "密码是....";
	JTextField keyLabel = new JTextField(text);
	JFileChooser jfc=new JFileChooser();//文件选择器

	public void action() {
		JFrame jf = new JFrame("Shawve的解密工具");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//设置可以关闭当前窗口
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置可以关闭当前窗口
		//获取屏幕尺寸
		HashMap Size = gitScreenSize(); 
		int height = (int) Size.get("height");
		int width = (int) Size.get("width");
		jf.setBounds((width-500)/2,(height-500)/2,  500, 500);
		//设置容器
		Container container = jf.getContentPane();
		container.setLayout(null);
		//设置Label标签大小和位置
		jl.setBounds(120, 120, 200, 40);
		//设置输入框大小位置
		txtfield.setBounds(80,170,200, 40);
		//设置按钮大小位置
		buttonTile.setBackground(Color.gray);
		Font f=new Font("宋体",Font.BOLD,16);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
		buttonTile.setFont(f);
		buttonTile.setEnabled(false);
		
		buttonBack.setBounds(210, 410, 60, 40);
		summit1.setBounds(290, 170, 60, 40);
		bChoice.addActionListener(this);//添加事件处理
		clear1.setBounds(360, 170, 60, 40);
		summit2.setBounds(290, 220, 60, 40);
		clear2.setBounds(360, 220, 60, 40);
		bChoice.setBounds(80, 220, 200, 40);
		textAdress.setBounds(80, 265, 200, 20);
		keyLabel.setBounds(150, 310, 200, 40);
		keyLabel.setEditable(false);
		textAdress.setEditable(false);
		buttonTile.setBounds(0, 0, 482, 40);
		
		//clear1清空
		clear1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtfield.setText("");	//显示置空
				new Ui().setInputvalue("");	//置空存有的值
			}
		});
		
		//clear2清空
		clear2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						textAdress.setText("");	//显示置空
						new Ui().setFileRoute("");	//置空index存有的值
					}
				});
		
		//summit1解密
		summit1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = txtfield.getText();	//获得输入框的值
				String key = new Ui().getInputText();	//密码
				if(path == null) {
					System.out.println("输入的数据不能为空");
				}
				path = Encryption(path,key);
				System.out.println("path:"+path);
				keyLabel.setText(path);
			}

		
		});
		//summit2解密
		summit2.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = new Ui().getFileRoute();	//文件路径
				String key = new Ui().getInputText();	//密码
				if(path == null) {
					System.out.println("输入的数据不能为空");
				}
					EncryptionFile(path,key);
		
			}
		});
		
		 //button返回上一页
		 buttonBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new jiemi_inputKey().action(); 	//跳转至首页
				jf.setVisible(false); 	//关闭当前窗体
			}
		});
		
		container.add(buttonBack);
		container.add(buttonTile);
		container.add(bChoice);
		container.add(txtfield);
		container.add(summit1);
		container.add(summit2); 
		container.add(clear1);
		container.add(clear2);
		container.add(jl);
		container.add(textAdress);
		container.add(keyLabel);
		jf.setVisible(true);
	}
	
	

	private void EncryptionFile(String path, String key) {
		byte[] Key = path.getBytes();
		int KeyChange = byteArrayToInt(Key);	//获取变化（byte[]到int）后的密码
		File file = new File(path);		//需要解密的文件
		InputStream is;
		try {
			is = new FileInputStream(file);//创建输入流对象
			//解密后输出路径
			String NewFilePath = change(path);	//处理路径
			File file2 = new File(NewFilePath);
			
			OutputStream os = new FileOutputStream(file2);
			byte[] car = new byte[8*1024];	//设置小车车
			while(is.read(car) != -1) {
				//解密
				for(int i = 0;i < car.length;i++) {
					car[i] = (byte) (car[i] ^ KeyChange);
				}
				os.write(car, 0, car.length);
				os.flush();//把数据刷一下
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			keyLabel.setText("解密成功！！！！！");
		}
		
		}




	private String Encryption(String value, String key) {
		char[] Value = value.toCharArray();
		byte[] Key = key.getBytes();
		int KeyChange = byteArrayToInt(Key);	//获取变化（byte[]到int）后的密码
		//抑或解密
		for(int i = 0;i<Value.length;i++) {
			Value[i] =  (char) (Value[i]^KeyChange);
		}
		return new String(Value);
	}

public static HashMap gitScreenSize() {
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int width = dim.width;
	int height = dim.height;
	HashMap hm = new HashMap();
	hm.put("width", width);
	hm.put("height", height);
	return hm;
	
}

/**
 * 	监听
 * 	作者： shawve
 *	时间：下午11:22:25
 */
public void actionPerformed(ActionEvent e){//事件处理
    if(e.getSource().equals(bChoice)){//判断触发方法的按钮是哪个
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int state=jfc.showOpenDialog(null);//此句是打开文件选择器界面的触发语句
        if(state==1){
            return;//撤销则返回
        }
        else{
            File f=jfc.getSelectedFile();//f为选择到的目录
            textAdress.setText(f.getAbsolutePath());
            new Ui().setFileRoute(f.getAbsolutePath()); //保存路径到index中
        }
    }
}

private String change(String path) {
	String[] newPath = path.split("\\(解密\\)");
//	newPath[newPath.length-1] = "(解密)"+newPath[newPath.length-1] ;
	StringBuffer temp= new StringBuffer();
	for (String string : newPath) {
		temp.append(string);
     }
	path = temp.toString();
	return path;
}

public static int byteArrayToInt(byte[] bytes) {
    int value=0;
    for(int i = 0; i < 4; i++) {
        int shift= (3-i) * 8;
        value +=(bytes[i] & 0xFF) << shift;
    }
    return value;

}

}



