# Java Design Patterns & Principles

## Principles

### SOLID
**Single Responsibility** - A class should only have one responsibility. Furthermore, it should only have one reason to change.

**Open/Closed Principle** - Classes should be open for extension, but closed for modification. In doing so, we stop ourselves from modifying existing code and causing potential new bugs. One exception to the rule is when fixing bugs in existing code.

**Liskov Substitution** - If class A is a subtype of class B, then we should be able to replace B with A without disrupting the behavior of our program.

**Interface Segregation** - Larger interfaces should be split into smaller ones. By doing so, we can ensure that implementing classes only need to be concerned about the methods that are of interest to them.

**Dependency Inversion** - The principle of Dependency Inversion refers to the decoupling of software modules. This way, instead of high-level modules depending on low-level modules, both will depend on abstractions.
## Behavioral Patterns

### Strategy Pattern

With the Strategy Pattern, a class behavior or its algorithm can be changed at run time.

When implementing the Strategy Pattern, we create objects which represent various strategies and a context object whose behavior varies as per its strategy object. The strategy object changes the executing algorithm of the context object.

![strategy pattern](https://www.tutorialspoint.com/design_pattern/images/strategy_pattern_uml_diagram.jpg)

### Observer Pattern

The Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified that it's dependent objects are to be notified automatically.

![observer pattern](https://www.tutorialspoint.com/design_pattern/images/observer_pattern_uml_diagram.jpg)

### Command Pattern

The Command pattern is a data driven design pattern. A request is wrapped under an object as command and passed to invoker object. Invoker object looks for the appropriate object which can handle this command and passes the command to the corresponding object which executes the command.

![command pattern](https://www.tutorialspoint.com/design_pattern/images/command_pattern_uml_diagram.jpg)

### Iterator Pattern

Iterator pattern is very commonly used design pattern in Java and .Net programming environment. This pattern is used to get a way to access the elements of a collection object in sequential manner without any need to know its underlying representation.

![iterator pattern](https://www.tutorialspoint.com/design_pattern/images/iterator_pattern_uml_diagram.jpg)

### Template Pattern

In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods. Its subclasses can override the method implementation as per need but the invocation is to be in the same way as defined by an abstract class.

![template pattern](https://www.tutorialspoint.com/design_pattern/images/template_pattern_uml_diagram.jpg)

### Null Object Pattern

In Null Object pattern, a null object replaces check of NULL object instance. Instead of putting if check for a null value, Null Object reflects a do nothing relationship. Such Null object can also be used to provide default behaviour in case data is not available.

In Null Object pattern, we create an abstract class specifying various operations to be done, concrete classes extending this class and a null object class providing do nothing implementation of this class and will be used seamlessly where we need to check null value.

![null object pattern](https://www.tutorialspoint.com/design_pattern/images/null_pattern_uml_diagram.jpg)

### Visitor Pattern

In Visitor pattern, we use a visitor class which changes the executing algorithm of an element class. By this way, the execution algorithm of an element can vary as and when the visitor varies. As per the pattern, element object has to accept the visitor object so that visitor object handles the operation on the element object.

![visitor pattern](https://www.tutorialspoint.com/design_pattern/images/visitor_pattern_uml_diagram.jpg) 

### Circuit Breaker Pattern

A circuit breaker acts as a proxy for operations that might fail. The proxy should monitor the number of recent failures that have occurred, and use this information to decide whether to allow the operation to proceed, or simply return an exception immediately.

The proxy can be implemented as a state machine with the following states that mimic the functionality of an electrical circuit breaker:

**Closed**: The request from the application is routed to the operation. The proxy maintains a count of the number of recent failures, and if the call to the operation is unsuccessful the proxy increments this count. If the number of recent failures exceeds a specified threshold within a given time period, the proxy is placed into the Open state. At this point the proxy starts a timeout timer, and when this timer expires the proxy is placed into the Half-Open state.

The purpose of the timeout timer is to give the system time to fix the problem that caused the failure before allowing the application to try to perform the operation again.

**Open**: The request from the application fails immediately and an exception is returned to the application.


**Half-Open**: A limited number of requests from the application are allowed to pass through and invoke the operation. If these requests are successful, it's assumed that the fault that was previously causing the failure has been fixed and the circuit breaker switches to the Closed state (the failure counter is reset). If any request fails, the circuit breaker assumes that the fault is still present so it reverts to the Open state and restarts the timeout timer to give the system a further period of time to recover from the failure.

The Half-Open state is useful to prevent a recovering service from suddenly being flooded with requests. As a service recovers, it might be able to support a limited volume of requests until the recovery is complete, but while recovery is in progress a flood of work can cause the service to time out or fail again.



![circuit breaker pattern](https://learn.microsoft.com/en-us/azure/architecture/patterns/_images/circuit-breaker-diagram.png)

## Creational Patterns

### Singleton Pattern

This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.

![singleton pattern](https://www.tutorialspoint.com/design_pattern/images/singleton_pattern_uml_diagram.jpg)

### Factory Pattern

In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.

![factory pattern](https://www.tutorialspoint.com/design_pattern/images/factory_pattern_uml_diagram.jpg)

### Builder Pattern

Builder pattern builds a complex object using simple objects and using a step by step approach. This pattern provides one of the best ways to create an object.

![builder pattern](https://www.tutorialspoint.com/design_pattern/images/builder_pattern_uml_diagram.jpg)

### Data Access Object (DAO) Pattern

Data Access Object Pattern or DAO pattern is used to separate low level data accessing API or operations from high level business services. Following are the participants in Data Access Object Pattern.

   - **Data Access Object Interface** - This interface defines the standard operations to be performed on a model object(s).

   - **Data Access Object concrete class** - This class implements above interface. This class is responsible to get data from a data source which can be database / xml or any other storage mechanism.

   - **Model Object or Value Object** - This object is simple Java object containing get/set methods to store data retrieved using DAO class.
   
![data access object pattern](https://www.tutorialspoint.com/design_pattern/images/dao_pattern_uml_diagram.jpg)

## Structural Patterns

### Decorator Pattern

Decorator pattern allows a user to add new functionality to an existing object without altering its structure. This pattern acts as a wrapper to existing class.

This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.

![decorator pattern](https://www.tutorialspoint.com/design_pattern/images/decorator_pattern_uml_diagram.jpg)

#### Facade Pattern

Facade pattern hides the complexities of the system and provides an interface to the client which the client can use to access the system. This pattern adds an interface to existing system to hide its complexities.

This pattern involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes.

![facade pattern](https://www.tutorialspoint.com/design_pattern/images/facade_pattern_uml_diagram.jpg)

#### Adapter Pattern

Adapter pattern works as a bridge between two incompatible interfaces. This pattern combines the capability of two independent interfaces.

This pattern involves a single class which is responsible to join functionalities of independent or incompatible interfaces. A real life example could be a case of card reader which acts as an adapter between memory card and a laptop. You plugin the memory card into card reader and card reader into the laptop so that memory card can be read via laptop.

We are demonstrating use of Adapter pattern via following example in which an audio player device can play mp3 files only and wants to use an advanced audio player capable of playing vlc and mp4 files. 

![adapter pattern](https://www.tutorialspoint.com/design_pattern/images/adapter_pattern_uml_diagram.jpg)

## Other Patterns

#### MVC Pattern

MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to separate application's concerns.

   - **Model** - Model represents an object or JAVA POJO carrying data. It can also have logic to update controller if its data changes.
   
   - **View** - View represents the visualization of the data that model contains.

   - **Controller** - Controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps view and model separate.

![mvc pattern](https://www.tutorialspoint.com/design_pattern/images/mvc_pattern_uml_diagram.jpg)

#### Service Locator Pattern

The service locator design pattern is used when we want to locate various services using JNDI (Java Naming and Directory Interface) lookup. Considering high cost of looking up JNDI for a service, Service Locator pattern makes use of caching technique. For the first time a service is required, Service Locator looks up in JNDI and caches the service object. Further lookup or same service via Service Locator is done in its cache which improves the performance of application to great extent. Following are the entities of this type of design pattern.

   - **Service** - Actual Service which will process the request. Reference of such service is to be looked upon in JNDI server.

   - **Context / Initial Context** - JNDI Context carries the reference to service used for lookup purpose.

   - **Service Locator** - Service Locator is a single point of contact to get services by JNDI lookup caching the services.

   - **Cache** - Cache to store references of services to reuse them

   - **Client** - Client is the object that invokes the services via ServiceLocator.

![service locator pattern](https://www.tutorialspoint.com/design_pattern/images/servicelocator_pattern_uml_diagram.jpg)

#### Envelope Pattern

Often called the Envelope Wrapper, Envelope Pattern is an architectural approach in messaging and data integration. It wraps application data (the payload) inside a standardized container with headers. This allows systems to route, trace, and process messages without reading or opening the underlying data.

![envelope pattern](https://softwarearch.santoslab.org/_images/adapt2.png)

## Misc

### Project Lombok
This project uses Project Lombok to handle most of the boilerplate code. See https://projectlombok.org/ for more information.

### Slf4j
This project uses SLF4J for logging. See http://www.slf4j.org/ for more information.

### Apache Commons-Lang
This project uses the Apache Commons-Lang library in several places. See https://commons.apache.org/proper/commons-lang/ for more information.
