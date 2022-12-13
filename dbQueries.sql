SELECT * FROM author;
SELECT * FROM book;
SELECT * FROM publisher;
SELECT * FROM person;
SELECT * FROM books_author;
SELECT * FROM books_publisher;

--CREATE Person;
UPDATE person 
SET email = 'sirme@gmail.com', first_name = 'Sammy', last_name='Muchai'
WHERE person_id = 1;