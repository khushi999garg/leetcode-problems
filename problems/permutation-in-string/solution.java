class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n) return false;
        int count = 0;
        // int left = 0;
        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
            count++;
        }

        for(int i = 0; i < m; i++) {
            char c = s2.charAt(i);

            if (freq[c - 'a'] > 0) {
                count--;
            }

            freq[c - 'a']--;
        }

        if (count == 0) return true;

        for (int i = m; i < n; i++) {
            char c = s2.charAt(i);

            if (freq[c - 'a'] > 0) {
                count--;
            }
            freq[c - 'a']--;

            char l = s2.charAt(i - m);

            if (freq[l - 'a'] >= 0) {
                count++;
            }

            freq[l - 'a']++;

            if (count == 0) return true;
        }

        return false;
    }
}