/*Solution078.java*/
/*LeetCode78*/

import java.util.*;

class Solution078 {
	public void tryAdd(ArrayList<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
		result.add(new ArrayList<Integer>(list));
		for(int i = pos; i < nums.length; i ++) {
			if(i != pos && nums[i] == nums[i-1]) {
				continue;
			}
			list.add(nums[i]);
			tryAdd(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        tryAdd(result, list, nums, 0);
        return result;
    }

    public static void main(String[] args) {
    	Solution078 test = new Solution078();
    	int[] nums1 = {6, 4, 5, 6, 7, 8};
    	System.out.println(test.subsets(nums1));
    }
}
