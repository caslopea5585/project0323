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
public class AnswerCopyMain extends JFrame implements ActionListener{
	JButton bt_open,bt_save,bt_openNew;
	JTextField t_open, t_save;
	FileInputStream fis; //파일을 대상으로 한 입력 스트림
	FileOutputStream fos; //파일을 대상으로 한 출력 스트림
	JFileChooser chooser; //파일 탐색기를 처리하는 객체
	File f;
	
	
	public AnswerCopyMain() {
		bt_open= new JButton("원본위치");
		bt_save=new JButton("복사");
		bt_openNew = new JButton("저장경로");
		t_open = new JTextField(30);
		t_save= new JTextField(30); 
		//파일 추저를 미리 올려놓자!!
		chooser = new JFileChooser("C:/java_workspace2/project0323"); //디폴트 디렉토리를 지정하면 편한다.
		f=new File("C:/java_workspace2/project0323/data/");
		
		setLayout(new FlowLayout());
		
		add(bt_open);
		add(t_open);
		add(bt_openNew);
		add(t_save);
		add(bt_save);
		
		//버튼과 리스너와 연결
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_openNew.addActionListener(this);

		setSize(475,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//여기선 문제가 없지만.. 닫으면 스트림을 닫을방법이없고 .........프로세스가 다 꺼져버린다.
		//따라서 윈도우리스너를 통해 클로즈가 일어날때 스트림을 닫고 클로즈오퍼레이션이 실행될수 있도록 해야한다.
		
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource(); //이벤트 소스 반환받기...
		
		if(obj == bt_open){	
			open();
		}else if(obj==bt_save){
			copy();
		}else if(obj==bt_openNew){
			int state = chooser.showSaveDialog(this);
			
			if(state == JFileChooser.APPROVE_OPTION){
				//상수는 인간에게 직관성을 부여해준다. 왜?영어단어를 이용하니깐...
			//저장경로를 텍스트필드에 출력!!
				System.out.println(state);
				openPath();
			}
		}

	}
	//새로 저장할 경로 열기!!
	public void openPath(){
		chooser.showOpenDialog(this);
		f=chooser.getCurrentDirectory();
		//파일클래스가 보유한 절대경로 메서드를 이용하여 경로반환받기!
		String path = f.getAbsolutePath(); 
		t_save.setText(path+'/');
	}

	//파일열기!!
	public void open(){
		chooser.showOpenDialog(this);
		
		int state = chooser.showOpenDialog(this);
		
		if(state == JFileChooser.APPROVE_OPTION){
			//유저가 선택한 파일에 대한 파일클래스 인스턴스 얻기!
			//여기서 굳이 파일을 new로 선언하지않고.. File file 이렇게 선언하고 바로 이용해도상관없다.
			f = chooser.getSelectedFile();
			//얻어진 인스턴스를 이요하여 절대경로얻기
			String path = f.getAbsolutePath();
			//절대경로 텍스트필에 출력하기
			t_open.setText(path);
			
		}

		
	}

	//복사하기!!
	public void copy(){
		//원본 파일에 스트림 생성하여 데이터를 들이마시자!!
		//들어온 데이터를 목적파일에 내려쓰자!
		String oriPath = t_open.getText();
		String destPath = t_save.getText();

		try{
			fis = new FileInputStream(oriPath);
			fos = new FileOutputStream(destPath);
			
			int data;
			while(true){

				data = fis.read(); //현재 실행중인 프로그램으로 1바이트 읽어들이기.
				if(data==-1)break;
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this,"복사완료");
			//스트림을닫자
			//try문에서 닫을 경우 문제점...
			//에러 발생시..이 문장이 수행이 안됨			fis.close(); 메모리 누수가 발생해버림....
		}catch(FileNotFoundException e){
			//이곳에서 스트림을 닫으면...정상수행시 close문이 없다...
			//그래서 finally을 통해 try나,catch문이 수행되도 finally로는 무조건 한번 들어가게된다...
			JOptionPane.showMessageDialog(this,"파일을 찾을 수 없습니다.");
		}catch(IOException e){
			JOptionPane.showMessageDialog(this,"IO작업중 에러발생.");
		}finally{
			//finally안에서도 try catch을 통해 다시 한번 예외처리
			try{
				//객체가 메모리에 올라왔다면...이라는 조건을 달아주어야 한다.

				if(fis!=null){fis.close();}
				if(fos!=null){fos.close();}
			}catch(IOException e ){
			
			}
		}
	
	}


	
	public static void main(String[] args) {
		new AnswerCopyMain();
	}
}
