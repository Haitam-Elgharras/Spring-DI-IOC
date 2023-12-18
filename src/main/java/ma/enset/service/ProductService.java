package ma.enset.service;

import ma.enset.dao.ProductDao;
import ma.enset.dao.entities.Product;

import java.util.List;

public class ProductService implements IProductService {
    private ProductDao productDao;

    // this is a constructor injection
    public ProductService(ProductDao productDao) {
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
}
