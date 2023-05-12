# 쇼핑몰 프로젝트 3단계 구매자 서버📦
3단계는 판매자(=관리자)와 구매자를 **다른 포트**를 사용하는 서버로 만들고<br/>
하나의 DB를 공유하는 방식으로 구현해 보았다.<br/>
구매자 포트 번호 : **8000**<br/>
판매자 포트 번호 : **8080**<br/>
[🏡스프링부트 ↔ MyBatis ↔ MySQL 연동하기 공부 정리](https://whiteclouds-dev.tistory.com/14)

<br/>

# 화면 구현 📺 

- 상품 목록보기
  - 상품 상세보기
- 주문 조회 페이지
  - 주문 취소하기

<br/>

#### [구매자 상품 목록보기]
![image](https://github.com/JungminK1m/Springboot-Product-Study-V3-Buyer/assets/118741874/7751e1e0-8f0f-4f31-add7-153a8b51a033)
#### [구매자 상품 상세보기]
![image](https://github.com/JungminK1m/Springboot-Product-Study-V3-Buyer/assets/118741874/1ede4f22-0309-4810-a11a-f446edaca9bd)
#### [구매자 주문조회]
![image](https://github.com/JungminK1m/Springboot-Product-Study-V3-Buyer/assets/118741874/838b474b-f669-4399-b0fb-26d923752f58)
#### [⏫구매자 주문내역 DB 연동 확인]
![image](https://github.com/JungminK1m/Springboot-Product-Study-V3-Buyer/assets/118741874/e179ebe8-6356-49bf-be41-e1322530a59f)

<br/>
  
# 사용기술 🧪
![Springboot](https://img.shields.io/badge/-Springboot-6DB33F)
![Java](https://img.shields.io/badge/-Java-F09820)
![CSS](https://img.shields.io/badge/-CSS-1572B6)
![HTML](https://img.shields.io/badge/-HTML-E34F26)
![JS](https://img.shields.io/badge/-JavaScript-F7DF1E)
![Bootstrap](https://img.shields.io/badge/-Bootstrap-7952B3)
![MyBatis](https://img.shields.io/badge/-MyBatis-B10000)
![MySQL](https://img.shields.io/badge/-MySQL-%2300758f)

<br/>

  
# 기능구현 🔧
#### ✔ 회원가입 
- 사용 중인 아이디, 이메일로 가입불가
#### ✔ 상품구매
- 상품 구매 시 재고 업데이트
- 상품 구매 수량 자바스크립트로 유효성 검사
#### ✔ 주문조회
- 주문 취소 시 재고 업데이트

   <br/>

# 테이블 생성 📁
```sql
CREATE TABLE user(
	user_id INT PRIMARY KEY auto_increment,
	user_name VARCHAR(20) NOT null,
	user_password VARCHAR(20) NOT null,
	user_email VARCHAR(20) NOT null,
	created_at TIMESTAMP NOT null
);
CREATE TABLE product(
	product_id INT PRIMARY KEY auto_increment,
	product_name VARCHAR(20) NOT null,
	product_price INT NOT null,
	product_qty INT NOT null,
	created_at TIMESTAMP NOT null
);
create table orders(
    orders_id int primary KEY auto_increment,
    orders_name varchar(20) NOT null,
    orders_price int NOT null,
    orders_qty int NOT null,
    product_id int NOT null,
    user_id int NOT null,
    created_at TIMESTAMP
);
```
# 더미 데이터 📰
```sql
INSERT INTO user(user_name, user_password, user_email, created_at) VALUES ('ssar', '1234', 'ssar@nate.com', NOW());
INSERT INTO user(user_name, user_password, user_email, created_at) VALUES ('kaka', '2345', 'kaka@nate.com', NOW());

INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('바나나', 3000, 98, NOW());
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('딸기', 2000, 100, NOW());

INSERT INTO orders(orders_name, orders_price, orders_qty, product_id, user_id, created_at) VALUES ('바나나', 3000, 2, 1, 1, NOW());
INSERT INTO orders(orders_name, orders_price, orders_qty, product_id, user_id, created_at)  VALUES ('딸기', 2000, 5, 2, 2, NOW());
```

