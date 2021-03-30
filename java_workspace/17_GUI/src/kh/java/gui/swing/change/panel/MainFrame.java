package kh.java.gui.swing.change.panel;

import java.awt.Color;

import javax.swing.JFrame;

import kh.java.gui.util.MyUtil;

public class MainFrame extends JFrame {
	
	// public static이니까 외부에서 접근가능
	public static CustomPanel[] panels = new CustomPanel[3];  
	
	public MainFrame(int w, int h, String title) {
		MyUtil.init(this, w, h, title);
		
		//panels 객체 할당
		panels[0] = new CustomPanel(this, Color. green, "panel0");
		panels[1] = new CustomPanel(this, Color.BLUE, "panel1");
		panels[2] = new CustomPanel(this, Color.MAGENTA, "panel2");
		
		add(panels[0]); // 시작페이지  , 0번지 부터니까 
		
		
	}

}
