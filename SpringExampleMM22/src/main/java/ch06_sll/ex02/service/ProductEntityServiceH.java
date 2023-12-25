package ch06_sll.ex02.service;

import java.util.List;

import ch06_sll.ex02.model.ProductEntityH;

public interface ProductEntityServiceH {

	// 新增一筆ProductEntity物件到資料庫
	Object save(ProductEntityH emp);

	ProductEntityH findById(int id);
	// 更新紀錄
	void update(ProductEntityH e);

	// 刪除紀錄
	void delete(int id);

	// 查詢所有紀錄
	List<ProductEntityH> findAll();

}