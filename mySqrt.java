// mySqrt.java
// Implement int sqrt(int x)

class Solution069 {
	public int mySqrt(int x) {
		int start = 0;
		int end = x;
		int mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			// System.out.println("Mid is " + mid);
			if (mid * mid == x) {
				start = mid;
				// System.out.println("find it");
			} else if (mid > x / mid) {
				// System.out.println("end move from " + end + " to " + mid);
				end = mid;
			} else {
				// System.out.println("start move from " + start + " to " + mid);
				start = mid;
			}
		}
		if (end * end == x) {
			return end;
		} else {
		return start;
		}
	}
	public static void main(String[] args) {
		Solution069 test = new Solution069();
		System.out.println(test.mySqrt(2147395599));
	}
}