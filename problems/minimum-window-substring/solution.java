class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int[] uFreq = new int[26];
        int[] lFreq = new int[26];
        int left = 0;
        int bestLeft = 0;
        int bestLen = Integer.MAX_VALUE;
        int count = 0;

        for (char c : t.toCharArray()) {
            if (Character.isUpperCase(c)) {
                if (uFreq[c - 'A'] == 0)
                    count++;
                uFreq[c - 'A']++;
            } else {
                if (lFreq[c - 'a'] == 0)
                    count++;
                lFreq[c - 'a']++;
            }
        }

        for (int right = 0; right < n; right++) {
            char r = s.charAt(right);

            if (Character.isUpperCase(r)) {
                if (uFreq[r - 'A'] == 1)
                    count--;
                uFreq[r - 'A']--;
            } else {
                if (lFreq[r - 'a'] == 1)
                    count--;
                lFreq[r - 'a']--;
            }

            while (count == 0) {
                char l = s.charAt(left);

                if (right - left + 1 < bestLen) {
                    bestLeft = left;
                    bestLen = right - left + 1;
                }
                if (Character.isUpperCase(l)) {
                    if (uFreq[l - 'A'] == 0)
                        count++;
                    uFreq[l - 'A']++;
                } else {
                    if (lFreq[l - 'a'] == 0)
                        count++;
                    lFreq[l - 'a']++;
                }

                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestLeft, bestLeft + bestLen);
    }
}