// /*combinationSum.java*/

// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, ..., ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7, 
// A solution set is: 
// [7] 
// [2, 2, 3] 

import java.util.*;
class Solution039 {
    public void combinationSumHelper(int[] candidates, int startIndex, int target, List<Integer> result, List<List<Integer>> resultSet) {
        if(target == 0) {
            resultSet.add(new ArrayList<Integer>(result));
        } else {
            for(int i = startIndex; i < candidates.length && target >= candidates[i]; i ++) {
                target -= candidates[i];
                result.add(candidates[i]);
                combinationSumHelper(candidates, i, target, result, resultSet);
                result.remove(result.size() - 1);
                target += candidates[i];
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0, target, result, resultSet);
        return resultSet;
    }

    public static void main(String[] args) {
        Solution039 test = new Solution039();
        int[] candidates = {8,7,4,3};
        System.out.println(test.combinationSum(candidates, 11));
    }
}