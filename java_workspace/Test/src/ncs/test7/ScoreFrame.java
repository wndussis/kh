package ncs.test7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreFrame extends JFrame {
	

	JPanel panel = new JPanel();

	public ScoreFrame(int w, int h, String title) {
		MyUtil.init(this, w, h, title);

		setTitle("문제7");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JLabel label = new JLabel();
		label.setFont(new Font("Serif", Font.BOLD, 70));
		label.setText("점수를 입력하세요");
		add(label);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("자바 : "));
		c.add(new JTextField(10));
		c.add(new JLabel("SQL : "));
		c.add(new JTextField(10));
		c.add(new JLabel("총점 : "));
		c.add(new JTextField(10));
		c.add(new JLabel("평균 : "));
		c.add(new JTextField(10));

		JButton calcbtn = new JButton("계산하기");
		calcbtn.setBounds(350, 300, 200, 100);
		calcbtn.addActionListener(new BtnListener());

		add(calcbtn);

		setVisible(true);
	}

	public class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("총점  :");
			System.out.println("평균  :");

		}

	}

}
