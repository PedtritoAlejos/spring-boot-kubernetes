package org.soyphea.k8s.srevice;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class MyClass {

	  public String applyCBC(String strKey, String plainText) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
	    byte[] bytesIV = "7cVgr5cbdCZVw5WY".getBytes("UTF-8");

	    /* KEY + IV setting */
	    IvParameterSpec iv = new IvParameterSpec(bytesIV);
	    SecretKeySpec skeySpec = new SecretKeySpec(strKey.getBytes("UTF-8"), "AES");

	    /* Ciphering */
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	    cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);  // Noncompliant: the IV is hard coded and thus not generated with a secure random generator
	    byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
	    return DatatypeConverter.printBase64Binary(bytesIV)
	            + ";" + DatatypeConverter.printBase64Binary(encryptedBytes);
	  }
	}