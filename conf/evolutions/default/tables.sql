# --- !Ups

create table "client" ("name" VARCHAR NOT NULL PRIMARY KEY, "lastname" VARCHAR NOT NULL);

# --- !Downs

drop table "client";

