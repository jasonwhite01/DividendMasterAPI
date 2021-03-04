package com.wls.DividendMaster.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wls.DividendMaster.repo.PortfolioRepository;
import com.wls.DividendMaster.repo.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class PortfolioServiceIntegrationTest {
	
	public static final int STARTING_NUMBER_OF_PORTFOLIOS = 2;
	public static final Long TEST_EXISTING_PORTFOLIO_ID = 1L; 
	public static final Long TEST_USER_ID = 1L;
	
	@Autowired
    private PortfolioService portfolioService;
	
	@Autowired
	private PortfolioRepository portfolioRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Test
	void testGetAll() {
		assertThat(portfolioService.getAll().size(), is(2));
	}
	
	/**
	 * test updating an existing portfolio
	 */
	@Test
	void testUpdatePortfolio() {
		//update the first portfolio with an addition stonk ticker (MRNA)
		portfolioService.savePortfolio("testPortfolio1", "AAPL,ATT,MRNA", userRepo.findById(TEST_USER_ID).get());
		assertThat(portfolioRepo.findById(TEST_EXISTING_PORTFOLIO_ID).get().getPortfolioStonks(), is("AAPL,ATT,MRNA"));	
	}
	
	/**
	 * test adding a new portfolio, including ensuring the total number of portfolios is increased as a result of the add
	 */
	@Test
	void testCreateNewPortfolio() {
		int numberOfPortfoliosBeforeAddition = portfolioService.getAll().size();
		portfolioService.savePortfolio("testPortfolio3", "X,Y,Z", userRepo.findById(TEST_USER_ID).get());
		int numberOfPortfoliosAfterAddition = portfolioService.getAll().size();
		assertTrue(numberOfPortfoliosAfterAddition > numberOfPortfoliosBeforeAddition);
		assertThat(portfolioRepo.findByPortfolioName("testPortfolio3").getPortfolioStonks(), is("X,Y,Z"));	
	}

}
