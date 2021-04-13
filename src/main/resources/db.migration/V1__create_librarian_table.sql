create table "E_LIBRARIAN"
(
    "ID"       integer not null
        constraint "E_LIBRARIAN_PK"
            primary key,
    "NAME"     varchar(4000),
    "PASSWORD" varchar(4000),
    "EMAIL"    varchar(4000),
    "MOBILE"   integer
);
