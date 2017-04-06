package graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

/*
 * 그림 그려질 목적으로 지원되는  객체인 Canvas에 그림을 그려보자!!
 * 왜??????????캔버스에 그려야 하나?
 *  캔버스는 컨테이너처럼 아무것도 없기 때문에 비어있다. 빈 도화지를 표현한 객체이므로...
 * */
public class CanvasTest extends JFrame {
	Canvas can; //텅빈 도화지
	Toolkit kit; //javaSE에서 이미지를 얻으려면! 툴킷 객체를 이용해야 한다.(Sun에서 정한것...)
	Image img;//추상클래스라서 new못함...
					//kit으로부터 얻어와야 함..
	
	//내부익명함수는 앞에 써져있는 함수의 자식이 되어 버리는것이다.
	//그러니 this를 하면 자식을 말하는거
	public CanvasTest() {
		kit=Toolkit.getDefaultToolkit(); //인스턴스 얻기
		img=kit.getImage("C:/html_workspace/images/mario.png"); //자바는 역슬래시 하나는 특수문자로된다.역슬래시 하나 더하던가, 슬러시로 바꾼다
		
		can = new Canvas(){
			//paint 메서드는 사실상 행위에 불과하며 어떤 그림을 그릴지 결정하는 객체는
			//Graphics객체이다.
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
