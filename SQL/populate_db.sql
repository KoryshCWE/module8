INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
                                                       ('Nazar Doe', '1990-05-15', 'Trainee', 800),
                                                       ('Dima Smith', '1985-08-20', 'Junior', 1200),
                                                       ('Nika Johnson', '1980-12-10', 'Middle', 3000),
                                                       ('Emily Brown', '1978-04-25', 'Senior', 6000),
                                                       ('David Wilson', '1992-07-03', 'Trainee', 900),
                                                       ('Jim Lee', '1987-09-18', 'Junior', 1500),
                                                       ('Christopher Davis', '1975-11-30', 'Middle', 4000),
                                                       ('Jessica Martinez', '1983-02-12', 'Senior', 7000),
                                                       ('Matthew Taylor', '1995-06-08', 'Trainee', 950),
                                                       ('Amanda Garcia', '1989-10-22', 'Junior', 1300);


INSERT INTO client (NAME) VALUES
                              ('BIC Corporation'),
                              ('ZYX Ltd.'),
                              ('Tech Innovations'),
                              ('Local Solutions'),
                              ('Digital Solutions');


INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
                                                             (1, '2023-01-01', '2023-03-15'),
                                                             (2, '2023-02-10', '2023-05-20'),
                                                             (3, '2023-03-05', '2023-07-10'),
                                                             (4, '2023-04-20', '2023-08-25'),
                                                             (5, '2023-05-15', '2023-09-30'),
                                                             (1, '2023-06-01', '2023-10-10'),
                                                             (3, '2023-07-10', '2023-11-20'),
                                                             (2, '2023-08-05', '2023-12-15'),
                                                             (4, '2023-09-20', '2024-01-25'),
                                                             (5, '2023-10-15', '2024-02-28');


INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
    (1, 1), (1, 2), (1, 3),
    (2, 2), (2, 4), (2, 5),
    (3, 3), (3, 4), (3, 6),
    (4, 4), (4, 5), (4, 7),
    (5, 5), (5, 6), (5, 8),
    (6, 6), (6, 7), (6, 9),
    (7, 7), (7, 8), (7, 10),
    (8, 8), (8, 9),
    (9, 9), (9, 10),
    (10, 10);