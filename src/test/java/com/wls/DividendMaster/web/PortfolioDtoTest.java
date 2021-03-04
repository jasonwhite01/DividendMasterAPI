package com.wls.DividendMaster.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class PortfolioDtoTest {
	
	public String testPortfolioName = "testPortfolioName";
	public String testPortfolioStonks = "I,J,K";
	public String testPortfolioUserId = "1";
	
	 @Test
	    public void testAll() {
		 PortfolioDto dto = new PortfolioDto(testPortfolioName,testPortfolioStonks,testPortfolioUserId);
	        assertThat(dto.getPortfolioName(), is(testPortfolioName));
	        assertThat(dto.getPortfolioStonks(), is(testPortfolioStonks));
	        assertThat(dto.getPortfolioUserId(), is(testPortfolioUserId));
	    }
}
