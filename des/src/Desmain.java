import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


//快捷键导入包ctrl+shift+m

public class Desmain {
	public static void main(String[] args)  {
		//des加密算法,java密码算法加解密功能都由 javax.crypto 包内的 Cipher类 提供。
		Cipher des = null;
		//定义密钥变量
		byte [] des_key = new byte [8];
		//定义明文变量；
		byte [] des_input = new byte[8];
		//定义加密输chu
		byte [] des_output = null;
		//增加另一个实例测试案例？？？？？
		for(int i=0; i < 8; i++)
		{
			des_key[i] = 0x11;
			des_input[i] = 0x11;
		}

		//创建des密钥
		SecretKey secretKey = new SecretKeySpec(des_key, "DES");
		
		
		//// 创建des 密码算法对象，指定电码本模式和无填充方式????
		///des = Cipher.getInstance("DES/ECB/NoPadding");
		//增加异常捕获
		try {
			//创建Cipher对象时，使用该类的类方法getInstance,电码本模式和无填充方式，因此需要的参数是 "DES/ECB/NoPadding"
			des = Cipher.getInstance("DES/ECB/NoPadding");
		}catch (NoSuchAlgorithmException | NoSuchPaddingException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//初始化des算法
		//des.init(Cipher.ENCRYPT_MODE, secretKey);
		//增加异常捕获
		try {
			des.init(Cipher.ENCRYPT_MODE, secretKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 加密
		//des_output = des.doFinal(des_input);
		//增加加密异常捕获
		try {
			des_output = des.doFinal(des_input);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//输出加密结果       
		System.out.print(des_output);
		System.out.print(byteArryToHex(des_output));
	}
	//将字节数组输出为16进制串
	public static String byteArryToHex(byte [] bs){
		StringBuilder res =new StringBuilder ();
		for(byte b:bs) {
			res.append(String.format("%02x",new Integer(b & 0xff)));
		}
 		return res.toString();
	}
}
