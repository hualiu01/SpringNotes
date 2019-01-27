# Spring DI :facepunch:

''' xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean definitions here -->

</beans>
'''

Spring is mostly identified with Dependency Injection(DI) which is a flavor of Inversion of Control(IoC).

What is DI?
Given class A is depended on class B, DI means class B will get injected into class A by the IoC.

How to do DI?
DI can happen in a way of passing parameters to the constructor or using setter method.

What are the conventions a Bean should follow?
1) have a no-arg constructor
2) serializable
3) provide setters and getters __for all private data members__?

What is the difference between a Bean and a Spring Bean?

The Spring Container is at the core of the Spring Framework. What's the container's job?
1) collect objects
2) wire/assembly objects
3) configure objects
4) manage the lifecycle of objects from creation till destruction

The container gets the configuration metadata of a Bean. What are the forms of metadata been provide in?
1) xml
2) java annotations
3) java code
