create table IF NOT EXISTS indicator (
    device_mac varchar(17) NOT NULL,
    name varchar(50) NOT NULL,
    type varchar(20),
    pin int,
    description varchar(200),
    current_state int,
    target_state int,
    indication float
);