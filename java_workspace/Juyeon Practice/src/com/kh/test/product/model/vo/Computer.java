package com.kh.test.product.model.vo;

public class Computer {

	private int productCode;
	private String productName;
	private int serialNumber;
	
	public Computer() {}
	
	public Computer(int productCode,String productName,int serialNumber) {
		this.productCode = productCode;
		this.productName = productName;
		this.serialNumber = serialNumber;
		

	}



	public Computer(String string) {
		// TODO Auto-generated constructor stub
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public void makeProduct() {
		System.out.println("상품코드 :" + productCode + "상품명 : "+ productName+
				               "제품번호 : "+ serialNumber + "컴퓨터를 생산하였습니다.");
	}
}
