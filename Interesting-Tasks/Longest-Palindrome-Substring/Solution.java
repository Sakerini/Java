class Solution {
   
    public static boolean isPalinfrom(String s, int begin, int end) {
        int len = end - begin;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i + begin) != s.charAt(end - i - 1)) {
                return false;
            }
        }

        return true;
    }
    public String longestPalindrome(String s) {
         for (int len = s.length(); len > 0; len--) {
            for (int j = 0; j <= s.length() - len; j++) {
                if (isPalinfrom(s, j, j + len)) {
                    return s.substring(j, j + len);
                }
            }
        }

        return s;
    }
}
