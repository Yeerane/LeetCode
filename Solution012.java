public class Solution012 {
	public String intToRoman(int num) {
		int[] numUnits = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		String[] romanUnits = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
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
}
