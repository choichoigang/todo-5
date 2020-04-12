INSERT INTO user (name, password) VALUES ('jypthemiracle', 'codesquad');
INSERT INTO category (name, created_date_time) VALUES ('todo', NOW());
INSERT INTO task (title, content, category, priority, category_key, user, user_key) VALUES ('test', 'test', 1, 1, 1, 1, 1);
INSERT INTO activity (user, action, task, user_key, task_key) VALUES (1, 'ADD', 1, 1, 1);
INSERT INTO activity (user, action, category_from, category_to, task, user_key, task_key) VALUES (1, 'MOVE', 1, 2, 1, 1, 1);
INSERT INTO activity (user, action, task, user_key, task_key) VALUES (1, 'UPDATE', 1, 1, 1);
INSERT INTO activity (user, action, task, user_key, task_key) VALUES (1, 'REMOVE', 1, 1, 1);