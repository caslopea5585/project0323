package collection;

import java.util.Vector;

import javax.swing.JButton;

/*
 * �÷��� �����ӿ��� api��ü ��  List�迭�� ���� ��ü�� Vector�� �н��غ���
 * 
 * ����) List�迭�� ��� �츮�� ���� ��Դ� �迭�� ���� ����.
 * 
 * 				�迭			VS				List
 * ũ��        �ݵ�� ���					  ���û���
 * ���	�ڹٱ⺻�ڷ���,��ü�ڷ���		���� ��ü!!
 * */
public class VectorTest {

	public static void main(String[] args) {
		
		//�÷��� �����ӿ� ��ü�� Generic Type�� ����ϸ� ��ü�� ���̴� ���� ������Ÿ�ӿ� ���� ���ش�....
		//<>�ȿ� �ڷ����� �ִ´�. Vector<Strig> �̰� ��ü �ڷ���...
		//���ʸ�Ÿ�����־������ �ٸ�Ÿ�Կ� ��ü�� ���������ϸ� ���������� ������ �߻��Ѵ�.
		//���ʸ��� �����ϸ� �ش��ڷ������� ��ȯ�Ǽ� ���Եȴ�. ���� ����Ÿ�Ե� �翬�� ���ʸ� Ÿ�԰� ���Ͻ� �ȴ�.
		//���󵵰�����
		Vector<String> v= new Vector<String>();
		
		v.add("���");
		v.add("����");
		v.add("�ٳ���");
		v.add("������");
		//e���� �������� �ʴ´�...������Ʈ�� ��Ÿ��������.!! public boolean add(E e)
		
		for(int i=0;i<v.size();i++){
			String obj = v.get(i);
		}
		//������ ��ü����..���ö��� ��ü���·� ���´�...�׷��� ���� ���ϴ°� String...���� ����ȯ�� ���־�� �Ѵ�. �̰� �ùٸ� ���
		//System.out.println(obj);
		
		
	}

}
