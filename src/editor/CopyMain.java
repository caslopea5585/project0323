package editor;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
public class CopyMain extends JFrame implements ActionListener{
	JButton bt_open,bt_save,bt_openNew;
	JTextField t_open, t_save;
	FileInputStream fis; //������ ������� �� �Է� ��Ʈ��
	FileOutputStream fos; //������ ������� �� ��� ��Ʈ��
	JFileChooser chooser; //���� Ž���⸦ ó���ϴ� ��ü
	File f;
	
	
	public CopyMain() {
		bt_open= new JButton("������ġ");
		bt_save=new JButton("����");
		bt_openNew = new JButton("������");
		t_open = new JTextField(30);
		t_save= new JTextField(30);
		//���� ������ �̸� �÷�����!!
		chooser = new JFileChooser("C:/java_workspace2");
		f=new File("C:/java_workspace2/project0323/data/");
		
		setLayout(new FlowLayout());
		
		add(bt_open);
		add(t_open);
		add(bt_openNew);
		add(t_save);
		add(bt_save);
		
		//��ư�� �����ʿ� ����
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_openNew.addActionListener(this);

		setSize(475,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���⼱ ������ ������.. ������ ��Ʈ���� ��������̾��� .........���μ����� �� ����������.
		//���� �����츮���ʸ� ���� Ŭ��� �Ͼ�� ��Ʈ���� �ݰ� Ŭ������۷��̼��� ����ɼ� �ֵ��� �ؾ��Ѵ�.
		
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource(); //�̺�Ʈ �ҽ� ��ȯ�ޱ�...
		
		if(obj == bt_open){
			System.out.println("����");	
			open();
		}else if(obj==bt_save){
			System.out.println("����");
			copy();
		}else if(obj==bt_openNew){
			System.out.println("���");	
			openPath();
		}

	}
	//���� ������ ��� ����!!
	public void openPath(){
		chooser.showOpenDialog(this);
		f=chooser.getCurrentDirectory();
		t_save.setText(f.toString()+'/');
	}

	//���Ͽ���!!
	public void open(){
		chooser.showOpenDialog(this);
		f=chooser.getSelectedFile();
		t_open.setText(f.toString());
		
	}

	//�����ϱ�!!
	public void copy(){
		//���� ���Ͽ� ��Ʈ�� �����Ͽ� �����͸� ���̸�����!!
		//���� �����͸� �������Ͽ� ��������!
		String oriPath = t_open.getText();
		String destPath = t_save.getText();

		try{
			fis = new FileInputStream(oriPath);
			fos = new FileOutputStream(destPath);
			
			int data;
			while(true){

				data = fis.read(); //���� �������� ���α׷����� 1����Ʈ �о���̱�.
				if(data==-1)break;
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this,"����Ϸ�");
			//��Ʈ��������
			//try������ ���� ��� ������...
			//���� �߻���..�� ������ ������ �ȵ�			fis.close(); �޸� ������ �߻��ع���....
		}catch(FileNotFoundException e){
			//�̰����� ��Ʈ���� ������...�������� close���� ����...
			//�׷��� finally�� ���� try��,catch���� ����ǵ� finally�δ� ������ �ѹ� ���Եȴ�...
			JOptionPane.showMessageDialog(this,"������ ã�� �� �����ϴ�.");
		}catch(IOException e){
			JOptionPane.showMessageDialog(this,"IO�۾��� �����߻�.");
		}finally{
			//finally�ȿ����� try catch�� ���� �ٽ� �ѹ� ����ó��
			try{
				//��ü�� �޸𸮿� �ö�Դٸ�...�̶�� ������ �޾��־�� �Ѵ�.

				if(fis!=null){fis.close();}
				if(fos!=null){fos.close();}
			}catch(IOException e ){
			
			}
		}
	
	}


	
	public static void main(String[] args) {
		new CopyMain();
	}
}
