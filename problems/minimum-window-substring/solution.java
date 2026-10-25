class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] freq = new int[58];
        int count = 0;
        int left = 0;
        int bestLeft = 0;
        int ans = Integer.MAX_VALUE;
        // String res = "";

        if (m < n) return "";

        for (char c : t.toCharArray()) {
            if (freq[c - 'A'] == 0)
                count++;
            freq[c - 'A']++;
        }

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);

            if (freq[c - 'A'] == 1)
                count--;
            freq[c - 'A']--;

            while (count == 0 && left < m) {
                if (ans > (i - left + 1)) {
                    ans = i - left + 1;
                    bestLeft = left;
                    // res = s.substring(left, i + 1);
                }
                char l = s.charAt(left);
                if (freq[l - 'A'] == 0)
                    count++;
                freq[l - 'A']++;
                left++;

            }
        }

        return ans != Integer.MAX_VALUE ? s.substring(bestLeft, bestLeft + ans) : "";
    }
}