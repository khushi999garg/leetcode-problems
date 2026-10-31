class Solution {
    public int compress(char[] chars) {
        int n = chars.length;

        if (n == 1)
            return n;

        String s = "";
        int left = 0;
        int ans;

        for (int i = 1; i < n; i++) {
            if (chars[i] != chars[i - 1] || i == n - 1) {
                int len;
                if (i == n - 1 && chars[i] == chars[i - 1]) {
                    len = i - left + 1;
                } else {
                    len = i - left;
                }
                s = s.concat(String.valueOf(chars[left]));
                if (len != 1) {
                    s = s.concat(String.valueOf(len));
                }

                    left = i;
                if (i == n - 1 && chars[i] != chars[i - 1]) {
                    s = s.concat(String.valueOf(chars[i]));
                }
            }
        }

        // System.out.println(s);
        int i = 0;
        for (char c : s.toCharArray()) {
            chars[i] = c;
            i++;
        }
        return s.length();
    }
}