USE test;

DROP TABLE IF EXISTS notes;
CREATE TABLE notes(id INT(11) NOT NULL AUTO_INCREMENT, done BOOLEAN, text VARCHAR(255), date TIMESTAMP, PRIMARY KEY (id));

INSERT INTO notes VALUES (1, 0 , 'First note added', '1986-11-04 11:05:34'),
  (2, 0, 'second note', '1995-08-04 11:05:34'),
  (3, 0, 'Third note', '2001-09-11 13:05:34'),
  (4, 0, 'some note added', '2005-10-22 20:05:34'),
  (5, 0, 'Hahaha, Im here', '2006-10-22 20:05:34'),
  (6, 0, 'Oom, new note', '2007-01-22 16:05:34'),
  (7, 0, 'note number 7', '2009-03-12 20:05:34'),
  (8, 0, 'This is good idea', '2012-10-11 23:05:34'),
  (9, 0, 'finish up test cases', '2013-03-03 09:05:34'),
  (10, 0, 'javarush to complete', '2014-07-22 20:05:34'),
  (11, 0, 'change my pin', '2015-02-22 20:05:34'),
  (12, 0, 'find my head', '2015-03-13 19:05:34'),
  (13, 0, 'neva gonna give you up', '2015-04-01 01:01:22'),
  (14, 0, 'neva gonna make you cry', '2015-12-31 19:05:34'),
  (15, 0, 'neva bla bla bla bla bla' ,'2016-01-13 19:05:34'),
  (16, 0, 'desert you', '2016-09-02 12:00:01'),
  (18, 0, 'dont have any', '2016-10-16 14:14:14'),
  (17, 0, 'big ideas', '2017-03-08 13:13:13'),
  (19, 0, 'nothing will happen', '2017-05-05 19:05:34'),
  (20, 0, 'life is a sand', '2017-07-17 17:17:34'),
  (21, 0, 'jaja', '2017-10-13 19:05:34');