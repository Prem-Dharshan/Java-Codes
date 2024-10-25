/*
6. Write a program to find the highest stock price, average of stock price and remove the
companies with stock price below 50.
 */

package WS10;

import java.util.Comparator;
import java.util.TreeSet;

public class WS10_PS06 {
    public static void main(String[] args){

        TreeSet<Stock> stocks = new TreeSet<>(Comparator.comparingDouble(Stock::stockPrice));

        stocks.add(new Stock("Company 1", 10));
        stocks.add(new Stock("Company 2", 20));
        stocks.add(new Stock("Company 3", 30));
        stocks.add(new Stock("Company 4", 40));
        stocks.add(new Stock("Company 5", 50));
        stocks.add(new Stock("Company 6", 60));
        stocks.add(new Stock("Company 7", 70));
        stocks.add(new Stock("Company 8", 80));
        stocks.add(new Stock("Company 9", 90));
        stocks.add(new Stock("Company 10", 100));

        System.out.println(stocks);

        Stock highestStockPrice = stocks.last();
        System.out.println("Highest stock price: " + highestStockPrice.companyName() + " - " + highestStockPrice.stockPrice());

        double averageStockPrice = stocks.stream()
                .mapToDouble(Stock::stockPrice)
                .average()
                .orElse(0);

        System.out.println("Average stock price: " + averageStockPrice);

        stocks.removeIf(stock -> stock.stockPrice() < 50);
  }
}

record Stock(String companyName, double stockPrice) {
}