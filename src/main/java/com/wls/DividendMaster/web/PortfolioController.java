package com.wls.DividendMaster.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wls.DividendMaster.domain.Portfolio;
import com.wls.DividendMaster.domain.User;
import com.wls.DividendMaster.service.PortfolioService;
import com.wls.DividendMaster.service.UserService;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioController.class);

    @Autowired
    private PortfolioService portfolioService;
    
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_PAYING_CUSTOMER')")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid PortfolioDto portfolioDto) {
    	User portfolioUser = null;
    	
    	if (userService.findUserById(Integer.parseInt(portfolioDto.getPortfolioUserId())).isPresent()){
    		portfolioUser = userService.findUserById(Integer.parseInt(portfolioDto.getPortfolioUserId())).get();
    		portfolioService.savePortfolio(portfolioDto.getPortfolioName(), portfolioDto.getPortfolioStonks(), portfolioUser);
    	}
       
    }

//    @PostMapping("/signup")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @ResponseStatus(HttpStatus.CREATED)
//    public User signup(@RequestBody @Valid LoginDto loginDto){
//        return userService.signup(loginDto.getUsername(), loginDto.getPassword(), loginDto.getFirstName(),
//                loginDto.getLastName()).orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
//    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Portfolio> getAllPortfolios() {
        return portfolioService.getAll();
    }

}
