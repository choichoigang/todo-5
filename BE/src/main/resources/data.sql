insert into board (id, name) values (1, 'TODO APPLICATION');
insert into user (id, name, password, board, board_key) values (1, 'jypthemiracle', 'codesquad', 1, 0);
insert into category (id, name, board, board_key) values (1, 'TODO', 1, 0);
insert into category (id, name, board, board_key) values (2, 'DOING', 1, 1);
insert into category (id, name, board, board_key) values (3, 'DONE', 1, 2);
insert into task (id, title, content, category, category_key, user, author, priority) values (1, 'study java', 'i love javajigi', 1, 0, 1, 'jypthemiracle', 1);