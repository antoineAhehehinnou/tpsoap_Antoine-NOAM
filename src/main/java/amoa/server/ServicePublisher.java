package amoa.server;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import amoa.webservices.ProductsManagerImpl;

@WebService
public class ServicePublisher {
    private static Logger logger = LoggerFactory.getLogger(ServicePublisher.class);

    public static void main(String[] args) {
        logger.info("Starting server");
        Endpoint.publish("http://localhost:2020/webservices/ProductsManager", new ProductsManagerImpl());
        logger.info("Server started");     
        
    }
    
}
