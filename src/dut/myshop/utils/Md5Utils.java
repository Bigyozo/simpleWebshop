package dut.myshop.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class Md5Utils {
	public static String md5(String msg) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(msg.getBytes());
			Base64.Encoder encoder = Base64.getEncoder();
			return encoder.encodeToString(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
	}
}
