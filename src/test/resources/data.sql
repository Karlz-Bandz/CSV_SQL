BEGIN;
INSERT INTO dynamic_data (id,name) VALUES (1, 'test666');
INSERT INTO dynamic_data (id,name) VALUES (2, 'test667');
INSERT INTO dynamic_data (id,name) VALUES (3, 'test668');

INSERT INTO dynamic_row (id,dynamic_data_id) VALUES (1,1);
INSERT INTO dynamic_row (id,dynamic_data_id) VALUES (2,1);
INSERT INTO dynamic_row (id,dynamic_data_id) VALUES (3,1);
INSERT INTO dynamic_row (id,dynamic_data_id) VALUES (4,2);
INSERT INTO dynamic_row (id,dynamic_data_id) VALUES (5,2);
INSERT INTO dynamic_row (id,dynamic_data_id) VALUES (6,2);
INSERT INTO dynamic_row (id,dynamic_data_id) VALUES (7,2);
INSERT INTO dynamic_row (id,dynamic_data_id) VALUES (8,3);
INSERT INTO dynamic_row (id,dynamic_data_id) VALUES (9,3);

INSERT INTO record_values (dynamic_row_id,record) VALUES (1, '1');
INSERT INTO record_values (dynamic_row_id,record) VALUES (1, 'Karl');
INSERT INTO record_values (dynamic_row_id,record) VALUES (2, '2');
INSERT INTO record_values (dynamic_row_id,record) VALUES (2, 'Bar');
INSERT INTO record_values (dynamic_row_id,record) VALUES (3, '3');
INSERT INTO record_values (dynamic_row_id,record) VALUES (3, 'Peter');
INSERT INTO record_values (dynamic_row_id,record) VALUES (4, '1');
INSERT INTO record_values (dynamic_row_id,record) VALUES (4, 'Warsaw');
INSERT INTO record_values (dynamic_row_id,record) VALUES (4, 'Poland');
INSERT INTO record_values (dynamic_row_id,record) VALUES (4, '1823');
INSERT INTO record_values (dynamic_row_id,record) VALUES (5, '2');
INSERT INTO record_values (dynamic_row_id,record) VALUES (5, 'Paris');
INSERT INTO record_values (dynamic_row_id,record) VALUES (5, 'France');
INSERT INTO record_values (dynamic_row_id,record) VALUES (5, '1966');
INSERT INTO record_values (dynamic_row_id,record) VALUES (6, '3');
INSERT INTO record_values (dynamic_row_id,record) VALUES (6, 'London');
INSERT INTO record_values (dynamic_row_id,record) VALUES (6, 'England');
INSERT INTO record_values (dynamic_row_id,record) VALUES (6, '2020');
INSERT INTO record_values (dynamic_row_id,record) VALUES (7, '4');
INSERT INTO record_values (dynamic_row_id,record) VALUES (7, 'Tokyo');
INSERT INTO record_values (dynamic_row_id,record) VALUES (7, 'Japan');
INSERT INTO record_values (dynamic_row_id,record) VALUES (7, '1966');
INSERT INTO record_values (dynamic_row_id,record) VALUES (8, '1');
INSERT INTO record_values (dynamic_row_id,record) VALUES (8, 'Baron');
INSERT INTO record_values (dynamic_row_id,record) VALUES (8, 'Dog');
INSERT INTO record_values (dynamic_row_id,record) VALUES (9, '2');
INSERT INTO record_values (dynamic_row_id,record) VALUES (9, 'Hubert');
INSERT INTO record_values (dynamic_row_id,record) VALUES (9, 'Human');
COMMIT;



