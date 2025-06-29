public int maxProfit(int[] prices) {
      if (prices == null || prices.length == 0) return 0;

      int n = prices.length;
      int[] profit1 = new int[n];
      int[] profit2 = new int[n];

      int minPrice = prices[0];
      for (int i = 1; i < n; i++) {
          minPrice = Math.min(minPrice, prices[i]);
          profit1[i] = Math.max(profit1[i - 1], prices[i] - minPrice);
      }

      int maxPrice = prices[n - 1];
      for (int i = n - 2; i >= 0; i--) {
          maxPrice = Math.max(maxPrice, prices[i]);
          profit2[i] = Math.max(profit2[i + 1], maxPrice - prices[i]);
      }

      int maxProfit = 0;
      for (int i = 0; i < n; i++) {
          maxProfit = Math.max(maxProfit, profit1[i] + profit2[i]);
      }

      return maxProfit;
}
