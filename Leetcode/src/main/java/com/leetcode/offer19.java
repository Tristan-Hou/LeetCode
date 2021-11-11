package com.leetcode;

class offer19 {


    public boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return false;
        }
        int sLength = s.length();
        int pLength = p.length();
        int sIndex = 0;
        int pIndex = 0;
        return match(s, sIndex, sLength, p, pIndex, pLength);
    }

    public boolean match(String s, int sIndex, int sLength, String p, int pIndex, int pLength) {
        if (sIndex == sLength && pIndex == pLength) {
            return true;
        }
        if (sIndex < sLength && pIndex >= pLength) {
            return false;
        }
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        if (pIndex + 1 < pLength) {
            char pNextChar = p.charAt(pIndex + 1);
            if (pNextChar == '*') {
                if (sChar == pChar || pChar == '.') {
                    return match(s, sIndex + 1, sLength, p, pIndex + 2, pLength)
                            || match(s, sIndex + 1, sLength, p, pIndex, pLength)
                            || match(s, sIndex, sLength, p, pIndex + 2, pLength);
                } else {
                    return match(s, sIndex, sLength, p, pIndex + 2, pLength);
                }
            }
        }
        if (sChar == pChar || pChar == '.') {
            return match(s, sIndex + 1, sLength, p, pIndex + 1, pLength);
        }
        return false;
    }


}
