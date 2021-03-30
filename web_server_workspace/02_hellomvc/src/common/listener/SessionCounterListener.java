package common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCounterListener
 *
 */
@WebListener
public class SessionCounterListener implements HttpSessionListener {
	
	private static int activeSessions; // 힙 공간에 만들어진 인스턴스변수,전역변수는 초기화 필요없음
   
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         activeSessions++;
         System.out.println("세션 생성! : 현재 세션수는 [" + activeSessions + "]개 입니다.");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        if(activeSessions > 0) activeSessions--;
        System.out.println("세션 해제! : 현재 세션수는 [" + activeSessions + "]개 입니다.");
    }
	
}
