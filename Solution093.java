import java.util.*;

public class Solution093 {
	public boolean isValid(int num) {
		return (num >= 0 && num <= 255);
	}

	public boolean beginWithZero(String s) {
		if(s == null || s == "") {
			return false;
		} else if(s.charAt(0) == '0') {
			return true;
		} else {
			return false;
		}
	}

	public void searchIpAdd(String curTry, List<String> ipList, String s, int beginIndex, int round) {
		// System.out.println("this is round " + round);
		if(round == 4) {
			if(beginIndex < s.length()) {
				String part = s.substring(beginIndex);
				if(part.length() <= 3 && isValid(Integer.parseInt(part))) {
					if(!beginWithZero(part) || (beginWithZero(part) && part.equals("0"))) {
						curTry += part;
						System.out.println("Valid IP: " + curTry);
						ipList.add(curTry);
						System.out.println(ipList.size());
					}
				}
			} 
		} else {
			for(int i = beginIndex + 1; i < beginIndex + 4 && i < s.length(); i++) {
				String part = s.substring(beginIndex, i);
				if(isValid(Integer.parseInt(part))) {
					// System.out.println("this is round " + round + ", try " + part);
					if(!beginWithZero(part) || (beginWithZero(part) && part.equals("0"))) {
						curTry += s.substring(beginIndex, i) + ".";
						searchIpAdd(curTry, ipList, s, i, round + 1);
						curTry = curTry.substring(0, beginIndex + round - 1);
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
    	list = test.restoreIpAddresses("0000");
    	System.out.println(list.size());
    	for(int i = 0; i < list.size(); i ++) {
    		System.out.println(list.get(i));
    	}
    }
}