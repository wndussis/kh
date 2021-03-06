package kh.java.gui.util;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kh.java.gui.swing.change.panel.CustomPanel;


public class MyUtil {

	public static void init(JFrame f , int w, int h, String title) {
		f.setTitle(title);
		f.setSize(w,h);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public static void chanegePanel(JFrame parent, CustomPanel current, JPanel next) {
		parent.remove(current);
		parent.add(next);
		
		parent.revalidate(); // revalidate -> 컨테이너 하위 계층구조를 새로고침 하는기능
		parent.repaint(); // repaint -> 화면 다시 그리기 메소드
		
	}

}
