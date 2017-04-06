package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManualMove extends JFrame{
	
	JPanel p;
	JButton bt;
	int x=0, y=0;
	
	public ManualMove() {
		p = new JPanel(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
			
		};
		p.setBackground(Color.YELLOW);
		bt = new JButton("�����̱�");
		add(bt, BorderLayout.NORTH);
		add(p);
		
		bt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
					x+=5;
					y+=5;
					
					//�������� �����ϴ� ���.
					repaint(); //������ ȣ��!
					
			}
		});
		
		setSize(600,500);
		setVisible(true);
		
	}
	
	public void test(){
		System.out.println("testȣ��");
		
	}
	
	public static void main(String[] args) {
		new ManualMove();
	}

}
