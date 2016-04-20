/*permutations.java*/
/*Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
import java.util.*;
class Solution046 {
    public void permuteHelper(int[] nums, List<Integer> curList, boolean[] used, List<List<Integer>> resultSet) {
        if(curList.size() == nums.length) {
            resultSet.add(new ArrayList<Integer>(curList));
        } else {
            for(int i = 0; i < nums.length; i ++) {
                if(!used[i]) {
                    curList.add(nums[i]);
                    used[i] = true;
                    permuteHelper(nums, curList, used, resultSet);
                    used[i] = false;
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        boolean used[] = new boolean[nums.length];
        for(int i = 0; i < used.length; i ++) {
            used[i] = false;
        }
        List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        permuteHelper(nums, curList, used, resultSet);
        return resultSet;

    }
    public static void main(String[] args) {
        Solution046 test = new Solution046();
        int[] nums1 = {1,2,3};
        System.out.println(test.permute(nums1));

    }
}