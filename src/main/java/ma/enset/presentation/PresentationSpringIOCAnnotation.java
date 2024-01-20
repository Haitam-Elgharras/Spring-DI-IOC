package ma.enset.presentation;

import ma.enset.service.IProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentationSpringIOCAnnotation {
    public static void main(String[] args) {

        // Initialize Spring context by providing the base package name for component scanning.
        // Spring will scan the provided package and its sub-packages for classes annotated with @Component, @Service, @Repository, etc.
        ApplicationContext context = new AnnotationConfigApplicationContext("ma.enset");

        // Request Spring context to provide a bean(implementation) of type IProductService.
        // Spring will search for a bean in the context that matches the specified type and return it.
        // If multiple beans of the same type exist, a NoUniqueBeanDefinitionException will be thrown.
        // We can solve it using the Qualifier annotation
        IProductService productService = context.getBean(IProductService.class);

        // or IProductService productService =(IProductService) context.getBean("name of the service");


        // Print all products retrieved from the productService bean.
        System.out.println(productService.getAllProducts());
    }

}