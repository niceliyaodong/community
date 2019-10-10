create table user
(
    id           int(100) auto_increment
        primary key,
    account_id   varchar(50)  null,
    name         varchar(100) null,
    token        varchar(100) null,
    gmt_create   varchar(100) null,
    gmt_modifile varchar(255) null
);