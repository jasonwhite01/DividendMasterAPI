-- USER
-- non-encrypted password: letmein
INSERT INTO security_user (id, username, password, first_name, last_name) VALUES
(1,  'admin', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Administrator', 'Administrator'),
(2,  'csr_jane', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Jane', 'Doe'),
(3,  'csr_mark', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Mark', 'Smith'),
(4,  'wally', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Walter', 'Adams');

INSERT INTO user_role(user_id, role_id) VALUES
 (1, 2), -- give admin ROLE_ADMIN
 (1, 1), -- give admin ROLE_PAYING_CUSTOMER
 (1, 3), -- give admin ROLE_CSR
 (2, 3),  -- give Jane ROLE_CSR
 (3, 3),  -- give Mark ROLE_CSR
 (4, 3),  -- give Wally ROLE_CSR
 (4, 1);  -- give Wally ROLE_PAYING_CUSTOMER