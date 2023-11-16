CREATE TABLE reservations
(
    id_reservation   int PRIMARY KEY,
    id_client        int,
    date_of_entry    date,
    date_of_exit     date,
    value_stay_price float4,
    form_payment     varchar(50),
    total            float4,
    is_active bool,
    CONSTRAINT fk_id_client FOREIGN KEY (id_client) REFERENCES clients (id_client)
);