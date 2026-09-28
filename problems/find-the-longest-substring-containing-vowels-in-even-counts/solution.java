class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = s.length();
        int pref = 0;
        int len = 0;

        map.put(0, -1);

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if (c == 'a') pref ^= 1;
            else if (c == 'e') pref ^= 2;
            else if (c == 'i') pref ^= 4;
            else if (c == 'o') pref ^= 8;
            else if (c == 'u') pref ^= 16;

            if (map.containsKey(pref)){
                len = Math.max(len, i - map.get(pref));
            } else {
                map.put(pref, i);
            }
        }
        return len;
    }
}