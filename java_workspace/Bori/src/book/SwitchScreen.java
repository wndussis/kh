package book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;





public class SwitchScreen extends JFrame  {
	
	private JFrame parent;

	
	
	public SwitchScreen(MainFrame mainFrame, Color blue, String title) {
		
		
		JPanel linkPanel = new JPanel();
		
		 // 버튼 2개 만들기
		
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		
		linkPanel.add(btn1);
		linkPanel.add(btn2);
		add(linkPanel, BorderLayout.SOUTH);
		
		// 각 버튼별 패널교체하기
				ActionListener listener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						int index = Integer.parseInt(((JButton)e.getSource()).getText());
						System.out.println(index);
						
					}
					
				};
				
				btn1.addActionListener(listener);
				btn2.addActionListener(listener);
		
	}
}