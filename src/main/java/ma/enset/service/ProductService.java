package ma.enset.service;

import ma.enset.dao.ProductDao;
import ma.enset.dao.ProductDaoImpl;
import ma.enset.dao.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ps")
public class ProductService implements IProductService {
    // autowired with is not raccomanded cause it stole the encapsulation in the context of object-oriented programming
    // instead we use constructor injection and let the setter for later usages
    //@Autowired
    //@Qualifier("pv2")
    private  ProductDao productDao;

    // this is a constructor injection
    public ProductService(@Qualifier("pv1") ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public void addProduct(Product product) {
        productDao.create(product);
    }

    @Override
    public void deleteProductById(int id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public void updateProduct(Product product) {
        productDao.update(product);
    }

    @Override
    public List<Product> searchProductByQuery(String query) {
        return productDao.searchProductByQuery(query);
    }

    public void setDao(ProductDao dao) {
        this.productDao =dao;
    }
}
