package com.wls.DividendMaster.web;

import javax.validation.constraints.NotNull;

import com.wls.DividendMaster.domain.User;

/**
 * DTO to make validation of request straight-forward and obvious
 * @author jasonwhite
 *
 */
public class PortfolioDto {
	
    private String portfolioId;

    @NotNull
    private String portfolioStonks;
    
    @NotNull
    private String portfolioUserId;
    
    @NotNull
    private String portfolioName;
   
	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getPortfolioUserId() {
		return portfolioUserId;
	}

	public void setPortfolioUserId(String portfolioUserId) {
		this.portfolioUserId = portfolioUserId;
	}

	/**
     * Default constructor
     */
    protected PortfolioDto() {
    }
    
    /**
     * Partial (no id) constructor
     * @param portfolioId
     * @param password
     */
    public PortfolioDto(String portfolioName, String portfolioStonks, String portfolioUserId) {
        this.portfolioName = portfolioName;
        this.portfolioStonks = portfolioStonks;
        this.portfolioUserId = portfolioUserId;
    }

    /**
     * Full constructor
     * @param portfolioId
     * @param password
     */
    public PortfolioDto(String portfolioId, String portfolioName, String portfolioStonks, String portfolioUserId) {
        this.portfolioId = portfolioId;
        this.portfolioName = portfolioName;
        this.portfolioStonks = portfolioStonks;
        this.portfolioUserId = portfolioUserId;
    }

	public String getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getPortfolioStonks() {
		return portfolioStonks;
	}

	public void setPortfolioStonks(String portfolioStonks) {
		this.portfolioStonks = portfolioStonks;
	}


}


