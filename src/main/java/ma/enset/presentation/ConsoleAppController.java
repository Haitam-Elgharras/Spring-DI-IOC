package ma.enset.presentation;


import ma.enset.dao.ClientDaoImpl;
import ma.enset.dao.ProductDaoImpl;
import ma.enset.dao.entities.Client;
import ma.enset.dao.entities.Product;
import ma.enset.service.ClientService;
import ma.enset.service.IClientService;
import ma.enset.service.IProductService;
import ma.enset.service.ProductService;

public class ConsoleAppController {
    public static void main(String[] args) {
        IProductService service = new ProductService(new ProductDaoImpl());

        // add a list of Products

        for (int i = 0; i < 10; i++) {
            Product product = new Product("Product " + i, (i+1)*10, 1000.0 + i);
            service.addProduct(product);
        }

        System.out.println("All products: \n");
        service.getAllProducts().forEach(System.out::println);


        IClientService clientService = new ClientService(new ClientDaoImpl());

//        // add a list of Clients
        for (int i = 0; i < 10; i++) {
            clientService.addClient(new Client("Client " + i, "Client " + i+"@gmail.com" , "Client " + i+" Phone", "Client " + i+" Address"));
        }

        System.out.println("All clients: \n");
        clientService.getAllClients().forEach(System.out::println);
    }
}
