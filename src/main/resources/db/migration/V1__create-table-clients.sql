CREATE TABLE clients (
                         id_client INT PRIMARY KEY ,
                         name varchar(50),
                         last_name varchar(50),
                         date_of_birth date,
                         nacionality varchar(50),
                         telephone varchar(10),
                         is_active bool
);