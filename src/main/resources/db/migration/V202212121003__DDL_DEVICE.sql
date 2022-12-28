create table IF NOT EXISTS device (
    id varchar(36),
    mac varchar(17) NOT NULL PRIMARY KEY,
    firmware_url_current varchar(1024),
    firmware_url_target varchar(1024),
    deep_sleep bool default true
);