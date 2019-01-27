#Spring DI :facepunch:

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean definitions here -->

</beans>

Spring is mostly identified with Dependency Injection(DI) which is a flavor of Inversion of Control(IoC).

What is DI?
Given class A is depended on class B, DI means class B will get injected into class A by the IoC.

How to do DI?
DI can happen in a way of passing parameters to the constructor or using setter method.

What are the conventions a Bean should follow?
1) have a no-arg constructor
2) serializable
3) provide setters and getters __for all private data members__?
