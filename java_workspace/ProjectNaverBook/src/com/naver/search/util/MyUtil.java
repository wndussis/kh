package com.naver.search.util;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.naver.search.view.CenterPanelBook;

import kh.java.gui.swing.change.panel.CustomPanel;
import kh.java.gui.swing.container.layout.BorderLayoutTest;

public class MyUtil {
	public static void init(JFrame f, int w, int h, String title) {
		f.setTitle(title);
		f.setSize(w,h);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
