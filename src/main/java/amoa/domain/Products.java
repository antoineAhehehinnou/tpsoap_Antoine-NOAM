package amoa.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {
	
	
    @XmlElement(name = "product")
    private List<Product> products;
   
    public Products(ArrayList<Product> products){
		this.products = products;
	}
    
	
	public List<Product> getProducts(){
		return products;	
	}


	public Product get(long id) {
		
		for (Product product : products) {
			if (product.getId()==id) {
				return product;
			}
		}
		return null;
	}


	
	
	
	
    
 

    
}
