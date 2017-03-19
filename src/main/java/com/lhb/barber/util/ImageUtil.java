package com.lhb.barber.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ImageUtil {

	public static  String encodeImageToStr(InputStream inputStream){
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new InputStreamReader(inputStream,"base64"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	     //最好在将字节流转换为字符流的时候 进行转码  
	     StringBuffer buffer=new StringBuffer();  
	     String line="";  
	     try {
			while((line=bf.readLine())!=null){  
			     buffer.append(line);  
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	       
	    return buffer.toString();  
	}
}
