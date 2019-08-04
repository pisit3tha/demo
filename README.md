
# demo
demo-service

# Getting Started

การ run service อย่างง่าย
 1. สร้าง package service ด้วยคำสั่ง mvn package 
 2. เข้าไปที่ path /traget
 3. ใช้คำสั่ง java -jar demo-0.0.1.jar.jar 
		 ที่เราจะได้ service เรามาลอง Test กัน
		 **เริ่มที่ method Post** 
		 ![997fa30db8ab837b361d5de5af2750d9.png](https://www.img.in.th/images/997fa30db8ab837b361d5de5af2750d9.png)
		 **method Get**
		 ![93c998a3e22e16bb125aa3c2bb61ffae.png](https://www.img.in.th/images/93c998a3e22e16bb125aa3c2bb61ffae.png)
		 method Delete
		 ![91c41a9e15a74a7e692b50b4ab99e94d.png](https://www.img.in.th/images/91c41a9e15a74a7e692b50b4ab99e94d.png)
		 methode put
		 จาก methode delete เรา จะทำการเปลี่ยน ค่า salary ของ  id = 3
		 ![c56fe9f53ff069fd566251c71f66dceb.png](https://www.img.in.th/images/c56fe9f53ff069fd566251c71f66dceb.png)
		 เราสามารถ ดู Document Api ได้ จาก ลิ้งนี้
		 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
### Guides

The following guides illustrates how to use certain features concretely:
 * [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
 * [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
 * [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
 * [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

**ข้อเสนอเนะ** 
1 . เราสามารถ นำ service นี้ ไปทำใน เรื่องของ authen service ได้ อีก เพื่อเพิ่ม ความปลอดภัยให้ กับ ตัว service เอง

 * [https://medium.com/@phayao/%E0%B8%A1%E0%B8%B2%E0%B8%9B%E0%B8%81%E0%B8%9B%E0%B9%89%E0%B8%AD%E0%B8%87-microservice-%E0%B8%94%E0%B9%89%E0%B8%A7%E0%B8%A2-oauth2-%E0%B9%83%E0%B8%99-spring-boot-82dfd2252f47](https://medium.com/@phayao/%E0%B8%A1%E0%B8%B2%E0%B8%9B%E0%B8%81%E0%B8%9B%E0%B9%89%E0%B8%AD%E0%B8%87-microservice-%E0%B8%94%E0%B9%89%E0%B8%A7%E0%B8%A2-oauth2-%E0%B9%83%E0%B8%99-spring-boot-82dfd2252f47)
 * [https://www.baeldung.com/sso-spring-security-oauth2](https://www.baeldung.com/sso-spring-security-oauth2)

 2 . การ deploy ในอานาคต อาจจะทำ ใช้ docker ในการ run ได้ ซึ่งผมได้ guide เป็น dockerfile กับ docker-compose ไว้แล้ว
