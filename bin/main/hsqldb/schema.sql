DROP TABLE PRODUCT_INFO IF EXISTS ;
DROP TABLE PRODUCT_CATEGORY IF EXISTS ;
DROP TABLE SELLING_TYPE IF EXISTS ;

CREATE TABLE SELLING_TYPE
(
    `id`       INT            NOT NULL    AUTO_INCREMENT, 
    `selling_type_name`     VARCHAR(45)    NOT NULL, 
    `remarks`  VARCHAR(255)   NULL, 
    PRIMARY KEY (id)
);


CREATE TABLE PRODUCT_CATEGORY
(
    `id`                   INT            NOT NULL    AUTO_INCREMENT, 
    `category_name`             VARCHAR(45)               NOT NULL, 
    `selling_type_id`      INT            NOT NULL, 
    `sub`                  CHAR(1)        NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE PRODUCT_CATEGORY
    ADD CONSTRAINT FK_PRODUCT_CATEGORY_selling_type_id_SELLING_TYPE_id FOREIGN KEY (selling_type_id)
        REFERENCES SELLING_TYPE (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


CREATE TABLE PRODUCT_INFO
(
    `id`                   INT            NOT NULL    AUTO_INCREMENT, 
    `name`                 VARCHAR(45)    NOT NULL, 
    `product_category_id`  INT            NOT NULL, 
    `price`                INT            NOT NULL, 
    `soldout`              CHAR(1)        NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE PRODUCT_INFO
    ADD CONSTRAINT FK_PRODUCT_INFO_product_category_id_PRODUCT_CATEGORY_id FOREIGN KEY (product_category_id)
        REFERENCES PRODUCT_CATEGORY (id) ON DELETE RESTRICT ON UPDATE RESTRICT;





