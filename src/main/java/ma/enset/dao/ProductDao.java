package ma.enset.dao;


import ma.enset.dao.entities.Product;
import java.util.List;

public interface ProductDao extends Dao<Product,Integer> {
    List<Product> searchProductByQuery(String query);
}
