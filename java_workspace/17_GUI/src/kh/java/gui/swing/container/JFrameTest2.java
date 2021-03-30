package kh.java.gui.swing.container;

import javax.swing.JFrame;

public class JFrameTest2 extends JFrame {  // JFrame 상속받음
	
	public JFrameTest2() {
		setTitle("두번째 프레임");
//		setSize(300,200);
//		setLocation(200,200);
		setBounds(200,200,300,200); //위에 두코드를 한번에 쓸수있음 Bounds이용해서
		
		
		//리사이즈 방지
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼-> 프로그램 종료처리
		
		setVisible(true); // 시각화 처리 꼭 해줘야함 마지막에!!!!!!
	}

	public static void main(String[] args) {
		new JFrameTest2();
		

	}

}
