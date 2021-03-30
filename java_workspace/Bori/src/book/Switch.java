package book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Switch extends JPanel {

	private JFrame parent;

	public Switch(JFrame parent, Color c, String title) {
		this.parent = parent; // 부모객체에 접근하기 위해 미리 필드로 지정

		JPanel linkPanel = new JPanel();
		JButton btn0 = new JButton("1");
		JButton btn1 = new JButton("2");
		linkPanel.add(btn0);
		linkPanel.add(btn1);
		add(linkPanel, BorderLayout.SOUTH);

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(((JButton) e.getSource()).getText());
				System.out.println(index);

			}

		};

		btn0.addActionListener(listener);
		btn1.addActionListener(listener);

	}

}
