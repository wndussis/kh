package kh.java.gui.swing.container.layout;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kh.java.gui.util.MyUtil;

public class BorderLayoutTest extends JFrame {
	
	public BorderLayoutTest(int w, int h , String title) {
		MyUtil.init(this, w, h , title);
		
		// JFrame 객체의 기본 layout 은 BorderLayout 이다.
		
		JPanel north = new BorderPanel("북" , Color.GREEN);  // 이름 , 배경색
		JPanel south = new BorderPanel("남" , Color.blue);
		JPanel east = new BorderPanel("동" , Color.cyan);
		JPanel west = new BorderPanel("서" , Color.magenta);
		JPanel center = new BorderPanel("가운데" , Color.YELLOW);
		
		//컨테이너의 add
		//생성한 패널은 JFrame에 add해줘야 보인다
		//두번째 인자로 위치지정을 안해주면 무조건 가운데임
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(center);
		
		
	}
	
	/**
	 * 
	 * 내부 클래스 선언 - 클래스 안의 클래스 
	 * 
	 * - 외부 클래스에서 자유롭게 가져다 사용할 수 있다.
	 */
	
	public class BorderPanel extends JPanel {   // 내부클래스
		
		public BorderPanel(String title, Color c) { //매개변수있는 생성자 만듬
			setBackground(c); // 배경색 지정
			JLabel label = new JLabel(title);
			add(label); // 현재 JPanel 객체에 추가
		}
	}

	public static void main(String[] args) {
		new BorderLayoutTest(500,500,"Border LayoutTest").setVisible(true); // setVisible 마지막에 함

	}

}
