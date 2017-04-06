package graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhotoGalley3 extends JFrame implements ActionListener {
	
	JLabel label;
	
	JPanel p_south;
	JButton left_bt, right_bt;
	Canvas canvas;
	Toolkit kit;
	Image img;
	int count=0;
	String[] path ={
			"C:/html_workspace/images/mario.png",
			"C:/html_workspace/images/duck2.png",
			"C:/html_workspace/images/enemy.png",
			"C:/html_workspace/images/enemy2.png",
			"C:/html_workspace/images/enemy3.png",
			"C:/html_workspace/images/enemy4.png",
			"C:/html_workspace/images/enemy5.png"
			
	};
	
	public PhotoGalley3() {
	
		
		
		p_south = new JPanel();
		left_bt=new JButton("◀");
		right_bt=new JButton("▶");
		
		p_south.add(left_bt);
		p_south.add(right_bt);
		
		kit=Toolkit.getDefaultToolkit();
		label=new JLabel(path[count]);
		img=kit.getImage(path[count]);
		
		
		left_bt.addActionListener(this);
		right_bt.addActionListener(this);
		
		
		canvas = new Canvas(){
			
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 600, 600, this);
				System.out.println("paint호출!!");
			}
			
		};
		
		
		add(canvas,BorderLayout.CENTER);
		add(p_south,BorderLayout.SOUTH);
		
		setSize(600,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		System.out.println(left_bt);
		//경고창 띄우는법
		JOptionPane.showMessageDialog(this, "나눌렀어?");
		
		/*
		 * ActionEvent는 클릭뿐만 아니라, 여러행위를 아우르는 이벤트 객체이다.
			따라서 버튼만 ActionEvent만 일으키는게 아니다.
			e.getSoutce를 호출하면 어떤 컴포넌트가 이벤트를 일으켰는지 예측 할 수 없으므로
			Object형으로 반환해준다!!!
		*/
		
		Object obj= e.getSource();//이벤트를 일으킨 컴포넌트
		JButton bt = (JButton)obj;
		
		if(bt == left_bt){
			//JOptionPane.showMessageDialog(this, "이전");
			//parentsCompponent는 자신의 상위를 말한다.(여기서 상위는 디자인 객체)
			//여기선 내자체가 윈도우니깐..this하면됨.
			
			prev();
		}
		if(bt==right_bt){
			//JOptionPane.showMessageDialog(this, "다음");
			next();
		}
		
	}
	
	//다음사진 보여주기!!
	public void next(){
		//이미지의 경로변경!! + 라벨의 값도 변경
		count++;
		img=kit.getImage(path[count]);
		
//		개발자는 paint 메서드를 호출 할 수 없다.
//		paint는 언제호출되나??
//		자기가 스스로 지웟다가 다시만드는 방식... 스스로 지가 호출할 수 밖에없다.
//		User가 해당 컴포넌트의 변경을 가할때 스스로 호출한다..
//		따라서 버튼을 누르게 되면 켄버스의 변경을 가한적이 없기 때문에 paint메서드는 호출되지 않는다.
//		해결책) 캔버스의 paint메서드를 강제해야하지만, 호출불가이기 떄문에 간접호출해야 한다..
//		즉! 시스템에게 paint를 호출해달라고 요청해야한다..
//		repaint()-->update()-->paint()
//		update() -->기존화면을 싹 지우는 메서드
//		paint() --> 그림을 다시 그린다.
//		따라서 이미지 용량이 큰 경우에는 우리 눈엔 깜빡 거리는 효과가 나는 것이다!
		
		canvas.repaint();
		//라벨의 변경을 가하자!
		label.setText(path[count]);
		
	}
	//이전사진 보여주기!!
	public void prev(){
		
		
	}
	
	
	public static void main(String[] args) {
		new PhotoGalley3();
	}

}
