package com.wls.DividendMaster.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wls.DividendMaster.domain.Portfolio;
import com.wls.DividendMaster.domain.User;
import com.wls.DividendMaster.repo.PortfolioRepository;

@Service
public class PortfolioService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioService.class);

    private PortfolioRepository portfolioRepository;

    /**
     * custom, autowired constructor
     * @param portfolioRepository
     */
    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }
    
    /**
     * saves new, or updates existing, portfolio object
     * @param portfolioName
     * @param portfolioStonks
     */
    public void savePortfolio(String portfolioName, String portfolioStonks, User user) {
    	
    	Portfolio portfolio = portfolioRepository.findByPortfolioName(portfolioName);
    	//first lookup portfolio name to see if it exists or not already
    	if(Objects.isNull(portfolio)) {
    		//create new portfolio
    		portfolio = portfolioRepository.save(new Portfolio(portfolioName, portfolioStonks, user));
    	} else { 
    		portfolio.setPortfolioStonks(portfolioStonks); 
    		portfolio = portfolioRepository.save(portfolio);
    	}
    }

    //get all portfolios, if desired
    public List<Portfolio> getAll() {
        return portfolioRepository.findAll();
    }
    
}
