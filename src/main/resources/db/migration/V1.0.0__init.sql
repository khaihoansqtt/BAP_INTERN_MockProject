/***************
 * User Table
 **************/
create table if not exists users
(
    id                      bigint              not null auto_increment,
    user_name               varchar(255) unique not null,
    email                   varchar(255) unique not null,
    first_name              varchar(255)        not null,
    last_name               varchar(255)        not null,
    password                varchar(255)        not null,
    phone                   varchar(255)        not null,
    num_login_attempts      int                 not null default 0,
    credentials_non_expired boolean,
    account_non_expired     boolean,
    account_non_locked      boolean,
    is_deleted              tinyint(1) default 0 null comment 'Check whether this record is deleted or not',
    created_at              datetime             null comment 'The time when this record is created at',
    created_by_user         varchar(255)               null comment 'Reference to users(user_name)',
    modified_at             datetime             null comment 'The time when this record is modified at',
    modified_by_user        varchar(255)               null comment 'Reference to users(user_name)',
    primary key (id)
);

insert into users (user_name, email, first_name, last_name, password, phone, num_login_attempts, is_deleted, created_at, created_by_user, modified_at, modified_by_user)
values ('admin', 'admin@bap.jp', 'Admin', 'Admin', '$2a$10$/guLlIexTXCD8sCKUSYnH.1gtVOp7mYO0nG53MSpw84rCBA.Zusky', '0123456789', 0, 0, '2020-03-17 11:15:05', 'system', '2020-03-17 11:15:05', null);

/***************
 * Role Table
 **************/
create table if not exists roles
(
    id                      bigint               not null auto_increment,
    name                    varchar(255)         unique not null,
    description             varchar(255),
    is_deleted              tinyint(1) default 0 null comment 'Check whether this record is deleted or not',
    created_at              datetime             null comment 'The time when this record is created at',
    created_by_user         varchar(255)               null comment 'Reference to users(user_name)',
    modified_at             datetime             null comment 'The time when this record is modified at',
    modified_by_user        varchar(255)               null comment 'Reference to users(user_name)',
    primary key (id)
);

insert into roles(name, description, is_deleted, created_at, created_by_user, modified_at, modified_by_user)
values ('ADMIN', 'Administrator', 0, '2020-03-17 11:15:05', 'system', '2020-03-17 11:15:05', null);
insert into roles(name, description, is_deleted, created_at, created_by_user, modified_at, modified_by_user)
values ('MEMBER', 'Member', 0, '2020-03-17 11:15:05', 'system', '2020-03-17 11:15:05', null);

/***************
 * User_Role Table
 **************/
create table if not exists user_role
(
    id                      bigint not null auto_increment,
    user_id                 bigint not null,
    role_id                 bigint not null,
    is_deleted              tinyint(1) default 0 null comment 'Check whether this record is deleted or not',
    created_at              datetime             null comment 'The time when this record is created at',
    created_by_user         varchar(255)               null comment 'Reference to users(user_name)',
    modified_at             datetime             null comment 'The time when this record is modified at',
    modified_by_user        varchar(255)               null comment 'Reference to users(user_name)',
    primary key (id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into user_role (user_id, role_id, is_deleted, created_at, created_by_user, modified_at, modified_by_user)
values (1, 1, 0, '2020-03-17 11:15:05', 'system', '2020-03-17 11:15:05', null);
insert into user_role (user_id, role_id, is_deleted, created_at, created_by_user, modified_at, modified_by_user)
values (1, 2, 0, '2020-03-17 11:15:05', 'system', '2020-03-17 11:15:05', null);