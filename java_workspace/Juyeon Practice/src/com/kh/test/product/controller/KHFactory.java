package com.kh.test.product.controller;

import com.kh.test.product.model.vo.Computer;
import com.kh.test.product.model.vo.Sugar;

public class KHFactory {

	public static void main(String[] args) {
		
		Computer[] arr = new Computer[3];
		
		arr[0] = new Computer(123456);
		arr[1] = new Computer(112233);
		arr[2] = new Computer(111333);
		
		for(Computer c : arr) {
			c.makeProduct();
		}
		
		Sugar[] arr1 = new Sugar[2];
		
		arr[0] = new Sugar(5);
		arr[1] = new Sugar(2);
		
		for(Sugar s : arr) {
			s.makeProduct();
		}
		


	}

}
