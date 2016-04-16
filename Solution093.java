import java.util.*;

public class Solution093 {
	public boolean isValid(int num) {
		return (num >= 0 && num <= 255);
	}

	public void searchIpAdd(String curTry, List<String> ipList, String s, int beginIndex, int round) {
		// System.out.println("this is round " + round);
		if(round == 4) {
			if(beginIndex < s.length()) {
				if(isValid(Integer.parseInt(s.substring(beginIndex))) && Integer.parseInt(s.substring(beginIndex)) != 0 || Integer.parseInt(s.substring(beginIndex)) == 0 && beginIndex == s.length() - 1) {
					// if(Integer.parseInt(s.substring(beginIndex)) == 0 && beginIndex < s.length() - 1) {
					// 	break;
					// }
					curTry += s.substring(beginIndex);
					System.out.println("Valid IP: " + curTry);
					ipList.add(curTry);
					System.out.println(ipList.size());
				}
			} 
		} else {
			for(int i = beginIndex + 1; i < beginIndex + 4 && i < s.length(); i++) {
				if(isValid(Integer.parseInt(s.substring(beginIndex, i)))) {
					// System.out.println("this is round " + round);
					curTry += s.substring(beginIndex, i) + ".";
					searchIpAdd(curTry, ipList, s, i, round + 1);
					curTry = curTry.substring(0, beginIndex + round - 1);
					if(Integer.parseInt(s.substring(beginIndex, )) == 0) {
						continue;
					}
				}
			}
		}
	}

	public List<String> restoreIpAddresses(String s) {
        List<String> ipAdd = new ArrayList<String>();
        String myTry = new String();
        searchIpAdd(myTry, ipAdd, s, 0, 1);
        return ipAdd;
    }

    public static void main(String[] args) {
    	Solution093 test = new Solution093();
    	List<String> list = new ArrayList<String>();
    	list = test.restoreIpAddresses("255000255");
    	System.out.println(list.size());
    	for(int i = 0; i < list.size(); i ++) {
    		System.out.println(list.get(i));
    	}
    }
}