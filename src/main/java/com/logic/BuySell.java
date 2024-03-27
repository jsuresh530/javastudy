package com.logic;

public class BuySell {

    public static void main(String[] args) {

        System.out.println("MAX price : "+buySellStock(new int[]{7,0,2,9,3}));
    }
    public static int buySellStock(int[] prices) {

        if(prices.length < 2) return 0;
        int profit = 0;
        int minPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i]-minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        System.out.println(minPrice);
        return profit;
    }
}

























