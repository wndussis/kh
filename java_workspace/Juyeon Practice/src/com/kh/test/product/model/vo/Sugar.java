package com.kh.test.product.model.vo;

public class Sugar {
	
	private int productCode;
	private String productName;
	private String type;
	private int weight;
	
	public Sugar() {}
	
	public Sugar(int productCode, String productName,String type,int weight) {
		this.productCode = productCode;
		this.productName = productName;
		this.type = type;
		this.weight = weight;
		
	}

	public Sugar(int i) {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	public void makeProduct() {
		System.out.println("상품코드 :" + productCode + "상품명 : " + productName+
				              "제품 유형 : " + type + " 중량 : " + weight + "kg 설탕을 생산하였습니다.");
	}
	

}
