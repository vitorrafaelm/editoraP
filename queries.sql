select * from primeira_tabela; 

CREATE TABLE tb_address (
	id SERIAL PRIMARY KEY, 
	street VARCHAR(255) NOT NULL, 
	neightboohood VARCHAR(255) NOT NULL,
	number_house VARCHAR(255) NOT NULL,
	zipcode VARCHAR(255) NOT NULL,
	city VARCHAR(255) NOT NULL
);

CREATE TABLE tb_authors (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL, 
	taxId VARCHAR(255) NOT NULL,
	address_id int NOT NULL REFERENCES tb_address(id) ON DELETE CASCADE
); 

INSERT INTO tb_address 
(street,neightboohood,number_house,zipcode,city) 
VALUES ('Rua','Rua','Rua','Rua','Rua');

SELECT * FROM tb_authors ta 
LEFT JOIN tb_address ta2 ON ta2.id = ta.address_id;


SELECT * FROM tb_authors;


CREATE TABLE tb_admin (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL, 
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
); 

INSERT INTO tb_admin 
(name,email,password) 
VALUES ('Vitor','vitor.rafael78@gmail.com','123456');

CREATE TABLE tb_evaluator (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL, 
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL, 
	taxId VARCHAR(255) NOT NULL,
	address_id int NOT NULL REFERENCES tb_address(id) ON DELETE CASCADE
); 

INSERT INTO tb_evaluator 
(name,email,password, taxId, address_id) 
VALUES ('Vitor','vitor.rafael@gmail.com','1234569', '78596325689', 2);

CREATE TABLE tb_books (
	id SERIAL PRIMARY KEY,
	title VARCHAR(255) NOT NULL, 
	description VARCHAR(255) NOT NULL,
	gender VARCHAR(255) NOT NULL, 
	year VARCHAR(255) NOT NULL, 
	status_register VARCHAR(255) NOT NULL,
	id_author int NOT NULL REFERENCES tb_authors(id)
); 

CREATE TABLE books_evaluators (
	id_evaluator int NOT NULL REFERENCES tb_evaluator(id),
	id_book int NOT NULL REFERENCES tb_books(id)
); 

INSERT INTO tb_books 
(title,description,gender, year, status_register, id_author) 
VALUES ('Titulo do livro','descrição do livro','ação', '2010', 'processando', 5);

INSERT INTO tb_books 
(title,description,gender, year, status_register, id_author) 
VALUES (?,?,?,?,?,?);


INSERT INTO books_evaluators 
(id_evaluator,id_book) 
VALUES (2,4);

SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName FROM tb_books
LEFT JOIN tb_authors ta on ta.id = tb_books.id_author 
LEFT JOIN books_evaluators eval on eval.id_book = tb_books.id 
RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator
where tb_books.id is not null;

SELECT * FROM tb_authors ta LEFT JOIN tb_address ta2 ON ta2.id = ta.address_id
WHERE ta.name LIKE '%vi%'; 

SELECT * FROM tb_evaluator ta LEFT JOIN tb_address ta2 ON ta2.id = ta.address_id
WHERE ta.name LIKE '%vi%';

SELECT * FROM tb_books ta LEFT JOIN tb_address ta2 ON ta2.id = ta.address_id
WHERE ta.title LIKE '%vi%';

SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName FROM tb_books 
RIGHT JOIN tb_authors ta on ta.id = tb_books.id_author 
RIGHT JOIN books_evaluators eval on eval.id_book = tb_books.id 
RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator
WHERE tb_books.title LIKE '%T%';

SELECT * FROM tb_evaluator ta LEFT JOIN tb_address ta2 ON ta2.id = ta.address_id;

SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName, te.id as IdEval FROM tb_books
LEFT JOIN tb_authors ta on ta.id = tb_books.id_author 
LEFT JOIN books_evaluators eval on eval.id_book = tb_books.id 
RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator
WHERE tb_books.id = 2;

SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName, te.id as IdEval 
FROM tb_books 
LEFT JOIN tb_authors ta on ta.id = tb_books.id_author 
LEFT JOIN books_evaluators eval on eval.id_book = tb_books.id 
RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator 
WHERE tb_books.id=2;

ALTER TABLE tb_books
ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE tb_books
ADD COLUMN updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName FROM tb_books
LEFT JOIN tb_authors ta on ta.id = tb_books.id_author 
LEFT JOIN books_evaluators eval on eval.id_book = tb_books.id 
RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator
where tb_books.id is not null and tb_books.created_at BETWEEN '2022-11-01' AND '2022-11-30'

select * from tb_evaluator;
select * from tb_admin;

SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName FROM tb_books
LEFT JOIN tb_authors ta on ta.id = tb_books.id_author 
LEFT JOIN books_evaluators eval on eval.id_book = tb_books.id 
RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator WHERE te.id = 2


