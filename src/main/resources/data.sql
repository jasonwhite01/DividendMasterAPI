-- USER
-- non-encrypted password: letmein
INSERT INTO security_user (id, username, password, first_name, last_name) VALUES
(1,  'admin', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Administrator', 'Administrator'),
(2,  'csr_jane', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Jane', 'Doe'),
(3,  'csr_mark', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Mark', 'Smith'),
(4,  'wally', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Walter', 'Adams');

-- ROLES

INSERT INTO security_role (id, role_name, description) VALUES (1, 'ROLE_PAYING_CUSTOMER', 'Paying Customer');
INSERT INTO security_role (id, role_name, description) VALUES (2, 'ROLE_ADMIN', 'Administrator');
INSERT INTO security_role (id, role_name, description) VALUES (3, 'ROLE_CSR', 'Customer Service Representative');

INSERT INTO user_role(user_id, role_id) VALUES
 (1, 2), -- give admin ROLE_ADMIN
 (1, 1), -- give admin ROLE_PAYING_CUSTOMER
 (1, 3), -- give admin ROLE_CSR
 (2, 3),  -- give Jane ROLE_CSR
 (3, 3),  -- give Mark ROLE_CSR
 (4, 3),  -- give Wally ROLE_CSR
 (4, 1);  -- give Wally ROLE_PAYING_CUSTOMER
 
 -- PORTFOLIOS WITH STONKS
 
 INSERT INTO portfolio (id, portfolio_name, portfolio_stonks, portfolio_owner_id) VALUES
 (1, 'testPortfolio1', 'AAPL,ATT', 1),
 (2, 'testPortfolio2', 'DIS,ABBV,NHI,WASH', 4);