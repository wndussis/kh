package com.naver.search.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.naver.search.util.MyUtil;

/**
 * Frame을 만드는 클래스
 * 
 * <필드>
 * centerPanelB : CenterPanelBook
 *  >> CenterPanelBook 호출
 * centerPanelM : CenterPanelMovie
 *  >> CenterPanelMovie 호출
 * 
 * 
 * <클래스>
 * MainView()
 *  : 호출용 생성자
 * MainView(int w, int h, String title)
 *  : 실제 프레임을 구성하는 생성자, MyUtil에서 기본 프레임 정보를 받고 HeaderPanel, CenterPanelBook, CenterPanelMovie 호출
 * 
 */
public class MainView extends JFrame {

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

}