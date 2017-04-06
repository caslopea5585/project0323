/*
 * 1. 스트림의 방향성에 따른 분류
 * 		- 입력, 출력
 * 
 * 2. 스트림의 데이터 처리방법에 따른 분류
 * 		(1) 바이트 기반 스트림
 * 			- 입출력시 1byte씩 처리
 * 
 * 		(2) 문자 기반 스트림 (바이트 기반 스트림에 문자 기반 스트림을 더한것)
 * 			- 입출력시 2byte씩 묶어서 이해할 수 있는 스트림
 * 			주의!!)2byte씩 읽거나, 쓰는 것이 아니다!!!!!!!!!!
 * 			
 * 			- 문자 기반 스트림의 명명규칙
 * 			 1) 입력스트림~~~Reader로 끝남
 * 			 2) 출력스트림 ~~~Writer로 끝남
 * 
 *		(3) 버퍼 스트림 
 *
 * */
package editor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {
	
	
	public static void main(String[] args) {
		//스트림 얻기!!!
		InputStream is = System.in;
		InputStreamReader reader = null;
		
		reader = new InputStreamReader(is);
		//문자 리더나 라이터라해서 2바이트 단독으로 스트림이 있는것이 아니다.
		//1바이트 기반에 2바이트 가 밖에 쌓여잇는것이다.
		//reader는 단독으로 존재XXXXX
		//바이트기반을 근거로 2바이트...데이터가 전달되는 것은 무조건 1byte씩 전달
		//리더를 덫붙이면 1바이트씩 보던걸 2바이트씩 묶어서 해결..
		
		
		int data;
		
		try {
			
				data = reader.read();//1Byte
				System.out.print((char)data);
				
				/*
				 * System.in //표준입력
				 * System.out//표준출력
				 * */			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		new StandardInput();
	}

}
