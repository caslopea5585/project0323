package copy;
/*
	����ó���� ����!
	- ������ ������ ����. (�� �������� �ý��� ��� ����)
	-
	�Ϲ������� ���α׷��� ���� ����ɼ� ���� ��Ȳ�� ������ "����"�� ��.

	sun������ ������ ���� ���� �з���...Ŭ������ ����
	
	1. ���α׷��Ӱ� ��ó�� �� ���� �Ұ��׷��� ����.(��������)
		- Error 
		- Ex)Cpu�� Ÿ������ ����. ��Ʈ��ũ ���� �Ұ�..

	2. ���α׷��Ӱ� ��ó�� �� �ִ� ����.(���ܻ���)
		- �ڹ��� ���� ������ �ٷ� "����"�̴�.
		sun������ �� ���ܸ� ��Ȳ�� ���� ü������ Ŭ������ �����ϰ� �ִ�.

		�� ���� ��ü���� �ٽ� ũ�� 2���� �������� �з��ȴ�.
			(1) ������ Ÿ�ӿ� ����ó���� �����ϴ� ���
				- checked Exception

			(2) ������ Ÿ�ӿ� ����ó���� �������� �ʴ� ���
				- Unchecked Exception = Runtime Exception

*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileCopy2{
	FileInputStream fis; //������ ������� �� �Է½�Ʈ��
	FileOutputStream fos; //������ ��������� ��½�Ʈ��

	public FileCopy2(){
		//�Ʒ��� �ڵ�� ���� ������ �߻� �� �� �ִ� ���ɼ��� �ٺ��ϴ�. ���� �����ڰ� ������ �� �ۼ��������� �ұ��ϰ�
		//Ư���� ������ġ�� �����ϱ⸦ �����Ѵ�!
		//try������ ���ξ� �Ѵ�.
		try{
			fis = new FileInputStream("C:/java_workspace2/project0323/res/pica.jpg");
			fos = new FileOutputStream("C:/java_workspace2/project0323/data/pica_copy.jpg");

			
			int data;
			while(true){
				data = fis.read(); //1 ����Ʈ�� �о����...
				
				if(data==-1){
					break;
				}
				fos.write(data);//1����Ʈ ����.
				System.out.println(data);
			}


		}catch(FileNotFoundException e){
			//������ �߻��ϸ� ����ΰ� �̿������� ���Եȴ�. cathch���� �����ϱ� ������ ���α׷��� ���������ᰡ �����ʰ� ��������ϰԵȴ�.
			//����ڿ��� �ȳ��ϴ� �뵵�� catch���� ����ϰ� �ȴ�.
			//d������ �߻��ϸ� �����߻��� ��ü�� catch������ �����ش�. �׷��� catch������ �� ��ü�� ���� ����ó���� ���ָ��
			
			System.out.println("������ ã�� �� �����ϴ�.");
		}catch(IOException e){
			System.out.println("������ ���� �� �����ϴ�.");
		}finally{
			//finally�� �����ϰ� �Ǹ�.....
			//try���� �����ϴ�, catch���� �����ϴ� ����ΰ� ������ �� ������ ��ġ�� �Ǿ��ִ�.
			//finally�� ������!!!
			/*
				�ַ� database������ ��Ʈ�� ����
				�������θ� ������ ������ �ڿ��� �ݰų� �������Ϸ��� try���̴� catch���� �����ϴ� �������
				������ ���İ����� �ڵ� ������ �α� ����....

			*/

					//��� ������ ������ ����!!
				try{
					if(fis!=null){fis.close();} //��Ʈ�� ���� ����!!!!! ���� ���ϸ� �޸� ���� �� �Ͼ..
					if(fos!=null){fos.close();}
				}catch(IOException e){

				}
		}

		
	
	}

	public static void main(String[] args){
		new FileCopy2();
	}

}
