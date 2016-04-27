// length of longest substring

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];			// lis[i] stores the length of longest substring from 0 to i;
        for(int i = 0; i < nums.length; i ++) {
        	lis[i] = 1;
        }
        for (int i = 1; i < nums.length; i ++) {
        	int max = 1;
        	for (int j = 0; j < i; j ++) {
        		if(nums[j] < nums[i]) {
        			max = Math.max(max, lis[j]);
        			lis[i] = max + 1;
        		}
        	}
        }

        int lisLength = 0;
        for (int i = 0; i < nums.length; i ++) {
        	lisLength = Math.max(lisLength, lis[i]);
        }
        return lisLength;
    }
}