package run;

import javax.swing.JFrame;

import book.MainView;

public class App extends JFrame {
	
	public static void main(String[] args) {
		new MainView(500,500,"책 찾아?").setVisible(true);
	
	}

}
