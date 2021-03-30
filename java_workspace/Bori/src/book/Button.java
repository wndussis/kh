package book;

import java.awt.Color;

import javax.swing.JFrame;

public class Button extends JFrame {
	
public static Switch[] panels = new Switch[2];
	
	public Button(int w, int h, String title) {
		MyUtil.init(this, w, h, title);
		
		//panel 객체 할당
				panels[0] = new Switch(this,Color.BLUE,"panels0");
				panels[1] = new Switch(this,Color.green,"panels1");
				
				add(panels[0]);  //시작페이지
			}

	

}
