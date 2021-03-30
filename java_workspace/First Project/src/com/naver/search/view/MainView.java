package com.naver.search.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.naver.search.util.MyUtil;

public class MainView extends JFrame {

	private JPanel panel = new JPanel();
	public CenterPanelBook centerPanelB = new CenterPanelBook("검색어를 입력 후 버튼을 눌러주세요.");
	public CenterPanelMovie centerPanelM = new CenterPanelMovie("검색어를 입력 후 버튼을 눌러주세요.");

	public MainView() {
	}

	public MainView(int w, int h, String title) {
		MyUtil.init(this, w, h, title);

		// 헤더 패널
		HeaderPanel headerPanel = new HeaderPanel(this, centerPanelB, centerPanelM);

		// 센터 패널 : 필드로 선언

		add(headerPanel, BorderLayout.NORTH);
		add(centerPanelB, BorderLayout.CENTER);

	}

	public class BorderPanel extends JPanel {

		public BorderPanel(String title, Color c) {
			setBackground(c);
			JLabel label = new JLabel(title);
			add(label);
		}
	}

}