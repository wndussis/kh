package book;

import java.awt.Color;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public static SwitchScreen[] panels = new SwitchScreen[2];
	
	public MainFrame(int w, int h, String title) {
		MyUtil.init(this, w, h, title);
		
		//panel 객체 할당
		panels[0] = new SwitchScreen(this,Color.BLUE,"panels0");
		panels[1] = new SwitchScreen(this,Color.green,"panels1");
		
		add(panels[0]);  //시작페이지
	}

}
