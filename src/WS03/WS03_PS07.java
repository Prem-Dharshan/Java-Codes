// 7. You are given an array prices where prices[i] is the price of a given stock on the i-th day. You want to
// maximize your profit by choosing a single day to buy one stock and choosing a different day in the
// future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot
// achieve any profit, return 0.

package WS03;

class StockProfit {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int maximumProfit = maxProfit(prices);
        System.out.println("Max profit is: " + maximumProfit);
    }

    static int maxProfit(int[] prices) {
        int maximumProfit = 0;
        int minimumPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            minimumPrice = Math.min(minimumPrice, price);
            maximumProfit = Math.max(maximumProfit, price - minimumPrice);
        }

        return maximumProfit;
    }
}
