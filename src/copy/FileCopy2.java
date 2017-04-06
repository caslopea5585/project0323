package copy;
/*
	예외처리의 목적!
	- 비정상 종료의 방지. (즉 안정적인 시스템 운영을 목적)
	-
	일반적으로 프로그램이 정상 수행될수 없는 상황을 가리켜 "에러"라 함.

	sun에서는 에러에 대한 나름 분류함...클래스를 지원
	
	1. 프로그래머가 대처할 수 없는 불가항력적 에러.(에러사항)
		- Error 
		- Ex)Cpu가 타버리는 현상. 네트워크 선이 불가..

	2. 프로그래머가 대처할 수 있는 에러.(예외사항)
		- 자바의 관심 사항은 바로 "예외"이다.
		sun에서는 이 예외를 상황에 따라 체계적인 클래스로 지원하고 있다.

		이 예외 객체들은 다시 크게 2가지 유형으로 분류된다.
			(1) 컴파일 타임에 예외처리를 강요하는 경우
				- checked Exception

			(2) 컴파일 타임에 예외처리를 강요하지 않는 경우
				- Unchecked Exception = Runtime Exception

*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileCopy2{
	FileInputStream fis; //파일을 대상으로 한 입력스트림
	FileOutputStream fos; //파일을 대상으로한 출력스트림

	public FileCopy2(){
		//아래의 코드는 장차 에러가 발생 할 수 있는 가능성이 다분하다. 따라서 개발자가 문법을 잘 작성했음에도 불구하고
		//특별한 안정장치를 마련하기를 강요한다!
		//try문으로 감싸야 한다.
		try{
			fis = new FileInputStream("C:/java_workspace2/project0323/res/pica.jpg");
			fos = new FileOutputStream("C:/java_workspace2/project0323/data/pica_copy.jpg");

			
			int data;
			while(true){
				data = fis.read(); //1 바이트를 읽어들임...
				
				if(data==-1){
					break;
				}
				fos.write(data);//1바이트 쓰기.
				System.out.println(data);
			}


		}catch(FileNotFoundException e){
			//에러가 발생하면 실행부가 이영역으로 진입된다. cathch문을 실행하기 때문에 프로그램이 비정상종료가 되지않고 정상수행하게된다.
			//사용자에게 안내하는 용도로 catch문을 사용하게 된다.
			//d에러가 발생하면 에러발생한 객체를 catch문으로 보내준다. 그래서 catch에서는 그 객체에 대한 에러처리를 해주면됨
			
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e){
			System.out.println("파일을 읽을 수 없습니다.");
		}finally{
			//finally를 선언하게 되면.....
			//try문을 수행하던, catch문을 수행하던 실행부가 무조건 이 영역을 거치게 되어있다.
			//finally의 사용목적!!!
			/*
				주로 database연동과 스트림 사용시
				성공여부를 떠나서 무조건 자원을 닫거나 마무리하려면 try문이던 catch문을 수행하던 상관없이
				무조건 거쳐가야할 코드 여역을 두기 위함....

			*/

					//모든 업무가 끝나는 시점!!
				try{
					if(fis!=null){fis.close();} //스트림 연결 해제!!!!! 해제 안하면 메모리 누수 가 일어남..
					if(fos!=null){fos.close();}
				}catch(IOException e){

				}
		}

		
	
	}

	public static void main(String[] args){
		new FileCopy2();
	}

}
