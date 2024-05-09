package amoa.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import amoa.domain.Product;
import amoa.domain.Products;
import amoa.exceptions.NoSuchProductException;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ProductsManager {

    @WebMethod
    @WebResult(name = "productId")
    long addProduct(@WebParam(name = "product") Product product);

    @WebMethod
    @WebResult(name = "product")
    Product getProduct(@WebParam(name = "productId") long id) throws NoSuchProductException;

    @WebMethod
    @WebResult(name = "price")
    double getProductPrice(@WebParam(name = "productId") long id) throws NoSuchProductException;
    
    @WebMethod
    @WebResult(name = "products")
    public Products getProducts();
    
    @WebMethod
    @WebResult(name = "product")
    public Product updateProduct(@WebParam(name = "product") Product product) throws NoSuchProductException  ;
    
    @WebMethod
     public boolean deleteProduct(@WebParam(name = "productId") long id);
    
    @WebMethod
    public boolean deleteAllProducts();
    
    
    
}
