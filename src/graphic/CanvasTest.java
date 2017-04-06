package graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

/*
 * �׸� �׷��� �������� �����Ǵ�  ��ü�� Canvas�� �׸��� �׷�����!!
 * ��??????????ĵ������ �׷��� �ϳ�?
 *  ĵ������ �����̳�ó�� �ƹ��͵� ���� ������ ����ִ�. �� ��ȭ���� ǥ���� ��ü�̹Ƿ�...
 * */
public class CanvasTest extends JFrame {
	Canvas can; //�ֺ� ��ȭ��
	Toolkit kit; //javaSE���� �̹����� ��������! ��Ŷ ��ü�� �̿��ؾ� �Ѵ�.(Sun���� ���Ѱ�...)
	Image img;//�߻�Ŭ������ new����...
					//kit���κ��� ���;� ��..
	
	//�����͸��Լ��� �տ� �����ִ� �Լ��� �ڽ��� �Ǿ� �����°��̴�.
	//�׷��� this�� �ϸ� �ڽ��� ���ϴ°�
	public CanvasTest() {
		kit=Toolkit.getDefaultToolkit(); //�ν��Ͻ� ���
		img=kit.getImage("C:/html_workspace/images/mario.png"); //�ڹٴ� �������� �ϳ��� Ư�����ڷεȴ�.�������� �ϳ� ���ϴ���, �����÷� �ٲ۴�
		
		can = new Canvas(){
			//paint �޼���� ��ǻ� ������ �Ұ��ϸ� � �׸��� �׸��� �����ϴ� ��ü��
			//Graphics��ü�̴�.
			public void paint(Graphics g) {
				
				g.drawImage(img,0,0,100,100,this);
				
			}
			
		};
		
		can.setBackground(Color.YELLOW);
		add(can);
		
		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new CanvasTest();
	}
	
}
