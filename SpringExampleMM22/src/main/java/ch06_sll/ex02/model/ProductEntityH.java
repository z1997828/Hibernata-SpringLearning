package ch06_sll.ex02.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ch06_sll_ex02_ProductH")
@Table(name = "ch04_Product")
public class ProductEntityH {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String  name;
	private Integer stock;
	
	@ManyToOne
	@JoinColumn(name="FK_category", foreignKey=@ForeignKey(name = "fkc_pro_cat"))
	CategoryH category;

	public ProductEntityH() {
		super();
	}

	public ProductEntityH(Integer productId, String name, Integer stock, CategoryH category) {
		super();
		this.productId = productId;
		this.name = name;
		this.stock = stock;
		this.category = category;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public CategoryH getCategory() {
		return category;
	}

	public void setCategory(CategoryH category) {
		this.category = category;
	}
}
