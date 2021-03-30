package kh.java.inherit.product.model.vo;

public class SmartPhone extends Product {
	
	private String os;
	private String carrier;
	
	public SmartPhone() {}  // 기본 생성자 만듬
		
	
	
	public SmartPhone(String brand, String productName,int price,
			String os, String carrier) { //파라미터 생성자 만듬
			
	//부모 생성자 호출
		
	super(brand , productName, price); // 아래 18,19,20 줄 대신 이거 사용하면 좋음
//  setBrand(brand);
//	setProductName(productName);
//	setPrice(price);

	this.os = os;
	this.carrier = carrier;		
	

}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	public String getSmartPhoneInfo() {
        return getProductInfo()+" , "+os+"  ,"+carrier;
    }
    
}


