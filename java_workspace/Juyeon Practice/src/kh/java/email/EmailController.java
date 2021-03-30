package kh.java.email;

public class EmailController {
	
	private EmailIO emailIO = new EmailIO();
	
	public void insertEmail(Email email) {
		emailIO.insertEmail(email);
	}
	
	public List<Email> loadEmailList() {
		return emailIO.loadEmailList();
	}

}
