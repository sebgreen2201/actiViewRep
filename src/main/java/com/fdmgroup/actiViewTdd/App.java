package com.fdmgroup.actiViewTdd;

import java.util.ArrayList;
import java.util.List;

public class App 
{
	public static void main(String[] args) {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(10.5);
        doubleList.add(20.0);
        doubleList.add(15.8);

        List<List<Double>> portfolioValues = List.of(
                List.of(-10.0, -8.0, -5.0, 15.0, 20.0),
                List.of(-5.0, -3.0, -2.0, 10.0, 12.0),
                List.of(-8.0, -6.0, -3.0, 12.0, 15.0)
        );
        
		double var = calculateSingleTradeVaR(doubleList, 0.95);
		double portvar = calculatePortfolioVaR(portfolioValues, 0.95);

	}
	
	 public static double calculateSingleTradeVaR(List<Double> historicalValues, double confidenceLevel) {
		 	int numValues = historicalValues.size();
		    int index = (int) Math.ceil(numValues * (1 - confidenceLevel));
		    
		    double[] sortedValues = historicalValues.stream()
		            .mapToDouble(Double::doubleValue)
		            .sorted()
		            .toArray();
		    
		    return sortedValues[index-1];
	    }
	 
	 public static double calculatePortfolioVaR(List<List<Double>> historicalValues, double confidenceLevel) {
	        List<Double> portfolioReturns = calculatePortfolioReturns(historicalValues);
	        return calculateSingleTradeVaR(portfolioReturns, confidenceLevel);
	    }

	    private static List<Double> calculatePortfolioReturns(List<List<Double>> portfolio) {
	        List<Double> portfolioReturns = new ArrayList<>();
	        int numTrades = portfolio.size();
	        int numValues = portfolio.get(0).size();

	        for (int i = 0; i < numTrades; i++) {
	            double sum = 0.0;
	            for (int j = 0; j < numValues; j++) {
	                sum += portfolio.get(i).get(j);
	            }
	            portfolioReturns.add(sum);
	        }

	        return portfolioReturns;
	    }

}

