# Springboot-Product-Study-Buyer
쇼핑몰 구매자 서버


🏆 목표 🏆
구매자 입장에서 회원가입, 로그인, 상품구매, 구매취소 기능을 구현






📃 시나리오 📃
✅  localhost 주소 입력하면 바로 로그인 페이지로 가기

  🔹  로그인 창 밑에 회원가입 문구(a 태그) 만들기


✅  로그인 하면 상품리스트 목록 페이지로 이동



✅  상품 리스트에 있는 상품 이름 클릭하면 상세 페이지로 이동하기

  🔹  상세 페이지 구매하기 버튼 만들기

  🔹  구매하면 재고 수량이 차감되는 기능



✅  구매 목록 페이지

  🔹  주문 취소 버튼 만들기





📺 화면 설계📺



🧱 테이블 설계 🧱

user
CREATE TABLE user(
	user_id INT PRIMARY KEY auto_increment,
	user_name VARCHAR(20) NOT null,
	user_password VARCHAR(20) NOT null,
	user_email VARCHAR(20) NOT null,
	created_at TIMESTAMP NOT null
);
product
CREATE TABLE product(
	product_id INT PRIMARY KEY auto_increment,
	product_name VARCHAR(20) NOT null,
	product_price INT NOT null,
	product_qty INT NOT null,
	created_at TIMESTAMP NOT null
);
order
create table orders(
    orders_id int primary KEY auto_increment,
    orders_name varchar(20) NOT null,
    orders_price int NOT null,
    orders_qty int NOT null,
    product_id int NOT null,
    user_id int NOT null,
    created_at TIMESTAMP
);





🧺 더미 데이터 🧺


user
INSERT INTO user(user_name, user_password, user_email, created_at) VALUES ('ssar', '1234', 'ssar@nate.com', NOW());
INSERT INTO user(user_name, user_password, user_email, created_at) VALUES ('kaka', '2345', 'kaka@nate.com', NOW());
product
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('바나나', 3000, 98, NOW());
INSERT INTO product(product_name, product_price, product_qty, created_at) VALUES('딸기', 2000, 100, NOW());
order
INSERT INTO orders(orders_name, orders_price, orders_qty, product_id, user_id, created_at) VALUES ('바나나', 3000, 2, 1, 1, NOW());
INSERT INTO orders(orders_name, orders_price, orders_qty, product_id, user_id, created_at)  VALUES ('딸기', 2000, 5, 2, 2, NOW());




