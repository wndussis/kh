package com.naver.search.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.naver.search.controller.NaverBookService;

public class HeaderPanel extends JPanel {

	MainView mainView = new MainView();
	NaverBookService service = new NaverBookService();
	CenterPanelBook currentNewBook;
	CenterPanelMovie currentNewMovie;

	private JFrame parent;
	private Color col =new Color(120,255,0);

	JComboBox<String> combo;
	JComboBox<String> comboGenre;
	JTextField txtField;

	private List<String> searchList = new ArrayList<>();
	private String[] select = { "도서", "영화" };
	private String[] selectGenre = { "드라마", "판타지", "서부", "공포", "로맨스", "모험", "스릴러", "느와르", "컬트", "다큐멘터리", "코미디", "가족",
			"미스터리", "전쟁", "애니메이션", "범죄", "뮤지컬", "SF", "액션", "무협", "에로", "서스팬스", "서사", "블랙코미디", "실험", "영화카툰", "영화음악",
			"영화패러디포스터" };

	public HeaderPanel() {
	}

	public HeaderPanel(JFrame parent, CenterPanelBook centerPanelB, CenterPanelMovie centerPanelM) {

		this.parent = parent;

		setLayout(new BorderLayout());

		// 패널 두개 호출 :
		JPanel searchPanel = new JPanel();
		JPanel resultPanel = new JPanel();

		searchPanel.setBackground(col);
		resultPanel.setBackground(col);

		JLabel topLabel = new JLabel("책찾아?");
		combo = new JComboBox<String>(select);
		comboGenre = new JComboBox<String>(selectGenre);
		txtField = new JTextField(10);
		JButton searchBtn = new JButton("검색");

		JLabel text = new JLabel("검색기록");

		// 검색기록 저장 : 버튼을 누르면 기록이 저장된다. 10개 이상 채워지면 지워지고 다시 채운다.
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// textField에 쓴 검색 정보 저장
				String saveSearch = txtField.getText();
				searchList.add(saveSearch);

				int count = 0;
				String searchRecode = "";
				for (int i = 0; i < searchList.size(); i++) {
					searchRecode += searchList.get(i);
					text.setText(searchRecode);

					count++;

					if (count == 10) {
						searchList.clear();
						count = 0;
					} else {
						searchRecode += ", ";
					}
				}

				// 콤보박스 선택에 따른 결과 출력
				String selectTag = combo.getSelectedItem().toString();
				String selectGenreTag = comboGenre.getSelectedItem().toString();

				if (selectTag.equals("도서")) {
					// 텍스트 필드의 검색 입력값을 mainView에 넘겨줌
					BookPanelWriter(parent, centerPanelB, centerPanelM);

				} else if (selectTag.equals("영화")) {
					for (int i = 0; i < selectGenre.length; i++) {
						if (selectGenre[i].equals(selectGenreTag)) {
							// 장르 콤보 박스의 값을 mainView에 넘겨줌
							MoviePanelWriter(parent, centerPanelB, centerPanelM, i+1);
						}
					}
				}

			}

		});
		
		searchPanel.add(topLabel);
		searchPanel.add(combo);
		searchPanel.add(comboGenre);
		searchPanel.add(txtField);
		searchPanel.add(searchBtn);

		resultPanel.add(text);

		add(searchPanel, BorderLayout.CENTER);
		add(resultPanel, BorderLayout.SOUTH);

	}

	public void BookPanelWriter(JFrame parent, CenterPanelBook centerPanelB, CenterPanelMovie centerPanelM) {

		parent.remove(centerPanelB);
		parent.remove(centerPanelM);

		if (currentNewBook != null) {
			parent.remove(currentNewBook);
		}
		
		if (currentNewMovie != null) {
			parent.remove(currentNewMovie);
		}
		
		currentNewBook = new CenterPanelBook(parent, txtField.getText(), 0, 0);
		parent.add(currentNewBook);

		parent.revalidate();
		parent.repaint();
	}
	

	public void MoviePanelWriter(JFrame parent, CenterPanelBook centerPanelB, CenterPanelMovie centerPanelM, int genre) {

		parent.remove(centerPanelB);
		parent.remove(centerPanelM);

		if (currentNewBook != null) {
			parent.remove(currentNewBook);
		}
		
		if (currentNewMovie != null) {
			parent.remove(currentNewMovie);
		}
		
		currentNewMovie = new CenterPanelMovie(parent, txtField.getText(), genre, 0);
		parent.add(currentNewMovie);

		parent.revalidate();
		parent.repaint();
	}
	
	

	// 테스터용 코드(삭제는 가능한데 아까워서 남겨둠)
//	public void searchBook(String title) {
//
//		NaverBookService service = new NaverBookService();
//		for (Book b : service.searchBook(title, 1, 1))
//			System.out.println(b);
//
//	}
//
//	public void searchMovie(String title, int genreNum) {
//
//		NaverMovieService serviceM = new NaverMovieService();
//		for (Movie m : serviceM.searchMovie(title, 1, 1, genreNum))
//			System.out.println(m);
//
//	}

}