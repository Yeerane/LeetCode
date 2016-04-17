public class Solution003 {
    public static final int NUM_OF_CHARS = 10000;
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] indexOfChars = new int[NUM_OF_CHARS];
        int start = 0;
        int curIndex = 0;
        int maxLength = -1;
        int curLength = 0;
        String longestSub = "";
        String curString = "";
        for(int i = 0; i < NUM_OF_CHARS; i++) {
            indexOfChars[i] = -1;
        }
        while(curIndex < s.length()) {
            if(s == null || s.length() == 0){
            return 0;
        }
            if(indexOfChars[s.charAt(curIndex)] < start) {
                indexOfChars[s.charAt(curIndex)] = curIndex;
                curLength ++;
                curString += s.substring(curIndex, curIndex + 1);
                maxLength = maxLength > curLength ? maxLength : curLength;
                longestSub = maxLength > curLength ? longestSub : curString;

            } else {
                start = indexOfChars[s.charAt(curIndex)] + 1;
                indexOfChars[s.charAt(curIndex)] = curIndex;
                curString = curIndex == s.length() - 1 ? s.substring(start) : s.substring(start, curIndex + 1);
                curLength = curString.length();
            }
            curIndex ++;
        }
        System.out.println("the longest substring of " + "\"" + s + "\"" + " is " + "\"" + longestSub + "\"" + ", length is " + maxLength);
        return maxLength;
    }

	public static void main(String[] args) {
		Solution003 test = new Solution003();
		System.out.println(test.lengthOfLongestSubstring("abcabcbbd"));
		System.out.println(test.lengthOfLongestSubstring("bbbb"));
	}
}
