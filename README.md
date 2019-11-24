# Getting Started

Draft viewer - tool for quick reading project from zip archive. 

### Stack

* Java 8

* Spring boot 2.2.0

* Postgresql 9.2

* Vue

* Vuetify

* ---

# Install DB (postgres)

port `5344` for local-env

```create batabase draftviewer;```

```create user draftvuser with encrypted password 'pav2019PAV';```

```grant all privileges on database draftviewer to draftvuser;```

```
create schema public;
   
   comment on schema public is 'standard public schema';
   
   alter schema public owner to postgres;
   
   create table users
   (
       id uuid not null
           constraint users_pkey
               primary key,
       login varchar,
       pass varchar,
       email varchar
   );
   
   alter table users owner to draftvuser;
   
   create table project
   (
       id uuid not null
           constraint project_pkey
               primary key,
       name varchar,
       tree json
   );
   
   alter table project owner to draftvuser;
   
   
   INSERT INTO public.users (id, login, pass, email) VALUES ('ef70c79c-4ebf-4de0-9c62-dd1046749322', 'user', 'f5d66ced28551b636ee550162090bdf8f6f75c3f', 'user@example.com');
```

# Install front

    sudo apt install nodejs
    
    sudo apt install npm
    
    sudo npm install -g @vue/cli
    
    cd ./dv-front
    
    npm install
    
    npm cache clear
    
    npm run build/serve

# Run application

    mvn clean install -DskipTests=true
    
* THEN: run spring-app via IDEA or jar

# Getting Started

### Reference Documentation
Description

* [link](https://index.html)
