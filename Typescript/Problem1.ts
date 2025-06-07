
function maxProfit(prices: number[]): number {
    if (prices.length === 0) return 0;
    const n = prices.length;

    const profit1 = new Array(n).fill(0);
    const profit2 = new Array(n).fill(0);

    let minPrice = prices[0];
    for (let i = 1; i < n; i++) {
        minPrice = Math.min(minPrice, prices[i]);
        profit1[i] = Math.max(profit1[i - 1], prices[i] - minPrice);
    }

    let maxPrice = prices[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        maxPrice = Math.max(maxPrice, prices[i]);
        profit2[i] = Math.max(profit2[i + 1], maxPrice - prices[i]);
    }

    let maxProfit = 0;
    for (let i = 0; i < n; i++) {
        maxProfit = Math.max(maxProfit, profit1[i] + profit2[i]);
    }

    return maxProfit;
}
