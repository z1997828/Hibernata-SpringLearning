package ch02._03_anno._04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("notebook")
//@PropertySource("ch02/_03_anno/_04/propertyFile.properties")
public class NoteBook implements Computer {
	
	// 使用SpEL的語法取出定義在propertyFile.properties中，key為 brandname 所對應的值
	// 會被注入到String brand來
	@Value("${brandname}") 
	String brand;
	
	@Value("${price}") 
    Integer price;
	
	@Value("${weight}") 
    Double weight;
	
	@Value("${size}")
	Double size;
	
	public NoteBook() { 	
	}
	
	@Override
	public String getDescription() {
		return String.format("廠牌:%-6s 價格=%6d 重量:%5.1f公斤  尺寸:%5.1f寸 \n", 
				brand, price, weight, size);
	}
}
