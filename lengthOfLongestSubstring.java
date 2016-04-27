/*Longest Increasing Subsequence*/


class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];            // lis[i] stores the length of longest substring from 0 to i;
        for(int i = 0; i < nums.length; i ++) {
            lis[i] = 1;
        }
        // lis[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            int max = 1;
            for (int j = 0; j < i; j ++) {
                if(nums[j] < nums[i]) {
                    // System.out.println("updating lis" + "[" + i + "] " + "according to " + j);
                    max = Math.max(max, lis[j]);

                    // max = a[j];
                    lis[i] = max + 1;
                }
            }
            // System.out.println("lengthOfLIS till " + i + ": " + lis[i]);
        }

        int lisLength = 0;
        for (int i = 0; i < nums.length; i ++) {
            lisLength = Math.max(lisLength, lis[i]);
        }
        return lisLength;
    }

    public static void main(String[] args) {
        Solution300 test = new Solution300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(test.lengthOfLIS(nums));
    }
}