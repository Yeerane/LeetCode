/*Solution077.java*/
/*LeetCode 77. Combinations*/

import java.util.*;
class Solution077 {
	public List<List<Integer>> findCombination(List<List<Integer>> result, List<Integer> list, int n, int k, int curIndex) {
		if(list.size() == k) {
			System.out.println("list size " + list.size() + " equals to " + k + ", go on");
			System.out.println("a result added");
			result.add(list);
			System.out.println(result);
		} else {
			for(int i = curIndex; i <= n; i ++) {
				if(n - curIndex + 1 < k - list.size()) {
					continue;
				}
				list.add(i);
				result = findCombination(result, list, n, k, i + 1);
				list.remove(list.size() - 1);
			}
			
		}
		return result;
	}
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        findCombination(result, list, n, k, 1);
        return result;
    }

    public static void main(String[] args) {
    	Solution077 test = new Solution077();
    	test.combine(4,2);
    }
}