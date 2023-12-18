package ma.enset.dao;

import ma.enset.dao.entities.Client;


public class DaoTest {

    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImpl();
//
//        productDao.searchProductByQuery("30").forEach(p->{
//            System.out.println("Product_Id: "+p.getId() +"\n"
//                    +"Product_Name: "+p.getName()+"\n"
//                    +"Product_Price: "+p.getPrice()+"\n"
//                    +"Product_Quantity: "+p.getQuantity()+"\n"
//            );
//        });
//
//        // test create
//        Product product = new Product("Product 1", 100, 10);
//        productDao.create(product);
//
//        // test getAll
//        productDao.getAll().forEach(p->{
//            System.out.println("Product_Id: "+p.getId() +"\n"
//                    +"Product_Name: "+p.getName()+"\n"
//                    +"Product_Price: "+p.getPrice()+"\n"
//                    +"Product_Quantity: "+p.getQuantity()+"\n"
//            );
//        });
//
//        // test findById
//        Product product1 = productDao.findById(4);
//        product1.setPrice(200);
//        productDao.update(product1);
//
//        // test delete
//        productDao.delete(2);

//        productDao.getAll().forEach(p->{
//            System.out.println("Product_Id: "+p.getId() +"\n"
//                    +"Product_Name: "+p.getName()+"\n"
//                    +"Product_Price: "+p.getPrice()+"\n"
//                    +"Product_Quantity: "+p.getQuantity()+"\n"
//            );
//        });

        // test add a client
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.create(new Client("Client 1", "gmail@gmail.com", "0606060606", "Address 1"));
        clientDao.getAll().forEach(System.out::println);
    }

}
