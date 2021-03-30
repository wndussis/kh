package ncs.test7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreFrame extends JFrame {

	// 필드
	private JTextField JavaScore;
	private JTextField sqlScore;
	private JTextField total;
	private JTextField average;

	private JButton calcBtn;

	// 생성자
	public ScoreFrame() {

		// 프레임 세팅
		setTitle("문제7");  // 제목정하기
		setSize(450, 400); // 창 사이즈 
		setLocationRelativeTo(null); // 스크린 가운데 띄우기
		setResizable(false); // 리사이즈 방지
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기 
		setLayout(new BorderLayout()); // 지금부터 BorderLayout 을 쓸거야!

		// 프레임 내부 패널 세팅
		JPanel main = new JPanel();   
		JPanel subTitle = new JPanel();
		JPanel getScore = new JPanel();
		JPanel btnPanel = new JPanel();
		JPanel setScore = new JPanel();

		// 각 패널을 main패널에 적용
		main.add(subTitle);
		main.add(getScore);
		main.add(btnPanel);
		main.add(setScore);

		// main패널을 프레임에 적용
		main.setLayout(new GridLayout(4, 1));
		add(main);

		// subTitle 세팅
		subTitle.setLayout(new FlowLayout());
		JLabel sub = new JLabel("점수를 입력하세요");
		Font font = new Font(null, Font.BOLD, 45);
		sub.setFont(font);
		subTitle.add(sub);

		// getScore 세팅
		JPanel subGet1 = new JPanel();
		JPanel subGet2 = new JPanel();
		getScore.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
		subGet1.setLayout(new FlowLayout());
		subGet2.setLayout(new FlowLayout());
		JLabel javaLa = new JLabel("자바 :");
		JLabel sqlLa = new JLabel("SQL :");
		JavaScore = new JTextField(10);
		sqlScore = new JTextField(10);
		subGet1.add(javaLa);
		subGet1.add(JavaScore);
		subGet2.add(sqlLa);
		subGet2.add(sqlScore);
		getScore.add(subGet1);
		getScore.add(subGet2);

		// btnPanel 세팅
		btnPanel.setLayout(new FlowLayout());
		calcBtn = new JButton("계산하기");

		ActionHandler ah = new ActionHandler();
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ah.actionPerformed(e);

				main.revalidate();
				main.repaint();
			}
		};
		calcBtn.addActionListener(listener);
		btnPanel.add(calcBtn);

		// setScore 세팅
		JPanel subSet1 = new JPanel();
		JPanel subSet2 = new JPanel();
		setScore.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
		subSet1.setLayout(new FlowLayout());
		subSet2.setLayout(new FlowLayout());
		JLabel tolLa = new JLabel("총점 :");
		JLabel avgLa = new JLabel("평균 :");
		total = new JTextField(10);
		average = new JTextField(10);
		subSet1.add(tolLa);
		subSet1.add(total);
		subSet2.add(avgLa);
		subSet2.add(average);
		setScore.add(subSet1);
		setScore.add(subSet2);

	}

	public class ActionHandler {

		public ActionHandler() {
		}

		public void actionPerformed(ActionEvent event) {
			double sTotal =  (Double.parseDouble(JavaScore.getText()) + Double.parseDouble(sqlScore.getText()));
			double sAverage = (Double.parseDouble(JavaScore.getText()) + Double.parseDouble(sqlScore.getText())) / 2;

			total.setText(Integer.toString(Integer.parseInt(String.valueOf(Math.round(sTotal)))));
			average.setText(Integer.toString(Integer.parseInt(String.valueOf(Math.round(sAverage)))));
		}
	}
}
