create table users
(
   id uuid not null
       constraint users_pkey
           primary key,
   login varchar,
   pass varchar,
   email varchar
);

alter table users owner to draft_user;

CREATE TYPE file_type AS (
    extension varchar,
    quantity integer
);

create table projects
(
    id uuid not null
        constraint project_pkey
            primary key,
    name varchar,
    size varchar,
    fileTypes file_type[],
    files integer,
    folders integer,
    uploadDate timestamp,
    tree json
);

alter table projects owner to draft_user;

INSERT INTO public.users (id, login, pass, email) VALUES
('dddddddddddddddddddddddddddddddddddd',
'demo',
'5ac800889327ec822bdd99f83c98984e4dccc58d', /* demomode */
'demo@example.com');
