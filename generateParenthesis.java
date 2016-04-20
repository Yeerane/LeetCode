/*generateParenthesis.java*/
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

Subscribe to see which companies asked this question

Show Tags
Show Similar Problems

*/
import java.util.*;
class Solution022 {
	public boolean isValid(String parentheses) {
		Stack<Character> validStack = new Stack<Character>();
		for(int i = 0; i < parentheses.length(); i ++) {
			if(parentheses.charAt(i) == '(') {
				validStack.push(parentheses.charAt(i));
			} else {
				if(validStack.empty()) {
					return false;
				}
				validStack.pop();
			}
		}
		if(validStack.empty()) {
			return true;
		} else {
			return false;
		}
	}
	public void parenthesesHelper(int leftNum, int rightNum, String result, List<String> resultSet) {
		if(leftNum == 0 && rightNum == 0) {
			if(isValid(result)) {
				resultSet.add(new String(result));
			}
		}
		if(leftNum > 0) {
			leftNum --;
			result += "(";
			parenthesesHelper(leftNum, rightNum, result, resultSet);
			result = result.substring(0, result.length() - 1);
			leftNum ++;
		}
		if(rightNum > 0) {
			rightNum --;
			result += ")";
			parenthesesHelper(leftNum, rightNum, result, resultSet);
			result = result.substring(0, result.length() - 1);
			rightNum ++;
		}
	}

	public List<String> generateParenthesis(int n) {
		if(n == 0) {
			return new ArrayList<String>();
		}
		List<String> resultSet = new ArrayList<String>();
		parenthesesHelper(n, n, "", resultSet);
		return resultSet;
	}

	public static void main(String[] args) {
		Solution022 test = new Solution022();
		System.out.println(test.generateParenthesis(3));
	}
}