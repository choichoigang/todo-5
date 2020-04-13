INSERT INTO user (name, password) VALUES ('jypthemiracle', 'codesquad');
INSERT INTO category (name, created_date_time) VALUES ('todo', NOW());
INSERT INTO task (title, content, category, priority, category_key, user, user_key) VALUES ('test', 'test', 1, 1, 0, 1, 0);