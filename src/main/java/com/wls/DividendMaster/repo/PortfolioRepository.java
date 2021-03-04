package com.wls.DividendMaster.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wls.DividendMaster.domain.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Portfolio findByPortfolioName(String name);
}