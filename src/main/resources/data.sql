INSERT INTO author (id, firstname, lastname, type)
VALUES (1, 'Ghassan', 'Nasr', 'admin');

INSERT INTO blogpost (id, title, body, date, author_id)
VALUES
    (1, 'First Post', 'This is my first post.', CURRENT_TIMESTAMP(), 1),
    (2, 'Second Post', 'This is my second po
    st.', CURRENT_TIMESTAMP(), 1);