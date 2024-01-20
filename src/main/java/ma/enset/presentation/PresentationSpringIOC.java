package ma.enset.presentation;

import ma.enset.service.IClientService;
import ma.enset.service.IProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationSpringIOC {
     public static void main(String[] args) {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");
        IProductService productService =  springContext.getBean(IProductService.class);
        System.out.println(productService.getAllProducts());

        IClientService clientService =  springContext.getBean(IClientService.class);
        System.out.println(clientService.getAllClients());
    }


}
