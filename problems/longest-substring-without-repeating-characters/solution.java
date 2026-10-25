class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        int left = 0;
        int count = 0;
        int[] freq = new int[128];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (freq[c] == 1)
                count++;
            freq[c]++;

            while (count != 0) {
                char l = s.charAt(left);
                if (freq[l] == 2)
                    count--;
                freq[l]--;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}