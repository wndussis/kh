package com.naver.search.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.border.LineBorder;

import com.naver.search.controller.NaverBookService;

/**
 * HeaderPanel을 만드는 클래스
 * 
 * <필드>
 *  service : NaverBookService
 *  currentNewBook : CenterPanelBook
 * 	currentNewMovie : CenterPanelMovie >>>> 전부 호출용 필드
 * 
 * parent : JFrame
 *  >> MainView의 주소값을 가져와 저장하기 위한 용도 
 * col : Color 
 * 	>> 네이버 컬러 저장용
 * 
 * combo : JComboBox 
 *  >> 도서, 영화 선택 콤보박스 
 * comboGenre : JComboBox
 *  >> 영화 장르 선택 콤보박스
 * txtField : JTextField
 *  >> 검색 입력값
 * 
 * searchList : List<String>
 *  >> 검색 기록 저장용 
 *  select : String[]
 *   >> 도서, 영화
 * selectGenre : String[]
 *  >> 영화 장르 이름 저장
 * 
 * <클래스> 
 * HeaderPanel()
 *  >> 호출용 생성자
 *   HeaderPanel(JFrame parent, CenterPanelBook centerPanelB, CenterPanelMovie centerPanelM)
 *  >> HeaderPanel에 들어갈 패널과 아이템들, 액션리스너를 가진 생성자, HeaderPanel는 여기에서 만들어진다.
 * 
 * <메소드> 
 * BookPanelWriter(JFrame parent, CenterPanelBook centerPanelB, CenterPanelMovie centerPanelM)
 * >> 콤보박스 '도서' 선택시 호출, 검색값을 통해 api를 가져와 보여준다.
 * MoviePanelWriter(JFrame parent, CenterPanelBook centerPanelB, CenterPanelMovie centerPanelM, int genre)
 * >> 콤보박스 '영화', '장르' 선택시 호출, 검색값을 통해 api를 가져와 보여준다.
 * 
 */
public class HeaderPanel extends JPanel {

	NaverBookService service = new NaverBookService();
	CenterPanelBook currentNewBook;
	CenterPanelMovie currentNewMovie;

	private JFrame parent;
	private Color col = new Color(120, 220, 0);
	private Font font = new Font(null, Font.BOLD, 14);

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

		// MainView의 주소값을 가져와 저장하기 위한 용도
		this.parent = parent;

		// HeaderPanel의 레이아웃 세팅
		setLayout(new BorderLayout());

		// 패널 두개 호출 : searchPanel는 검색하는 텍스트필드, 버튼을 넣을 용도 / resultPanel는 검색 기록을 보여줄 용도
		JPanel topPanel = new JPanel();
		JPanel searchPanel = new JPanel();
		JPanel resultPanel = new JPanel();

		topPanel.setBackground(col);
		searchPanel.setBackground(col);
		resultPanel.setBackground(Color.white);
		resultPanel.setBorder(new LineBorder(col, 3));

		// HeaderPanel에 들어갈 아이템
		JLabel topLabel = new JLabel("NAVER SEARCH");
		combo = new JComboBox<String>(select);
		comboGenre = new JComboBox<String>(selectGenre);
		txtField = new JTextField(10);
		JButton searchBtn = new JButton("검색");

		// 검색 기록 표시용 라벨
		JLabel text = new JLabel("검색기록");
		
		//아이템 꾸미기
		topLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		topLabel.setForeground(Color.white);
		searchBtn.setFont(font);
		searchBtn.setBackground(new Color(120, 170, 0));
		searchBtn.setForeground(Color.white);
		searchBtn.setBorderPainted(false);
		combo.setFont(font);
		comboGenre.setFont(font);
		txtField.setFont(font);
		text.setFont(new Font(null, Font.BOLD, 18));

		
		// 검색기록 저장 : 검색 버튼을 누르면 기록이 저장된다. 10개 이상 채워지면 지워지고 다시 채운다.
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// textField에 쓴 검색 정보를 searchList에 하나씩 저장
				String saveSearch = txtField.getText();
				searchList.add(saveSearch);

				int count = 0;
				String searchRecode = "";
				// 저장했던 검색 기록들을 하나씩 더해서 보여줌(단, 10개가 넘어가면 삭제)
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

				// 콤보박스가 '도서'일 경우
				if (selectTag.equals("도서")) {
					// 텍스트 필드의 '검색 입력값'을 mainView에 넘겨줌
					BookPanelWriter(parent, centerPanelB, centerPanelM);

				} // 콤보박스가 '영화'일 경우
				else if (selectTag.equals("영화")) {
					for (int i = 0; i < selectGenre.length; i++) {
						// 선택한 장르 콤보박스에서 값이 일치하는 배열값을 찾기위한 기능
						if (selectGenre[i].equals(selectGenreTag)) {
							// 텍스트 필드의 '검색 입력값'과 장르 콤보 박스의 '숫자값'을 mainView에 넘겨줌
							MoviePanelWriter(parent, centerPanelB, centerPanelM, i + 1);
						}
					}
				}

			}

		});

		// 각 패널에 아이템을 add시켜주기
		topPanel.add(topLabel);
		searchPanel.add(combo);
		searchPanel.add(comboGenre);
		searchPanel.add(txtField);
		searchPanel.add(searchBtn);

		resultPanel.add(text);

		// 아이템이 들어간 searchPanel, resultPanel패널을 HeaderPanel에 add시켜준다
		add(topPanel, BorderLayout.NORTH);
		add(searchPanel, BorderLayout.CENTER);
		add(resultPanel, BorderLayout.SOUTH);

	}

	// 콤보상자에서 '도서'를 택했을 시, 이 메소드 호출
	public void BookPanelWriter(JFrame parent, CenterPanelBook centerPanelB, CenterPanelMovie centerPanelM) {

		// frame에서 그리고 있는 centerPanel의 내용 지우기
		parent.remove(centerPanelB);
		parent.remove(centerPanelM);

		// 검색했던 결과를 centerPanel에 띄우고 있을 경우 지우기
		if (currentNewBook != null) {
			parent.remove(currentNewBook);
		}

		if (currentNewMovie != null) {
			parent.remove(currentNewMovie);
		}

		// 새로 검색한 값으로 다시 centerPanel에 띄워주기
		currentNewBook = new CenterPanelBook(parent, txtField.getText(), 0, 0);
		parent.add(currentNewBook);

		parent.revalidate();
		parent.repaint();
	}

	// 콤보상자에서 '영화'를 택했을 시, 이 메소드 호출
	public void MoviePanelWriter(JFrame parent, CenterPanelBook centerPanelB, CenterPanelMovie centerPanelM,
			int genre) {

		// frame에서 그리고 있는 centerPanel의 내용 지우기
		parent.remove(centerPanelB);
		parent.remove(centerPanelM);

		// 검색했던 결과를 centerPanel에 띄우고 있을 경우 지우기
		if (currentNewBook != null) {
			parent.remove(currentNewBook);
		}

		if (currentNewMovie != null) {
			parent.remove(currentNewMovie);
		}

		// 새로 검색한 값으로 다시 centerPanel에 띄워주기
		currentNewMovie = new CenterPanelMovie(parent, txtField.getText(), genre, 0);
		parent.add(currentNewMovie);

		parent.revalidate();
		parent.repaint();
	}

	// 테스터용 코드(삭제 가능)
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