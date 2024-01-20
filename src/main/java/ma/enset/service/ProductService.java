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
    @Autowired
    @Qualifier("pv2")
    private  ProductDao productDao;

    // this is a constructor injection
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public ProductService() {
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
