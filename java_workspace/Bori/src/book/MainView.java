package book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.java.gui.util.MyUtil;

public class MainView extends JFrame {
	JFrame parent = this;
	JPanel[] centerPanel = new CenterPanel[2];

	public MainView(int w, int h, String title) {
		MyUtil.init(this, w, h, title);

		NaverBookService service = new NaverBookService();
		int display = 4; // 검색결과 갯수
		int start = 1; // 검색결과 중 출력할 순서 (2 : 2번째결과부터 출력)
		List<Book> bList = service.searchBook("java", display, start);
		List<Book> bList2 = service.searchBook("java", display, start + 4);

		JPanel north = new BorderPanel("책 찾아?", Color.orange);
		JPanel south = new BorderPanel(Color.green);
		south.setLayout(new FlowLayout());
		
		centerPanel[0] = new CenterPanel(bList, 0);
		centerPanel[1] = new CenterPanel(bList2, 0);

		
		south.setLayout(new FlowLayout());
		JButton btn0 = new JButton("1");
		JButton btn1 = new JButton("2");

		south.add(btn0, BorderLayout.SOUTH);
		south.add(btn1, BorderLayout.SOUTH);
		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = Integer.parseInt((((JButton)e.getSource()).getText()));
				System.out.println(idx);
				
				if(idx == 1) //버튼1 클릭 시 첫페이지 출력
					changePanel(parent, centerPanel[1], centerPanel[0]);
				
				else if(idx == 2) //버튼2 클릭 시 두번째 페이지 출력
					changePanel(parent, centerPanel[0], centerPanel[1]);
			}
			
		};
		
		btn0.addActionListener(listener);
		btn1.addActionListener(listener);
		
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(centerPanel[0]);
	}

	public class BorderPanel extends JPanel {

		public BorderPanel(Color c) {
			setBackground(c);
		}

		public BorderPanel(String title, Color c) {
			setBackground(c);
			JLabel label = new JLabel(title);
			add(label);
		}
	}

	public static void main(String[] args) {
		new MainView(800, 500, "Book").setVisible(true);
	}
	
	//MyUtil의 메소드를 가져왔음
	public void changePanel(JFrame main, JPanel current, JPanel next) {
		main.remove(current);
		main.add(next);
		
		main.revalidate();
		main.repaint();
	}

}


}