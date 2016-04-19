class Solution012 {

	public static final int[] numUnits = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
	public static final String[] romanUnits = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
	public String intToRoman(int num) {
		String roman = "";
		while(num > 0) {
			int length = numUnits.length;
			for(int i = length - 1; i >= 0; i --) {
				if(num >= numUnits[i]) {
					num -= numUnits[i];
					roman += romanUnits[i];
					break;
				}
			}
		}
		return roman;
	}

	public static void main(String[] args) {
		Solution012 test = new Solution012();
		System.out.println(test.intToRoman(2345));
		System.out.println(test.intToRoman(99));
	}
}
