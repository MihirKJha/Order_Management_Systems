# Order_Management_Systems

Order management system that has two microservices: Order Service and Order Item Service. The Order Service is responsible for creating new orders, retrieving existing order info. Similarly, Order Item Service is responsible for creating order items, retrieving order items.

Order Item has below data:
-	Product code
-	Product name
-	Quantity


Order has below data:
-	Customer name	
-	Order date
-	Shipping address
-	Order items
-	Total ($)


Tech stack:
- Java
- Spring REST 
- Spring Boot
- Spring data JPA
- H2
-Swagger
-Lombok
-Spring cloud (Eureka,Ribbon,Feign,Hystrix ciruit breaker,API Gateway,Config,Zipkin server with Sring cloud Sleuth and RabbitMQ)

