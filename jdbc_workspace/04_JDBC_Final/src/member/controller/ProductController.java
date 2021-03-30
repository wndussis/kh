package member.controller;

import java.util.List;

import member.model.exception.ProductException;
import member.model.service.ProductService;
import member.model.vo.Product;
import member.view.ProductMenu;

public class ProductController{
	//필드로 has a  관계 맺음 -> ProductService의 메소드를 ProductController에서 호출할수 있도록 구조화한것.
	private ProductService productService = new ProductService();

	public List<Product> selectAll() {
		List<Product> list = null;
		try {
			list = productService.selectAll();
		} catch(ProductException e) {
			//서버로깅
			//관리자 이메일 알림
			new ProductMenu().displayError(e.getMessage() + " : 관리자에게 문의하세요");
		}
		return list;
	}
	
	public int insertProduct(Product m) {
		return productService.insertMember(m);
	}

	public Product selectOne(String memberId) {
		return productService.selectOneMember(memberId); 
	}

	public int deleteProduct(String memberId) {
		return productService.deleteMember(memberId);
	}
	
	public int updateProduct(Product m) {
		return productService.updateMember(m);
	}
	
	public List<Product> selectByName(String memberName) {
		return productService.selectByName(memberName);
	}
		
		

	
}
