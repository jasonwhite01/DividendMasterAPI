package com.wls.DividendMaster.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Portfolio of stonks, which in turn produce dividends (or not)
 * @author jasonwhite
 *
 */
@Entity
@Table(name = "portfolio")
public class Portfolio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	public Portfolio() {
		//default constructor
	}
	
	//public constructor which accepts a non-empty comma-delimited string of dividend producing stocks
	public Portfolio(String portfolioName,String portfolioStonks, User portfolio_owner_id) {
		//create new Portfolio with provided set of stonks
		this.portfolioStonks = portfolioStonks;
		this.portfolioName = portfolioName;		
		this.portfolio_owner_id = portfolio_owner_id;
	}
	
	@ManyToOne
	@JoinColumn(name = "PORTFOLIO_OWNER_ID")
	private User portfolio_owner_id;
		
	

	public User getPortfolio_owner_id() {
		return portfolio_owner_id;
	}

	public void setPortfolio_owner_id(User portfolio_owner_id) {
		this.portfolio_owner_id = portfolio_owner_id;
	}

	@Column(name="portfolio_name")
    private String portfolioName;
	
	@Column(name="portfolio_stonks")
    private String portfolioStonks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	
	public String getPortfolioStonks(){
    	return portfolioStonks;
    }
	
	public void setPortfolioStonks(String portfolioStonks){
    	this.portfolioStonks = portfolioStonks;
    }
}
