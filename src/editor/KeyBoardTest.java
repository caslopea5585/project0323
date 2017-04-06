/*
 * 키보드
 * */
package editor;

import java.io.IOException;
import java.io.InputStream;

public class KeyBoardTest {
	
	public static void main(String[] args) {
		/*
		 * 키보드는 개발자가 원할때 생성할 수 있는 스트림이 아니라 이미 시스템에서 컴퓨터킬때
		 * 미리 얻어놓기 때문에 개발자는 이미 존재하는 스트림을 얻어와서 사용하면 된다.
		 * 자바에서는 OS로부터 스트림을 이미 얻어와서 System클래스에 멤버변수인 in 변수에 받아놓았다.
		 * 
		 * 자바는 하드웨어를 직접 제어하지 않고 또한 하드웨어 자체는 현 시스템을 운영하는 OS가 제어하므로,
		 * 하드웨어에 대한 입력 스트림은 자바가 아닌 OS가 이미 제어해놓고 있다.따라서 자바 언어를 이용하여
		 * 키보드 , 스캐너 등등의 입력 하드웨어를 값을 얻기 위해서는 각 하드웨어의 알맞는 스트림 클래스가 지원되는 것이 아니라!!
		 * 오직 표준 입력 스트림인 InputStream을 쓰면 된다...
		 * 
		 * OS로부터 입력을 받는거다!!!!!
		 * 
		 * */
		InputStream is = System.in;
		//try,catch문 자동으로 입력하려면 에러난 부분에 블럭지정후 쉬프트 +알트+제트눌른다..
		int data;
		try {
			//read()메서드는 사용자의 입력이 있을때까지 Block상태에 빠진다..
			//블럭상태란... 대기상태를 말함.. 입력이 될떄까지 다음줄 수행안하고 기다리고 있음.
			while(true){
				data = is.read();//1byte읽기
				System.out.print((char)data); //만약 인트형 그대로 하면 기능문자인 엔터와 캐리지리턴값도 함께 찍히게 된다.
															//문자만 보려면 char형으로 변환해서 문자만 보면된다. 기능문자는 char형으로 변환 불가하기때문이다.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
