create table "E_BOOK"
(
    "CALLNO"    varchar(4000) not null
        constraint "E_BOOK_PK"
            primary key,
    "NAME"      varchar(4000),
    "AUTHOR"    varchar(4000),
    "PUBLISHER" varchar(4000),
    "QUANTITY"  integer,
    "ISSUED"    integer
);
