package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter 
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	private String productId;
	private String pname;
	private Integer unitprice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private String condition;
	private String filename;
	private int quantity;
	

	public Product(String productId, String pname, Integer unitprice, String description,
			String category, String manufacturer, long unitsInStock, String condition, String filename) {
		this.productId = productId;
		this.pname = pname;
		this.unitprice = unitprice;
		this.description = description;
		this.category = category;
		this.manufacturer = manufacturer;
		this.unitsInStock = unitsInStock;
		this.condition = condition;
		this.filename = filename;
	}
}
