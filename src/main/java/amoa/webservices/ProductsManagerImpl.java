package amoa.webservices;

import java.util.ArrayList;

import java.util.List;

import javax.jws.WebService;


import amoa.domain.Product;
import amoa.domain.Products;
import amoa.exceptions.NoSuchProductException;
import java.util.Random;

@WebService(endpointInterface = "amoa.webservices.ProductsManager")
public class ProductsManagerImpl implements ProductsManager {
    
	private static List<Long> productsId;
	private static final Random random=new Random();
	
	private static Products products =new Products(new ArrayList<Product>());
	
	@Override
	public long addProduct(Product product) {
		List<Product> myProducts=products.getProducts();
		Long id=random.nextLong();
		while(verifyIfIdExist(id)){
			id=random.nextLong();
		}
		product.setId(id);
		myProducts.add(product);
		return id;
	}
	
	

	@Override
	public Product getProduct(long id) throws NoSuchProductException {
		Product product=products.get(id);
		if (product!=null) {
			return product;
		}else {
			throw new NoSuchProductException("Non such product");
		}	
	}
	
	@Override
	public double getProductPrice(long id) throws NoSuchProductException {
		Product product=getProduct(id);
		return product.getPrice();
	}


	@Override
	public Products getProducts() {
		return products;
	}



	@Override
	public Product updateProduct(Product product)  throws NoSuchProductException  {
		Product existingProduct = getProduct(product.getId());  
	    if (existingProduct != null) {
	        existingProduct.setLabel(product.getLabel());
	        existingProduct.setPrice(product.getPrice());
	        return existingProduct;
	    } else {
	        throw new NoSuchProductException("No such product to update with ID: " + product.getId());
	    }
	}



	@Override
	public boolean deleteProduct(long id) {
		List<Product> myProducts = products.getProducts();

	    for (int i = 0; i < myProducts.size(); i++) {
	        Product product = myProducts.get(i);
	        if (product.getId() == id) {
	            myProducts.remove(i);
	            return true;  
	        }
	    }
	    
	    return false;
	}



	@Override
	public boolean deleteAllProducts() {
		 products.getProducts().clear();
		    return true;
	}


	
	



	private static boolean verifyIfIdExist(long id) {
		for(long productId : productsId) {
			if (productId==id) {
				return true;	
				}	
		}
		return false;
	}


    
   
    
}
