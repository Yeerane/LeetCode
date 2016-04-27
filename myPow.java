/* myPow.java */
// Implement pow(x, n).

class Solution050 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        int abs = n;
        if (n < 0) {
            abs = -n;
        }

        double result = myPow(x, abs / 2);

        if(abs % 2 == 0) {
            result = result * result;
        } else {
            result = x * result * result;
        }

        if (n < 0) {
            return 1 / result;
        } else {
            return result;
        }
    }
}