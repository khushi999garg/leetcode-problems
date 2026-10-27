class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();

        if (n < m)
            return ans;

        int[] freq = new int[26];
        int count = 0;

        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
            count++;
        }

        int left = 0;

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);

            if (freq[c - 'a'] > 0)
                count--;
            freq[c - 'a']--;
        }

        if (count == 0) {
            ans.add(left);
        }

        for (int i = m; i < n; i++) {
            char c = s.charAt(i);

            if (freq[c - 'a'] > 0)
                count--;
            freq[c - 'a']--;

            char l = s.charAt(left);

            if (freq[l - 'a'] >= 0)
                count++;
            freq[l - 'a']++;
            left++;
            if (count == 0) {
                ans.add(left);
            }
        }

        return ans;
    }
}