package ch04.service;

import java.util.Map;

import ch04.model.BookBean;

public interface BookService {
	// 依bookId來查詢單筆記錄
	BookBean getBook(Long bookId);
	
	Map<Long, BookBean> getAllBooks();
}
