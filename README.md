# Spring

## Spring Core

### DI (Dependency Injection)
Dependency Injection (DI) is a design pattern in software development where the dependencies of a component are injected into it rather than being created within the component. In simpler terms, it's like giving a component the things it needs (dependencies) from the outside, instead of letting it create or find them itself.

### IoC (Inversion of Control)
In a manual Dependency Injection (DI) approach, you, as the developer, are responsible for creating and passing the instances of the dependent classes to the classes that require them. This involves writing code to instantiate objects and manage their relationships.

In contrast, with Inversion of Control (IoC) and frameworks like Spring, the framework takes over the responsibility of managing the instances and their dependencies. Instead of you explicitly creating and passing instances, the framework does it for you. It "injects" the dependencies into the classes that need them.

So, in the context of IoC, the framework handles the instantiation and wiring of dependencies, making your code more decoupled and allowing you to focus on the business logic rather than managing object creation and relationships. This is typically achieved through techniques like constructor injection, setter injection, or method injection, where the framework injects the dependencies into the components at runtime.

### Automatic Injection and IoC
The behavior of automatically injecting dependencies into the components, as facilitated by the framework, is what we refer to as Inversion of Control (IoC). In IoC, the control over object creation and management is inverted or "inverted" from the application code to the framework. The framework takes charge of creating objects, managing their lifecycle, and injecting dependencies, relieving the developer from explicitly handling these concerns.

IoC is a fundamental concept in the design of frameworks like Spring, and it promotes a more modular, decoupled, and maintainable codebase by reducing the direct dependencies between components and facilitating easier testing and maintenance.

## Annotations

### @Component
This is a generic annotation for any Java class managed by Spring's container. The @Repository and @Service annotations are specializations of @Component for more specific use cases.

### @Service
This annotation is a specialization of the @Component annotation. It doesn't provide any additional behavior over the @Component annotation, but it's a good practice to use it in Service layer classes for better readability and understanding of the code.

### @Autowired
This annotation is used for automatic dependency injection. Spring will look in its context for a bean that matches the property and will inject it automatically.

### @Qualifier
This annotation is used along with @Autowired to avoid confusion when multiple instances of a bean type are present. It specifies which exact bean should be wired.

### @Repository
This annotation is a specialization of the @Component annotation with similar use and functionality. However, in addition to importing the DAOs into the DI container, it also makes the unchecked exceptions (thrown from DAO methods) eligible for translation into Spring DataAccessException.

### @ComponentScan
This annotation is used with the @Configuration annotation to tell Spring the packages to scan for annotated components. @ComponentScan without arguments tells Spring to scan the current package and its sub-packages.

## Best Practices

### @Autowired vs. Constructor Injection

#### @Autowired (Field Injection)
`@Autowired` is an annotation in Spring used for automatic dependency injection, particularly in field injection. While it simplifies the injection process, it comes with considerations regarding encapsulation.

Field injection using `@Autowired` might compromise encapsulation in the context of Object-Oriented Programming (OOP). This approach involves directly injecting dependencies into fields, potentially exposing the internal state of a class.

#### Constructor Injection
Constructor injection, on the other hand, is considered a best practice in Spring and OOP. With constructor injection, dependencies are explicitly declared as parameters in the class constructor. This approach aligns with the principle of explicit dependency declaration and supports encapsulation.

Using constructor injection, the dependencies are clearly communicated through the constructor's signature. It makes the dependencies of a class evident at the point of instantiation, enhancing code readability and maintainability.

- **Prefer Constructor Injection Over Field Injection**: Prioritize constructor injection over field injection with `@Autowired` for better adherence to OOP principles and improved code transparency.
- **Encapsulation Support**: Constructor injection supports encapsulation by explicitly declaring dependencies in the constructor, reducing direct exposure of internal details.

By choosing constructor injection, you not only adhere to best practices but also create code that is more modular, maintainable, and in line with the principles of good object-oriented design.