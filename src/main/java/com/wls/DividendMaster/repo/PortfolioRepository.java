package com.wls.DividendMaster.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wls.DividendMaster.domain.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByPortfolioName(String name);
}