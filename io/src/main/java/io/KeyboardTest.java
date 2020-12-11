package io;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {

	public static void main(String[] args) {
		//기반 스트림 (System.int,표준입력, stdin )
		
		
		
		try {
			InputStreamReader isr =new InputStreamReader(System.in, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
		} catch (UnsupportedEncodingException e) {
			System.out.println("error: " + e);
		}
		
		
	}

}
