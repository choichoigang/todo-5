INSERT INTO user (name, password) VALUES ('jypthemiracle', 'codesquad');
INSERT INTO category (name, created_date_time) VALUES ('todo', NOW());
INSERT INTO task (title, content, category, priority, category_key, user, user_key) VALUES ('test', 'test', 1, 1, 0, 1, 0);
INSERT INTO activity (user, action, user_key) VALUES (1, 'ADD', 1);
INSERT INTO activity (user, action, category_from, category_to, user_key) VALUES (1, 'MOVE', 1, 2, 1);
INSERT INTO activity (user, action, user_key) VALUES (1, 'UPDATE', 1);
INSERT INTO activity (user, action, user_key) VALUES (1, 'REMOVE', 1);