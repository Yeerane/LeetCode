// myPow(x, n)

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean isNegative = (n < 0);
        int abs = n;
        if (isNegative) {
            abs = -n;
        }
        double result = myPow(x, abs / 2);
        if(abs % 2 == 0) {
            result = result * result;
        } else {
            result = x * result * result;
        }
        if(isNegative) {
            return 1 / result;
        } else {
            return result;
        }
    }
}