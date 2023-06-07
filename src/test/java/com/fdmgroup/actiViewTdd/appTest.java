package com.fdmgroup.actiViewTdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class appTest {
	
	public App VaRCalculator;
	
	 @Test
	    public void testCalculateSingleTradeVaR() {
	        List<Double> tradeValues = List.of(-10.0, -8.0, -5.0, 15.0, 20.0);
	        double confidenceLevel = 0.95;
	        double expectedVaR = -10.0;

	        double calculatedVaR = VaRCalculator.calculateSingleTradeVaR(tradeValues, confidenceLevel);

	        assertEquals(expectedVaR, calculatedVaR, 0.0001);
	    }
	 
	 @Test
	    public void testCalculateSingleTradeVaR2() {
	        List<Double> tradeValues = List.of(-10.0, -10.0, -10.0, -10.0, -10.0, -10.0, -10.0, -10.0, -10.0 -10.0
	        		, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 20.0, 20.0, 20.0, 20.0, 20.0, 20.0
	        		, 20.0, 20.0, 20.0, 20.0);
	        double confidenceLevel = 0.95;
	        double expectedVaR = -10.0;

	        double calculatedVaR = VaRCalculator.calculateSingleTradeVaR(tradeValues, confidenceLevel);

	        assertEquals(expectedVaR, calculatedVaR, 0.0001);
	    }

	    @Test
	    public void testCalculatePortfolioVaR() {
	        List<List<Double>> portfolioValues = List.of(
	                List.of(-10.0, -8.0, -5.0, 15.0, 20.0),
	                List.of(-5.0, -3.0, -2.0, 10.0, 12.0),
	                List.of(-8.0, -6.0, -3.0, 12.0, 15.0)
	        );
	        double confidenceLevel = 0.95;
	        double expectedVaR = 10.0;

	        double calculatedVaR = VaRCalculator.calculatePortfolioVaR(portfolioValues, confidenceLevel);

	        assertEquals(expectedVaR, calculatedVaR, 0.0001);
	    }
	}
	
