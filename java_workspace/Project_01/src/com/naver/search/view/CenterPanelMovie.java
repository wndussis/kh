package com.naver.search.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.naver.search.controller.NaverMovieService;
import com.naver.search.model.vo.Book;
import com.naver.search.model.vo.Movie;


/**
 * CenterPanelMovie를 만드는 클래스
 * 
 * <필드>
 * saveKeyword : String
 * indexBtn : int
 * genre : int
 * parent : JFrame
 * col : Color
 * 
 * viewPanel : JPanel
 * gBag : GridBagLayout
 * service : NaverMovieService
 * 
 * <클래스>
 * CenterPanelMovie(String s)
 * >> 검색값이 없을 시 centerPanel에 표시할 생성자
 * CenterPanelMovie(JFrame parent, String keyword, int genre, int idx)
 * >> CenterPanelMovie에 들어갈 패널, 아이템, 액션리스너 등을 담당하는 생성자
 * 
 * <메소드>
 * insertCPanelContext(JPanel p, List<Movie> bList, int idx)
 * >> 패널, mlist, idx를 받아 centerPanel안에 들어가는 작은 cPanel꾸미는 기능을 하는 메소드
 */
public class CenterPanelMovie extends JPanel {

	private String saveKeyword;
	private int indexBtn = 1;
	private int genre;
	private JFrame parent;
	private Color col = new Color(120, 255, 0);

	JPanel viewPanel;
	GridBagLayout gBag;
	NaverMovieService service = new NaverMovieService();

	// 검색 값이 없을 때 보여주기용 생성자
	public CenterPanelMovie(String s) {

		setLayout(new BorderLayout());
		setBackground(Color.white);

		JLabel centerLabel = new JLabel();
		centerLabel.setText(s);
		centerLabel.setHorizontalAlignment(JLabel.CENTER);
		add(centerLabel);

	}

	// 실제 검색시 생성되는 생성자
	public CenterPanelMovie(JFrame parent, String keyword, int genre, int idx) {

		// 값 받아서 저장
		this.parent = parent;
		this.saveKeyword = keyword;
		this.genre = genre;

		// centerPanel의 레이아웃 세팅
		setLayout(new BorderLayout());

		// centerPanel에 두개의 패널 생성 : viewPanel, buttonPanel
		viewPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		// 패널들에 색 지정 : viewPanel = 하양, buttonPanel = 필드값에 지정한 색(네이버 초록)
		viewPanel.setBackground(Color.white);
		buttonPanel.setBackground(col);

		// 각 패널 레이아웃 세팅 : viewPanel = grid, buttonPanel = flow
		viewPanel.setLayout(new GridLayout(1, 4));
		buttonPanel.setLayout(new FlowLayout());

		// 센터 패널
		JPanel[] cPanel = { new JPanel(), new JPanel(), new JPanel(), new JPanel() };
		List<Movie> mList = service.searchMovie(keyword, 4, 1 + ((indexBtn - 1) * 4), genre);

		// 버튼 갯수 설정 : 리스트에 받아오는 값 개수 100개 지정 후 4개씩 나눠서 페이지 번호 정해줌
		int btnNumber = 0;
		List<Movie> btnList = service.searchMovie(keyword, 100, 1 + ((indexBtn - 1) * 4), genre);
		if ((btnList.size() % 4 == 0)) {
			btnNumber = (btnList.size() / 4);
		} else {
			System.out.println(btnList.size() / 4);
			btnNumber = (btnList.size() / 4) + 1;
		}

		// 각각의 cPanel에 내용 삽입 및 배치
		for (int i = 0; i < cPanel.length; i++) {
			// 매개변수 : cPanel, bList, bList의 인덱스(초기값=0)
			insertCPanelContext(cPanel[i], mList, idx + i);
			cPanel[i].setBackground(Color.white);
			viewPanel.add(cPanel[i]);
		}

		// 실제 버튼 생성
		List<JButton> btn = new ArrayList<JButton>();
		for (int i = 0; i < btnNumber; i++) {
			String num = Integer.toString(i + 1);
			btn.add(new JButton(num));
		}

		// 각 버튼을 눌렀을 때 패널교체
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				indexBtn = Integer.parseInt(((JButton) e.getSource()).getText());

				CenterPanelMovie.this.remove(viewPanel);

				viewPanel = new JPanel();
				CenterPanelMovie.this.add(viewPanel);

				viewPanel.setBackground(Color.white);
				viewPanel.setLayout(new GridLayout(1, 4));

				JPanel[] cPanel = { new JPanel(), new JPanel(), new JPanel(), new JPanel() };

				List<Movie> mList = service.searchMovie(saveKeyword, 4, (1 + ((indexBtn - 1) * 4)), genre);

				// 각각의 cPanel에 내용 삽입 및 배치
				for (int i = 0; i < cPanel.length; i++) {
					// 매개변수 : cPanel, bList, bList의 인덱스(초기값=0)
					insertCPanelContext(cPanel[i], mList, idx + i);
					cPanel[i].setBackground(Color.white);
					viewPanel.add(cPanel[i]);
				}

				parent.revalidate();
				parent.repaint();
			}
		};

		// 버튼의 액션 설정 및 꾸며주기
		for (int i = 0; i < btn.size(); i++) {
			btn.get(i).addActionListener(listener);
			btn.get(i).setBackground(col);
			btn.get(i).setForeground(Color.white);
			btn.get(i).setBorderPainted(false);
		}

		// buttonPanel에 만든 버튼들 넣어주기
		for (int i = 0; i < btn.size(); i++) {
			buttonPanel.add(btn.get(i));
		}

		// viewPanel, buttonPanel을 위치시켜 centerPanel에 넣어주기
		add(viewPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

	}

	// cPanel에 검색결과 데이터 넣는 메소드
	public void insertCPanelContext(JPanel p, List<Movie> mList, int idx) {

		// 패널, mlist, idx를 받아 cPanel꾸미는 기능
		// mlist가 부족할 시 패널을 비도록 설정하기 위해 try~catch문 작성 후 기능 코드 삽입
		try {

			// 패널에 패딩 상하좌우 10씩 넣기
			p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

			Image image = null;
			URL url = null;
			try {
				url = new URL(mList.get(idx).getImage());
				image = ImageIO.read(url);

			} catch (IOException e) {
				//이미지가 없은 항목일 경우 그냥 삭제됐다고 표현
				p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

				p.add(Box.createVerticalStrut(150)); // 세로 100인 빈 컴포넌트 삽입
				JLabel noLabel = new JLabel("삭제된 항목");
				p.add(noLabel);
			}

			JLabel imageLabel = new JLabel(new ImageIcon(image));
			// <b> </b> 삭제
			JLabel titleLabel = new JLabel((mList.get(idx).getTitle().replaceAll("<b>", "")).replaceAll("</b>", ""));
			JLabel directorLabel = new JLabel("감독 : " + mList.get(idx).getDirector());
			JLabel actorLabel = new JLabel("배우 : " + mList.get(idx).getActor());
			JLabel userRatingLabel = new JLabel("별점 : " + mList.get(idx).getUserRating());

			// BoxLayout을 써서 라벨을 세로정렬
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

			p.add(Box.createVerticalStrut(30)); // 세로 30인 빈 컴포넌트 삽입
			p.add(imageLabel);
			p.add(Box.createVerticalStrut(20));
			p.add(titleLabel);
			p.add(Box.createVerticalStrut(15));
			p.add(directorLabel);
			p.add(actorLabel);
			p.add(userRatingLabel);
			p.add(Box.createVerticalStrut(15));

		} catch (Exception e) {

		}

	}

}
