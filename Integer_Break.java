public class Solution {
    public int integerBreak(int n) {
        int[] product = new int[n + 1];
        Arrays.fill(product, 1);
        int maxValue = 1;
        for (int i = 2; i <= n; i ++) {
            for (int j = 2; j < i; j ++) {
                product[i] = Math.max(Math.max(j, product[j]) * (i - j), product[i]);
            }
        }
        return product[n];
    }
}