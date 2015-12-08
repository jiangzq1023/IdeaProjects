package com.handpay.obm.pg.simulator.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;


/**
 * 
 * 
 * @author zqjiang
 * @version 1.0 2015年9月8日
 */
public class Encrypt {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

        //待加密内容
        String str = "2323";
        //密码，长度要是8的倍数
        String password = "55ff608151fc081ad08a8757";
        
        
        System.out.println("MD5加密后内容为："+DigestUtils.md5Hex("wlt20150921135!!"));

        
        //DES加密
        byte[] result = Encrypt.desCrypto(str.getBytes(),password);
        System.out.println("DES加密后内容为："+new String(result));

		//Base64加密
		byte[] b = Base64.encodeBase64(result, true);
		System.out.println("Base64加密后内容为："+new String(b));

		//内部测试100元
		//2320440004369218
		//32392525609377978998
		//20161231
		
		//内部测试100元
		//2320440004369226
		//32971814865575968083
		//20161231
		
		//内部测试100元
		//2330440014573310
		//33433646480779468829
		//20190228
		
		//Base64解密
		byte[] bb = Base64.decodeBase64("kMXK6GWP3/1A99/fSs8nikS5NqDQm6A6\r\n".getBytes());
		System.out.println("Base64解密后内容为："+new String(bb));

		//DES解密
		try {
			byte[] decryResult = Encrypt.decrypt(bb, password);
			System.out.println("DES解密后内容为："+new String(decryResult));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public static String encrypt(String srcMsg, String key){
		//DES加密
		byte[] result = Encrypt.desCrypto(srcMsg.getBytes(), key);

		//Base64编码
		byte[] resultBase = Base64.encodeBase64(result, true);
		
		return new String(resultBase);
	}

	private static byte[] desCrypto(byte[] datasource, String password) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] decrypt(byte[] src, String password) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}

}
