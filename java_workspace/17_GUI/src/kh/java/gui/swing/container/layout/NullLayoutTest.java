package kh.java.gui.swing.container.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kh.java.gui.util.MyUtil;

public class NullLayoutTest extends JFrame{
	
	private JTextField id;   //  private 은 내부 클래스에서도 접근가능 !!!
	private JPasswordField pwd;

	public NullLayoutTest(int w, int h, String title) {
		MyUtil.init(this, w, h, title);
		
		//layout 무효화
		setLayout(null);
		
		JLabel labelId = new JLabel("아이디 : ");
	    labelId.setBounds(50,100,60,50);
	    
	    id = new JTextField();
	    id.setBounds(110,100,200,50);
	    
	    JLabel labelPwd = new JLabel("비번 : ");
	    labelPwd.setBounds(50,160,60,50);
	    
	    pwd = new JPasswordField();
	    pwd.setBounds(110,160,200,50);
	    
	    JButton btn  = new JButton("로그인");
	    btn.setBounds(330,100,100,110);
	    
	    // 사용자가 로그인버튼을 클릭했을때 
	    //입력한 아이디 , 비밀번호값을 가져오기 
	    // 사용자Event  + EventHandling  // 사용자가 하는 모든것들이 Event 라고생각해라
	    // 1. 이벤트 처리객체생성(클래스 생성)
	    //2. btn 컴포넌트와 연결(binding)
	    
	    btn.addActionListener(new LoginListener());
	    
	    
	    
	    add(labelId);
	    add(id);
	    add(labelPwd);
	    add(pwd);
	    add(btn);
	  
	}
/**
 * 
 * JButton용 action event handler클래스 작성
 * 
 * event handler = event listener
 * 
 */
	public class LoginListener implements ActionListener {
		/**
		 *  JButton의 ActionEvent가 발생시 자동 호출되는 메소드 , 아래에 있는거
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼을 클릭하셨습니다.");
			//사용자 입력 id , password 가져오기
			System.out.println("id :  " + id.getText());
			System.out.println("pwd : " + new String(pwd.getPassword())); //char 배열로 가져온다음에 String객체에 전달한것
			
			
			
		}
	}
	public static void main(String[] args) {
		new NullLayoutTest(500,500,"로그인").setVisible(true);
	}

}
