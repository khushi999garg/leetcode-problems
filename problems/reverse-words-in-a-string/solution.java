class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int left = n - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '\s') {
                if (i + 1 <= left) {
                    sb.append(s.substring(i + 1, left + 1));
                    if (i != 0) {
                        sb.append(" ");
                    }
                }
                left = i - 1;
            } else if (i == 0) {
                sb.append(s.substring(i, left + 1));
            }
        }

        return sb.toString().trim();
    }
}