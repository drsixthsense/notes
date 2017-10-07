CREATE TABLE IF NOT EXISTS Todo(id IDENTITY PRIMARY KEY, done BOOLEAN, text VARCHAR(255));
DELETE FROM notes;
INSERT INTO notes VALUES(1, true, 'Prepare presentation');
INSERT INTO notes VALUES(2, true, 'Procrastinate');
INSERT INTO notes VALUES(3, false, 'Have presentation');
