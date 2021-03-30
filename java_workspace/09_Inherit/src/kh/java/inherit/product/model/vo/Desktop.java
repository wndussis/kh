package kh.java.inherit.product.model.vo;

public class Desktop extends Product {
	
	private String os;   // 캡슐화한 필드
	private String monitor;
	private String keyboard;
	
	public Desktop() {  //기본 생성자 만듬
		
		
	}
	
	/**
	 * brnad , productName,price ,os , monitor, keyboard
	 * 
	 * Desktop d = new Desktop("삼성" , "삼성데탑", "윈도우" , 1_000_000,
	 *                                    "27인치 좋은거","기계식 키보드");
	 */
	public Desktop(String brand, String productName, int price ,
			            String os, String monitor, String keyboard) {   // 파라미터 생성자 만듬
		
//		this.brand = brand;
//		this.productName = productName;
//		this.price = price;
		
		//상속받은 public  메소드는 현재객체 소속인 것처럼 사용가능 set 사용해서
		setBrand(brand); // 앞에 this. 가 생략되어있음
		setProductName(productName);
		setPrice(price);
		
		this.os = os;
		this.monitor = monitor;
		this.keyboard = keyboard;
		
	
		
		
		
				
		
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}
	
	public String getDesktopInfo() {  // 이렇게 해도 되고 아래처럼 리턴처럼 해도 됨
//		return getBrand() + ", "  + getProductName() + "," +getPrice() + "," 
//				+ os + "," + monitor + " , " + keyboard;
//		
		return getProductInfo()
			
				+ " ," + os + "," + monitor + " , " + keyboard;
				
		
	}
	@Override
	public String toString() {
	return super. toString()
			
			+ " ," + os + "," + monitor + " , " + keyboard;
	}

}
