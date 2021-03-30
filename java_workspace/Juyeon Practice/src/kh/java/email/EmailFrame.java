package kh.java.email;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmailFrame extends JFrame {
	
	private EmailController emailController = new EmailController();
	private JTextArea textArea;
	
	public EmailFrame(int w, int h, String title) {
		MyUtil.init(this,w,h,title);
		
		JPanel inputPanel = new JPanel();
		JTextField inputEmail = new JTextField(10);
		JButton submitBtn = new JButton("등록");
		inputPanel.add(inputEmail);
		inputPanel.add(submitBtn);
		
		//제출 이벤트 핸들러
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = inputEmail.getText();
				Email email = new Email(s);
				emailController.insertEmail(email);
				
				
			}
			
		}); //// 이 부분 이해안감 강의 다시보기
	}

}
