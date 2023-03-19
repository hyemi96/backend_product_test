INSERT INTO SELLING_TYPE (selling_type_name, remarks) VALUES ('단일상품','단품상품'),('1:1상품','1+1상품'),('묶음상품','묶음으로 구성된상품'),('옵션상품','옵션으로 추가로 구매 가능한상품');
INSERT INTO PRODUCT_CATEGORY (category_name, selling_type_id, sub) VALUES ('가방',4 ,'N'),('모자', 3,'Y'),('바지',3,'N'),('반지',1,'N'),('신발',1,'N'),('티셔츠',2,'N');
INSERT INTO PRODUCT_INFO (name, product_category_id, price,soldout) VALUES ('A', 5 , 100, 'N'), ('B', 5 , 200, 'N'),('C', 1 , 150, 'Y'), ('D', 3 , 200, 'N'), ('E', 2 , 400, 'N'), ('F', 4 , 2000, 'N'), ('G', 1 , 200, 'N'), ('H', 3 , 300, 'N'), ('I', 2 , 2100, 'N'), ('J', 5 , 20, 'Y'), ('K', 4 , 10, 'N'), ('M', 1 , 200, 'N'), ('N', 3 , 200, 'N') 