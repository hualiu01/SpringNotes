# IOC
Inversion of control. Inverse on Service Locator Pattern.
A spring IOC container is a xml file (most common form, also can be other forms with proper config) containing a
bunch of beans.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="accountDao"
        class="org.springframework.samples.jpetstore.dao.jpa.JpaAccountDao">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>
    ...
</beans>
```
``` xml
<beans>
    <import resource="services.xml"/>
    <import resource="resources/messageSource.xml"/>
    ...

    <bean id="bean1" class="..."/>
    ...
</beans>
```

```java
// create and configure beans
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");

// retrieve configured instance
PetStoreService service = context.getBean("petStore", PetStoreService.class);

// use configured instance
List<String> userList = service.getUsernameList();
```

# Beans
## Bean Factory
In short, the BeanFactory provides the configuration framework
and basic functionality, and the ApplicationContext adds more enterprise-specific functionality.
The ApplicationContext is a complete superset of the BeanFactory. One difference between *BeanFactory*
and *ApplicationContext* is: BeanFactory will create beans only when requested (in the java code). While
ApplicationContext will create beans what so ever.


Within the container itself, these bean definitions are represented as BeanDefinition objects, which contain
(among other information) the following metadata:

* A package-qualified **class name**: typically the actual implementation class of the bean being defined.

* Bean **behavioral configuration elements**, which state how the bean should behave in the container (scope,
lifecycle callbacks, and so forth).

* **References** to other beans that are needed for the bean to do its work; these references are also called collaborators
or dependencies.

* **Other configuration settings** to set in the newly created object, for example, the number of connections
to use in a bean that manages a connection pool, or the size limit of the pool.


## Bean names


In XML-based configuration metadata, you use the id and/or name attributes to specify the bean identifier(s).
Note that bean id uniqueness is still enforced by the container, though no longer by XML parsers. You are
not required to supply a name or id for a bean. If no name or id is supplied explicitly, the container generates a
unique name for that bean. However, if you want to refer to that bean by name, through the use of the ref element
or Service Locator style lookup, you must provide a name. The convention is to use camel-cased.


If you want to introduce other aliases to the bean, you can 1) also specify them in the name attribute, separated
by a comma (,), semicolon (;), or white space 2) introduce an alias for a bean that is defined elsewhere. This is
commonly the case in large systems where configuration is split amongst each subsystem, each subsystem having its own
set of object definitions. In XML-based configuration metadata, you can use the <alias/> element to accomplish this.
<alias name="fromName" alias="toName"/> In this case, a bean in the same container which is named fromName,
may also, after the use of this alias definition, be referred to as toName.

## Bean initiation
* normal:
```xml
<bean id="exampleBean" class="examples.ExampleBean"/>

<bean name="anotherExample" class="examples.ExampleBeanTwo"/>
```
* static factory method
```xml
<bean id="clientService" class="examples.ClientService" factory-method="createInstance"/>
```
Equals to:
``` java
public class clientService {
    private static clientService instance = new clientService();

    private clientService() {}

    public static createInstance() {
        return instance;
    }
}
```

* non-static factory method
``` xml
<bean id="serviceLocator" class="examples.DefaultServiceLocator">
    <!-- inject any dependencies required by this locator bean -->
</bean>

<bean id="clientService"
    factory-bean="serviceLocator"
    factory-method="createClientServiceInstance"/>

<bean id="accountService"
    factory-bean="serviceLocator"
    factory-method="createAccountServiceInstance"/>
 ```
 Equals to:
 ```java
public class DefaultServiceLocator {

    private static ClientService clientService = new ClientServiceImpl();

    private static AccountService accountService = new AccountServiceImpl();

    public ClientService createClientServiceInstance() {
        return clientService;
    }

    public AccountService createAccountServiceInstance() {
        return accountService;
    }
}
 ```


# Dependencies
## DI
Dependency Injection. DI exists in two major variants, Constructor-based dependency injection and Setter-based dependency injection.  Note that use of the @Required annotation on a setter method can be used to make the property a required dependency.


For Sim[le types:
```xml
<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg type="int" value="7500000"/>
    <constructor-arg type="java.lang.String" value="42"/>
</bean>

<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg index="0" value="7500000"/>
    <constructor-arg index="1" value="42"/>
</bean>

<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg name="years" value="7500000"/>
    <constructor-arg name="ultimateAnswer" value="42"/>
</bean>
```
To make the third one work out of box, need to be compiled with the debug flag enabled so that Spring.
An alternative way is using ConstructorProperties annotation:
```java
package examples;

public class ExampleBean {
    ...
    @ConstructorProperties({"years", "ultimateAnswer"})
    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
}
```

# Component Scanning
```java
@Configuration
@ComponentScan(basePackages = "com.baeldung.annotations")
class VehicleFactoryConfig {}

@Configuration
@ComponentScan(basePackageClasses = VehicleFactoryConfig.class)
class VehicleFactoryConfig {}
```
```java
@Configuration
@ComponentScan(basePackages = "com.baeldung.annotations")
@ComponentScan(basePackageClasses = VehicleFactoryConfig.class)
class VehicleFactoryConfig {}

@Configuration
@ComponentScans({
  @ComponentScan(basePackages = "com.baeldung.annotations"),
  @ComponentScan(basePackageClasses = VehicleFactoryConfig.class)
})
class VehicleFactoryConfig {}
```
```xml
<context:component-scan base-package="com.baeldung" />
```

