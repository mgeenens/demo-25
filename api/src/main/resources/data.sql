-- USERS
INSERT INTO USERS (U_FIRST_NAME, U_LAST_NAME, U_EMAIL, U_BIRTH_DATE, U_INSCRIPTION_DATE)
VALUES
    ('Alice', 'Dupont', 'alice.dupont@example.com', '1990-04-12', '2024-01-10'),
    ('Bob', 'Martin', 'bob.martin@example.com', '1985-09-30', '2024-03-05'),
    ('Charlie', 'Nguyen', 'charlie.nguyen@example.com', '1992-11-14', '2024-05-21');

-- AUTHORS
INSERT INTO AUTHOR (AU_FIRST_NAME, AU_LAST_NAME)
VALUES
    ('Isaac', 'Asimov'),
    ('Agatha', 'Christie'),
    ('J.K.', 'Rowling'),
    ('Terry', 'Pratchett');

-- BOOKS
INSERT INTO BOOK (BK_TITLE, BK_GENRE, BK_PUBLICATION_DATE, BK_AUTHOR_ID)
VALUES
    ('Foundation', 'SCIENCE_FICTION', '1951-01-01', 1),
    ('Murder on the Orient Express', 'MYSTERY', '1934-01-01', 2),
    ('Harry Potter and the Philosopher''s Stone', 'FANTASY', '1997-06-26', 3),
    ('The Last Hero', 'FANTASY', '2001-06-06', 4);

-- LOANS
INSERT INTO LOAN (LO_USER_ID, LO_BOOK_ID, LO_LOAN_DATE, LO_RETURN_DATE)
VALUES
    (1, 1, '2025-09-15', NULL),
    (2, 2, '2025-09-20', '2025-10-01'),
    (3, 3, '2025-10-10', NULL);