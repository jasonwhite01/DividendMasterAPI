CREATE TABLE portfolio (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  portfolio_owner_id BIGINT NOT NULL,
  portfolio_name varchar(255) NOT NULL,
  portfolio_stonks varchar(255) NOT NULL
);
ALTER TABLE portfolio ADD FOREIGN KEY (portfolio_owner_id) REFERENCES security_user(id);

-- ADD PORTFOLIOS WITH STONKS
 
 INSERT INTO portfolio (id, portfolio_name, portfolio_stonks, portfolio_owner_id) VALUES
 (1, 'testPortfolio1', 'AAPL,ATT', 1),
 (2, 'testPortfolio2', 'DIS,ABBV,NHI,WASH', 4);