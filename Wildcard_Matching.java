//use a boolean matrix match[i][j] to record whether s[0...i] and p[0...j] can match
//if s[i] == p[j] or p[j] == '?', match[i][j] = match[i-1][j-1]
// if p[j] == '*', match[i][j] = match[i][j-1] || match[i-1][j-1] || match[i-2][j-1] || ... || match[0][j-1]
// since match[i-1][j] = match[i-1][j-1] || match[i-2][j-1] || ... || match[0][j-1]
// so when p[j] == '*', match[i][j] = match[i][j-1] || match[i-1][j]

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        s = " " + s;
        p = " " + p;
        int slen = s.length();
        int plen = p.length();
        
        boolean[][] match = new boolean[slen][plen];
        for(int i = 0; i < slen; i ++) {
            Arrays.fill(match[i], false);
        }
        match[0][0] = true;
        
        for(int i = 0; i < slen; i ++) {
            for(int j = 0; j < plen; j ++) {
                if(i == 0 && j != 0) {
                    if(p.charAt(j) == '*') {
                        match[i][j] = match[i][j-1];
                    } else {
                        match[i][j] = false;
                    }
                } else if(j != 0) {
                    if(p.charAt(j) == '*') {
                        match[i][j] = match[i-1][j] || match[i][j-1];
                    } else if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                        match[i][j] = match[i-1][j-1];
                    }
                }
            }
        }
        return match[slen-1][plen-1];
        
    }
}