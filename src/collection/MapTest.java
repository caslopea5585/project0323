package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * 	컬렉션 프레임웍 중 순서없는 객체들을 key-value쌍으로 관리하는 Map을 학습한다.
 * 
 * */
public class MapTest {
	
	
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("caslopea", "이상운");
		map.put("suzy","수지" );
		map.put("momo", "모모");
		
		//String obj = map.get("suzy");//key값으로 객체 탐색
		//System.out.println(obj);
		
		//모든 객체출력
		
		Set set =map.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()){
			//아이디가져오기(key)
			String str = it.next();
			//value 가져오기
			String value= map.get(str);
			System.out.println(str+" "+value);
			
		}
		
		
		
		
	}
}
