package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * 	�÷��� �����ӿ� �� �������� ��ü���� key-value������ �����ϴ� Map�� �н��Ѵ�.
 * 
 * */
public class MapTest {
	
	
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("caslopea", "�̻��");
		map.put("suzy","����" );
		map.put("momo", "���");
		
		//String obj = map.get("suzy");//key������ ��ü Ž��
		//System.out.println(obj);
		
		//��� ��ü���
		
		Set set =map.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()){
			//���̵�������(key)
			String str = it.next();
			//value ��������
			String value= map.get(str);
			System.out.println(str+" "+value);
			
		}
		
		
		
		
	}
}
