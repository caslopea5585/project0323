package collection;

import java.util.Vector;

import javax.swing.JButton;

/*
 * 컬렉션 프레임웍의 api객체 중  List계열의 하위 객체인 Vector를 학습해보자
 * 
 * 참고) List계열은 사실 우리가 흔히 써왔던 배열과 거의 같다.
 * 
 * 				배열			VS				List
 * 크기        반드시 명시					  선택사항
 * 대상	자바기본자료형,객체자료형		오직 객체!!
 * */
public class VectorTest {

	public static void main(String[] args) {
		
		//컬렉션 프레임웍 객체에 Generic Type을 명시하면 객체가 섞이는 것을 컴파일타임에 방지 해준다....
		//<>안에 자료형을 넣는다. Vector<Strig> 이게 전체 자료형...
		//제너릭타입을넣어버리면 다른타입에 객체가 들어오려고하면 넣을때부터 에러가 발생한다.
		//제너릭을 선언하면 해당자료형으로 변환되서 들어가게된다. 따라서 리턴타입도 당연히 제너릭 타입과 동일시 된다.
		//사용빈도가높음
		Vector<String> v= new Vector<String>();
		
		v.add("사과");
		v.add("딸기");
		v.add("바나나");
		v.add("오렌지");
		//e형은 존재하지 않는다...오브젝트를 나타내기위함.!! public boolean add(E e)
		
		for(int i=0;i<v.size();i++){
			String obj = v.get(i);
		}
		//들어갈때는 객체형태..나올때도 객체형태로 나온다...그래서 내가 원하는건 String...따라서 형변환을 해주어야 한다. 이게 올바른 방법
		//System.out.println(obj);
		
		
	}

}
