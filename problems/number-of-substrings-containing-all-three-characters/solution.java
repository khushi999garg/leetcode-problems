class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 3;
        int left = 0;
        int[] freq = new int[] {1, 1, 1};
        int ans = 0;

        for(int right = 0; right < n; right++){
            char r = s.charAt(right);

            if (freq[r - 'a'] == 1) count--;

            freq[r - 'a']--;

            while(count == 0) {
                int l = s.charAt(left);
                ans += n - right;
                if (freq[l - 'a'] == 0) count++;
                freq[l - 'a']++;
                left++;
            }
        }

        return ans;
    }
}