
-- Insert into Role Table
insert into tbl_roles(created_at, updated_at, description, name)
select  now(), now(), 'Default User Role', 'ROLE_USER'
WHERE NOT EXISTS(
        select name from tbl_roles where name = 'ROLE_USER'
    );

insert into tbl_roles(created_at, updated_at, description, name)
select  now(), now(), 'Developer Role', 'ROLE_DEVELOPER'
WHERE NOT EXISTS(
        select name from tbl_roles where name = 'ROLE_DEVELOPER'
    );

insert into tbl_roles(created_at, updated_at, description, name)
select  now(), now(), 'Manager Role', 'ROLE_MANAGER'
WHERE NOT EXISTS(
        select name from tbl_roles where name = 'ROLE_MANAGER'
    );

-- Insert into User Table
INSERT INTO tbl_users
(created_at, updated_at, email, first_name, last_name)
SELECT now(), now(), 'nwabudoemmanuel@gmail.com', 'Emmanuel', 'Nwabudo'
WHERE NOT EXISTS (
        SELECT email FROM tbl_users WHERE email = 'nwabudoemmanuel@gmail.com'
    );

INSERT INTO tbl_users
(created_at, updated_at, email, first_name, last_name)
SELECT now(), now(), 'e.nwabudo@ratepay.com', 'Emmanuel', 'Nwabudo'
WHERE NOT EXISTS (
        SELECT email FROM tbl_users WHERE email = 'e.nwabudo@ratepay.com'
    );

insert into user_roles (user_id, role_id) values (1, 1);
insert into user_roles (user_id, role_id) values (1, 2);
insert into user_roles (user_id, role_id) values (1, 3);
insert into user_roles (user_id, role_id) values (2, 1);
insert into user_roles (user_id, role_id) values (2, 2);

--Insert into bug table
insert into TBL_BUGS
(CREATED_AT, UPDATED_AT, DESCRIPTION, STATUS, TITLE, DEVELOPER_ID)
values
( now(), now(), 'Null pointer Experienced', 'OPEN', 'Null pointer Exception', 1),
( now(), now(), 'IllegalArgument Exception Experienced', 'IN_PROGRESS', 'IllegalArgument Exception', 1),
( now(), now(), 'Null pointer Experienced', 'CLOSED', 'Null pointer Exception', 1),
( now(), now(), 'Wrong Parameter Passed', 'OPEN', 'IllegalArgument Exception', 2),
( now(), now(), 'Null pointer Experienced', 'IN_PROGRESS', 'Null pointer Exception', 2);



