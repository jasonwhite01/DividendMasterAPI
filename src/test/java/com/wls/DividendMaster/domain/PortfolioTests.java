package com.wls.DividendMaster.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.wls.DividendMaster.repo.PortfolioRepository;
import com.wls.DividendMaster.repo.UserRepository;

@DataJpaTest
public class PortfolioTests {
	
	public static final Long TEST_USER_ID = 1L;
	public String TEST_PORTFOLIO_NAME = "NewTestPortfolio";
	
	@Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private PortfolioRepository portfolioRepository;
    
    @Autowired
    private UserRepository userRepository;
     
    @Test
    public void testSaveNewProduct() {
        entityManager.persist(new Portfolio(TEST_PORTFOLIO_NAME,"A,B,C", userRepository.findById(TEST_USER_ID).get()));
        assertThat(portfolioRepository.findByPortfolioName(TEST_PORTFOLIO_NAME).getPortfolioName(), is(TEST_PORTFOLIO_NAME));
    }

}
