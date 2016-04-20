/*LeetCode17*/

/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.*/

import java.util.*;
class Solution017 {
    public static final String[] numMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private void findNthChar(List<String> resultSet, int n, String result, String digits) {
        if(n == digits.length()) {
            resultSet.add(new String(result));
        } else {
            int num = digits.charAt(n) -'1' + 1;
            for(int i = 0; i < numMap[num].length(); i ++) {
                result += numMap[num].charAt(i);
                findNthChar(resultSet, n + 1, result, digits);
                result = result.substring(0, n);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return new ArrayList<String>();
        }
        List<String> resultSet = new ArrayList<String>();
        findNthChar(resultSet, 0, "", digits);
        return resultSet;
    }

    public static void main(String[] args) {
        Solution017 test = new Solution017();
        test.letterCombinations("123");
        System.out.println(test.letterCombinations("23456"));
    }
}