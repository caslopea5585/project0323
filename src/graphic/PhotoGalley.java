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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhotoGalley extends JFrame {
	
	JTextField text;
	JPanel p_north,p_south;
	JButton left_bt, right_bt;
	Canvas canvas;
	Toolkit kit;
	Image img;
	int i=0;
	
	public PhotoGalley() {
		text = new JTextField(10);
		p_north = new JPanel();
		p_south = new JPanel();
		left_bt=new JButton("¢¸");
		right_bt=new JButton("¢º");
		
		
		p_north.add(text);
		
		p_south.add(left_bt);
		p_south.add(right_bt);
		
		kit=Toolkit.getDefaultToolkit();
		
		
		String[] images = new String[10];
		
		images[0]="C:/html_workspace/images/mario.png";
		images[1]="C:/html_workspace/images/duck2.png";
		images[2]="C:/html_workspace/images/enemy.png";
		images[3]="C:/html_workspace/images/enemy2.png";
		images[4]="C:/html_workspace/images/enemy3.png";
		images[5]="C:/html_workspace/images/enemy4.png";
		images[6]="C:/html_workspace/images/enemy5.png";
		
		
		
		left_bt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				i--;
								
			}
		});
		
		right_bt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				i++;
							
			}
		});
		

		canvas = new Canvas(){
			
			public void paint(Graphics g) {
				g.drawImage(kit.getImage(images[i]), 100, 100, this);
				canvas.repaint();
				
				
			}
			
		};
		
		
		
		
		add(p_north,BorderLayout.NORTH);
		add(canvas,BorderLayout.CENTER);
		add(p_south,BorderLayout.SOUTH);
		
		setSize(600,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new PhotoGalley();
	}

}
