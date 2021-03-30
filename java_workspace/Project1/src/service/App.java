package service;

import model.Book;
import service.NaverBookService;
 
public class App {
    public static void main(String[] args) {
        
        NaverBookService service = new NaverBookService();
        for(Book b : service.searchBook("java", 20, 1))
            System.out.println(b);
    }
}


