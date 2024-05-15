CREATE TABLE worker (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000),
                        BIRTHDAY DATE CHECK (BIRTHDAY > '1900-01-01'),
                        LEVEL VARCHAR(20) NOT NULL CHECK (LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')),
                        SALARY INT CHECK (SALARY >= 100 AND SALARY <= 100000)
);

CREATE TABLE client (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000)
);

CREATE TABLE project (
                         ID INT AUTO_INCREMENT PRIMARY KEY,
                         CLIENT_ID INT,
                         START_DATE DATE,
                         FINISH_DATE DATE,
                         FOREIGN KEY (CLIENT_ID) REFERENCES client(ID)
);

CREATE TABLE project_worker (
                                PROJECT_ID INT,
                                WORKER_ID INT,
                                PRIMARY KEY (PROJECT_ID, WORKER_ID),
                                FOREIGN KEY (PROJECT_ID) REFERENCES project(ID),
                                FOREIGN KEY (WORKER_ID) REFERENCES worker(ID)
);
