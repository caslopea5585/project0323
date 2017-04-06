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
		left_bt=new JButton("��");
		right_bt=new JButton("��");
		
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
				System.out.println("paintȣ��!!");
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
		//���â ���¹�
		JOptionPane.showMessageDialog(this, "��������?");
		
		/*
		 * ActionEvent�� Ŭ���Ӹ� �ƴ϶�, ���������� �ƿ츣�� �̺�Ʈ ��ü�̴�.
			���� ��ư�� ActionEvent�� ����Ű�°� �ƴϴ�.
			e.getSoutce�� ȣ���ϸ� � ������Ʈ�� �̺�Ʈ�� �����״��� ���� �� �� �����Ƿ�
			Object������ ��ȯ���ش�!!!
		*/
		
		Object obj= e.getSource();//�̺�Ʈ�� ����Ų ������Ʈ
		JButton bt = (JButton)obj;
		
		if(bt == left_bt){
			//JOptionPane.showMessageDialog(this, "����");
			//parentsCompponent�� �ڽ��� ������ ���Ѵ�.(���⼭ ������ ������ ��ü)
			//���⼱ ����ü�� ������ϱ�..this�ϸ��.
			
			prev();
		}
		if(bt==right_bt){
			//JOptionPane.showMessageDialog(this, "����");
			next();
		}
		
	}
	
	//�������� �����ֱ�!!
	public void next(){
		//�̹����� ��κ���!! + ���� ���� ����
		count++;
		img=kit.getImage(path[count]);
		
//		�����ڴ� paint �޼��带 ȣ�� �� �� ����.
//		paint�� ����ȣ��ǳ�??
//		�ڱⰡ ������ ���m�ٰ� �ٽø���� ���... ������ ���� ȣ���� �� �ۿ�����.
//		User�� �ش� ������Ʈ�� ������ ���Ҷ� ������ ȣ���Ѵ�..
//		���� ��ư�� ������ �Ǹ� �˹����� ������ �������� ���� ������ paint�޼���� ȣ����� �ʴ´�.
//		�ذ�å) ĵ������ paint�޼��带 �����ؾ�������, ȣ��Ұ��̱� ������ ����ȣ���ؾ� �Ѵ�..
//		��! �ý��ۿ��� paint�� ȣ���ش޶�� ��û�ؾ��Ѵ�..
//		repaint()-->update()-->paint()
//		update() -->����ȭ���� �� ����� �޼���
//		paint() --> �׸��� �ٽ� �׸���.
//		���� �̹��� �뷮�� ū ��쿡�� �츮 ���� ���� �Ÿ��� ȿ���� ���� ���̴�!
		
		canvas.repaint();
		//���� ������ ������!
		label.setText(path[count]);
		
	}
	//�������� �����ֱ�!!
	public void prev(){
		
		
	}
	
	
	public static void main(String[] args) {
		new PhotoGalley3();
	}

}
