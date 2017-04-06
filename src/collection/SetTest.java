package collection;

import java.util.Iterator;
import java.util.TreeSet;

/*
 *  컬렉션 프레임웍의 유형 2가지중 순서없는 객체들의 집합인 Set유형을 알아보자!!
 * 
*/
public class SetTest {

	public static void main(String[] args) {
		//Set 자식들중 TreeSet을 써보자!!
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("사과");
		set.add("딸기");
		set.add("오렌지");
		
		/*
		 * 컬렉션 프레임 우거의 객체 중 순서없는 객체를 사용하다보면, 
		 * 대량의 처리시 반복문을 직접 사용할 수 없다는 어려움에 부딪친다.
		 * 
		 * 해결책!!!) 순서없는 것을 순서 있게 만든다 (순서없는것 ->순서 있게)
		 * 				Enumeration(구), Iterator(신) 혼용해서 사용하면됨..
		 */
		
		Iterator<String> it=set.iterator();
		//Treeset은 순서가 없으니깐 순서있게 만든다. 그 방식이 2가지가 있는데 한개를 선택한다 한다
		//iterator()가 메서드인데 이것의 반환형이 Iterator it를 만들어서 그것을 담는다.
		//TreeSet과 Iterator는 다르다. 따라서 ITerator도 Treeset과 동일시 자료형으로 만들어주면 좋다.
		
		
		
		
		//has.next는 다음있는지 여부를 판단하여 boolean으로 반환해준다...
		//has.next()로 다음을 판단하고 있따면 next()로 다음을 지정해준다..
		while(it.hasNext()){
			//String e = it.next();
			System.out.println(set.size());
			
			System.out.println(it.next());			
		}
		
		
	}

}
