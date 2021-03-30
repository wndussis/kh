package kh.java.gui.swing.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import kh.java.gui.util.MyUtil;

public class RadioButtonTest extends JFrame {
	
	JLabel resultLabel;  // 필드로 선언

	public RadioButtonTest(int w, int h, String title) {
		MyUtil.init(this, w, h, title);
		
		topPanel();
		sizePanel();
		resultPanel();
		
		
		
	}

	private void topPanel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("커피 사이즈를 선택하세요.");
		panel.add(label);
		add(panel, BorderLayout.NORTH);
		
		
	}

	private void sizePanel() {
		JPanel panel = new JPanel();
		JRadioButton small = new JRadioButton("small");
		JRadioButton medium = new JRadioButton("mediuml");
		JRadioButton large = new JRadioButton("large");
		
		//단일 선택을 위해서 그루핑 필수 !!!  -> 버튼 하나만 선택할수있게
		ButtonGroup group = new ButtonGroup();
		group.add(small);
		group.add(medium);
		group.add(large);
		
		//이벤트 핸들러 설치 , 각각의 컴포넌트마다 추가해야함
		ActionListener listener = new ActionListener() {   // import 하고 오버라이딩

			@Override
			public void actionPerformed(ActionEvent e) {
				// 이벤트 발생객체 알아내기
				JRadioButton btn = (JRadioButton)e.getSource(); //getSouse 로 알아낸 다음에 내용가져옴
				
				resultLabel.setText("[" + btn.getText() + "]를 선택하셨습니다.");
				
			}
			
		};
		small.addActionListener(listener);
	    medium.addActionListener(listener);
		large.addActionListener(listener);
		
		
		panel.add(small);
		panel.add(medium);
		panel.add(large);
		add(panel);
		
	}

	private void resultPanel() {
		JPanel panel = new JPanel();
	    this.resultLabel = new JLabel("사이즈를 선택하세요.");
	    panel.add(resultLabel); //필드에 값대입
	    add(panel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new RadioButtonTest(300,200, "라디오 버튼").setVisible(true);
	}

}
