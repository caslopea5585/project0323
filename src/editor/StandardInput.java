/*
 * 1. ��Ʈ���� ���⼺�� ���� �з�
 * 		- �Է�, ���
 * 
 * 2. ��Ʈ���� ������ ó������� ���� �з�
 * 		(1) ����Ʈ ��� ��Ʈ��
 * 			- ����½� 1byte�� ó��
 * 
 * 		(2) ���� ��� ��Ʈ�� (����Ʈ ��� ��Ʈ���� ���� ��� ��Ʈ���� ���Ѱ�)
 * 			- ����½� 2byte�� ��� ������ �� �ִ� ��Ʈ��
 * 			����!!)2byte�� �аų�, ���� ���� �ƴϴ�!!!!!!!!!!
 * 			
 * 			- ���� ��� ��Ʈ���� ����Ģ
 * 			 1) �Է½�Ʈ��~~~Reader�� ����
 * 			 2) ��½�Ʈ�� ~~~Writer�� ����
 * 
 *		(3) ���� ��Ʈ�� 
 *
 * */
package editor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {
	
	
	public static void main(String[] args) {
		//��Ʈ�� ���!!!
		InputStream is = System.in;
		InputStreamReader reader = null;
		
		reader = new InputStreamReader(is);
		//���� ������ �����Ͷ��ؼ� 2����Ʈ �ܵ����� ��Ʈ���� �ִ°��� �ƴϴ�.
		//1����Ʈ ��ݿ� 2����Ʈ �� �ۿ� �׿��մ°��̴�.
		//reader�� �ܵ����� ����XXXXX
		//����Ʈ����� �ٰŷ� 2����Ʈ...�����Ͱ� ���޵Ǵ� ���� ������ 1byte�� ����
		//������ �����̸� 1����Ʈ�� ������ 2����Ʈ�� ��� �ذ�..
		
		
		int data;
		
		try {
			
				data = reader.read();//1Byte
				System.out.print((char)data);
				
				/*
				 * System.in //ǥ���Է�
				 * System.out//ǥ�����
				 * */			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		new StandardInput();
	}

}
