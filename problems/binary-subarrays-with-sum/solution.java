class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int pref = 0;
        int count = 0;

        map.put(0, 1);
        for (int x : nums) {
            pref += x;
            int ans = pref - goal;
            count += map.getOrDefault(ans, 0);
            map.put(pref, map.getOrDefault(pref, 0) + 1);
        }

        return count;
    }
}