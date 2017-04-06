package collection;

import java.util.Iterator;
import java.util.TreeSet;

/*
 *  �÷��� �����ӿ��� ���� 2������ �������� ��ü���� ������ Set������ �˾ƺ���!!
 * 
*/
public class SetTest {

	public static void main(String[] args) {
		//Set �ڽĵ��� TreeSet�� �Ẹ��!!
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("���");
		set.add("����");
		set.add("������");
		
		/*
		 * �÷��� ������ ����� ��ü �� �������� ��ü�� ����ϴٺ���, 
		 * �뷮�� ó���� �ݺ����� ���� ����� �� ���ٴ� ����� �ε�ģ��.
		 * 
		 * �ذ�å!!!) �������� ���� ���� �ְ� ����� (�������°� ->���� �ְ�)
		 * 				Enumeration(��), Iterator(��) ȥ���ؼ� ����ϸ��..
		 */
		
		Iterator<String> it=set.iterator();
		//Treeset�� ������ �����ϱ� �����ְ� �����. �� ����� 2������ �ִµ� �Ѱ��� �����Ѵ� �Ѵ�
		//iterator()�� �޼����ε� �̰��� ��ȯ���� Iterator it�� ���� �װ��� ��´�.
		//TreeSet�� Iterator�� �ٸ���. ���� ITerator�� Treeset�� ���Ͻ� �ڷ������� ������ָ� ����.
		
		
		
		
		//has.next�� �����ִ��� ���θ� �Ǵ��Ͽ� boolean���� ��ȯ���ش�...
		//has.next()�� ������ �Ǵ��ϰ� �ֵ��� next()�� ������ �������ش�..
		while(it.hasNext()){
			//String e = it.next();
			System.out.println(set.size());
			
			System.out.println(it.next());			
		}
		
		
	}

}
