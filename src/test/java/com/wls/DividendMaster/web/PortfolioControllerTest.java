package com.wls.DividendMaster.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpMethod.GET;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.wls.DividendMaster.domain.Portfolio;
import com.wls.DividendMaster.service.UserService;


import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PortfolioControllerTest {
	
	public String TEST_USER_ID = "1";
	public static final int USER_ID_INT_VALUE = 1;
	public String TEST_PORTFOLIO_NAME = "testPortfolio1";
	public String TEST_PORTFOLIO_STONKS = "AAPL,ATT";

	//@MockBean
	@Autowired
	private UserService userService;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private JwtRequestHelper jwtRequestHelper;
	
	@Test
    public void getAllPortfolios() {
		
		PortfolioDto portfolioDto = new PortfolioDto(TEST_PORTFOLIO_NAME, TEST_PORTFOLIO_STONKS, TEST_USER_ID);
	    Portfolio testPortfolio = new Portfolio(portfolioDto.getPortfolioName(), portfolioDto.getPortfolioStonks(), userService.findUserById(USER_ID_INT_VALUE).get());
		
		ResponseEntity<List<Portfolio>> response = restTemplate.exchange("/portfolios", GET, new HttpEntity(jwtRequestHelper.withRole("ROLE_ADMIN")), new ParameterizedTypeReference<List<Portfolio>>() {});

        assertThat(response.getStatusCode().value(), is(200));
        assertThat(response.getBody().get(0).getPortfolioName(), is(testPortfolio.getPortfolioName()));
    }
	
	@Test
    public void updateExistingPortfolio() {
		
		PortfolioDto portfolioDto = new PortfolioDto(TEST_PORTFOLIO_NAME, TEST_PORTFOLIO_STONKS, TEST_USER_ID);
	    Portfolio testPortfolio = new Portfolio(portfolioDto.getPortfolioName(), portfolioDto.getPortfolioStonks(), userService.findUserById(USER_ID_INT_VALUE).get());
		
		ResponseEntity<Portfolio> response = restTemplate.exchange("/portfolios/save", POST, new HttpEntity(portfolioDto, jwtRequestHelper.withRole("ROLE_ADMIN")), Portfolio.class);

        assertThat(response.getStatusCode().value(), is(200));
        assertThat(response.getBody().getPortfolioName(), is(testPortfolio.getPortfolioName()));
    }
	
	@Test
    public void saveNewPortfolio() {
		
		PortfolioDto portfolioDto = new PortfolioDto(TEST_PORTFOLIO_NAME, TEST_PORTFOLIO_STONKS, TEST_USER_ID);
	    Portfolio testPortfolio = new Portfolio(portfolioDto.getPortfolioName(), portfolioDto.getPortfolioStonks(), userService.findUserById(USER_ID_INT_VALUE).get());
		
		ResponseEntity<Portfolio> response = restTemplate.exchange("/portfolios/save", POST, new HttpEntity(portfolioDto, jwtRequestHelper.withRole("ROLE_PAYING_CUSTOMER")), Portfolio.class);

        assertThat(response.getStatusCode().value(), is(200));
        assertThat(response.getBody().getPortfolioName(), is(testPortfolio.getPortfolioName()));
    }
}
