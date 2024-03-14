package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.repository.ProductRepository;
import ecom.mobile.app.service.serviceInterface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    // code functions

}
