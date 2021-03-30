package kh.java.inherit.product.model.vo;

public class TV  extends Product {
	
	private int size;	//인치
	private int channel;
	
	//생성자 자동으로 만들려면 Alt shift s  해서 맨아래에서 두번쨰꺼 superclass 누르면됨
	public TV() {
	
	}
	public TV(String brand, String productName, int price,
			  int size, int channel) {
		super(brand, productName, price);
		this.size = size;
		this.channel = channel;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public String getTVInfo() {
		return getProductInfo() + ", " + size + ", " + channel;
	}
	
	
	
}


    