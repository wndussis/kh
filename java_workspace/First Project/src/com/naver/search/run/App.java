package com.naver.search.run;

import java.util.List;

import javax.swing.JFrame;

import com.naver.search.controller.NaverBookService;
import com.naver.search.controller.NaverMovieService;
import com.naver.search.model.vo.Book;
import com.naver.search.model.vo.Movie;
import com.naver.search.view.MainView;

public class App extends JFrame {
	
	public static void main(String[] args) {
		
		new MainView(500, 450, "NAVER SEARCH").setVisible(true);
		
	}
}


