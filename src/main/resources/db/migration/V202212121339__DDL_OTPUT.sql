create table IF NOT EXISTS output (
--    id varchar(36),
    device_mak varchar(17) NOT NULL,
    id_type int NOT NULL,
    current_state int,
    target_state int,
    output_Number int,
    read_only boolean,
    description varchar(200)
);