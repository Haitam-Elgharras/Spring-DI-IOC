package ma.enset.presentation;


import ma.enset.dao.*;
import ma.enset.dao.entities.Client;
import ma.enset.dao.entities.Product;
import ma.enset.service.ClientService;
import ma.enset.service.IClientService;
import ma.enset.service.IProductService;
import ma.enset.service.ProductService;

import java.io.File;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) throws Exception {
        // dynamic instantiation
        Scanner scanner = new Scanner(new File("src/main/resources/config.txt"));
        String daoClassName = scanner.nextLine();
        Class<?> cPDao = Class.forName(daoClassName);
        ProductDao Pdao = (ProductDao) cPDao.getConstructor().newInstance();

        String serviceClassName = scanner.nextLine();
        Class<?> cService = Class.forName(serviceClassName);
        // we need to give the getConstructor method the type of the param
        IProductService serviceV2 = (IProductService) (cService.getConstructor(ProductDao.class).newInstance(Pdao));

        // if we have setter dependency injection, we use the invoke method like this
        // IProductService serviceV2 = (IProductService) (cService.getConstructor().newInstance());
        // Method setProductDao = cService.getDeclaredMethod("setProductDao", ProductDao.class);
        // setProductDao.invoke(serviceV2, Pdao); this is the setter injection


        // add a list of Products

        for (int i = 0; i < 10; i++) {
            Product product = new Product("Product " + i, (i+1)*10, 1000.0 + i);
            serviceV2.addProduct(product);
        }

        System.out.println("All products: \n");
        serviceV2.getAllProducts().forEach(System.out::println);


//        IClientService clientService = new ClientService(new ClientDaoImpl());

        // dynamic instantiation
        String daoClassName2 = scanner.nextLine();
        Class<?> cCDao = Class.forName(daoClassName2);
        ClientDao Cdao = (ClientDao)cCDao.getConstructor().newInstance();

        String serviceClassName2 = scanner.nextLine();
        Class<?> cService2 = Class.forName(serviceClassName2);
        IClientService clientService = (IClientService) (cService2.getConstructor(ClientDao.class).newInstance(Cdao));

//        // add a list of Clients
        for (int i = 0; i < 10; i++) {
            clientService.addClient(new Client("Client " + i, "Client " + i+"@gmail.com" , "Client " + i+" Phone", "Client " + i+" Address"));
        }

        System.out.println("All clients: \n");
        clientService.getAllClients().forEach(System.out::println);
    }
}
