package kh.java.gui.swing.container;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * 800 * 500 가운데 위치시키기
 *
 */
public class JPanelTest extends JFrame { // JFrame 을 가져다 쓰겠다 라는 뜻 상속
	
	public JPanelTest() {
		
		// 800 * 500 가운데 정렬
		setSize(800,500); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JFrame 의 기본 LayoutManager 객체는 BorderLayout 이다.
//      setLayout(new BorderLayout());
		//null layout : layout manager 객체를 사용하지 않고 직접 좌표를 지정함.
		setLayout(null);  // null layout -> 직접 좌표 지정함
		
		//자식 컴포넌트 추가
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.BLUE);
		JLabel label1 = new JLabel("panel1");
		panel1.setBounds(100, 50, 300 , 400);
		add(panel1);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		JLabel label2 = new JLabel("panel2");
		panel2.setBounds(400 ,50 ,300 ,400);
		panel2.add(label2);
		
		//프레임에 패널 추가
		add(panel1);
		add(panel2);
		
		// 시각화 처리 맨마지막에 씀 항상 !
		setVisible(true);  // 시각화처리 맨마지막에 씀 항상 !!! , 이거 안해주면 스크린 안보임
	}

	public static void main(String[] args) {
		new JPanelTest(); // 화면에 보여주기 위한 컴포넌트 설정

	}

}
