package com.other.algorithms.asymetric;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


public class RSAEncryptionJava8
{

	public static void main(String[] args)
	{
		String plainText = "My name is suresh";
		Map<String, Object> keys = generateRSAKeys();
		PrivateKey priKey = (PrivateKey) keys.get("private");
		PublicKey pKey = (PublicKey) keys.get("public");
		
		String encryptMessage = encryptMessage(plainText, priKey);
		String decrtptMessage = decrtptMessage(encryptMessage, pKey);
		
		System.out.println("encryptMessage ::: "+encryptMessage+" \n decrtptMessage ::: "+decrtptMessage);
	}

	private static String decrtptMessage(String encrtptText, PublicKey pKey)
	{
		Cipher cipher = null;
		try
		{
			cipher =Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, pKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(encrtptText)));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static String encryptMessage(String plainText, PrivateKey priKey)
	{
		Cipher cipher = null;
		try
		{
			cipher =Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, priKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static Map<String, Object> generateRSAKeys()
	{
		Map<String, Object> out = new HashMap<String, Object>();
		try
		{
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
			//PrivateKey privateKey = generateKeyPair.getPrivate();
			//PublicKey publicKey = generateKeyPair.getPublic();
			System.out.println("generateKeyPair.getPublic() : "+generateKeyPair.getPublic().toString());
			System.out.println("generateKeyPair.getPrivate() : "+generateKeyPair.getPrivate().toString());
			out.put("public", generateKeyPair.getPublic());
			out.put("private", generateKeyPair.getPrivate());
		}
		catch (NoSuchAlgorithmException e)
		{
			//e.printStackTrace();
		}
		return out;
	}
}
