public class Solution {
    public int maxProduct(int[] nums) {
        int[] product = new int[nums.length]; //product[i] stores the max product of a contiguous subarry containing nums[i];
        int[] negIndex = new int[nums.length + 1]; //negIndex[i] is the farthest index of a subarray starting from nums[0] which contains i negtive numbers;
        int negCount = 0;
        int result = -Integer.MAX_VALUE;
        
        //initialization
        if(nums[0] < 0) {
            negCount = 1;
            negIndex[1] = 0;
            negIndex[0] = -1;
        }
        product[0] = nums[0];
        
        
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] >= 0) {
                product[i] = Math.max(product[i - 1] * nums[i], nums[i]);
            } else {
                negCount ++;
                int start = 0;
                if(negCount == 1) {
                    product[i] = nums[i];
                    negIndex[negCount] = i;
                    continue;
                }
                if(negIndex[negCount - 2] < 0) {
                    product[i] = nums[0];
                    start = 1;
                } else {
                    if(product[negIndex[negCount - 2]] > 0) {
                        product[i] = product[negIndex[negCount - 2]];
                        start = negIndex[negCount - 2] + 1;
                    } else {
                        product[i] = nums[negIndex[negCount - 2] + 1];
                        start = negIndex[negCount - 2] + 2;
                    }
                }
                
                for(int j = start; j <= i; j ++) {
                    product[i] *= nums[j];
                }
            }
            negIndex[negCount] = i;
        }
        for(int i = 0; i < nums.length; i ++) {
            result = Math.max(result, product[i]);
        }
        return result;
    }
}