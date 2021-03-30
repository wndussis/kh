package member.model.vo;

import java.sql.Date;

/**
 * Vo 는 실제 데이터가 담기는 객체
 * VO객체는 Member테이블의 한 행과 대응한다.
 *
 */

public class Product {
	
	private String productId;
	private String productName;
	private String description;
	private int price; 		//M F
	private int stock;
	private int iono;
	private int amount;
	private Date ioDate;	//java.sql.Date - java.util.Date의 자식클래스
	
	public Product() {
		super();
	
	}

	public Product(String productId, String productName, String description, int price, int stock, int iono, int amount,
			Date ioDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.iono = iono;
		this.amount = amount;
		this.ioDate = ioDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIono() {
		return iono;
	}

	public void setIono(int iono) {
		this.iono = iono;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getIoDate() {
		return ioDate;
	}

	public void setIoDate(Date ioDate) {
		this.ioDate = ioDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", stock=" + stock + ", iono=" + iono + ", amount=" + amount + ", ioDate="
				+ ioDate + "]";
	}

	
	
	
}
