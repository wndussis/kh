package book;

public class Book  {
	private String title;
	private String author;
	private String price;
	private String discountprice;
	private String publisher;
	private String pubdate;
	
	
	public Book() {
		super();
	}


	public Book(String title, String author, String price, String discountprice, String publisher, String pubdate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.discountprice = discountprice;
		this.publisher = publisher;
		this.pubdate = pubdate;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getDiscountprice() {
		return discountprice;
	}


	public void setDiscountprice(String discountprice) {
		this.discountprice = discountprice;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getPubdate() {
		return pubdate;
	}


	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", discountprice=" + discountprice
				+ ", publisher=" + publisher + ", pubdate=" + pubdate + "]";
	}
	
	
	
	

   
}